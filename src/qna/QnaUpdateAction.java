package qna;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.QService;
import service.QServiceImpl;
import vo.QnaVO;

import controller.IAction;

public class QnaUpdateAction implements IAction {
	
	private boolean redirect = false;
	
	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
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
			Map<String, String>params = new HashMap<String, String>();
			QnaVO qnaInfo = new QnaVO();
			QService service = QServiceImpl.getInstance();
			
			if(request.getParameter("qn_title")==null){
				String qn_no = request.getParameter("qn_no");
				params.put("qn_no",qn_no);			
				qnaInfo = service.getQnaInfo(params);
				
				request.setAttribute("qnaInfo", qnaInfo);
				
				return "/qna/qnaUpdate.tiles";
			}
			try {
				BeanUtils.populate(qnaInfo, request.getParameterMap());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			params.put("qnaInfo.getQn_no()",qnaInfo.getQn_no());
			service.updateQnaInfo(qnaInfo);
			
			return "/qna/qnaList.do";
		}
	
	
	
	}
	
}










