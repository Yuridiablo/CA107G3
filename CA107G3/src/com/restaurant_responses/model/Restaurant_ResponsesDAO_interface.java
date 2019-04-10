package com.restaurant_responses.model;

import java.util.List;

import com.member_wallet_list.model.Member_Wallet_ListVO;

public interface Restaurant_ResponsesDAO_interface {
	
	public void insert(Restaurant_ResponsesVO Restaurant_ResponsesVO);
	public void update(Restaurant_ResponsesVO Restaurant_ResponsesVO);
	public void delete(String res_no);
	public Restaurant_ResponsesVO findByPK(String res_no);
	public List<Restaurant_ResponsesVO> getAll();

}
