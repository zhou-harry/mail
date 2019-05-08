package com.harry.mail.controller;

import com.harry.api.domain.EmailDomain;
import com.harry.api.domain.LanguageDomain;
import com.harry.api.feign.MailApi;
import com.harry.api.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class MailClientController implements MailApi {

    @Autowired
    @Qualifier("feignMailApi")
    private MailApi mailApi;

    @GetMapping("/mail/find")
    public List<LanguageDomain> findAll() {
        return mailApi.findAll();
    }

    @PostMapping("/notify/email")
    public ResponseData sendEmail(@RequestBody EmailDomain domain) {
        return mailApi.sendEmail(domain);
    }
}
