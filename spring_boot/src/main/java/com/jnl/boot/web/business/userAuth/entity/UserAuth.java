package com.jnl.boot.web.business.userAuth.entity;


public class UserAuth{

    private Integer id;//

    private Integer userId;//

    private String platform;//

    private String accessToken;//

    private Boolean isAuth;//

    private String loginName;

    private Boolean isLock;

    public void setId(Integer  id){
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    public void setUserId(Integer  userId){
        this.userId = userId;
    }
    public Integer getUserId(){
        return userId;
    }
    public void setPlatform(String  platform){
        this.platform = platform;
    }
    public String getPlatform(){
        return platform;
    }
    public void setAccessToken(String  accessToken){
        this.accessToken = accessToken;
    }
    public String getAccessToken(){
        return accessToken;
    }

    public Boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Boolean getIsLock() {
        return isLock;
    }

    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }
}