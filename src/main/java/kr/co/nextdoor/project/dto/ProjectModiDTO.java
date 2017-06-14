package kr.co.nextdoor.project.dto;

import java.util.Date;

public class ProjectModiDTO {
	private int PROJECTMODI_NO;
	private int PROJECT_NO;
	private Date PROJECT_START;
	private Date PROJECT_END;
	
	public int getPROJECTMODI_NO() {
		return PROJECTMODI_NO;
	}
	public void setPROJECTMODI_NO(int pROJECTMODI_NO) {
		PROJECTMODI_NO = pROJECTMODI_NO;
	}
	public int getPROJECT_NO() {
		return PROJECT_NO;
	}
	public void setPROJECT_NO(int pROJECT_NO) {
		PROJECT_NO = pROJECT_NO;
	}
	public Date getPROJECT_START() {
		return PROJECT_START;
	}
	public void setPROJECT_START(Date pROJECT_START) {
		PROJECT_START = pROJECT_START;
	}
	public Date getPROJECT_END() {
		return PROJECT_END;
	}
	public void setPROJECT_END(Date pROJECT_END) {
		PROJECT_END = pROJECT_END;
	}
	
	
}
