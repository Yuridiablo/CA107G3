package com.comment_reported.model;

public class Comment_ReportedService {
	
	private Comment_ReportedDAO_interface dao;
	
	public Comment_ReportedService() {
		dao = new Comment_ReportedJDBCDAO();
		
		
		
		
	}
	
}
