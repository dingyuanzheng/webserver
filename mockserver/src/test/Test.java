package test;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import utils.MailUtils;


public class Test {

	public static void main(String[] args) {
		try {
			MailUtils.sendMail("huangshan0@gaosiedu.com" , "apk打包成功了" , "放假had会计师过的痕迹开始干");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
