package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.BuildedSqlMapClient;

import vo.MemberVO;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao dao = null;
	private SqlMapClient client = null;
	private MemberDaoImpl(){
		client = BuildedSqlMapClient.getSqlMapClient();
	}
	public static MemberDao getInstance(){
		if(dao == null)
			dao = new MemberDaoImpl();
			return dao;
	}
	
	
	@Override
	public MemberVO getMemberInfo(Map<String, String> params)
			throws SQLException {
		
		return (MemberVO) client.queryForObject("member.memberInfo",params);
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		return client.queryForList("member.getMemberList");
	}

	@Override
	public String insertMemberInfo(MemberVO memberInfo) throws SQLException {
		return (String) client.insert("member.InsertmemberInfo", memberInfo);
	}
	@Override
	public int updateMemberInfo(MemberVO memberinfo) throws SQLException {
		return client.update("member.updateMemberInfo", memberinfo);
	}

	
}
