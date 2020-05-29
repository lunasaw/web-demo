package com.luna.web.email;
 
import java.io.InputStream;
import java.io.Serializable;
 
/**
 * @Description: 邮件模型
 * @author lc
 * @date 2018年4月24日
 */
public class EmailModelDTO implements Serializable{
 
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = -8840079326802564269L;
	
	/**
	 * 发送者
	 */
	private String from;
	
	/**
	 * 接受者
	 */
	private String[] to;
	
	/**
	 * 抄送
	 */
	private String[] cc;
	
	/**
	 * 邮件主题
	 */
	private String subject;
	
	/**
	 * 邮件内容
	 */
	private String text;
	
	/**
	 * 附件路径
	 */
	private String path;
	
	private InputStream is;
	
	public EmailModelDTO(String from, String[] to, String[] cc, String subject, String text, InputStream is){
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.text = text;
		this.is = is;
	}
 
	public String getPath() {
		return path;
	}
 
	public void setPath(String path) {
		this.path = path;
	}
 
	public String getFrom() {
		return from;
	}
 
	public void setFrom(String from) {
		this.from = from;
	}
 
	public String[] getTo() {
		return to;
	}
 
	public void setTo(String[] to) {
		this.to = to;
	}
 
	public String[] getCc() {
		return cc;
	}
 
	public void setCc(String[] cc) {
		this.cc = cc;
	}
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
 
	public String getSubject() {
		return subject;
	}
 
	public void setSubject(String subject) {
		this.subject = subject;
	}
 
	public String getText() {
		return text;
	}
 
	public void setText(String text) {
		this.text = text;
	}
 
	public InputStream getIs() {
		return is;
	}
 
	public void setIs(InputStream is) {
		this.is = is;
	}
	
}