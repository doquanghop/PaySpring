package io.github.doquanghop.payspring.dto.response;

public class InitPaymentResponse {
    private String vnpUrl;

    private InitPaymentResponse(Builder builder) {
        this.vnpUrl = builder.vnpUrl;
    }

    public String getVnpUrl() {
        return vnpUrl;
    }

    public void setVnpUrl(String vnpUrl) {
        this.vnpUrl = vnpUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String vnpUrl;

        public Builder vnpUrl(String vnpUrl) {
            this.vnpUrl = vnpUrl;
            return this;
        }

        public InitPaymentResponse build() {
            return new InitPaymentResponse(this);
        }
    }
}
