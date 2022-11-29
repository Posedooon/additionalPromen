package com.example.wsbp.page;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("ChatComp")
public class ChatPageComp extends WebPage{

    public ChatPageComp(IModel<String> userTextModel){

        var userTextLabel = new Label("textBody",userTextModel);
        add(userTextLabel);
        var toHomeLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toHomeLink);
    }
}
