package org.hzz.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    private static int PORT = 8082;
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server start up at port: "+PORT);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("连接成功："+socket.getInetAddress().getHostAddress()
                        +" : " + socket.getPort());

                System.in.read(); // 阻塞
                System.out.println("开始读取RecvBuf的数据");
                byte[] bytes = new byte[1024*1024];
                InputStream inputStream = socket.getInputStream();
                int read = inputStream.read(bytes);
                System.out.println(new String(bytes,0,read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
