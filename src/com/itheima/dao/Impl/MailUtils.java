package com.itheima.dao.Impl;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {
	public static void sendMail(String to) {
		/*
		 * 1、获得一个session对象 2、创建一个邮件对象messenge 3、发送 Transport *
		 */
		// 1、创建连接对象 sender
		Properties props = new Properties();
		// 设置邮件服务器主机名
		props.setProperty("mail.host", "localhost");
		// 设置环境信息
		Session session = Session.getInstance(props, new Authenticator() {
			// 在session中设置账户信息，Transport发送邮件时会使用
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@shop.com", "1");
			}
		});
		// 2、创建邮件对象 message
		Message message = new MimeMessage(session);
		try {
			// 设置发件人
			message.setFrom(new InternetAddress("service@shop.com"));
			// 设置收件人
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 设置标题
			message.setSubject("注册邮件");
			message.setContent("恭喜您成为本站成员", "text/html;charset=UTF-8");
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
