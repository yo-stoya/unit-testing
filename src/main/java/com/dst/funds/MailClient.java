package com.dst.funds;

public class MailClient {
    public boolean sendEmail(String address, String title, String body) {
        Email email = new Email(address, title, body);
        return sendMail(email);
    }


    protected boolean sendMail(Email email) {
        return EmailServer.sendEmail(email);
    }
}
