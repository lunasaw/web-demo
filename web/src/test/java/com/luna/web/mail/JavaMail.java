package com.luna.web.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Luna@win10
 * @date 2020/4/11 15:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaMail {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Test
	public void aTest() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		//邮件设置

		//标题
		simpleMailMessage.setSubject("通知. 王者上号");
		//内容
		simpleMailMessage.setText("排位");
		//发送人地址
		simpleMailMessage.setTo("15696756582@163.com");
		simpleMailMessage.setFrom("1173282254@qq.com");

		javaMailSender.send(simpleMailMessage);
	}

	@Test
	public void bTest() throws MessagingException, FileNotFoundException {
		//创建复杂邮件
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

		//标题
		mimeMessageHelper.setSubject("通知. 王者");
		//内容
		mimeMessageHelper.setText("<b style='color:red'>排位上号</b>",true);
		//获取类路径下
		String path = ResourceUtils.getURL("classpath:static/").getPath();
		//上传文件
		mimeMessageHelper.addAttachment("favicon.ico",new File(path+"favicon.ico"));
		mimeMessageHelper.addAttachment("luna.png",new File(path+"luna.png"));
		//发送人地址
		mimeMessageHelper.setTo("15696756582@163.com");
		mimeMessageHelper.setFrom("1173282254@qq.com");

		javaMailSender.send(mimeMessage);
	}
}
