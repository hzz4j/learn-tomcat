package org.hzz.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 8082)){
            OutputStream outputStream = socket.getOutputStream();
            int count = 0;
            while(true){
                outputStream.write("123".getBytes());
                System.out.println(++count);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
