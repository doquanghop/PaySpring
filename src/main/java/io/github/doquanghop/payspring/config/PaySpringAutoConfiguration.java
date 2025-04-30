package io.github.doquanghop.payspring.config;

import io.github.doquanghop.payspring.service.CryptoService;
import io.github.doquanghop.payspring.service.implement.CryptoServiceImpl;
import io.github.doquanghop.payspring.service.implement.VNPayServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.NoSuchAlgorithmException;

@Configuration
@EnableConfigurationProperties({VNPayProperties.class, PayspringProperties.class})
public class PaySpringAutoConfiguration {

    @Bean
    public VNPayServiceImpl vnPayService() {
        return new VNPayServiceImpl();
    }

    @Bean
    public CryptoService cryptoService() throws NoSuchAlgorithmException {
        return new CryptoServiceImpl();
    }
}