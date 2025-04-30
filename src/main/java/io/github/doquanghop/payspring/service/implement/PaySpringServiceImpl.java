package io.github.doquanghop.payspring.service.implement;

import io.github.doquanghop.payspring.dto.request.InitPaymentRequest;
import io.github.doquanghop.payspring.dto.response.InitPaymentResponse;
import io.github.doquanghop.payspring.service.PaymentGatewayService;
import io.github.doquanghop.payspring.service.PaymentServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PaySpringServiceImpl implements PaymentGatewayService {
    @Autowired
    private PaymentServiceFactory factory;

    @Override
    public InitPaymentResponse init(InitPaymentRequest request) {
        PaymentGatewayService service = factory.getPaymentGatewayService(request.getPaymentGateway());
        return service.init(request);
    }
}
