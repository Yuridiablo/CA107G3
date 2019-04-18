package com.vendor.model;

import java.util.List;

public class VendorService {
	
	private VendorDAO_interface dao;
	
	public VendorService() {
		dao = new VendorJDBCDAO();
	}
	

	
	public VendorVO addV(String v_account, String v_pwd, String v_mail, String v_tel, String v_n_code, String v_ad_code, String v_address1,String v_address2,String v_address3,String v_name,byte[] v_pic) {
		VendorVO vVO = new VendorVO();
		
		vVO.setV_account(v_account);
		vVO.setV_pwd(v_pwd);
		vVO.setV_mail(v_mail);
		vVO.setV_tel(v_tel);
		vVO.setV_n_code(v_n_code);
		vVO.setV_ad_code(v_ad_code);
		vVO.setV_address1(v_address1);
		vVO.setV_address2(v_address2);
		vVO.setV_address3(v_address3);
		vVO.setV_name(v_name);
		vVO.setV_pic(v_pic);
		
		dao.create(vVO);
		return vVO;
	}
	
	public VendorVO findByPK(String vendor_no) {
		return dao.findByPrimaryKey(vendor_no);
	}
	
	public List<VendorVO> getAll() {
		return dao.getAll();
	}
}
