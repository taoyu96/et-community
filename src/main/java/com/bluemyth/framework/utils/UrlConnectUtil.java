package com.bluemyth.framework.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlConnectUtil {

    private static final String DEFAULT_ENCODING = "UTF-8";

    public static String httpConnect(String url, String method, String data) {
        HttpURLConnection hc =null;
        StringBuilder result = new StringBuilder();
        try {
            URL httpurl = new URL(url);  //创建一个URL对象
            long s = System.currentTimeMillis();
            hc = (HttpURLConnection) httpurl.openConnection();
            hc.setConnectTimeout(5 * 1000);  //设置连接超时(毫秒)
            String Method = method.toUpperCase();
            hc.setRequestMethod(Method);  //设置提交方式get或者post
            //URL 连接可用于输入和/或输出。将 doInput 标志设置为 true，指示应用程序要从 URL 连接读取数据。
            hc.setDoInput(true);
            if ("POST".equals(Method)) {
                //post请求一定要容许输出
                hc.setDoInput(true);
                hc.setDoOutput(true);
                if (data != null) {
                    //设置文件的总长度
                    hc.setRequestProperty("Content-Length",
                            String.valueOf(data.length()));
                }
            }

            hc.setUseCaches(false);   //设置缓存
            //hc.setRequestProperty("Content-Type", "text/xml"); //设置文件类型
            hc.setRequestProperty("Content-Type", "application/json"); //设置文件类型
            hc.setRequestProperty("Charset", DEFAULT_ENCODING); //设置字符集
            hc.connect();  //连接
            if ("POST".equals(Method)) {
                OutputStream ops = hc.getOutputStream();
                byte[] buff;
                if (data != null) {
                    buff = data.getBytes(DEFAULT_ENCODING);    //设置请求参数为二进制流为UTF-8编码格式
                    ops.write(buff);
                }
                ops.flush();//刷空输出流，并输出所有被缓存的字节
                ops.close();//流操作完毕后关闭
            }

            //System.out.println("Http Status Code:" + hc.getResponseCode()); //请求响应代码
            //System.out.println("request headers : " + hc.getHeaderFields()); //请求头文件
            int code = hc.getResponseCode();
            if (code == 200) {
                InputStream ins;
                ins = hc.getInputStream();
                //将返回的字节流转换为字符流
                InputStreamReader isr = new InputStreamReader(ins, DEFAULT_ENCODING);
                char[] cbuf = new char[1024];
                int i = isr.read(cbuf);
                while (i > 0) {
                    result.append(new String(cbuf, 0, i));
                    i = isr.read(cbuf);
                }
                ins.close();

            } else {
                System.out.println("连接发生错误，错误代码：" + code);
                InputStream ins;
                ins = hc.getErrorStream();
                InputStreamReader isr = new InputStreamReader(ins);
                char[] cbuf = new char[1024];
                int i = isr.read(cbuf);
                while (i > 0) {
                    result.append(new String(cbuf, 0, i));
                    i = isr.read(cbuf);
                }
                System.out.println("error:" + result);
                //关闭输出流
                ins.close();
            }

            //关闭请求
            hc.disconnect();
            long e = System.currentTimeMillis();
            long time = e - s;
            System.out.println("耗时: " + time + "毫秒");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(hc !=null) hc.disconnect();
        }

        return result.toString();
    }

    public static int checkConnect(String url, String method) {
        HttpURLConnection hc = null;
        try {
            URL httpurl = new URL(url);  //创建一个URL对象
            hc = (HttpURLConnection) httpurl.openConnection();
            hc.setReadTimeout(15 * 1000);  //设置连接超时(毫秒)
            hc.setConnectTimeout(5 * 1000);  //设置连接超时(毫秒)
            String Method = method.toUpperCase();
            hc.setRequestMethod(Method);  //设置提交方式get或者post
            hc.setUseCaches(false);   //设置缓存
            hc.setRequestProperty("Content-Type", "text/xml"); //设置文件类型
            //hc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); //设置文件类型
            hc.setRequestProperty("Charset", DEFAULT_ENCODING); //设置字符集
            hc.connect();  //连接
            //System.out.println("Http Status Code:" + hc.getResponseCode()); //请求响应代码
            return hc.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (hc != null) hc.disconnect();
        }

        return 999;
    }

    /**
     * 解码
     * @param str
     * @param charset
     * @return
     */
    public static  String decode(String str,String charset){
        try {
            if(StringUtils.isBlank(charset)) charset = DEFAULT_ENCODING;
            str = URLDecoder.decode(str, charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 编码
     * @param str
     * @param charset
     * @return
     */
    public static  String encode(String str,String charset){
        try {
            if(StringUtils.isBlank(charset)) charset = DEFAULT_ENCODING;
            str = URLEncoder.encode(str,charset);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //String url = "http://www.chinaweal.com.cn:7888/oa";
        String url = "http://127.0.0.1:8088/monitor-ws/rest/annualReport?cityname="+encode("珠海","UTF-8");
        System.out.println(url);
        System.out.println(checkConnect(url, "get"));
    }
}
