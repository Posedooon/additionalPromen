package com.example.wsbp.page.signed;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@MountPath("Signed")
public class SignedPage extends WebPage{
    public SignedPage(){
        var name = Model.of("test");
        var userNameLabel = new Label("userName",name);
        add(userNameLabel);
    }
    //HTML->認証が終わったユーザに、認証済みである胸とそのIDを表示させてる
    //Java-＞wicked:id=userの部分を認証できたユーザの名前として、書き換える予定だが、
    //テスト段階であるためモデル：testをつかっている状態。パスを~/Signedとすれば動作チェック可能
}
