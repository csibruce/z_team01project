package qna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QService;
import service.QServiceImpl;
import vo.QnaVO;

import controller.IAction;

public class QnaListAction implements IAction {
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
			QService service = QServiceImpl.getInstance();
			List<QnaVO> qnaList = service.getQnaList();
			request.setAttribute("qnaList", qnaList);
			
			return "/qna/qnaList.tiles";
	}

	}
}
