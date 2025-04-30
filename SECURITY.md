<div align="center">

# 🔒 Security Policy

</div>

## 🛡️ Overview
**PaySpring** is an open-source Spring Boot library for seamless payment gateway integration. We prioritize the security of our library to protect users and their sensitive payment data. This document outlines how to report security vulnerabilities, our response process, and best practices for using PaySpring securely.

## 📜 Supported Versions
We provide security updates for the following versions of PaySpring:

| Version | Supported          |
|---------|--------------------|
| 0.0.1   | ✅ Actively Supported |
| < 0.0.1 | ❌ Not Supported    |

> **Note**: Always use the latest version to benefit from security fixes and improvements.

## 🚨 Reporting a Vulnerability
If you discover a security vulnerability in PaySpring, please report it responsibly. We appreciate your efforts to keep our community safe.

### How to Report
1. **Do Not Open a Public Issue**: Avoid disclosing vulnerabilities publicly (e.g., in GitHub Issues) to prevent exploitation.
2. **Email Us**: Send a detailed report to [dqhopx@gmail.com](mailto:dqhopx@gmail.com). Include:
    - A description of the vulnerability.
    - Steps to reproduce the issue.
    - Potential impact (e.g., data exposure, payment fraud).
    - Any suggested fixes (optional).
3. **Use Encryption (Optional)**: If you have a GPG key, encrypt your email using our public key (available upon request).

### What to Expect
- **Acknowledgment**: We will confirm receipt of your report within 48 hours.
- **Investigation**: We will investigate and assess the vulnerability within 5 business days.
- **Resolution**: If the vulnerability is confirmed, we will:
    - Release a patch in the next version (or a hotfix for critical issues).
    - Notify users via GitHub Releases and the [PaySpring Discussions](https://github.com/doquanghop/payspring/discussions).
- **Disclosure**: We will publicly disclose the vulnerability only after a fix is released, crediting you (if desired) unless you prefer anonymity.

## 🔐 Security Best Practices
To use PaySpring securely, follow these guidelines:

- **Keep Dependencies Updated**: Regularly update PaySpring and its dependencies (e.g., Spring Boot, Jackson) to mitigate known vulnerabilities. Check `pom.xml` for versions.
- **Secure Configuration**: Store sensitive configuration (e.g., VNPay `tmn-code`, secret keys) in environment variables or a secure vault, not in `application.yml`.
- **Validate Inputs**: Use PaySpring’s validation (e.g., `InitPaymentRequest` checks) and add custom validation to prevent injection attacks.
- **Encrypt Data**: Ensure payment data (e.g., transaction IDs, amounts) is transmitted over HTTPS and stored securely.
- **Monitor Logs**: Enable logging in PaySpring to detect suspicious activity (e.g., invalid payment requests).
- **Dependency Scanning**: Use tools like Dependabot or OWASP Dependency-Check to monitor for vulnerable dependencies.

## 🛠️ Dependency Security
PaySpring relies on third-party dependencies (e.g., Spring Boot, Jackson). We actively monitor for vulnerabilities using:

- **GitHub Dependabot**: Enabled to alert for outdated or vulnerable dependencies.
- **Manual Reviews**: We review dependency updates during releases.

If a dependency vulnerability is identified, we will:
- Upgrade to a secure version in the next release.
- Notify users via GitHub Issues or Discussions.

## 🙏 Acknowledgments
We thank all security researchers and contributors who help keep PaySpring secure. If you report a verified vulnerability, we will acknowledge your contribution in our release notes (unless you prefer anonymity).

## 📬 Contact
For security-related questions or to request our GPG public key, contact us at [dqhopx@gmail.com](mailto:dqhopx@gmail.com).

## 📜 License
This security policy is part of PaySpring, licensed under the [MIT License](LICENSE).

---

⭐ **Found PaySpring useful? Give us a star on [GitHub](https://github.com/doquanghop/payspring)!**