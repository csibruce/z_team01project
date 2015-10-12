package mapper;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import controller.IAction;

public class URIActionMapper {
	//properties 파일을 작성
	// /13/main.do = kr.or.ddit.main.MainAction
	
	private static Map<String, String> actionMap = new HashMap<String,String>();
	
	static{
		//properties파일 접근하기위한 
		//kr.or.ddit.mapper.uriMapper.properties
		ResourceBundle bundle = ResourceBundle.getBundle("mapper.uriMapper");
		Enumeration<String> keys = bundle.getKeys();
		while (keys.hasMoreElements()) {
			String key =  keys.nextElement().trim();
			String value = bundle.getString(key).trim();
			
			actionMap.put(key, value);
		}
	}
	public static IAction getAction(String uri){
		IAction action = null;
		//key : /13/main.do
		//value : kr.or.ddit.main.MainAction
		try {
			//default 생성자를 가진 클래스의 인스턴스화
			Class clz = Class.forName(actionMap.get(uri));
			action =  (IAction) clz.newInstance();
			
			//싱글톤 패턴이 적용된 클래서의 인스턴스화
//			Class clazz = Class.forName("kr.or.ddit.service.member.IMemberServiceImpl");
//			Method getInstance = clazz.getDeclaredMethods("getInstance",null);
//			IMemberService service = getInstance.invoke(null, null);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return action;
	}
}
