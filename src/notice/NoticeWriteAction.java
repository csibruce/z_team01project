package notice;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.NoticeService;
import service.NoticeServiceImpl;
import vo.NoticeVO;

import controller.IAction;

public class NoticeWriteAction implements IAction {
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
		
		if(request.getParameter("nt_title")== null){
			return "/notice/noticeWrite.tiles";
		}else{
			NoticeVO noticeInfo = new NoticeVO();
			try {
				BeanUtils.populate(noticeInfo, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			
			NoticeService service = NoticeServiceImpl.getInstace();
			String nt_no = service.insertNoticeInfo(noticeInfo);
			return "/notice/noticeList.do";
		}
	}
}
