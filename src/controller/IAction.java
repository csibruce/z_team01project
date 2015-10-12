package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAction {
	//모든 Action 클래스에 사용될 공통코드가 정의
	public boolean isRedirect();
	
	//view(jsp)의 이름
	public String process(HttpServletRequest request, HttpServletResponse response);
}
