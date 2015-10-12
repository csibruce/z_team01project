package member;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import service.MService;
import service.MServiceImpl;
import vo.MemberVO;

import controller.IAction;

public class MemberListAction implements IAction {
	private boolean redirect = false;
	
	@Override
	public boolean isRedirect() {
		return redirect;
	}

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		MService service = MServiceImpl.getInstance();
		List<MemberVO> memList = service.getMemberList();
		request.setAttribute("memList", memList);
		return "/member/memberList.tiles";
	}

}
