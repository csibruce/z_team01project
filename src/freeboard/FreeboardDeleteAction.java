package freeboard;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FreeService;
import service.FreeServiceImpl;
import vo.FreeVO;

import controller.IAction;

public class FreeboardDeleteAction implements IAction {
	private boolean redirect = false;
	@Override
	public boolean isRedirect() {
		return redirect;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		if(request.getSession().getAttribute("LOGIN_INFO")==null){
			return "/needlogin/needlogin.tiles";
		}else{
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("fb_no", request.getParameter("fb_no"));
		params.put("fb_pass", request.getParameter("fb_pass"));
		
		FreeService service = FreeServiceImpl.getInstance();
		FreeVO freeinfo = service.getFreeInfo(params);
		
		if(freeinfo == null){
			return "/freeboard/freeboardView.do?message=wrong";
		}else{
			int delcnt = service.deleteFreeInfo(params);
		}
		
			return "/freeboard/freeboardList.do";
		}
		
	}

}
