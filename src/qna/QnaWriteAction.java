package qna;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.QService;
import service.QServiceImpl;
import vo.QnaVO;

import controller.IAction;

public class QnaWriteAction implements IAction {
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
		if(request.getSession().getAttribute("LOGIN_INFO")==null){
			return "/needlogin/needlogin.tiles";
		}else{
			if(request.getParameter("qn_title")==null){
				return "/qna/qnaWrite.tiles";
			}else{
				QnaVO qnaInfo = new QnaVO();
				try {
					BeanUtils.populate(qnaInfo, request.getParameterMap());
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
	
					e.printStackTrace();
				}
				QService service = QServiceImpl.getInstance();
				String qn_id = service.insertQnaInfo(qnaInfo);
				
			return "/qna/qnaList.do";
			}
		}
	
	
	}
}
