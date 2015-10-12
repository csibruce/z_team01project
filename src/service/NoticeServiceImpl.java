package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.NoticeDao;
import dao.NoticeDaoImpl;

import vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	private static NoticeService service = null;
	
	private NoticeDao dao = null;
	private NoticeServiceImpl(){
		dao = NoticeDaoImpl.getInstance();
	}
	
	public static NoticeService getInstace(){
		if(service == null){
			service = new NoticeServiceImpl();
		}
		return service;
	}
	

	@Override
	public NoticeVO getNoticeInfo(Map<String, String> params) {
		NoticeVO nboardInfo = null;
		try {
			nboardInfo = dao.getNoticeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nboardInfo;
	}

	@Override
	public List<NoticeVO> getNoticeList(Map<String, String>params) {
		List<NoticeVO> nboardList = null;
		try {
			nboardList = dao.getNoticeList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nboardList;
	}

	@Override
	public String insertNoticeInfo(NoticeVO noticeInfo) {
		String nt_title = null;
		try {
			noticeInfo.setNt_content(noticeInfo.getNt_content().replace("\r\n", "<br/>"));
			nt_title = dao.insertNoticeInfo(noticeInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateNoticeInfo(NoticeVO noticeInfo) {
		int updateCnt = -1;
		try {
			updateCnt = dao.updateNoticeInfo(noticeInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCnt;
	}

	@Override
	public int deleteNoticeInfo(Map<String, String> params) {
		int deleteCnt = -1;
		try {
			deleteCnt = dao.deleteNoticeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteCnt;
	}
	
	
}
