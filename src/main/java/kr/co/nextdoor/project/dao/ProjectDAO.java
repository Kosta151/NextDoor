package kr.co.nextdoor.project.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.nextdoor.project.dto.ProjectDTO;
import kr.co.nextdoor.project.dto.ProjectModiDTO;

public interface ProjectDAO {

	//프로젝트 생성
	public int insertProject(ProjectDTO projectDTO)throws Exception;	
	//프로젝트멤버 생성
	public int insertProjectMember()throws Exception;
	//프로젝트추가 생성
	public int insertProjectModi(ProjectModiDTO projectmodiDTO)throws Exception;
	//프로젝트 수정
	public int updateProject(ProjectDTO projectDTO)throws Exception;
	//프로젝트 삭제
	public int deleteProject(int PROJECT_NO)throws Exception;
	//프로젝트 전체 리스트
	public List<ProjectDTO> projectList(String member_id)throws Exception;
	//프로젝트 멤버초대
	public int sendMember(ProjectDTO projectDTO)throws Exception;
	//캘린더 프로젝트 생성
	public int insertFullcalendarProject(ProjectDTO projectDTO)throws Exception;
	//캘린더 프로젝트 전체 리스트
	public ArrayList<ProjectDTO> fullcalendarProjectList()throws Exception;
}
