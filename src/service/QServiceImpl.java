package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.QnaDao;
import dao.QnaDaoImpl;

import vo.QnaVO;

public class QServiceImpl implements QService {
	private static QService service = null;
	
	private QnaDao dao = null;
	
	private QServiceImpl(){
		dao = QnaDaoImpl.getInstance();
	}
	public static QService getInstance(){
		if(service == null){
			service = new QServiceImpl();
		}
		return service;
	}
	
	@Override
	public QnaVO getQnaInfo(Map<String, String> params) {
		QnaVO qnaInfo = null;
		try {
			qnaInfo = dao.getQnaInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaInfo;
	}

	@Override
	public List<QnaVO> getQnaList() {
		List<QnaVO> qnaList = null;
		try {
			qnaList = dao.getQnaList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qnaList;
	}

	@Override
	public int updateQnaInfo(QnaVO qnaInfo) {
		int updateCnt = -1;
		try {
			updateCnt = dao.updateQnaInfo(qnaInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateCnt;
	}


	@Override
	public String insertQnaInfo(QnaVO qnaInfo) {
		String qn_title="";
		try {
			qn_title = dao.insertQnaInfo(qnaInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int deleteQnaInfo(Map<String, String> params) {
		int delCnt = -1;
		try {
			delCnt = dao.deleteQnaInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
}
