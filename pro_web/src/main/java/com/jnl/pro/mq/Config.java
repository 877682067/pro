package com.jnl.pro.mq;

public class Config {

    private String host;
    private int port;
    private String userName;
    private String passWord;


    public Config(String host,int port,String userName,String passWord){
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
