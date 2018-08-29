package utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.swetake.util.Qrcode;

public class CreateQRCode {
	
	public void productQcode(String url) throws IOException {
		   Qrcode qrcode = new Qrcode();
		   qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
		   qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
		   qrcode.setQrcodeVersion(7);//版本
		   //生成二维码中要存储的信息
		   String qrData = url;
		   //设置一下二维码的像素
		   int width = 500;
		   int height = 500;
		   BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		   //绘图
		   Graphics2D gs = bufferedImage.createGraphics();
		   gs.setBackground(Color.WHITE);
		   gs.setColor(Color.BLACK);
		   gs.clearRect(0, 0, width, height);//清除下画板内容
		   
		   //设置下偏移量,如果不加偏移量，有时会导致出错。
		   int pixoff = 2;
		   
		   byte[] d = qrData.getBytes("gb2312");
		   if(d.length > 0 && d.length <120){
			   boolean[][] s = qrcode.calQrcode(d);
			   for(int i=0;i<s.length;i++){
				   for(int j=0;j<s.length;j++){
					   if(s[j][i]){
						   gs.fillRect(j*3+pixoff, i*3+pixoff, 3, 3);
					   }
				   }
			   }
		   }
		   gs.dispose();
		   bufferedImage.flush();
		   ImageIO.write(bufferedImage, "png", new File("E:/code/qrcode.png"));
	}
	
	public void encoderQRCoder(String content, HttpServletResponse response) {  
        try {  
            Qrcode handler = new Qrcode();  
            handler.setQrcodeErrorCorrect('M');  
            handler.setQrcodeEncodeMode('B');  
            handler.setQrcodeVersion(7);  
            byte[] contentBytes = content.getBytes("UTF-8");  
            BufferedImage bufImg = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);  
            Graphics2D gs = bufImg.createGraphics();  
            gs.setBackground(Color.WHITE);  
            gs.clearRect(0, 0, 150, 150);  
            //设定图像颜色：BLACK  
            gs.setColor(Color.BLACK);  
            //设置偏移量  不设置肯能导致解析出错  
            int pixoff = 2;  
            //输出内容：二维码  
            if(contentBytes.length > 0 && contentBytes.length < 124) {  
                boolean[][] codeOut = handler.calQrcode(contentBytes);  
                for(int i = 0; i < codeOut.length; i++) {  
                    for(int j = 0; j < codeOut.length; j++) {  
                        if(codeOut[j][i]) {  
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff,3, 3);  
                        }  
                    }  
                }  
            } else {  
                System.err.println("QRCode&nbsp;content&nbsp;bytes&nbsp;length&nbsp;=&nbsp;" + contentBytes.length + "&nbsp;not&nbsp;in&nbsp;[&nbsp;0,120&nbsp;].&nbsp;");  
            }  
            gs.dispose();  
            bufImg.flush();  
            //生成二维码QRCode图片  
            ImageIO.write(bufImg, "jpg", response.getOutputStream());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
	
}
