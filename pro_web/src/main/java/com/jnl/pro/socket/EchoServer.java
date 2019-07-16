package com.jnl.pro.socket;

import java.io.*;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class EchoServer {

    private ServerSocket server;

    private Integer port;
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10,20,100,TimeUnit.MICROSECONDS,new LinkedBlockingQueue(10));

    public EchoServer(Integer port){

        try {
            server = new ServerSocket();
            SocketAddress addr = new InetSocketAddress("127.0.0.1",port);
            server.bind(addr);
            System.out.println("------------------------ 启动成功");
            handleClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient() throws IOException {
        while(true){
            Socket client = server.accept();
            threadPool.execute( new Runnable() {
                @Override
                public void run() {
                    System.out.println(client.getInetAddress().getHostName()+"连接成功");
                    InputStream inputStream = null;
                    InputStreamReader isr = null;
                    BufferedReader br = null;
                    try {
                        inputStream = client.getInputStream();//输入流
                        isr = new InputStreamReader(inputStream);
                        br =new BufferedReader(isr);
                        String msg = null;
                        String hostName = client.getInetAddress().getHostName();
                        while ((msg = br.readLine())!=null){
                            System.out.println(hostName+":"+msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            inputStream.close();
                            isr.close();
                            br.close();
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    OutputStream outputStream = null;
                    BufferedReader br = null;
                    PrintWriter pw = null;
                    String msg = null;
                    String hostName = client.getInetAddress().getHostName();
                    br = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        outputStream = client.getOutputStream();//输出流
                        pw = new PrintWriter(outputStream);
                        while ((msg = br.readLine())!=null){
                            pw.write(msg+"\r\n");
                            pw.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public static void main(String[] args){
        System.out.println(new BigDecimal(0).compareTo(BigDecimal.ZERO));
    }
}
