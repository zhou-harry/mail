package com.harry.api.fallback;

import com.harry.api.domain.EmailDomain;
import com.harry.api.domain.LanguageDomain;
import com.harry.api.feign.MailApi;
import com.harry.api.response.ResponseData;

import java.util.Collections;
import java.util.List;

public class MailServiceFallback implements MailApi {
    @Override
    public List<LanguageDomain> findAll() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public ResponseData sendEmail(EmailDomain domain) {
        return new ResponseData(ResponseData.ERROR,"Fallback...",null);
    }
}
