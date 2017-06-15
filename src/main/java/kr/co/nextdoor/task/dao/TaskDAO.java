package kr.co.nextdoor.task.dao;

import java.util.List;

import kr.co.nextdoor.task.dto.TaskDTO;

public interface TaskDAO {
	
	//업무 리스트
	public List<TaskDTO> listTasks(String project_no);
	//업무 삭제
	public int deleteTask(int taskno);
	//업무 수정
	public int updateTask(TaskDTO taskdto);
	//업무 입력
	public int insertTask(TaskDTO taskdto);
	
}
