package com.luna.web.email;

import com.alibaba.fastjson.JSONArray;
import com.luna.common.utils.DateUtils;
import com.luna.web.jpa.controller.JpaUserController;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Luna@win10
 * @date 2020/4/11 15:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaMail {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	private static Logger log = LoggerFactory.getLogger(JavaMail.class);

	@Test
	public void aTest() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		//邮件设置

		//标题
		simpleMailMessage.setSubject("通知. 王者上号");
		//内容
		simpleMailMessage.setText("排位");
		//发送人地址
		simpleMailMessage.setTo("864636142@qq.com");
		simpleMailMessage.setFrom("1173282254@qq.com");

		javaMailSender.send(simpleMailMessage);
	}

	@Test
	public void bTest() throws MessagingException, FileNotFoundException {
		//创建复杂邮件
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");


		//标题
		mimeMessageHelper.setSubject("通知. 王者");
		//内容
		mimeMessageHelper.setText("<b style='color:red'>排位上号</b>", true);
		//获取类路径下
		String path = ResourceUtils.getURL("classpath:static/").getPath();
		//上传文件
//		mimeMessageHelper.addAttachment("favicon.ico",new File(path+"favicon.ico"));
//		mimeMessageHelper.addAttachment("luna.png",new File(path+"luna.png"));
		//发送人地址
		mimeMessageHelper.setTo("864636142@qq.com");
//		mimeMessageHelper.setFrom("1173282254@qq.com");
		//设置自定义发件人昵称
		String nick = "";
		try {
			nick = javax.mail.internet.MimeUtility.encodeText("Luna");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		mimeMessage.setFrom(new InternetAddress(nick + " <" + "1173282254@qq.com" + ">"));

		javaMailSender.send(mimeMessage);
	}

	@Autowired
	private MailService mailService;

	@Test
	public void test() {
		// 发送邮件
		String[] to = null;
		String content = "测试";
		String from = "1173282254@qq.com";
		ArrayList<String> list = new ArrayList<>();
		list.add("1956493136@qq.com");
		list.add("15696756582@163.com");

		String subject = "短信发送失败通知（" + DateUtils.getDate() + "） ";
		log.info("短信平台通知邮件信息（邮件）：{}", content);
		to = list.toArray(new String[list.size()]);
		EmailModelDTO email = new EmailModelDTO(from, to, null, subject, content, null);
		mailService.sendSimpleMail(email);
	}

	@Test
	public void sendmail() {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = null;
		try {
			helper = new MimeMessageHelper(message, true, "UTF-8");
			helper.setTo(new String[]{"15696756582@163.com"});
			helper.setCc("1956493136@qq.com");
			helper.setFrom("1173282254@qq.com");
			helper.setSubject("测试高逼格邮件");
			helper.setText(buildContent(), true);
//			String path = ResourceUtils.getURL("classpath:static/").getPath();
//			String alarmIconName = "success-alarm.png";
//			ClassPathResource img = new ClassPathResource("D:\\myproject\\luna-demo\\web\\src\\main\\resources\\static\\success-alarm.png");
//			if (Objects.nonNull(img)) {
//				helper.addInline("icon-alarm", img);
//			}
			javaMailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String buildContent() throws IOException {

		//加载邮件html模板
		String fileName = "luna-message.html";
//		InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName);
		String path = ResourceUtils.getURL("classpath:static/").getPath();
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(path+fileName)));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			while ((line = fileReader.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			log.error("读取文件失败，fileName:{}", fileName, e);
		} finally {
//			inputStream.close();
			fileReader.close();
		}


		String contentText = "以下是服务信息, 敬请查看.<br>below is the information of service instance scale, please check. ";
		//邮件表格header
		String header = "<td>分区(Namespace)</td><td>服务(Service)</td><td>伸缩结果(Scale Result)</td><td>伸缩原因(Scale Reason)</td><td>当前实例数(Pod instance number)</td>";
		StringBuilder linesBuffer = new StringBuilder();
		linesBuffer.append("<tr><td>" + "myNamespace" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
				"<td>" + "mReason" + "</td><td>" + "my4" + "</td></tr>");

		//绿色
		String emailHeadColor = "#10fa81";
		String date = DateFormatUtils.format(new Date(), "yyyy/MM/dd HH:mm:ss");
		//填充html模板中的五个参数
		String htmlText = MessageFormat.format(buffer.toString(), emailHeadColor, contentText, date, header, linesBuffer.toString());

		//改变表格样式
		htmlText = htmlText.replaceAll("<td>", "<td style=\"padding:6px 10px; line-height: 150%;\">");
		htmlText = htmlText.replaceAll("<tr>", "<tr style=\"border-bottom: 1px solid #eee; color:#666;\">");
		return htmlText;
	}

}
