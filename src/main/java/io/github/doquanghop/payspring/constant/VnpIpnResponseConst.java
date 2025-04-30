package io.github.doquanghop.payspring.constant;


import io.github.doquanghop.payspring.dto.response.IpnResponse;

public class VnpIpnResponseConst {

    public static final IpnResponse SUCCESS = new IpnResponse("00", "Successful");
    public static final IpnResponse SIGNATURE_FAILED = new IpnResponse("97", "Signature failed");
    public static final IpnResponse UNKNOWN_ERROR = new IpnResponse("99", "Unknown error");

}