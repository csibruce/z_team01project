package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.NoticeVO;

public interface NoticeDao {
	public NoticeVO getNoticeInfo(Map<String, String>params)throws SQLException;
	public List<NoticeVO>getNoticeList(Map<String, String>params)throws SQLException;
	public String insertNoticeInfo(NoticeVO noticeInfo)throws SQLException;
	public int updateNoticeInfo(NoticeVO noitceInfo)throws SQLException;
	public int deleteNoticeInfo(Map<String, String> params)throws SQLException;
}
