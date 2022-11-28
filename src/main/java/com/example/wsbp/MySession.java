package com.example.wsbp;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import java.util.Objects;
//ブラウザ毎に異なる情報を一時保存できるセッション
public class MySession extends AbstractAuthenticatedWebSession{
    //認証時に照合したユーザ名
    private String userName;

    public MySession(Request request){
        //コンストラクタ。初期状態では認証済みユーザはいない＝null
        super(request);
        this.userName = null;
    }
    @Override
    public Roles getRoles() {
        // 認証結果OK(userName = ユーザー名)だった場合は、誰もが "USER" 権限を持っているとして返す
        // 認証結果NG(userName = null）だった場合は、権限なしとして返す
        // wicket-auth-roles　では、この権限の有無と種類でページを表示してよいか判断してくれる

        if (isSignedIn()) {
            return new Roles(Roles.USER);
        }
        return new Roles();
        }

    @Override
    public boolean isSignedIn() {
        // 認証結果OK(userName = ユーザー名)だった場合は、trueを返す
        // 認証結果NG(userName = null）だった場合は、falseを返す
        return Objects.nonNull(this.userName);
    }

    public String getUserName() {
        // ユーザー名 を返す
        return this.userName;
    }

    public static MySession get() {
        // サーバーの中から Session を取り出す
        return (MySession) Session.get();
    }

}
/*特に重要なメソッド
sign...照合済みユーザを一時記録する。
セッションはブラウザごとに用意されるため、ブラウザごとのユーザ名
getRoles...認証したユーザの役割を返り値にする。Wicketはこの値を使って、ページを表示してよいかダメかを判定する。
この例では全員が USER（一般ユーザ） という役割になると一律で設定しているが、ユーザごとに管理者や
他の役割（学生、教育、ゲスト...）を区別するようにもできる。
get...クラスメソッド（staticなメソッド）なので、インスタンス化（new）せずに利用できる。
Wicketでセッション情報を変更したり取り出したりするときは、必ずこのメソッド経由で行う（後述）。
 */