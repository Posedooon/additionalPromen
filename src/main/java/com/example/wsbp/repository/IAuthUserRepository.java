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

    /**
     * ユーザー名を指定してAuthUserテーブルから削除する
     *
     * @param userName ユーザー名
     * @return データベースの更新行数
     */
    public int delete(String userName);

    /**
     * ユーザ名とパスワードが一致するレコードがAuthUserテーブルにあるか検索する
     *
     * @param userName ユーザー名
     * @param userPass パスワード
     * @return レコードの有無, 存在すれば<code>true</code>, それ以外は <code>false</code>
     */
    public boolean exists(String userName, String userPass);

}