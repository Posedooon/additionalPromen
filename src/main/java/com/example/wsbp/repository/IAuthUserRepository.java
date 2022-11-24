package com.example.wsbp.repository;
//データベースなどの、アプリケーション外のデータ元（データ・ソース）を使うときに、
// Springでは Repository というクラスを作成する。
public interface IAuthUserRepository {
    /**
     * ユーザー名とパスワードをAuthUserテーブルに記録する
     *
     * @param userName ユーザー名
     * @param userPass パスワード
     * @return データベースの更新行数
     */
    public int insert(String userName, String userPass);

    public int delete(String userName);

}