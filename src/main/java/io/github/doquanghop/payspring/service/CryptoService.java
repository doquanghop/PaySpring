package io.github.doquanghop.payspring.service;

import io.github.doquanghop.payspring.constant.DefaultValue;
import io.github.doquanghop.payspring.constant.ResponseCode;
import io.github.doquanghop.payspring.exception.VNPayException;
import io.github.doquanghop.payspring.util.EncodingUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class CryptoService {

    private final Mac mac = Mac.getInstance(DefaultValue.HMAC_SHA512);

    @Value("${payment.vnpay.secret-key}")
    private String secretKey;

    public CryptoService() throws NoSuchAlgorithmException {
    }

    @PostConstruct
    void init() throws InvalidKeyException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), DefaultValue.HMAC_SHA512);
        mac.init(secretKeySpec);
    }


    public String sign(String data) {
        try {
            return EncodingUtil.toHexString(mac.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new VNPayException(ResponseCode.VNPAY_SIGNING_FAILED);
        }
    }
}