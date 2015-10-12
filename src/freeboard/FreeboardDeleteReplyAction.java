package freeboard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.FreeService;
import service.FreeServiceImpl;
import vo.FreeVO;
import vo.MemberVO;

import controller.IAction;

public class FreeboardDeleteReplyAction implements IAction {
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
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		if(request.getSession().getAttribute("LOGIN_INFO")==null){
			return "/needlogin/needlogin.tiles";
		}else{
		
			FreeService service = FreeServiceImpl.getInstance();
			FreeVO freeinfo = new FreeVO();
			Map<String, String> params = new HashMap<String, String>();
			if(((MemberVO)(request.getSession().getAttribute("LOGIN_INFO"))).getMem_type().trim().intern()=="admin"){
				params.put("fb_no", request.getParameter("fb_no"));
				freeinfo = service.getFreeInfo(params);
				service.deleteFreeReply(freeinfo);
				return "/freeboard/freeboardView.do?fb_no="+request.getParameter("fb_noA")+"&start="+start+"&end="+end;
				
			}else{
			
				if(request.getParameter("fb_pass")==null){
					return "/freeboard/freeboardView.do?fb_no="+request.getParameter("fb_noA")+"&message=wrong&start="+start+"&end="+end;
				}else{
					params.put("fb_no", request.getParameter("fb_no"));
					params.put("fb_pass", request.getParameter("fb_pass"));
		//			params.put("fb_group", request.getParameter("fb_noA"));
					freeinfo = service.getFreeInfo(params);
					
					if(freeinfo==null){
						return "/freeboard/freeboardView.do?fb_no="+request.getParameter("fb_noA")+"&message=wrong&start="+start+"&end="+end;
					}else{
						service.deleteFreeReply(freeinfo);
						return "/freeboard/freeboardView.do?fb_no="+request.getParameter("fb_noA")+"&start="+start+"&end="+end;
					}	
				}
			}
		}

		
		
	}

}
