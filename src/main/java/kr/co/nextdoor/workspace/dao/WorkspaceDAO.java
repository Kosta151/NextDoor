package kr.co.nextdoor.workspace.dao;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.User;

import kr.co.nextdoor.workspace.dto.WorkspaceDTO;

public interface WorkspaceDAO {
	
	public List<WorkspaceDTO> workspacelist(String member_id);
	public void workspaceinsert(WorkspaceDTO workspacedto);
}
