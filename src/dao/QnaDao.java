package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.QnaVO;

public interface QnaDao {
	public QnaVO getQnaInfo(Map<String, String>params)throws SQLException;
	public List<QnaVO> getQnaList() throws SQLException;
	public int updateQnaInfo(QnaVO qnaInfo)throws SQLException;
	public int deleteQnaInfo(Map<String, String> params) throws SQLException;
	public String insertQnaInfo(QnaVO qnaInfo) throws SQLException;
}
