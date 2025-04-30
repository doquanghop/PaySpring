package io.github.doquanghop.payspring.service.implement;

import io.github.doquanghop.payspring.constant.ResponseCode;
import io.github.doquanghop.payspring.exception.PaySpringException;
import io.github.doquanghop.payspring.exception.VNPayException;
import io.github.doquanghop.payspring.service.CryptoService;
import io.github.doquanghop.payspring.util.EncodingUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class CryptoServiceImpl implements CryptoService {
    private Mac mac;

    @Value("${payspring.secretKey}")
    private String secretKey;
    @Value("${payspring.algorithm}")
    private String algorithm;

    public CryptoServiceImpl() throws NoSuchAlgorithmException {
    }

    @PostConstruct
    void init() throws InvalidKeyException {
        try {
            mac = Mac.getInstance(algorithm);
            var secretKeySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
            mac.init(secretKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new PaySpringException(ResponseCode.VNPAY_SIGNING_FAILED);
        }
    }


    @Override
    public String sign(String data) {
        try {
            return EncodingUtil.toHexString(mac.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new VNPayException(ResponseCode.VNPAY_SIGNING_FAILED);
        }
    }
}