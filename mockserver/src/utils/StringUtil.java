package utils;

import java.io.File;
import java.net.*;
import java.util.*;

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
        return getWebRootAiXueXiResStrAbsolutePath(httpServlet.getServletContext(),group);
    }
    /**
     * 获取webroot下面aixuexiapp/apk下面的文件
     *
     * @return WebRoot目录的绝对路径
     */
    public static String[] getWebRootAiXueXiResStrAbsolutePath(ServletContext httpServlet, String group) {
        String path = "";
        if (StringUtil.isBlank(group)) {
            path = httpServlet.getRealPath("/aixuexiapp/res");
        } else {
            path = httpServlet.getRealPath("/aixuexiapp/res") + File.separator + group;
        }
        File file = new File(path);
        return file.list();
    }
    /**
     * 获取ip地址
     *
     * @return
     */
    public static String getIp() {
//        InetAddress hostAddress = null;
//        try {
//            hostAddress = getLocalHostLANAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        if (hostAddress != null) {
//            System.out.println("hostAddress" + hostAddress.getHostAddress());
//            return "http://" + hostAddress.getHostAddress() + ":8080/mockserver";
//        }
        return "http://192.168.0.228:8080/mockserver";

    }

    // 正确的IP拿法，即优先拿site-local地址  https://www.jianshu.com/p/87b8ff9a466b
    private static InetAddress getLocalHostLANAddress() throws UnknownHostException {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr;
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress;
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            if (jdkSuppliedAddress == null) {
                throw new UnknownHostException("The JDK InetAddress.getLocalHost() method unexpectedly returned null.");
            }
            return jdkSuppliedAddress;
        } catch (Exception e) {
            UnknownHostException unknownHostException = new UnknownHostException(
                    "Failed to determine LAN address: " + e);
            unknownHostException.initCause(e);
            throw unknownHostException;
        }
    }
}

