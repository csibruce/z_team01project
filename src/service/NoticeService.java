package service;

import java.util.List;
import java.util.Map;
import vo.NoticeVO;

public interface NoticeService {
	public NoticeVO getNoticeInfo(Map<String, String>params);
	public List<NoticeVO>getNoticeList(Map<String, String>params);
	public String insertNoticeInfo(NoticeVO noticeInfo);
	public int updateNoticeInfo(NoticeVO noticeInfo);
	public int deleteNoticeInfo(Map<String, String> params);
	
}
