package io.github.doquanghop.payspring.util;

import io.github.doquanghop.payspring.constant.Symbol;
import io.github.doquanghop.payspring.constant.VNPayParams;
import io.github.doquanghop.payspring.service.CryptoService;
import io.github.doquanghop.payspring.service.implement.CryptoServiceImpl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * VNPayUtil provides utility methods for VNPay payment processing, including URL building and signature verification.
 */
public final class VNPayUtil {

    private VNPayUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Builds a VNPay payment URL from the provided parameters and base URL.
     *
     * @param params        the payment parameters
     * @param baseUrl       the base payment URL (e.g., VNPay sandbox URL)
     * @param cryptoService the service for generating secure hashes
     * @return the complete payment URL with query parameters and secure hash
     */
    public static String buildPaymentUrl(Map<String, String> params, String baseUrl, CryptoService cryptoService) {
        StringBuilder query = new StringBuilder();
        StringBuilder hashPayload = new StringBuilder();
        ArrayList<String> fieldNames = new ArrayList<>(params.keySet());
        Collections.sort(fieldNames);

        for (String fieldName : fieldNames) {
            String fieldValue = params.get(fieldName);
            if (fieldValue != null && !fieldValue.isEmpty()) {
                String encodedName = URLEncoder.encode(fieldName, StandardCharsets.US_ASCII);
                String encodedValue = URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII);

                query.append(encodedName).append(Symbol.EQUAL).append(encodedValue);
                hashPayload.append(fieldName).append(Symbol.EQUAL).append(encodedValue);

                query.append(Symbol.AND);
                hashPayload.append(Symbol.AND);
            }
        }

        // Remove trailing '&' or '&' from query and hash payload
        if (query.length() > 0) {
            query.deleteCharAt(query.length() - 1);
        }
        if (hashPayload.length() > 0) {
            hashPayload.deleteCharAt(hashPayload.length() - 1);
        }

        String secureHash = cryptoService.sign(hashPayload.toString());
        query.append("&").append(VNPayParams.SECURE_HASH).append("=").append(secureHash);

        return baseUrl + "?" + query;
    }

    /**
     * Verifies the signature of a VNPay IPN or callback response.
     *
     * @param params        the response parameters
     * @param cryptoServiceImpl the service for generating secure hashes
     * @return true if the signature is valid, false otherwise
     */
    public static boolean verifySignature(Map<String, String> params, CryptoServiceImpl cryptoServiceImpl) {
        String reqSecureHash = params.get(VNPayParams.SECURE_HASH);
        if (reqSecureHash == null) {
            return false;
        }

        Map<String, String> verificationParams = new TreeMap<>(params);
        verificationParams.remove(VNPayParams.SECURE_HASH);
        verificationParams.remove(VNPayParams.SECURE_HASH_TYPE);

        StringBuilder hashPayload = new StringBuilder();
        for (Map.Entry<String, String> entry : verificationParams.entrySet()) {
            String fieldValue = entry.getValue();
            if (fieldValue != null && !fieldValue.isEmpty()) {
                hashPayload.append(entry.getKey())
                        .append(Symbol.EQUAL)
                        .append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII))
                        .append(Symbol.AND);
            }
        }

        if (hashPayload.length() > 0) {
            hashPayload.deleteCharAt(hashPayload.length() - 1);
        }

        String secureHash = cryptoServiceImpl.sign(hashPayload.toString());
        return secureHash.equals(reqSecureHash);
    }
}