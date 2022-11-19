package com.example.wsbp.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("UserMarker")
public class UserMarkerPage extends WebPage{
    public UserMarkerPage(){
        var toUserMakerLink = new BookmarkablePageLink<>("toHome", HomePage.class);
        add(toUserMakerLink);
    }
}
