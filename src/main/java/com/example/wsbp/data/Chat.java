package com.example.wsbp.data;

import java.io.Serializable;

// AUTH_USER テーブルのデータを入れるクラス
// Wicketの Model に使うかもしれないクラスは、 implements Serializable をつける
public class Chat implements Serializable {

    private final String userName;  // Chatテーブルのuser_name列のデータ
    private final String textBody;  // Chatテーブルのmsg_body列のデータ

    public Chat(String userName, String textBody) {
        this.userName = userName;
        this.textBody = textBody;
    }

    public String getUserName() {
        return userName;
    }

    public String getTextBody() {
        return textBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chat chat = (Chat) o;

        if (!userName.equals(chat.userName)) return false;
        return textBody.equals(chat.textBody);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();
        result = 31 * result + textBody.hashCode();
        return result;
    }
}