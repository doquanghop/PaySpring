package io.github.doquanghop.payspring.config;

import io.github.doquanghop.payspring.service.CryptoService;
import io.github.doquanghop.payspring.service.implement.VNPayService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(VnPayProperties.class)
public class VnPayAutoConfiguration {

    @Bean
    public VNPayService vnPayService() {
        return new VNPayService();
    }

    @Bean
    public CryptoService cryptoService() {
        return new CryptoService();
    }
}