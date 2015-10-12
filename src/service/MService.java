package service;

import java.util.List;
import java.util.Map;

import vo.MemberVO;

public interface MService {
	public MemberVO getMemberInfo(Map<String, String>params);
	public List<MemberVO>getMemberList();
	public String insertMemberInfo(MemberVO memberInfo);
	public int updateMemberInfo(MemberVO memberinfo);
	
}
