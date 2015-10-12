package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IAction;

public class MainAction implements IAction {

	private boolean redirect = false;
	
	@Override
	public boolean isRedirect() {
		return redirect;
	}
	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(request.getParameter("logout")!=null){
			request.getSession().removeAttribute("LOGIN_INFO");
		}
		return "/realmain.tiles";
	}

}
