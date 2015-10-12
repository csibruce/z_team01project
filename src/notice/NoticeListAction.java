package notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.NoticeService;
import service.NoticeServiceImpl;
import vo.NoticeVO;


import service.MService;


import controller.IAction;

public class NoticeListAction implements IAction {
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
		
		String nt_no = request.getParameter("nt_no");
		Map<String, String> params = new HashMap<String, String>();
		params.put("nt_no", nt_no);
		NoticeService service = NoticeServiceImpl.getInstace();
		List<NoticeVO> noticeList = service.getNoticeList(params);
		
		request.setAttribute("noticeList", noticeList);
		
		return "/notice/noticeList.tiles";
		}
	}

}
