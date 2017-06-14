package kr.co.nextdoor.specifictask.dto;

import java.util.Date;

public class SpecifictaskModiDTO {
	
	private int SPECIFICTASKMODI_NO;
	private int SPECIFICTASK_NO;
	private String MEMBER_ID;
	private Date SPECIFICTASK_START;
	private Date SPECIFICTASK_END;
	private String SPECIFICTASK_COMP;
	public int getSPECIFICTASKMODI_NO() {
		return SPECIFICTASKMODI_NO;
	}
	public void setSPECIFICTASKMODI_NO(int sPECIFICTASKMODI_NO) {
		SPECIFICTASKMODI_NO = sPECIFICTASKMODI_NO;
	}
	public int getSPECIFICTASK_NO() {
		return SPECIFICTASK_NO;
	}
	public void setSPECIFICTASK_NO(int sPECIFICTASK_NO) {
		SPECIFICTASK_NO = sPECIFICTASK_NO;
	}
	public String getMEMBER_ID() {
		return MEMBER_ID;
	}
	public void setMEMBER_ID(String mEMBER_ID) {
		MEMBER_ID = mEMBER_ID;
	}
	public Date getSPECIFICTASK_START() {
		return SPECIFICTASK_START;
	}
	public void setSPECIFICTASK_START(Date sPECIFICTASK_START) {
		SPECIFICTASK_START = sPECIFICTASK_START;
	}
	public Date getSPECIFICTASK_END() {
		return SPECIFICTASK_END;
	}
	public void setSPECIFICTASK_END(Date sPECIFICTASK_END) {
		SPECIFICTASK_END = sPECIFICTASK_END;
	}
	public String getSPECIFICTASK_COMP() {
		return SPECIFICTASK_COMP;
	}
	public void setSPECIFICTASK_COMP(String sPECIFICTASK_COMP) {
		SPECIFICTASK_COMP = sPECIFICTASK_COMP;
	}
	
	

}
