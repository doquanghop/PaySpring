package io.github.doquanghop.vnpay.util;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class VNPayUtil {
    public static String hmacSHA512(String key, String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA512");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA512");
            mac.init(secretKey);
            byte[] hmacData = mac.doFinal(data.getBytes());
            return Hex.encodeHexString(hmacData);
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate HMAC-SHA512", e);
        }
    }

    public static String generateSecureHash(Map<String, String> params, String hashSecret) {
        List<String> fields = new ArrayList<>(params.keySet());
        Collections.sort(fields);
        StringBuilder data = new StringBuilder();
        for (String field : fields) {
            if (!field.equals("vnp_SecureHash") && params.get(field) != null && !params.get(field).isEmpty()) {
                data.append(field).append("=").append(params.get(field)).append("&");
            }
        }
        data.setLength(data.length() - 1); // Remove last "&"
        return hmacSHA512(hashSecret, data.toString());
    }

    public static Map<String, String> extractParams(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        request.getParameterMap().forEach((key, value) -> params.put(key, value[0]));
        return params;
    }
}