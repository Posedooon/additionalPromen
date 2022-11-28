package com.example.wsbp;

import com.giffing.wicket.spring.boot.starter.app.WicketBootSecuredWebApplication;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsbpApplication extends WicketBootSecuredWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsbpApplication.class, args);
	}

	// 認証OK/NGを判定するセッションクラスを返値にする
	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return MySession.class;
	}
	//getWebSession メソッドをオーバーライドする。先ほど作成した MySession クラスを返り値とすれば、
	// このクラスの getRoles メソッドを使って、ページの表示の可・不可を判断する。
}
