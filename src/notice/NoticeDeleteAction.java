package notice;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.NoticeService;
import service.NoticeServiceImpl;
import vo.NoticeVO;

import controller.IAction;

public class NoticeDeleteAction implements IAction {
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
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		if(request.getParameter("nt_title") != null){
			NoticeVO noticeInfo = new NoticeVO();
			NoticeService service = NoticeServiceImpl.getInstace();
			noticeInfo = service.getNoticeInfo(params);
			request.setAttribute("noticeInfo", noticeInfo);
		}
			
		NoticeService service = NoticeServiceImpl.getInstace();
		int deleteCnt = service.deleteNoticeInfo(params);
		
		return "/notice/noticeList.do";
	}

}
