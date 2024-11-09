package com.spring_i18n.spring_i18n_multi_language.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("locale")
public class LocaleController {

    private final MessageSource messageSource;

    public LocaleController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String sayHello(){

        return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/with-header")
    public String sayHelloWithHeaders(@RequestHeader(name = "Accept-Language", required = false) Locale locale){

        return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
    }
}
