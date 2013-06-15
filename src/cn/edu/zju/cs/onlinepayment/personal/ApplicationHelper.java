package cn.edu.zju.cs.onlinepayment.personal;

import android.app.Application;

/*
 Application Helper 
 is used to store some Application Context such as session, login status
 All activities can access these data
 */

public class ApplicationHelper extends Application {
	// Application context parameters
	private static boolean session_login = false;

	// modify the Application context parameters
	public void putSession(boolean bol) {
		session_login = bol;
	}

	// Make Login
	public void makeLogin() {
		session_login = true;
	}

	// Make Logout
	public void makeLogout() {
		session_login = false;
	}

	// return the status
	public boolean isLogin() {
		return session_login;
	}
}
