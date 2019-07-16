package com.jnl.pro.socket;

import java.io.*;
import java.net.Socket;

public class EchoClient {

    private Socket socket;
    EchoClient(String remoteHost,int port){
        try {
            socket = new Socket(remoteHost,port);
            OutputStream os = socket.getOutputStream();
            new Thread( new Runnable(){
                @Override
                public void run() {
                    String msg = null;
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    BufferedWriter pw  = new BufferedWriter(new OutputStreamWriter(os));
                    try {
                        while((msg = br.readLine())!=null){
                            pw.write(msg+"\r\n");
                            pw.flush();
                        }
                    } catch (IOException e) {
                        try {
                            pw.close();
                            br.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        e.printStackTrace();
                    }
                }
            }).start();
            InputStream is = socket.getInputStream();
            BufferedReader response = new BufferedReader(new InputStreamReader(is));
            String responseMsg = null;
            while((responseMsg = response.readLine())!=null){
                System.out.println(responseMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }

    public static void main(String[] args){
        new EchoClient("127.0.0.1",8089);
    }
}
