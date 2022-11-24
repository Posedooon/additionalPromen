package com.example.wsbp.service;
//サービス-＞リポジトリを利用する部分
public interface IUserService {

    public void registerUser(String userName, String userPass);
    public void deleteUser(String userName);

}