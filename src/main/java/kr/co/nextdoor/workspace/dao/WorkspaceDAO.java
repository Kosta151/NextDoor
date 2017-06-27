package kr.co.nextdoor.workspace.dao;

import java.util.List;
import kr.co.nextdoor.workspace.dto.WorkspaceDTO;

/*
* @Class : WorkspaceDAO
* @Date : 2017. 06. 13
* @Author : 이재민
* @Desc : Workspace에 대한 DAO
*/
public interface WorkspaceDAO {

    /*
    * @method Name : listWorkspace
    * @date : 2017. 06. 13
    * @author : 이재민
    * @description : 워크스페이스 목록
    * @return : List
    */
	public List<WorkspaceDTO> listWorkspace(String member_id);

	/*
    * @method Name : insertWorkspace
    * @date : 2017. 06. 13
    * @author : 이재민
    * @description : 워크스페이스 생성
    * @return : int
    */
	public int insertWorkspace(WorkspaceDTO workspacedto);
	
	/*
    * @method Name : deleteWorkspace
    * @date : 2017. 06. 15
    * @author : 송지은
    * @description : 워크스페이스 삭제
    * @return : int
    */
	public int deleteWorkspace(int workspace_no);
	
	public String nameWorkspace(String workspace_no);
}
