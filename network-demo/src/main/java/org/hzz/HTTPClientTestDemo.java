package org.hzz;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @Author 静默
 * @Email 1193094618@qq.com
 */
public class HTTPClientTestDemo {
    public static void main(String[] args) {
        try(
                Socket socket = new Socket("localhost",8087);
                PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));){

                out.println(oneHttp());
                String msg;
                while((msg = in.readLine()) != null){
                    System.out.println(msg);
                }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String oneHttp() {
        // 请求行
        StringBuffer sb = new StringBuffer("GET /servlet-demo/helloServlet HTTP/1.1\r\n");
        // 请求头
        sb.append("Host: localhost:8087\r\n");
        sb.append("Connection: keep-alive\r\n");
        sb.append("Cookie: Hm_lvt_8b02a318fde5831da10426656a43d03c=1637624849; _ga=GA1.1.1405518053.1637624850; password=admin; username=admin\r\n");
        sb.append("\r\n");


//        // 结束请求头
//        sb.append("123");

        return sb.toString();
    }
}
