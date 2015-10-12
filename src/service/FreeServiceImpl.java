package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import vo.FreeVO;
import dao.FreeDao;
import dao.FreeDaoImpl;


public class FreeServiceImpl implements FreeService {

	private static FreeService service = null;
	
	private FreeDao dao = null;
	
	private FreeServiceImpl(){
		dao = FreeDaoImpl.getInstance();
	}
	public static FreeService getInstance(){
		if(service == null){
			service = new FreeServiceImpl();
		}
		return service;
	}
	@Override
	public List<FreeVO> getFreeList(Map<String, String> params) {
		List<FreeVO> freeList = null;
		try {
			freeList = dao.getFreeList(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeList;
	}
	@Override
	public FreeVO getFreeInfo(Map<String, String> params) {
		FreeVO freeInfo = null;
		try {
			freeInfo = dao.getFreeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return freeInfo;
	}
	@Override
	public String insertFreeInfo(FreeVO freeInfo) {
		String fb_no = "";
		try {
			fb_no = dao.insertFreeInfo(freeInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fb_no;
	}
	@Override
	public int updateFreeInfo(FreeVO freeInfo) {
		int fb_no = -1;
		try {
			fb_no = dao.updateFreeInfo(freeInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fb_no;
	}
	@Override
	public int deleteFreeInfo(Map<String, String> params) {
		int delcnt = -1;
		try {
			delcnt = dao.deleteFreeInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return delcnt;
	}
	@Override
	public int addCount(Map<String, String> params) {
		int cnt = -1;
		try {
			cnt = dao.addCount(params);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	@Override
	public String insertFreeInfoReply(FreeVO freeInfo) {
		String fb_no = "";
		try {
			fb_no = dao.insertFreeInfoReply(freeInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fb_no;
	}
	@Override
	public List<FreeVO> getReplyList(Map<String, String> params) {
		List<FreeVO> replyList = null;
		try {
			replyList = dao.getReplyList(params);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return replyList;
	}
	@Override
	public String getlistTotal() {
		String listTotal = "";
		try {
			listTotal = dao.getlistTotal();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTotal;
	}
	@Override
	public int deleteFreeReply(FreeVO freeinfo) {
		int deletecnt = -1;
		try {
			deletecnt = dao.deleteFreeReply(freeinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deletecnt;
	}
}
