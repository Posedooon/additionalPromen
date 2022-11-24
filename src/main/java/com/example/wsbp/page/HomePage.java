package com.example.wsbp.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.wicketstuff.annotation.mount.MountPath;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

@WicketHomePage
@MountPath("Home")
public class HomePage extends WebPage{
    SampleService sampleService = new SampleService();
    public HomePage(){
        //乱数
        var rand = Model.of(sampleService.makeRandInt());
        var randLabel = new Label("rand",rand);
        add(randLabel);
        var youModel = Model.of("Wicket-Spring-Boot");
        var youLabel = new Label("you", youModel);
        add(youLabel);
    //学籍番号を表示させるラベル
        var gakuseki = Model.of("B2200930");
        var gakusekiLabel = new Label("gakuseki",gakuseki);
        add(gakusekiLabel);
    //名前を表示させるラベル
        var name = Model.of("工藤彰太");
        var nameLabel = new Label("name",name);
        add(nameLabel);
    //BookmarkablePageLinkコンポーネントを使って、toUserMaker のタグを UserMakerPage へのリンクに書き換えるようにする。
        var toUserMakerLink = new BookmarkablePageLink<>("toUserMaker", UserMarkerPage.class);
        add(toUserMakerLink);

        //BookmarkablePageLinkコンポーネントを使って、toUserDeleter のタグを UserDeleterPage へのリンクに書き換えるようにする。
        var toUserDeleterLink = new BookmarkablePageLink<>("toUserDeleter", UserDeletePage.class);
        add(toUserDeleterLink);
    }
}
/*
@WicketHomePage は、Wicket-Spring-Bootが表示する最初のページに設定する
@MountPath("Home") は、HomePageクラスとそのHTMLを http://.../Home というURLでアクセスできるよう、URLのファイルパス部を設定する
Wicketが提供する WebPage クラスを継承することで、同じ名前のHTMLファイルを書き換える能力をもつ
*/
