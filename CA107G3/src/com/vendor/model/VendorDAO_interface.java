package com.vendor.model;

import java.util.List;

public interface VendorDAO_interface {
	
	public int insert(VendorVO vendorVO);
	

	//修改廠商資訊(OK)
	public int update(VendorVO vendor);

	public int delete(String vendor_no);
	
	//以PK查詢一家餐廳(OK)
	public VendorVO findByPK(String vendor_no);
	
	//創新帳號(OK)
	public int create(VendorVO vendorVO);
	
	//新增詳情
	public void detail(VendorVO vendorVO);
	
	//修改審核狀態碼
	public void upStatus(VendorVO vendorVO);
	
	//修改開放訂位狀態
	public void waitOnOff(VendorVO vendorVO);
	
	//修改餐廳圖片(OK)
	public int updatePic(VendorVO vendorVO);
	
	//修改廣告圖片(OK)
	public int updateAd(VendorVO vendorVO);
	
	
	//以帳號查一間餐廳(登入用)(OK)
	public VendorVO findByAcc(String v_account);
	

	public List<VendorVO> getAll();
	
	
	public List<VendorVO> search(String v_name);

}
