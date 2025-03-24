package com.dst.funds;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private StringUtils stringUtils;

    @InjectMocks
    private Service service;


    @Test
    void testDoShit() {

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        service.doShit();

        verify(stringUtils).isEmpty(captor.capture());
        assertThat(captor.getValue()).isEqualTo("");

    }



}
