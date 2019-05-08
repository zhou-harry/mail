package com.harry.api.feign;

import com.harry.api.domain.EmailDomain;
import com.harry.api.domain.LanguageDomain;
import com.harry.api.fallback.MailServiceFallback;
import com.harry.api.response.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "mail-server", qualifier = "feignMailApi", fallback = MailServiceFallback.class)
public interface MailApi {

    @GetMapping("/mail/find")
    List<LanguageDomain> findAll();

    @PostMapping("/mail/notify/email")
    public ResponseData sendEmail(@RequestBody EmailDomain domain);

}
