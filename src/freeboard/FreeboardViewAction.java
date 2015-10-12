package freeboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FreeService;
import service.FreeServiceImpl;
import vo.FreeVO;

import controller.IAction;

public class FreeboardViewAction implements IAction {
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
		String fb_no = request.getParameter("fb_no");
		Map<String, String> params = new HashMap<String, String>();
		params.put("fb_no", fb_no);
		FreeService service = FreeServiceImpl.getInstance();	
		//////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////
		List<String> viewlog = new ArrayList<String>();
		if(request.getSession().getAttribute("viewlog")==null){
			int addCount = service.addCount(params);				
			viewlog.add(fb_no);
			request.getSession().setAttribute("viewlog", viewlog);
		}else{
			viewlog = (List<String>) request.getSession().getAttribute("viewlog");
			int checkcnt = 0;
			for (String log : viewlog) {
				if(checkcnt==1)
					break;
				if(log.equals(fb_no)){
					checkcnt++;
				}
			}
			if(checkcnt==0){
				int addCount = service.addCount(params);	
				viewlog.add(fb_no);
				request.getSession().setAttribute("viewlog", viewlog);
			}
		}
		////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////
		FreeVO freeInfo = service.getFreeInfo(params);
		List<FreeVO> replyList = service.getReplyList(params);
		request.setAttribute("freeInfo", freeInfo);
		request.setAttribute("replyList", replyList);
		return "/freeboard/freeboardView.tiles?start="+request.getParameter("start")+"&end="+request.getParameter("end");
	}
	}

}
