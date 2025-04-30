package io.github.doquanghop.payspring.dto.request;

import io.github.doquanghop.payspring.exception.PaySpringException;
import io.github.doquanghop.payspring.type.PaymentGateway;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class InitPaymentRequestTest {

    @Test
    void testBuildValidRequest() {
        InitPaymentRequest request = InitPaymentRequest.builder()
                .paymentGateway(PaymentGateway.VNPAY)
                .requestId("req123")
                .ipAddress("127.0.0.1")
                .userId("34")
                .txnRef("txn456")
                .amount(new BigDecimal("100000"))
                .build();

        assertEquals(PaymentGateway.VNPAY, request.getPaymentGateway());
        assertEquals("req123", request.getRequestId());
        assertEquals("127.0.0.1", request.getIpAddress());
        assertEquals("34", request.getUserId());
        assertEquals("txn456", request.getTxnRef());
        assertEquals(new BigDecimal("100000"), request.getAmount());
    }

    @Test
    void testBuildMissingRequiredFields() {
        // Missing paymentGateway
        PaySpringException ex1 = assertThrows(PaySpringException.class, () -> InitPaymentRequest.builder()
                .requestId("req123")
                .ipAddress("127.0.0.1")
                .userId("34")
                .txnRef("txn456")
                .amount(new BigDecimal("100000"))
                .build());
        assertEquals("ERR_MISSING_PAYMENT_GATEWAY", ex1.getCode());
        assertEquals("Payment gateway is required", ex1.getMessage());

        // Missing requestId
        PaySpringException ex2 = assertThrows(PaySpringException.class, () -> InitPaymentRequest.builder()
                .paymentGateway(PaymentGateway.VNPAY)
                .ipAddress("127.0.0.1")
                .userId("34")
                .txnRef("txn456")
                .amount(new BigDecimal("100000"))
                .build());
        assertEquals("ERR_MISSING_REQUEST_ID", ex2.getCode());
        assertEquals("Request ID is required", ex2.getMessage());

        // Missing ipAddress
        PaySpringException ex3 = assertThrows(PaySpringException.class, () -> InitPaymentRequest.builder()
                .paymentGateway(PaymentGateway.VNPAY)
                .requestId("req123")
                .userId("34")
                .txnRef("txn456")
                .amount(new BigDecimal("100000"))
                .build());
        assertEquals("ERR_MISSING_IP_ADDRESS", ex3.getCode());
        assertEquals("IP address is required", ex3.getMessage());

        // Missing txnRef
        PaySpringException ex4 = assertThrows(PaySpringException.class, () -> InitPaymentRequest.builder()
                .paymentGateway(PaymentGateway.VNPAY)
                .requestId("req123")
                .ipAddress("127.0.0.1")
                .userId("34")
                .amount(new BigDecimal("100000"))
                .build());
        assertEquals("ERR_MISSING_TXN_REF", ex4.getCode());
        assertEquals("Transaction reference is required", ex4.getMessage());

        // Missing amount
        PaySpringException ex5 = assertThrows(PaySpringException.class, () -> InitPaymentRequest.builder()
                .paymentGateway(PaymentGateway.VNPAY)
                .requestId("req123")
                .ipAddress("127.0.0.1")
                .userId("34")
                .txnRef("txn456")
                .build());
        assertEquals("ERR_MISSING_AMOUNT", ex5.getCode());
        assertEquals("Amount is required", ex5.getMessage());
    }

    @Test
    void testBuildInvalidAmount() {
        // Negative amount
        PaySpringException ex1 = assertThrows(PaySpringException.class, () -> InitPaymentRequest.builder()
                .paymentGateway(PaymentGateway.VNPAY)
                .requestId("req123")
                .ipAddress("127.0.0.1")
                .userId("34")
                .txnRef("txn456")
                .amount(new BigDecimal("-100"))
                .build());
        assertEquals("ERR_INVALID_AMOUNT", ex1.getCode());
        assertEquals("Amount must be greater than zero", ex1.getMessage());

        // Zero amount
        PaySpringException ex2 = assertThrows(PaySpringException.class, () -> InitPaymentRequest.builder()
                .paymentGateway(PaymentGateway.VNPAY)
                .requestId("req123")
                .ipAddress("127.0.0.1")
                .userId("34")
                .txnRef("txn456")
                .amount(BigDecimal.ZERO)
                .build());
        assertEquals("ERR_INVALID_AMOUNT", ex2.getCode());
        assertEquals("Amount must be greater than zero", ex2.getMessage());
    }
}