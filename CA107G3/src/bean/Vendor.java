package bean;

import java.io.Serializable;

public class Vendor implements Serializable{
	
	private String vendor_no;
	private String v_account;
	private String v_pwd;
	private String v_mail;
	private String v_tel;
	private String v_n_code;
	private String v_ad_code;
	private String v_address1;
	private String v_address2;
	private String v_address3;
	private String v_wallet;
	private String v_name;
	private String v_w_no;
	private String v_n_no;
	private String v_alt_no;
	private String v_start_time;
	private String v_end_time;
	private String v_day;
	private String v_turn_time;
	
	public Vendor(){
	}
		
	public Vendor(String vendor_no, String v_account, String v_pwd, String v_mail, String v_tel, String v_n_code,
			String v_ad_code, String v_address1, String v_address2, String v_address3, String v_wallet, String v_name,
			String v_w_no, String v_n_no, String v_alt_no, String v_start_time, String v_end_time, String v_day,
			String v_turn_time) {
		super();
		this.vendor_no = vendor_no;
		this.v_account = v_account;
		this.v_pwd = v_pwd;
		this.v_mail = v_mail;
		this.v_tel = v_tel;
		this.v_n_code = v_n_code;
		this.v_ad_code = v_ad_code;
		this.v_address1 = v_address1;
		this.v_address2 = v_address2;
		this.v_address3 = v_address3;
		this.v_wallet = v_wallet;
		this.v_name = v_name;
		this.v_w_no = v_w_no;
		this.v_n_no = v_n_no;
		this.v_alt_no = v_alt_no;
		this.v_start_time = v_start_time;
		this.v_end_time = v_end_time;
		this.v_day = v_day;
		this.v_turn_time = v_turn_time;
	}

	public String getVendor_no() {
		return vendor_no;
	}
	public void setVendor_no(String vendor_no) {
		this.vendor_no = vendor_no;
	}
	public String getV_account() {
		return v_account;
	}
	public void setV_account(String v_account) {
		this.v_account = v_account;
	}
	public String getV_pwd() {
		return v_pwd;
	}
	public void setV_pwd(String v_pwd) {
		this.v_pwd = v_pwd;
	}
	public String getV_mail() {
		return v_mail;
	}
	public void setV_mail(String v_mail) {
		this.v_mail = v_mail;
	}
	public String getV_tel() {
		return v_tel;
	}
	public void setV_tel(String v_tel) {
		this.v_tel = v_tel;
	}
	public String getV_n_code() {
		return v_n_code;
	}
	public void setV_n_code(String v_n_code) {
		this.v_n_code = v_n_code;
	}
	public String getV_ad_code() {
		return v_ad_code;
	}
	public void setV_ad_code(String v_ad_code) {
		this.v_ad_code = v_ad_code;
	}
	public String getV_address1() {
		return v_address1;
	}
	public void setV_address1(String v_address1) {
		this.v_address1 = v_address1;
	}
	public String getV_address2() {
		return v_address2;
	}
	public void setV_address2(String v_address2) {
		this.v_address2 = v_address2;
	}
	public String getV_address3() {
		return v_address3;
	}
	public void setV_address3(String v_address3) {
		this.v_address3 = v_address3;
	}
	public String getV_wallet() {
		return v_wallet;
	}
	public void setV_wallet(String v_wallet) {
		this.v_wallet = v_wallet;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getV_w_no() {
		return v_w_no;
	}
	public void setV_w_no(String v_w_no) {
		this.v_w_no = v_w_no;
	}
	public String getV_n_no() {
		return v_n_no;
	}
	public void setV_n_no(String v_n_no) {
		this.v_n_no = v_n_no;
	}
	public String getV_alt_no() {
		return v_alt_no;
	}
	public void setV_alt_no(String v_alt_no) {
		this.v_alt_no = v_alt_no;
	}
	public String getV_start_time() {
		return v_start_time;
	}
	public void setV_start_time(String v_start_time) {
		this.v_start_time = v_start_time;
	}
	public String getV_end_time() {
		return v_end_time;
	}
	public void setV_end_time(String v_end_time) {
		this.v_end_time = v_end_time;
	}
	public String getV_day() {
		return v_day;
	}
	public void setV_day(String v_day) {
		this.v_day = v_day;
	}
	public String getV_turn_time() {
		return v_turn_time;
	}
	public void setV_turn_time(String v_turn_time) {
		this.v_turn_time = v_turn_time;
	}
	
	

}