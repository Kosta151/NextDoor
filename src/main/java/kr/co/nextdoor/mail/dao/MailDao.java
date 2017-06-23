package kr.co.nextdoor.mail.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.nextdoor.mail.dto.MailDto;
import kr.co.nextdoor.project.dto.ProjectDTO;

public interface MailDao {
	public ArrayList<MailDto> selectTaskdeadline();
	public MailDto searchMember(String member_id);
	public int updatePassword(HashMap<String, String> map);
	public void insertProjectMember(MailDto maildto);
}
