package login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import service.MService;
import service.MServiceImpl;
import vo.MemberVO;

import controller.IAction;

public class LoginCheckAction implements IAction {
	private boolean redirect = false; 
	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return redirect;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		Map<String, String>params = new HashMap<String, String>();
		String mem_id =request.getParameter("mem_id");
		String mem_pass =request.getParameter("mem_pass");
		params.put("mem_id",mem_id );
		params.put("mem_pass",mem_pass );
		MService service = MServiceImpl.getInstance();
		MemberVO memberInfo = service.getMemberInfo(params);
		
		if(memberInfo == null){
			return "/main.do?message=wrong";			
		}else{
			request.getSession().removeAttribute("LOGIN_INFO");
			request.getSession().setAttribute("LOGIN_INFO", memberInfo);
			return "/notice/noticeList.do";
		}
	}

}
