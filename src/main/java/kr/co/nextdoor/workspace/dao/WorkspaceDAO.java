package kr.co.nextdoor.workspace.dao;

import java.util.List;
import kr.co.nextdoor.workspace.dto.WorkspaceDTO;

public interface WorkspaceDAO {
	
	public List<WorkspaceDTO> workspacelist(String member_id);
	public int workspaceinsert(WorkspaceDTO workspacedto);
	public int deleteWorkspace(int workspace_no)throws Exception;
}
