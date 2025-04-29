package io.github.doquanghop.vnpay.service;

import io.github.doquanghop.vnpay.dto.response.IpnResponse;

import java.util.Map;

public interface IpnHandler {

    IpnResponse process(Map<String, String> params);

}