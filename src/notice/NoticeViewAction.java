package notice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NoticeService;
import service.NoticeServiceImpl;
import vo.NoticeVO;

import controller.IAction;

public class NoticeViewAction implements IAction{
	private boolean redirect = false;
	@Override
	public boolean isRedirect() {
		return redirect;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String nt_no = request.getParameter("nt_no");
		Map<String, String> params = new HashMap<String, String>();
		params.put("nt_no", nt_no);
		NoticeService service = NoticeServiceImpl.getInstace();
		NoticeVO noticeInfo = service.getNoticeInfo(params);
		
		request.setAttribute("noticeInfo", noticeInfo);
		
		return "/notice/noticeView.tiles";
	}

}
