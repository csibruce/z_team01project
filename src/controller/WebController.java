package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.IAction;
import mapper.URIActionMapper;

public class WebController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//요청주소 URI
				//http://localhost/ddit/13/main.do
				///ddit/13/main.jsp
				String reqUri = request.getRequestURI();
				
				int contextPathLength = request.getContextPath().length();
				
				///13/main.do
				reqUri = reqUri.substring(contextPathLength);
				
				//처리된 URI를 기초로 Controller의 servant(Action 클래스 선택)
				//Action class는 공통코드(메서드, 변수)를 포함.
				
				IAction action = null;
				
				action = URIActionMapper.getAction(reqUri);
				String viewPage = "";
				if(action==null){
					//response.setStatus(HttpServletResponse.SC_OK);
					//404 코드를 브라우저에 전송
					response.setStatus(HttpServletResponse.SC_NOT_FOUND);
					return;
				}else{
					viewPage = action.process(request, response);
					
					//리다이렉트 여부
					if(action.isRedirect()){
						//리다이렉트
						response.sendRedirect(request.getContextPath()+viewPage);
					}else{
						//포워딩
						RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
						dispatcher.forward(request, response);
					}
				}
				
			}
		
		
	}
	

