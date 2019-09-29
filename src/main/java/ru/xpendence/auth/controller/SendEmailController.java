package ru.xpendence.auth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.auth.dto.EmailDto;
import ru.xpendence.auth.service.SendEmailService;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SendEmailController {
    private final SendEmailService sendEmailService;

    @PostMapping("/email")
    public boolean sendEmail(@RequestBody EmailDto emailDto) {
        return sendEmailService.sendEmail(emailDto);
    }
}