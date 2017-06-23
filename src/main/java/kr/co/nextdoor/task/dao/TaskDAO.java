package kr.co.nextdoor.task.dao;

import java.util.List;

import kr.co.nextdoor.member.dto.MemberDTO;
import kr.co.nextdoor.task.dto.TaskDTO;

/*
* @Class : TaskDAO
* @Date : 2017. 06. 13
* @Author : 장진환
* @Desc : Task DAO 설명
*/
public interface TaskDAO {
	
	/*
    * @method Name : listTask
    * @date : 2017. 06. 13
    * @author : 장진환
    * @description : 업무 목록
    * @return : List<TaskDTO>
    */
	public List<TaskDTO> listTask(String project_no);
	
	/*
    * @method Name : deleteTask
    * @date : 2017. 06. 13
    * @author : 장진환
    * @description : 업무 삭제
    * @return : int
    */
	public int deleteTask(TaskDTO taskdto);

	/*
    * @method Name : updateTask
    * @date : 2017. 06. 13
    * @author : 장진환
    * @description : 업무 수정
    * @return : int
    */
	public int updateTask(TaskDTO taskdto);

	/*
    * @method Name : insertTask
    * @date : 2017. 06. 13
    * @author : 장진환
    * @description : 업무 생성하기
    * @return : int
    */
	public int insertTask(TaskDTO taskdto);
	
	/*
    * @method Name : memberList
    * @date : 2017. 06. 13
    * @author : 장진환
    * @description : 프로젝트 멤버 리스트 
    * @return : List<MemberDTO>
    */
	public List<MemberDTO> memberList(String project_no);
	
}
