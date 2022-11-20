package com.example.wsbp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("UserMarker")
public class UserMarkerPage extends WebPage{
    public UserMarkerPage(){
        var toUserMakerLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toUserMakerLink);

        var userInfoForm = new Form<>("userInfo");
        add(userInfoForm);

        var userNameField = new TextField<>("userName");
        userInfoForm.add(userNameField);

        var userPassField = new PasswordTextField("userPass");
        userInfoForm.add(userPassField);
    }
}
