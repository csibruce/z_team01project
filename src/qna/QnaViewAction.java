package qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QService;
import service.QServiceImpl;
import vo.QnaVO;

import controller.IAction;

public class QnaViewAction implements IAction {
	private boolean redirect = false;
	
	@Override
	public boolean isRedirect() {
		// TODO Auto-generated method stub
		return redirect;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		if(request.getSession().getAttribute("LOGIN_INFO")==null){
			return "/needlogin/needlogin.tiles";
		}else{
			String qn_no = request.getParameter("qn_no");
			Map<String, String>params = new HashMap<String, String>();
			params.put("qn_no", qn_no);
			QService service = QServiceImpl.getInstance();
			QnaVO qnaInfo = service.getQnaInfo(params);
			request.setAttribute("qnaInfo", qnaInfo);
			return "/qna/qnaView.tiles";
		}
	}
}
