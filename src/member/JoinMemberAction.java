package member;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.MService;
import service.MServiceImpl;
import vo.MemberVO;

import controller.IAction;

public class JoinMemberAction implements IAction {
	private boolean redirect = false;
	
	@Override
	public boolean isRedirect() {
		return redirect;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(request.getParameter("mem_id")==null){
			return "/needlogin/joinForm.tiles";
		}else{
			MemberVO memberInfo = new MemberVO();
			try {
				BeanUtils.populate(memberInfo, request.getParameterMap());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
			MService service = MServiceImpl.getInstance();
			String mem_name = service.insertMemberInfo(memberInfo);		
			
			return "/needlogin/cong.tiles?name"+mem_name;
		}
	}

}
