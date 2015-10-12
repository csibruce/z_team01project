package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.BuildedSqlMapClient;

import vo.QnaVO;

public class QnaDaoImpl implements QnaDao {
	private static QnaDao dao = null;
	private SqlMapClient client = null;
	private QnaDaoImpl(){
		client = BuildedSqlMapClient.getSqlMapClient();
	}
	public static QnaDao getInstance(){
		if(dao == null)
			dao = new QnaDaoImpl();
		return dao;
	}
	
	@Override
	public QnaVO getQnaInfo(Map<String, String> params) throws SQLException {
		QnaVO qnaInfo = null;
		try{
			client.startTransaction();
			client.update("qna.updateHitCnt",params);
			qnaInfo = (QnaVO) client.queryForObject("qna.qnaInfo",params);
			client.commitTransaction();
		}finally{
		client.endTransaction();
		}
		return qnaInfo; 
	}

	@Override
	public List<QnaVO> getQnaList() throws SQLException {
		return client.queryForList("qna.qnaList");
	}

	@Override
	public int updateQnaInfo(QnaVO qnaInfo) throws SQLException {
		return client.update("qna.updateqnaInfo",qnaInfo);
	}

	

	@Override
	public String insertQnaInfo(QnaVO qnaInfo) throws SQLException {
		return (String) client.insert("qna.insertqnaInfo",qnaInfo);
	}
	@Override
	public int deleteQnaInfo(Map<String, String> params) throws SQLException {
		return client.delete("qna.deleteqnaInfo",params);
		}
 
	
	
}
