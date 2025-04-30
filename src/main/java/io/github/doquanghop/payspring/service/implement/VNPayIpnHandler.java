package io.github.doquanghop.payspring.service.implement;

import io.github.doquanghop.payspring.constant.VNPayParams;
import io.github.doquanghop.payspring.constant.VnpIpnResponseConst;
import io.github.doquanghop.payspring.dto.response.IpnResponse;
import io.github.doquanghop.payspring.service.IpnHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class VNPayIpnHandler implements IpnHandler {
    private final Logger log = LoggerFactory.getLogger(VNPayIpnHandler.class);

    @Autowired
    private VNPayService vnPayService;

    public IpnResponse process(Map<String, String> params) {
        if (!vnPayService.verifyIpn(params)) {
            return VnpIpnResponseConst.SIGNATURE_FAILED;
        }

        IpnResponse response;
        var txnRef = params.get(VNPayParams.TXN_REF);
        try {
            var bookingId = Long.parseLong(txnRef);
            bookingService.markBooked(bookingId);
            response = VnpIpnResponseConst.SUCCESS;
        } catch (BusinessException e) {
            switch (e.getResponseCode()) {
                case BOOKING_NOT_FOUND -> response = VnpIpnResponseConst.ORDER_NOT_FOUND;
                default -> response = VnpIpnResponseConst.UNKNOWN_ERROR;
            }
        } catch (Exception e) {
            response = VnpIpnResponseConst.UNKNOWN_ERROR;
        }

        log.info("[VNPay Ipn] txnRef: {}, response: {}", txnRef, response);
        return response;
    }
}
