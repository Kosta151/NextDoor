package kr.co.nextdoor.workspace.dao;

import java.util.List;
import kr.co.nextdoor.workspace.dto.WorkspaceDTO;

public interface WorkspaceDAO {

	// 워크스페이스 리스트
	public List<WorkspaceDTO> workspacelist(String member_id);

	// 워크스페이스 추가
	public int workspaceinsert(WorkspaceDTO workspacedto);
}
