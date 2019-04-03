package com.comment_reported.model;

import java.util.List;

public interface Comment_ReportedDAO_interface {
	
	public void insert(Comment_ReportedVO Comment_ReportedVO);
	public void update(Comment_ReportedVO Comment_ReportedVO);
	public void delete(String rep_no);
	public List<Comment_ReportedVO> getAll();

}