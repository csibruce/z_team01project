package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.FreeVO;

public interface FreeDao {
	public List<FreeVO> getFreeList(Map<String, String> params) throws SQLException; 
	public FreeVO getFreeInfo(Map<String, String> params) throws SQLException;
	public String insertFreeInfo(FreeVO freeInfo) throws SQLException;
	public int updateFreeInfo(FreeVO freeInfo) throws SQLException;
	public int deleteFreeInfo(Map<String, String> params) throws SQLException;
	public int addCount(Map<String, String> params) throws SQLException;
	public String insertFreeInfoReply(FreeVO freeInfo) throws SQLException;
	public List<FreeVO> getReplyList(Map<String, String> params) throws SQLException;
	public String getlistTotal() throws SQLException;
	public int deleteFreeReply(FreeVO freeinfo) throws SQLException;
}
