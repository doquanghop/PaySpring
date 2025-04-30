package io.github.doquanghop.payspring.service;

import io.github.doquanghop.payspring.dto.request.InitPaymentRequest;
import io.github.doquanghop.payspring.dto.response.InitPaymentResponse;

/**
 * PaymentService interface provides methods for handling payment operations across multiple payment gateways.
 * It defines a unified API for initiating payments, processing callbacks, and handling instant payment notifications (IPN).
 * Currently supports VNPay, with planned support for Stripe, PayPal, Momo, and other gateways.
 */
public interface PaymentGatewayService {

    /**
     * Initiates a payment request for the specified gateway (e.g., VNPay, Stripe, PayPal, Momo).
     * This method generates a payment URL or transaction details to redirect the user to the gateway's payment page.
     *
     * @param request the payment initiation request containing details like gateway type, amount, transaction ID, and customer info
     * @return InitPaymentResponse containing the payment URL or transaction details for the gateway
     * @throws UnsupportedOperationException if the specified gateway is not yet implemented
     */
    InitPaymentResponse init(InitPaymentRequest request);

}