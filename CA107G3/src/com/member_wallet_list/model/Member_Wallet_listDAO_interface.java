package com.member_wallet_list.model;

import java.util.List;

import com.comment_reported.model.Comment_ReportedVO;

public interface Member_Wallet_listDAO_interface {
	
	public void insert(Member_Wallet_listVO Member_Wallet_listVO);
	public void update(Member_Wallet_listVO Member_Wallet_listVO);
	public void delete(String list_no);
	public List<Member_Wallet_listVO> getAll();

}
