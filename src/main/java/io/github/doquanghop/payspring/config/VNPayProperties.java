package io.github.doquanghop.payspring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "payspring.vnpay")
public class VNPayProperties {
    private String tmnCode;
    private String initPaymentUrl;
    private String returnUrl;
    private Integer timeout;

    // Getters & Setters
    public String getTmnCode() {
        return tmnCode;
    }

    public void setTmnCode(String tmnCode) {
        this.tmnCode = tmnCode;
    }

    public String getInitPaymentUrl() {
        return initPaymentUrl;
    }

    public void setInitPaymentUrl(String initPaymentUrl) {
        this.initPaymentUrl = initPaymentUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}