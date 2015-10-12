package freeboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FreeService;
import service.FreeServiceImpl;
import vo.FreeVO;

import controller.IAction;

public class FreeboardListAction implements IAction {
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
		
		FreeService service = FreeServiceImpl.getInstance();
		//default설정 초기리스트 이 후에 페이징처리(브라우저로부터 start, end값이 들어올 때)
		Map<String, Integer> pagingvalue = new HashMap<String,Integer>();
		Map<String, String> params = new HashMap<String, String>();
		String listTotal = service.getlistTotal();
		int show = 15;
		pagingvalue.put("listTotal", Integer.parseInt(listTotal));
		pagingvalue.put("show",show);
		request.setAttribute("paging", pagingvalue);
		
		String start = "";
		String end = "";
		if(request.getParameter("start")==null){
			start = String.valueOf(Integer.parseInt(listTotal)-show);
			end = String.valueOf((Integer.parseInt(listTotal)+1));
//			params.put("start",String.valueOf(Integer.parseInt(listTotal)-show));
//			params.put("end", String.valueOf((Integer.parseInt(listTotal)+1)));		
		}else{
			start = request.getParameter("start");
			end = String.valueOf(Integer.parseInt(request.getParameter("end"))+1);
//			params.put("start", request.getParameter("start"));
//			params.put("end",String.valueOf(Integer.parseInt(request.getParameter("end"))+1));
		}
			params.put("start", start);
			params.put("end", end);
		
		
		
		
		List<FreeVO> freeList = service.getFreeList(params);
		
		request.setAttribute("freeList", freeList);
		
		return "/freeboard/freeboardList.tiles?start="+start+"&end="+(Integer.parseInt(end)-1);
		}
	}

}
