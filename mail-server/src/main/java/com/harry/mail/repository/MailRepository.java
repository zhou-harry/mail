package com.harry.mail.repository;

import com.harry.api.domain.LanguageDomain;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MailRepository {

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    public List<LanguageDomain> findAll() {

        return sessionTemplate.selectList("findAll");
    }
}
