package ru.xpendence.auth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.xpendence.auth.dto.EmailDto;
import ru.xpendence.auth.dto.EmailMessageDto;
import ru.xpendence.auth.dto.ResponseDto;
import ru.xpendence.auth.repository.PersonDeathGroupDao;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SendEmailService {
    private static final String URL_EMAIL_SENDER = "http://message:8082/email";
    private final PersonDeathGroupDao personDeathGroupDao;
    private final RestTemplate restTemplate;

    public boolean sendEmail(@NotNull EmailDto emailDto) {
        String email = personDeathGroupDao
                .findById(emailDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Not found person")).getEmail();
        EmailMessageDto request = new EmailMessageDto(
                email,
                "slava_rossii@list.ru",
                "Предложение курсов для переквалификации",
                "Список курсов: \n" + emailDto.getUrls().stream().collect(Collectors.joining("\n"))
        );
        log.info("sending message to url {}: {}", URL_EMAIL_SENDER, request);
        ResponseDto response = restTemplate.postForObject(
                URL_EMAIL_SENDER,
                request,
                ResponseDto.class
        );
        return Objects.nonNull(response) ? response.getSuccess() : false;
    }
}
