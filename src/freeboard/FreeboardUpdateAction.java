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

import controller.IAction;

public class FreeboardUpdateAction implements IAction {
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
		FreeVO freeInfo = new FreeVO();
		Map<String, String> fbinfo = new HashMap<String, String>();
		if(request.getParameter("fb_title")==null || request.getParameter("message")!=null){
			fbinfo.put("fb_no", request.getParameter("fb_no"));
			FreeService service = FreeServiceImpl.getInstance();
			freeInfo = service.getFreeInfo(fbinfo);
			request.setAttribute("freeinfo", freeInfo);
			
			return "/freeboard/freeboardUpdate.tiles";
		}else{
			try {
				BeanUtils.populate(freeInfo, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			fbinfo.clear();
			if(freeInfo.getFb_pass()==""){
				freeInfo.setFb_pass("d d d");
			}
			fbinfo.put("fb_no", freeInfo.getFb_no());
			fbinfo.put("fb_pass", freeInfo.getFb_pass());
			FreeService service = FreeServiceImpl.getInstance();
			FreeVO fbinfo2 = service.getFreeInfo(fbinfo);
			
			if(fbinfo2==null){
				return "/freeboard/freeboardUpdate.do?message=wrong&fb_no="+freeInfo.getFb_no();
			}else{
				int fb_no = service.updateFreeInfo(freeInfo);
			}
			
			
//			FreeService service = FreeServiceImpl.getInstance();
//			String fb_no = service.insertFreeInfo(freeInfo);
//			
			
			return "/freeboard/freeboardList.do";
		}
	}
	}

}
