package service;

import java.util.List;
import java.util.Map;

import vo.QnaVO;

public interface QService {
	public QnaVO getQnaInfo(Map<String, String>params);
	public List<QnaVO>getQnaList();
	public int updateQnaInfo(QnaVO qnaInfo);
	public int deleteQnaInfo(Map<String, String>params);
	public String insertQnaInfo(QnaVO qnaInfo);
}
