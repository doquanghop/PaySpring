<div align="center">

# 📦 VNPay Spring Boot Starter

[🇻🇳 Tiếng Việt](./README.md) | [🇺🇸 English](./README_en-US.md)

[![Maven Central](https://img.shields.io/maven-central/v/io.github.doquanghop/vnpay)](https://mvnrepository.com/artifact/com.example/vnpay-spring-boot-starter)
[![License](https://img.shields.io/badge/license-MIT-blue)](https://github.com/doquanghop/vnpay/blob/main/LICENSE)

**Thư viện Spring Boot tích hợp cổng thanh toán [VNPay](https://vnpay.vn) vào ứng dụng của bạn một cách dễ dàng và chuyên nghiệp.**

</div>

## 📚 Tài liệu

**Thư viện VNPay:**
- [vn.js.org](#) - Tài liệu chi tiết của thư viện
- [sandbox.vnpayment.vn/apis](https://sandbox.vnpayment.vn/apis) - Tài liệu tích hợp từ VNPay

## 🚀 Cài đặt

> [!TIP]
> Thư viện được thiết kế theo kiểu **Spring Boot Starter**, tự động cấu hình các bean cần thiết. Chỉ cần thêm dependency và cấu hình là bạn có thể sử dụng ngay!

### Thêm Dependency
Thêm dependency vào file `pom.xml` của dự án:

```xml
<dependency>
    <groupId>io.github.doquanghop</groupId>
    <artifactId>vnpay</artifactId>
    <version>1.0.0</version>
</dependency>
```

> **Lưu ý**: Đảm bảo bạn đã cấu hình Maven repository chứa thư viện hoặc sử dụng JAR cục bộ nếu tự build.

## Cấu hình
Cấu hình thông tin VNPay trong file **application.yml** hoặc **application.properties**:

```yaml
vnpay:
  tmnCode: "YOUR_TMN_CODE"          # Mã TmnCode từ VNPay
  hashSecret: "YOUR_HASH_SECRET"    # Mã bí mật từ VNPay
  baseUrl: "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html" # URL sandbox hoặc production
  returnUrl: "http://your-app.com/api/vnpay/callback" # URL callback
  ipnUrl: "http://your-app.com/api/vnpay/ipn"         # URL IPN
  version: "2.1.0"                   # Phiên bản VNPay API
  locale: "vn"                       # Ngôn ngữ (vn/en)
  orderType: "250000"                # Loại đơn hàng
```
> Lưu ý:
> - tmnCode và hashSecret được cung cấp bởi VNPay sau khi đăng ký tài khoản.
> - returnUrl và ipnUrl phải là URL công khai (có thể truy cập từ internet).
> - Trong môi trường production, thay baseUrl bằng URL chính thức của VNPay (ví dụ: https://pay.vnpay.vn).


## Cách sử dụng
Thư viện cung cấp các chức năng chính:

- **Tạo URL thanh toán**: Gọi VNPayService.createPaymentUrl để tạo link thanh toán cho khách hàng.

- **Xử lý callback (Return URL)**: Gọi VNPayService.processCallback để xử lý kết quả thanh toán từ VNPay.

- **Xử lý IPN (Instant Payment Notification)**: Gọi VNPayService.processIpn để xử lý thông báo giao dịch từ VNPay.

## Tham gia đóng góp

Tham gia phát triển dự án:

- Đọc hướng dẫn đóng góp (.github/CONTRIBUTING.md)

- Fork dự án và tạo Pull Request

- Tham gia thảo luận trong Issues

## Giấy phép
MIT (LICENSE) © Do Quang Hop

