package cn.edu.zju.cs.onlinepayment.personal;
import android.app.Application;

public class ApplicationHelper extends Application {

	 private static boolean session_login = false;
	 
	 public void putSession(boolean bol) {
		  session_login = bol;
	 }
	 
	 public void makeLogin(){
		 session_login = true;
	 }
	 
	 public void makeLogout(){
		 session_login = false;
	 }
	 
	 public boolean isLogin(){
		 return session_login;
	 }
}
