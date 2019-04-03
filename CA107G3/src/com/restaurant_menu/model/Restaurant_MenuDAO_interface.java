package com.restaurant_menu.model;

import java.util.List;

import com.member_wallet_list.model.Member_Wallet_listVO;

public interface Restaurant_MenuDAO_interface {
	
	public void insert(Restaurant_MenuVO Restaurant_MenuVO);
	public void update(Restaurant_MenuVO Restaurant_MenuVO);
	public void delete(String menu_no);
	public List<Restaurant_MenuVO> getAll();

}