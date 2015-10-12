package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.BuildedSqlMapClient;

import vo.NoticeVO;

public class NoticeDaoImpl implements NoticeDao {

	private static NoticeDao dao = null;
	private SqlMapClient client = null;
	private NoticeDaoImpl(){
		client = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static NoticeDao getInstance(){
		if(dao == null)
			dao = new NoticeDaoImpl();
			return dao;
	}
	
	@Override
	public NoticeVO getNoticeInfo(Map<String, String> params)
			throws SQLException {
		client.update("notice.updateHitCount", params);
		return (NoticeVO) client.queryForObject("notice.noticeInfo", params);
	}

	@Override
	public List<NoticeVO> getNoticeList(Map<String, String>params)
			throws SQLException {
		return client.queryForList("notice.noticeList") ;
	}

	@Override
	public String insertNoticeInfo(NoticeVO noticeInfo) throws SQLException {
		String nt_no = null;
		nt_no = (String) client.insert("notice.insertNoticeInfo", noticeInfo);
		return nt_no;
	}

	@Override
	public int updateNoticeInfo(NoticeVO noitceInfo) throws SQLException {
		return client.update("notice.updateNoticeInfo", noitceInfo);
	}

	@Override
	public int deleteNoticeInfo(Map<String, String> params) throws SQLException {
		return client.delete("notice.deleteNoticeInfo", params) ;
	}

	
	
	
}
