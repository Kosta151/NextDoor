package kr.co.nextdoor.file.dto;

import java.util.Date;

public class FileDTO {
	
	private int FILE_NO;
	private int SPECIFICTASK_NO;
	private String FILE_NAME;
	private Date FILE_DATE;
	private int FILE_SIZE;
	public int getFILE_NO() {
		return FILE_NO;
	}
	public void setFILE_NO(int fILE_NO) {
		FILE_NO = fILE_NO;
	}
	public int getSPECIFICTASK_NO() {
		return SPECIFICTASK_NO;
	}
	public void setSPECIFICTASK_NO(int sPECIFICTASK_NO) {
		SPECIFICTASK_NO = sPECIFICTASK_NO;
	}
	public String getFILE_NAME() {
		return FILE_NAME;
	}
	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}
	public Date getFILE_DATE() {
		return FILE_DATE;
	}
	public void setFILE_DATE(Date fILE_DATE) {
		FILE_DATE = fILE_DATE;
	}
	public int getFILE_SIZE() {
		return FILE_SIZE;
	}
	public void setFILE_SIZE(int fILE_SIZE) {
		FILE_SIZE = fILE_SIZE;
	}
	
	
}
