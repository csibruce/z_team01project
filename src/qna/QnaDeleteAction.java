
package qna;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.QService;
import service.QServiceImpl;
import vo.QnaVO;

import controller.IAction;

public class QnaDeleteAction implements IAction {
   
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
         params.put("qn_no", request.getParameter("qn_no"));
         params.put("qn_pass",request.getParameter("qn_pass"));
         
         QService service = QServiceImpl.getInstance();
         QnaVO qnaInfo = service.getQnaInfo(params);
         
         if(qnaInfo == null){
            return "/qna/qnaList.tiles";
         }else{
            int delCnt = service.deleteQnaInfo(params);
         }
      }
      return "/qna/qnaList.do";
   }

}