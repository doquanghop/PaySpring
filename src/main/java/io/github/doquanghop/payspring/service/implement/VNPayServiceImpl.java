package io.github.doquanghop.payspring.service.implement;

import io.github.doquanghop.payspring.constant.*;
import io.github.doquanghop.payspring.datatransferobject.request.InitPaymentRequest;
import io.github.doquanghop.payspring.datatransferobject.response.InitPaymentResponse;
import io.github.doquanghop.payspring.service.CryptoService;
import io.github.doquanghop.payspring.service.PaymentGatewayService;
import io.github.doquanghop.payspring.type.Currency;
import io.github.doquanghop.payspring.type.Locale;
import io.github.doquanghop.payspring.type.PaymentGateway;
import io.github.doquanghop.payspring.util.DateUtil;
import io.github.doquanghop.payspring.util.VNPayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/**
 * VNPayServiceImpl implements PaymentGatewayService to handle VNPay payment operations.
 */
@Service("VNPay")
public class VNPayServiceImpl implements PaymentGatewayService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VNPayServiceImpl.class);

    @Value("${payspring.vnpay.tmn-code}")
    private String tmnCode;

    @Value("${payspring.vnpay.init-payment-url}")
    private String paymentUrl;

    @Value("${payspring.vnpay.return-url}")
    private String returnUrlFormat;

    @Value("${payspring.vnpay.timeout}")
    private Integer paymentTimeout;

    @Autowired
    private CryptoService cryptoService;


    /**
     * Initiates a VNPay payment by generating a payment URL.
     *
     * @param request the payment initiation request
     * @return InitPaymentResponse with the payment URL and transaction details
     * @throws IllegalArgumentException if the request is invalid or not for VNPay
     */
    @Override
    public InitPaymentResponse init(InitPaymentRequest request) {
        validateGateway(request.getPaymentGateway());

        Map<String, String> params = buildPaymentParameters(request);
        String initPaymentUrl = VNPayUtil.buildPaymentUrl(params, paymentUrl, cryptoService);

        LOGGER.debug("[request_id={}] Generated VNPay payment URL: {}", request.getRequestId(), initPaymentUrl);
        return InitPaymentResponse.builder()
                .paymentGateway(PaymentGateway.VNPAY)
                .paymentURL(initPaymentUrl)
                .build();
    }


    private Map<String, String> buildPaymentParameters(InitPaymentRequest request) {
        BigDecimal amount = request.getAmount().multiply(BigDecimal.valueOf(VNPayConstant.AMOUNT_MULTIPLIER));
        String txnRef = request.getTxnRef();
        String returnUrl = String.format(returnUrlFormat, txnRef);
        Calendar vnCalendar = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        String createdDate = DateUtil.formatVnTime(vnCalendar);
        vnCalendar.add(Calendar.MINUTE, paymentTimeout);
        String expiredDate = DateUtil.formatVnTime(vnCalendar);

        Map<String, String> params = new TreeMap<>();
        params.put(VNPayParams.VERSION, VNPayConstant.VERSION);
        params.put(VNPayParams.COMMAND, VNPayConstant.COMMAND);
        params.put(VNPayParams.TMN_CODE, tmnCode);
        params.put(VNPayParams.AMOUNT, amount.toString());
        params.put(VNPayParams.CURRENCY, Currency.VND.getValue());
        params.put(VNPayParams.TXN_REF, txnRef);
        params.put(VNPayParams.RETURN_URL, returnUrl);
        params.put(VNPayParams.CREATED_DATE, createdDate);
        params.put(VNPayParams.EXPIRE_DATE, expiredDate);
        params.put(VNPayParams.IP_ADDRESS, request.getIpAddress());
        params.put(VNPayParams.LOCALE, Locale.VIETNAM.getCode());
        params.put(VNPayParams.ORDER_INFO, String.format("Thanh toan don dat phong %s", txnRef));
        params.put(VNPayParams.ORDER_TYPE, VNPayConstant.ORDER_TYPE);

        return params;
    }

    private static void validateGateway(PaymentGateway gateway) {
        if (gateway != PaymentGateway.VNPAY) {
            throw new IllegalArgumentException("Gateway " + gateway + " is not supported by VNPayService");
        }
    }
}