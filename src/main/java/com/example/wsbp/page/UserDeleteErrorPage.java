package com.example.wsbp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("UserDeleteError")
public class UserDeleteErrorPage extends WebPage{

    public UserDeleteErrorPage(IModel<String> userNameModel){
        var userNameLabel = new Label("userName",userNameModel);
        add(userNameLabel);

        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);
    }
}
