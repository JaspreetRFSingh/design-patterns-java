package com.patterns.principles.solid.srp;

/**
 * Single responsibility: send emails.
 * If the email provider changes, only this class changes.
 */
public class EmailService {

    public void sendWelcomeEmail(User user) {
        System.out.println("[Email] Sending welcome email to " + user.getEmail());
    }
}
