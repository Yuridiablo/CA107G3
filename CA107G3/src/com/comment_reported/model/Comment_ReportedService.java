package com.comment_reported.model;

import java.util.List;

public class Comment_ReportedService {
	
	private Comment_ReportedDAO_interface dao;
	
	public Comment_ReportedService() {
		
		dao = new Comment_ReportedJDBCDAO();
		
	}
	
	//會員檢舉評論
	public Comment_ReportedVO  addCR(String cmnt_no, String mem_no, String rep_for, Integer rep_stat) {
		Comment_ReportedVO  crVO = new Comment_ReportedVO ();
		
//		crVO.setRep_no(rep_no);
		crVO.setCmnt_no(cmnt_no);
		crVO.setMem_no(mem_no);
		crVO.setRep_for(rep_for);
//		crVO.setRep_time(rep_time);
		crVO.setRep_stat(rep_stat);
		dao.insert(crVO);
		
		return crVO;
	}
	
	//管理員對評論檢舉逕行審核
	public Comment_ReportedVO  updateCR(Integer rep_stat) {
		
		Comment_ReportedVO  crVO = new Comment_ReportedVO ();
		
//		crVO.setRep_no(rep_no);
//		crVO.setCmnt_no(cmnt_no);
//		crVO.setMem_no(mem_no);
//		crVO.setRep_for(rep_for);
//		crVO.setRep_time(rep_time);
		crVO.setRep_stat(rep_stat);
		dao.update(crVO);
		
		return crVO;
	}
	
	//查出指定狀態碼的評論
	public List<Comment_ReportedVO> findByStat(Integer rep_stat) {
		return dao.findByStat(rep_stat);
	}
	
	
	//查出所有檢舉清單
	public List<Comment_ReportedVO> getAll() {
		return dao.getAll();
	}

}
