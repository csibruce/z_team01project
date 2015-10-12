package member;



import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;



import service.MService;
import service.MServiceImpl;
import vo.MemberVO;

import controller.IAction;

public class MemberUpdateAction implements IAction {
	private boolean redirect = false;
	
	@Override
	public boolean isRedirect() {
		return redirect;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		MemberVO memberinfo = new MemberVO();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			BeanUtils.populate(memberinfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		MService service = MServiceImpl.getInstance();
		int update = service.updateMemberInfo(memberinfo);
		
		List<MemberVO> memList = service.getMemberList();
		request.setAttribute("memList", memList);
		return "/member/memberList.tiles";
	}

}
