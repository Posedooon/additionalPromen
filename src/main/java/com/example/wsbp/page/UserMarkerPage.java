package com.example.wsbp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

import javax.sound.midi.Soundbank;

@MountPath("UserMarker")
public class UserMarkerPage extends WebPage{
    public UserMarkerPage(){
        //送信されたユーザ名、パスワードを受け取り管理するインスタンスを作成
        var userNameModel = Model.of("");
        var userPassModel = Model.of("");
        //匿名クラス（無名クラス）を使用してデータ送信時の処理を書く
        //新しくクラスを作成せずに抽象クラスやインタフェースをそのままインスタンス化させるような動作を行うことができる。
        var userInfoForm = new Form<>("userInfo"){
            @Override
            //送信ボタンを押すとonSubmitが実行される
            protected void onSubmit(){
                var userName = userNameModel.getObject();
                var userPass = userPassModel.getObject();
                var msg = "送信データ:"
                        +userName
                        +","
                        +userPass;
                System.out.println(msg);
                //次に表示するページを表示させる命令。onSubmitやデータを
                // 他のページに移動させるLinkコンポーネント等で利用する
                setResponsePage(new UserMakerCompPage(userNameModel));
                //userNameModelを渡しているので、それを利用したページを精製・移動できる
            }
        };
        add(userInfoForm);

        var toUserMakerLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toUserMakerLink);

        var userNameField = new TextField<>("userName",userNameModel);
        userInfoForm.add(userNameField);

        var userPassField = new PasswordTextField("userPass",userPassModel);
        userInfoForm.add(userPassField);
    }
}
