package freeboard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.FreeService;
import service.FreeServiceImpl;
import vo.FreeVO;
import vo.MemberVO;

import controller.IAction;

public class FreeboardWriteReplyAction implements IAction {
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
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if(request.getSession().getAttribute("LOGIN_INFO")==null){
			return "/needlogin/needlogin.tiles";
		}else{
		if(request.getParameter("fb_content")==null||request.getParameter("fb_writer")==null||request.getParameter("fb_pass")==null){
			return "/freeboard/freeboardView.do?fb_no="+request.getParameter("fb_no");
		}else{
			FreeVO freeInfo = new FreeVO();
			try {
				BeanUtils.populate(freeInfo, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String fb_id = ((MemberVO)request.getSession().getAttribute("LOGIN_INFO")).getMem_id();
			freeInfo.setFb_id(fb_id);
			freeInfo.setFb_group(freeInfo.getFb_no());
			FreeService service = FreeServiceImpl.getInstance();
			String fb_no = service.insertFreeInfoReply(freeInfo);
			
			
			return "/freeboard/freeboardView.do?fb_no="+request.getParameter("fb_no");
		}
	}
	}

}
