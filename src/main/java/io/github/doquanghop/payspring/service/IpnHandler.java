package io.github.doquanghop.payspring.service;

import io.github.doquanghop.payspring.dto.response.IpnResponse;

import java.util.Map;

public interface IpnHandler {

    IpnResponse process(Map<String, String> params);

}