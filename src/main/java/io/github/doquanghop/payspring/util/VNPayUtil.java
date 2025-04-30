package io.github.doquanghop.payspring.util;


import io.github.doquanghop.payspring.constant.VNPayParams;
import io.github.doquanghop.payspring.dto.request.InitPaymentRequest;

import java.util.*;

import static io.github.doquanghop.payspring.service.implement.VNPayService.*;

public class VNPayUtil {
    private Map<String, String> buildPaymentParameters(InitPaymentRequest request) {
        long amount = (long) (request.getAmount() * DEFAULT_MULTIPLIER);
        String txnRef = request.getTxnRef();
        String returnUrl = String.format(returnUrlFormat, txnRef);
        Calendar vnCalendar = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        String createdDate = DateUtil.formatVnTime(vnCalendar);
        vnCalendar.add(Calendar.MINUTE, paymentTimeout);
        String expiredDate = DateUtil.formatVnTime(vnCalendar);

        Map<String, String> params = new TreeMap<>(); // TreeMap for sorted keys
        params.put(VNPayParams.VERSION, VERSION);
        params.put(VNPayParams.COMMAND, COMMAND);
        params.put(VNPayParams.TMN_CODE, tmnCode);
        params.put(VNPayParams.AMOUNT, String.valueOf(amount));
        params.put(VNPayParams.CURRENCY, Currency.VND.getValue());
        params.put(VNPayParams.TXN_REF, txnRef);
        params.put(VNPayParams.RETURN_URL, returnUrl);
        params.put(VNPayParams.CREATED_DATE, createdDate);
        params.put(VNPayParams.EXPIRE_DATE, expiredDate);
        params.put(VNPayParams.IP_ADDRESS, request.getIpAddress());
        params.put(VNPayParams.LOCALE, io.github.doquanghop.payspring.constant.Locale.VIETNAM.getCode());
        params.put(VNPayParams.ORDER_INFO, buildOrderInfo(txnRef));
        params.put(VNPayParams.ORDER_TYPE, ORDER_TYPE);

        return params;
    }
}