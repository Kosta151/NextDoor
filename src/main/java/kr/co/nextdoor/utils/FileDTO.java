package kr.co.nextdoor.utils;

import java.util.Date;

public class FileDTO {

	private String file_no;
	private String specifictask_no;
	private String file_name;
	private Date file_date;
	private String file_size;
	
	public String getFile_no() {
		return file_no;
	}
	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}
	public String getSpecifictask_no() {
		return specifictask_no;
	}
	public void setSpecifictask_no(String specifictask_no) {
		this.specifictask_no = specifictask_no;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public Date getFile_date() {
		return file_date;
	}
	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	public String getFile_size() {
		return file_size;
	}
	public void setFile_size(String file_size) {
		this.file_size = file_size;
	}
	
}
