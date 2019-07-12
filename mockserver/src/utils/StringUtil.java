package utils;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public class StringUtil {


    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * 随机生成字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //长度为几就循环几次
        for (int i = 0; i < length; ++i) {
            //产生0-61的数字
            int number = random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    /**
     * 获取webroot下面aixuexiapp/apk下面的文件
     *
     * @return WebRoot目录的绝对路径
     */
    public static String[] getWebRootAiXueXiAppAbsolutePath(HttpServlet httpServlet) {
        String path = httpServlet.getServletContext().getRealPath("/aixuexiapp/apk/");
        File file = new File(path);
        String[] listFile = file.list();
        return listFile;
    }

    /**
     * 获取webroot下面aixuexiapp/res下面的文件
     *
     * @return WebRoot目录的绝对路径
     */
    public static File[] getWebRootAiXueXiResAbsolutePath(HttpServlet httpServlet, String group) {
        String path = "";
        if (StringUtil.isBlank(group)) {
            path = httpServlet.getServletContext().getRealPath("/aixuexiapp/res/");
        } else {
            path = httpServlet.getServletContext().getRealPath("/aixuexiapp/res/") + File.separator + group;
        }
        File file = new File(path);
        File[] listFile = file.listFiles();
        return listFile;
    }
    /**
     * 获取webroot下面aixuexiapp/res下面的文件
     *
     * @return WebRoot目录的绝对路径
     */
    public static File[] getWebRootAiXueXiResAbsolutePath(ServletContext httpServlet, String group) {
        String path = "";
        if (StringUtil.isBlank(group)) {
            path = httpServlet.getRealPath("/aixuexiapp/res/");
        } else {
            path = httpServlet.getRealPath("/aixuexiapp/res/") + File.separator + group;
        }
        File file = new File(path);
        File[] listFile = file.listFiles();
        return listFile;
    }
    /**
     * 获取webroot下面aixuexiapp/apk下面的文件
     *
     * @return WebRoot目录的绝对路径
     */
    public static String[] getWebRootAiXueXiResStrAbsolutePath(HttpServlet httpServlet, String group) {
        String path = "";
        if (StringUtil.isBlank(group)) {
            path = httpServlet.getServletContext().getRealPath("/aixuexiapp/res");
        } else {
            path = httpServlet.getServletContext().getRealPath("/aixuexiapp/res") + File.separator + group;
        }
        File file = new File(path);
        return file.list();
    }
    
    /**
     * 获取ip地址
     * @return
     */
    public static String getIp() {
		return "http://10.39.3.203:8080/mockserver";
    }
}

