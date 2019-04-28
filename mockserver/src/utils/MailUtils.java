package utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {

	private static final String MAIL_HOST = "smtp.163.com";
	private static final String USER = "gspublicmail@163.com";
	private static final String PSW = "gs2015";
	
	 public static void sendMail(String email, String subject, String emailMsg)
	            throws AddressException, MessagingException {
	        // 1.创建一个程序与邮件服务器会话对象 Session
	        Properties props = new Properties();
	        props.setProperty("mail.host", MAIL_HOST);
	        props.setProperty("mail.transport.protocol", "smtp");
	        props.setProperty("mail.smtp.auth", "true");
	        //1、创建session
	        Session session = Session.getInstance(props);
	        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	        session.setDebug(true);
	        //2、通过session得到transport对象
	        Transport ts = session.getTransport();
	        ts.connect(MAIL_HOST, USER, "gs2015");
			try {
	        	//创建邮件对象
		        MimeMessage message = new MimeMessage(session);
		        //指明邮件的发件人
		        message.setFrom(new InternetAddress(USER));
		        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
		        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		        //邮件的标题
		        message.setSubject(subject);
		        //邮件的文本内容
		        message.setContent(emailMsg, "text/html;charset=UTF-8");
				//5、发送邮件
	        	ts.sendMessage(message, message.getAllRecipients());
		        ts.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	
}
