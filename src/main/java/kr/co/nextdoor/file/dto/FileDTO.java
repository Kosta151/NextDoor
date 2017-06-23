package kr.co.nextdoor.file.dto;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileDTO {

	private String file_no;
	private String specifictask_no;
	private String original_name;
	private String file_name;
	private Date file_date;
	private long file_size;
	
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
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
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
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	
	private CommonsMultipartFile file;

	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	
}