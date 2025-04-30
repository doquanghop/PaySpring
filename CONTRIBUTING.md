# Contributing to PaySpring

Thank you for your interest in contributing to **PaySpring**! We aim to make payment gateway integrations simple and accessible for developers worldwide, and your contributions are key to achieving this goal. Whether you're fixing bugs, adding new features, improving documentation, or suggesting ideas, we value your efforts.

This guide outlines how you can contribute to PaySpring and become part of our open-source community.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [How Can I Contribute?](#how-can-i-contribute)
    - [Reporting Bugs](#reporting-bugs)
    - [Suggesting Features](#suggesting-features)
    - [Contributing Code](#contributing-code)
    - [Improving Documentation](#improving-documentation)
- [Setting Up the Project](#setting-up-the-project)
- [Pull Request Process](#pull-request-process)
- [Style Guidelines](#style-guidelines)
- [Community](#community)
- [License](#license)

## 🤝 Code of Conduct

By participating in this project, you agree to abide by our [Code of Conduct](CODE_OF_CONDUCT.md). We are committed to fostering a respectful, inclusive, and harassment-free environment for everyone.

## 🚀 How Can I Contribute?

There are many ways to contribute to PaySpring, regardless of your expertise level. Here are some ideas:

### 🐛 Reporting Bugs

If you find a bug, please let us know so we can address it!

- **Check Existing Issues**: Search the [Issues](https://github.com/doquanghop/PaySpring/issues) to ensure the bug hasn’t already been reported.
- **Open a New Issue**: Use the **Bug Report** template and provide:
    - A clear description of the issue.
    - Steps to reproduce the bug.
    - Expected and actual behavior.
    - Relevant logs, screenshots, or code snippets.
    - Your environment (e.g., Java version, Spring Boot version).

### 💡 Suggesting Features

We’d love to hear your ideas for new payment gateways, features, or improvements!

- **Open a Feature Request**: Use the **Feature Request** template in [Issues](https://github.com/doquanghop/PaySpring/issues).
- **Describe the Feature**: Explain the use case, benefits, and any implementation ideas.
- **Engage**: Be open to discussing your idea with the community.

### 💻 Contributing Code

Whether it’s fixing a bug, adding a new payment gateway, or optimizing code, your contributions are welcome!

1. **Find an Issue**: Browse [Issues](https://github.com/doquanghop/PaySpring/issues) labeled `help wanted` or `good first issue`, or create one.
2. **Comment**: Let maintainers know you’re working on it to avoid duplication.
3. **Follow the Pull Request Process**: See [Pull Request Process](#pull-request-process) below.

### 📝 Improving Documentation

Good documentation is critical for PaySpring’s success. You can:

- Fix typos or unclear sections in the [README](README.md) or other docs.
- Add examples or tutorials for using PaySpring.
- Translate documentation into other languages.
- Submit documentation changes via a Pull Request (see below).

## 🛠️ Setting Up the Project

To contribute code or test changes locally:

1. **Fork the Repository**:
    - Click the "Fork" button on [GitHub](https://github.com/doquanghop/PaySpring).
    - Clone your fork: `git clone https://github.com/YOUR_USERNAME/PaySpring.git`

2. **Install Dependencies**:
    - Ensure you have [Java 11+](https://adoptium.net/) and [Maven](https://maven.apache.org/) installed.
    - Run `mvn install` to install dependencies.

3. **Set Up a Local Environment**:
    - Create an `application.yml` or `application.properties` file with PaySpring credentials (see [README](README.md) for configuration details).
    - Run the project using `mvn spring-boot:run`.

4. **Test Your Changes**:
    - Write and run unit tests using `mvn test`.
    - Test payment flows with PaySpring’s sandbox environment.

## 🔄 Pull Request Process

To submit your changes:

1. **Create a Branch**:
    - Use a descriptive name, e.g., `feature/add-stripe` or `fix/bug-callback`.
    - `git checkout -b your-branch-name`

2. **Commit Your Changes**:
    - Follow [Conventional Commits](https://www.conventionalcommits.org/) (e.g., `feat: add Stripe integration`, `fix: resolve callback error`).
    - Keep commits focused and descriptive.

3. **Push and Create a Pull Request**:
    - Push your branch: `git push origin your-branch-name`.
    - Open a Pull Request (PR) on [GitHub](https://github.com/doquanghop/PaySpring/pulls).
    - Use the **Pull Request** template and include:
        - A summary of changes.
        - Related issue numbers (e.g., `Fixes #123`).
        - Any testing instructions.

4. **Review Process**:
    - Maintainers will review your PR and may request changes.
    - Be responsive to feedback and make updates as needed.
    - Once approved, your changes will be merged!

## 🎨 Style Guidelines

- **Code Style**:
    - Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).
    - Use 4-space indentation.
    - Add meaningful Javadoc comments for public methods.

- **Testing**:
    - Write unit tests for new features or bug fixes.
    - Ensure all tests pass before submitting a PR.

- **Documentation**:
    - Update [README](README.md) or other docs for new features or changes.
    - Keep documentation clear and concise.

## 🌍 Community

Join our community to connect with other contributors:

- **GitHub Issues**: Discuss bugs, features, or questions in [Issues](https://github.com/doquanghop/PaySpring/issues).
- **Star the Repo**: Show your support by starring [PaySpring](https://github.com/doquanghop/PaySpring).
- **Spread the Word**: Share PaySpring with your network to grow our community.

## 📜 License

By contributing to PaySpring, you agree that your contributions will be licensed under the [MIT License](LICENSE).

---

Thank you for helping make PaySpring better for everyone! 🚀