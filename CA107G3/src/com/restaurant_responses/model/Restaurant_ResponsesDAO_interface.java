package com.restaurant_responses.model;

import java.util.List;

import com.restaurant_menu.model.Restaurant_MenuVO;

public interface Restaurant_ResponsesDAO_interface {
	
	public void insert(Restaurant_ResponsesVO Restaurant_ResponsesVO);
	public void update(Restaurant_ResponsesVO Restaurant_ResponsesVO);
	public void delete(Restaurant_ResponsesVO Restaurant_ResponsesVO);
	public List<Restaurant_ResponsesVO> getAll();

}
