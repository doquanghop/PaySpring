package io.github.doquanghop.payspring.type;

public enum PaymentGateway {
    VNPAY("VNPay"),
    MOMO("Momo");

    private final String code;

    PaymentGateway(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
