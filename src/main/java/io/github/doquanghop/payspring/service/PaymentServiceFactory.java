package io.github.doquanghop.payspring.service;

import io.github.doquanghop.payspring.constant.Provider;
import io.github.doquanghop.payspring.service.implement.VNPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFactory {
    @Autowired
    private VNPayService vnPayService;

    public PaymentGatewayService getPaymentGatewayService(Provider provider) {
        switch (provider){
            case VNPay:
                return vnPayService;
            default:
                throw new IllegalArgumentException("Unsupported payment provider: " + provider);
        }
    }
}
