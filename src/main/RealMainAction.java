package main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IAction;

public class RealMainAction implements IAction {
	
	private boolean redirect = false;
	
	
	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return redirect;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
