package io.github.doquanghop.payspring.dto.response;

import io.github.doquanghop.payspring.type.PaymentGateway;

public class InitPaymentResponse {
    private PaymentGateway paymentGateway;
    private String paymentURL;

    private InitPaymentResponse(Builder builder) {
        this.paymentURL = builder.paymentURL;
        this.paymentGateway = builder.build().paymentGateway;
    }

    public String getPaymentURL() {
        return paymentURL;
    }

    public void setPaymentURL(String paymentURL) {
        this.paymentURL = paymentURL;
    }

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String paymentURL;
        private PaymentGateway paymentGateway;

        public Builder paymentURL(String paymentURL) {
            this.paymentURL = paymentURL;
            return this;
        }

        public Builder paymentGateway(PaymentGateway paymentGateway) {
            this.paymentGateway = paymentGateway;
            return this;
        }

        public InitPaymentResponse build() {
            return new InitPaymentResponse(this);
        }
    }
}
