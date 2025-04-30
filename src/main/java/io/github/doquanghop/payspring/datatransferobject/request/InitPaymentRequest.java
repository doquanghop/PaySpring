package io.github.doquanghop.payspring.datatransferobject.request;

import io.github.doquanghop.payspring.constant.ResponseCode;
import io.github.doquanghop.payspring.exception.PaySpringException;
import io.github.doquanghop.payspring.type.PaymentGateway;

import java.math.BigDecimal;

public class InitPaymentRequest {
    public PaymentGateway paymentGateway;

    private String requestId;

    private String ipAddress;

    private String userId;

    private String txnRef;

    private BigDecimal amount;

    private InitPaymentRequest(Builder builder) {
        this.paymentGateway = builder.paymentGateway;
        this.requestId = builder.requestId;
        this.ipAddress = builder.ipAddress;
        this.userId = builder.userId;
        this.txnRef = builder.txnRef;
        this.amount = builder.amount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTxnRef() {
        return txnRef;
    }

    public void setTxnRef(String txnRef) {
        this.txnRef = txnRef;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public static class Builder {
        private PaymentGateway paymentGateway;
        private String requestId;
        private String ipAddress;
        private String userId;
        private String txnRef;
        private BigDecimal amount;

        public Builder paymentGateway(PaymentGateway paymentGateway) {
            this.paymentGateway = paymentGateway;
            return this;
        }

        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder ipAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder txnRef(String txnRef) {
            this.txnRef = txnRef;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public InitPaymentRequest build() {
            validate();
            return new InitPaymentRequest(this);
        }

        private void validate() {
            if (paymentGateway == null) {
                throw new PaySpringException(ResponseCode.MISSING_PAYMENT_GATEWAY, "Payment gateway is required");
            }
            if (requestId == null) {
                throw new PaySpringException(ResponseCode.MISSING_REQUEST_ID, "Request ID is required");
            }
            if (ipAddress == null) {
                throw new PaySpringException(ResponseCode.MISSING_IP_ADDRESS, "IP address is required");
            }
            if (txnRef == null) {
                throw new PaySpringException(ResponseCode.MISSING_TXN_REF, "Transaction reference is required");
            }
            if (amount == null) {
                throw new PaySpringException(ResponseCode.MISSING_AMOUNT, "Amount is required");
            }
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new PaySpringException(ResponseCode.INVALID_AMOUNT, "Amount must be greater than zero");
            }
        }
    }
}
