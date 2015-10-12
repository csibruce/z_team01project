package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.MemberDao;
import dao.MemberDaoImpl;

import vo.MemberVO;

public class MServiceImpl implements MService{

	private static MService service = null;
	
	private MemberDao dao = null;
	
	private MServiceImpl(){
		dao = MemberDaoImpl.getInstance();
	}
	public static MService getInstance(){
		if(service == null){
			service = new MServiceImpl();
		}
		return service;
	}
	
	@Override
	public MemberVO getMemberInfo(Map<String, String> params) {
		MemberVO memberInfo = null;
		try {
			memberInfo = dao.getMemberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberInfo;
	}

	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memlist = null;
		try {
			memlist = dao.getMemberList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memlist;
	}

	@Override
	public String insertMemberInfo(MemberVO memberInfo) {
		   String mem_name = null;
		      try {
		         mem_name = dao.insertMemberInfo(memberInfo);
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      return mem_name;	   
	}
	@Override
	public int updateMemberInfo(MemberVO memberinfo) {
		int update = -1;
		try {
			update = dao.updateMemberInfo(memberinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return update;
	}
	
	
}
