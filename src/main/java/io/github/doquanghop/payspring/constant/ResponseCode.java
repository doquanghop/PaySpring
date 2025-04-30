package io.github.doquanghop.payspring.constant;

public class ResponseCode {
    // Common error codes
    public static final String MISSING_PAYMENT_GATEWAY = "ERR_MISSING_PAYMENT_GATEWAY";
    public static final String MISSING_REQUEST_ID = "ERR_MISSING_REQUEST_ID";
    public static final String MISSING_IP_ADDRESS = "ERR_MISSING_IP_ADDRESS";
    public static final String MISSING_TXN_REF = "ERR_MISSING_TXN_REF";
    public static final String MISSING_AMOUNT = "ERR_MISSING_AMOUNT";
    public static final String INVALID_AMOUNT = "ERR_INVALID_AMOUNT";


    // VNPay error codes
    public static final String VNPAY_SIGNING_FAILED = "VNP001";
    public static final String VNPAY_INVALID_CONFIG = "VNP002";
}