package com.restaurant_responses.model;

public class Restaurant_ResponsesService {
	
	private Restaurant_ResponsesDAO_interface dao;
	
	public Restaurant_ResponsesService() {
		dao = new Restaurant_ResponsesJDBCDAO();
	}

	public Restaurant_ResponsesVO addRR(String cmnt_no, String res_text) {
		Restaurant_ResponsesVO rrVO = new Restaurant_ResponsesVO();
		
		rrVO.setCmnt_no(cmnt_no);
		rrVO.setRes_text(res_text);
		
		return rrVO;
	}
	
	public void deleteRR(String res_no) {
		dao.delete(res_no);
	}
}
