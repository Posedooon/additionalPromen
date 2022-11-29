package com.example.wsbp.page;


import com.example.wsbp.service.IUserService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.validation.validator.StringValidator;
import org.wicketstuff.annotation.mount.MountPath;
import org.apache.wicket.model.Model;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;


@MountPath("Chat")
public class ChatPage extends WebPage {
    // ServiceをIoC/DIする
    @SpringBean
    private IUserService userService;

    public ChatPage(){
        //送信されたユーザ名、メッセージ受け取り管理するインスタンスを作成
        var userNameModel = Model.of("");
        var userTextModel = Model.of("");
        //匿名クラス（無名クラス）を使用してデータ送信時の処理を書く
        var userInfoForm = new Form<Void>("userInfo") {
            //匿名クラス
            @Override
            //送信ボタンを押すとonSubmitが実行される
            protected void onSubmit() {
                var userName = userNameModel.getObject();
                var userText = userTextModel.getObject();
                var msg = "送信データ:"
                        + userName
                        + ","
                        + userText;
                System.out.println(msg);
                //次に表示するページを表示させる命令。onSubmitやデータを
                // 他のページに移動させるLinkコンポーネント等で利用する
                setResponsePage(new ChatPageComp(userTextModel));
                //userNameModelを渡しているので、それを利用したページを精製・移動できる
                // IoC/DI した userService のメソッドを呼び出す
                userService.sendMessageUser(userName,userText);
                setResponsePage(new ChatPageComp(userTextModel));
            }
        };
        add(userInfoForm);


        //var toUserMakerLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        //add(toUserMakerLink);

        var userNameField = new TextField<>("userName", userNameModel) {
            // onInitialize() は全てのコンポーネントに備わっている、初期化時の処理。
            // オーバーライドするときは super.onInitialize() を忘れずに残しておく。
            @Override
            protected void onInitialize() {
                super.onInitialize();
                // 文字列の長さを8〜32文字に制限するバリデータ
                var validator = StringValidator.lengthBetween(8, 32);
                add(validator);
            }
        };
        userInfoForm.add(userNameField);

        var userTextField = new TextField<>("textBody", userTextModel) {
            @Override
            protected void onInitialize() {
                super.onInitialize();
                var validator = StringValidator.lengthBetween(1, 200);
                add((validator));
            }
        };
        userInfoForm.add(userTextField);

    }
}
