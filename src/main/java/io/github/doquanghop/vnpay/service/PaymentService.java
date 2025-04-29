package io.github.doquanghop.vnpay.service;

import io.github.doquanghop.vnpay.dto.request.InitPaymentRequest;
import io.github.doquanghop.vnpay.dto.response.InitPaymentResponse;

/**
 * Interface PaymentService cung cấp các phương thức liên quan đến thanh toán VNPay.
 * Interface này định nghĩa phương thức `init`, được sử dụng để khởi tạo yêu cầu thanh toán.
 */
public interface PaymentService {

    /**
     * Phương thức này được sử dụng để khởi tạo một yêu cầu thanh toán.
     * Sau khi khởi tạo, người dùng sẽ được chuyển hướng đến VNPay để thực hiện thanh toán.
     *
     * @param request là đối tượng chứa thông tin yêu cầu thanh toán (ví dụ: mã giao dịch, số tiền, thông tin khách hàng, v.v.)
     * @return InitPaymentResponse chứa URL thanh toán và các thông tin phản hồi từ VNPay
     */
    InitPaymentResponse init(InitPaymentRequest request);

}