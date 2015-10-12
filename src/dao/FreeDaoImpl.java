package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.FreeVO;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.BuildedSqlMapClient;

public class FreeDaoImpl implements FreeDao {
	private static FreeDao dao = null;
	private SqlMapClient client = null;
	private FreeDaoImpl(){
		client = BuildedSqlMapClient.getSqlMapClient();
	}
	public static FreeDao getInstance(){
		if(dao == null)
			dao = new FreeDaoImpl();
			return dao;
	}
	@Override
	public List<FreeVO> getFreeList(Map<String, String> params) throws SQLException {
		
		return client.queryForList("free.getFreeList", params);
	}
	@Override
	public FreeVO getFreeInfo(Map<String, String> params) throws SQLException {
		return (FreeVO) client.queryForObject("free.getFreeInfo", params);
	}
	@Override
	public String insertFreeInfo(FreeVO freeInfo) throws SQLException {
		return (String) client.insert("free.insertFreeInfo", freeInfo);
	}
	@Override
	public int updateFreeInfo(FreeVO freeInfo) throws SQLException {
		return client.update("free.updateFreeInfo", freeInfo);
	}
	@Override
	public int deleteFreeInfo(Map<String, String> params) throws SQLException {
//		client.update("free.updateRcnt", params);
		return client.update("free.deleteFreeInfo", params);
	}
	@Override
	public int addCount(Map<String, String> params) throws SQLException {
		return client.update("free.addCount", params);
	}
	@Override
	public String insertFreeInfoReply(FreeVO freeInfo) throws SQLException {
			client.insert("free.insertFreeInfoReply", freeInfo);
			client.update("free.updateRcnt", freeInfo);	
			String success = "hello";
		return success;
	}
	@Override
	public List<FreeVO> getReplyList(Map<String, String> params)
			throws SQLException {
		return client.queryForList("free.getReplyList", params);
	}
	@Override
	public String getlistTotal() throws SQLException {
		return (String) client.queryForObject("free.getlistTotal");
	}
	@Override
	public int deleteFreeReply(FreeVO freeinfo) throws SQLException {
		client.update("free.deleteFreeReply", freeinfo);	
		client.update("free.updateRcnt", freeinfo);
		return 1;
	}
	
}
