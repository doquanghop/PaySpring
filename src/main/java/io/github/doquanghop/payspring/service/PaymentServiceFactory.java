package io.github.doquanghop.payspring.service;

import io.github.doquanghop.payspring.type.PaymentGateway;
import io.github.doquanghop.payspring.service.implement.VNPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFactory {
    @Autowired
    private VNPayServiceImpl vnPayServiceImpl;

    public PaymentGatewayService getPaymentGatewayService(PaymentGateway paymentGateway) {
        return switch (paymentGateway) {
            case VNPAY -> vnPayServiceImpl;
            case MOMO -> null;
        };
    }
}
