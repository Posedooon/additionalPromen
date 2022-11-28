package com.example.wsbp.service;

import com.example.wsbp.repository.IAuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    private IAuthUserRepository authUserRepos;

    @Autowired
    public UserService(IAuthUserRepository authUserRepos){
        this.authUserRepos = authUserRepos;
    }

    @Override
    public void registerUser(String userName, String userPass){
        int n = authUserRepos.insert(userName,userPass);
        System.out.println("記録行数:"+n);
    }
    @Override
    public void deleteUser(String userName){
        int n = authUserRepos.delete(userName);
        System.out.println("記録行数:"+n);
    }
    @Override
    public boolean existsUser(String userName, String userPass) {
        var result = authUserRepos.exists(userName, userPass);
        System.out.println(userName + ", " + userPass + " のユーザ照合結果：" + result);
        return result;
    }
    /*
ブラウザから入力・送信された値は、UserMakerPage の Form の onSubmit の中で取得される
UserMakerPage の Form は、 IUserService のregisterUser機能に、取得した入力値（記録してほしいユーザIdとパスワード）を依頼する
IUserService の registerUser 機能は、渡された入力値を IAuthUserRepository の insert 機能に依頼する
IAuthUserRepository の insert 機能 は、H2DBにデータの登録を依頼し、呼び出し元に記録行数を返す
IUserService の registerUser 機能は、IAuthUserRepository から返された記録行数を標準出力に表示する
UserMakerPage の Form は、IUserService の registerUser機能の終了後、UserMakerCompPageを作ってブラウザに返す
ブラウザに UserMakerCompPage が表示される
*/
}
