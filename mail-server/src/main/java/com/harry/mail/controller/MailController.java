package com.harry.mail.controller;

import com.harry.api.domain.EmailDomain;
import com.harry.api.domain.LanguageDomain;
import com.harry.api.response.ResponseData;
import com.harry.mail.repository.MailRepository;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("mail")
public class MailController {

    private Random random = new Random();

    private final MailRepository repository;
    private final Mailer mailer;
    //template模板引擎
    private final TemplateEngine templateEngine;

    public MailController(MailRepository repository, Mailer mailer, TemplateEngine templateEngine) {
        this.repository = repository;
        this.mailer = mailer;
        this.templateEngine = templateEngine;
    }

    @GetMapping("/find")
    public List<LanguageDomain> find() {
        return repository.findAll();
    }

    @Async
    @PostMapping("/notify/email")
    public ResponseData sendEmail(@RequestBody EmailDomain domain) {
        //定义模板数据
        Context context = new Context();
        context.setVariables(domain.getVariables());
        //获取thymeleaf的html模板
//        String emailContent = templateEngine.process("/mail/mail", context); //指定模板路径

        //动态模板
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        StringTemplateResolver stringTemplateResolver = new StringTemplateResolver();
        stringTemplateResolver.setCacheable(true);
        stringTemplateResolver.setTemplateMode(TemplateMode.HTML);
        springTemplateEngine.setTemplateResolver(stringTemplateResolver);

        StringBuffer format = new StringBuffer();
        format.append("<SPAN lang=EN-US style='FONT-WEIGHT: normal; FONT-SIZE: 12pt; FONT-STYLE: italic; FONT-FAMILY: Arial;'>");
        format.append("<b>尊敬的用户:  <span th:text=\"${name}\" />，您好</b>：");
        format.append("<br><br>");
        format.append("您的手机号为：<a th:href=\"${url}\"  th:text=\"${phone}\"></a>");//内容
        format.append("<br><br>");
        format.append("</SPAN>");
        format.append("<SPAN lang=EN-US style='FONT-WEIGHT: normal; FONT-SIZE: 12pt; FONT-STYLE: italic; FONT-FAMILY: Times New Roman;'>");
        format.append("<br><br><br>系统邮件，请勿回复</SPAN>");

        String emailContent = springTemplateEngine.process(format.toString(), context);

        System.out.println("邮件内容：" + emailContent);
        //发送邮件
        Email email = EmailBuilder.startingBlank()
                .to(null, domain.getTo())
                .withSubject(domain.getSubject())
                .withHTMLText(emailContent)
                .buildEmail();

        mailer.sendMail(email, true);

        ResponseData data = new ResponseData(domain.getFromID() + "-" + random.nextInt(100000));
        data.setMessage(ResponseData.SUCCESS);

        return data;
    }

}
