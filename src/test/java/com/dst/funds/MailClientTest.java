package com.dst.funds;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MailClientTest {

    @Captor
    private ArgumentCaptor<Email> emailCaptor;

    @Spy
    private MailClient spyMailClient;

    @Test
    void testSendExtra() {
        when(spyMailClient.sendMail(any(Email.class))).thenReturn(true);

        boolean result = spyMailClient.sendEmail("a", "t", "b");

        assertTrue(result);
        verify(spyMailClient).sendMail(emailCaptor.capture());

        Email value = emailCaptor.getValue();
        Assertions.assertThat(value).isNotNull()
                .extracting(Email::address, Email::title, Email::body)
                .contains("a", "t", "b");

    }

    @Test
    void testSendMail() {

        MailClient mailClient = new MailClient();
        try (var emailServer = Mockito.mockStatic(EmailServer.class)) {
           emailServer.when(() -> EmailServer.sendEmail(any(Email.class))).thenReturn(true);

            boolean result = mailClient.sendEmail("a", "t", "b");

            emailServer.verify(() -> EmailServer.sendEmail(emailCaptor.capture()));
            assertTrue(result);

            Email value = emailCaptor.getValue();
            Assertions.assertThat(value).isNotNull()
                    .extracting(Email::address, Email::title, Email::body)
                    .contains("a", "t", "b");
        }
    }

}