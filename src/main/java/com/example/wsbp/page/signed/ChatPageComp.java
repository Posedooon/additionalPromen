package com.example.wsbp.page.signed;
import com.example.wsbp.page.HomePage;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.wicketstuff.annotation.mount.MountPath;
@AuthorizeInstantiation(Roles.USER)
@MountPath("ChatComp")
public class ChatPageComp extends WebPage{

    public ChatPageComp(IModel<String> userTextModel){

        var userTextLabel = new Label("textBody",userTextModel);
        add(userTextLabel);

        var toChatLink = new BookmarkablePageLink<>("toChat", ChatPage.class);
        add(toChatLink);

        var toSignedHome = new BookmarkablePageLink<>("toSignedHome", SignedPage.class);
        add(toSignedHome);
    }
}
