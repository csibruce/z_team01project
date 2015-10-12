package service;

import java.util.List;
import java.util.Map;

import vo.FreeVO;

public interface FreeService {
	public List<FreeVO> getFreeList(Map<String, String> params);
	public FreeVO getFreeInfo(Map<String, String> params);
	public String insertFreeInfo(FreeVO freeInfo);
	public int updateFreeInfo(FreeVO freeInfo);
	public int deleteFreeInfo(Map<String, String> params);
	public int addCount(Map<String, String> params);
	public String insertFreeInfoReply(FreeVO freeInfo);
	public List<FreeVO> getReplyList(Map<String, String> params);
	public String getlistTotal();
	public int deleteFreeReply(FreeVO freeinfo);
}
