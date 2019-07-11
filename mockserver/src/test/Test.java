package test;

import utils.SendMsgUtil;
import utils.StringUtil;


public class Test {

	public static void main(String[] args) {
		System.out.println(StringUtil.getIp());
//		try {
//			MailUtils.sendMail("huangshan0@gaosiedu.com" , "apk打包成功了" , "放假had会计师过的痕迹开始干");
//		} catch (AddressException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
		
//		String postResult = SendMsgUtil.sendText("22354165-c0e0-40ab-8280-3fafe5da61a9", "学生端Android出新包了, 赶快去下载吧！\n\r下载地址：https://www.pgyer.com/xsd-android");
		String postResult = SendMsgUtil.sendText("22354165-c0e0-40ab-8280-3fafe5da61a9"
				, "学生端Android出新包了, 赶快去下载吧！\n\r下载地址：https://www.pgyer.com/xsd-android" 
				, new String[]{"lilei3" , "@all"} );
		System.out.println(postResult);
	}
	
}
