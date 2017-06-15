package kr.co.nextdoor.project.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.nextdoor.project.dto.ProjectDTO;
import kr.co.nextdoor.project.dto.ProjectModiDTO;

public interface ProjectDAO {

	// �봽濡쒖젥�듃 �쟾泥� 由ъ뒪�듃
	public List<ProjectDTO> projectList(ProjectDTO projectdto) throws Exception;

	// 프로젝트멤버추가
	public void insertProjectMember(ProjectDTO projectdto) throws Exception;
	
	// �봽濡쒖젥�듃 �깮�꽦
	public int insertProject(ProjectDTO projectDTO) throws Exception;

	// �봽濡쒖젥�듃異붽� �깮�꽦
	public int insertProjectModi(ProjectModiDTO projectmodiDTO) throws Exception;

	// �봽濡쒖젥�듃 �닔�젙
	public int updateProject(ProjectDTO projectDTO) throws Exception;

	// �봽濡쒖젥�듃 �궘�젣
	public int deleteProject(int PROJECT_NO) throws Exception;

	// �봽濡쒖젥�듃 硫ㅻ쾭珥덈�
	public int sendMember(ProjectDTO projectDTO) throws Exception;
	
    //캘린더 프로젝트 생성
    public int insertFullcalendarProject(ProjectDTO projectDTO)throws Exception;
    //캘린더 프로젝트 전체 리스트
    public ArrayList<ProjectDTO> fullcalendarProjectList()throws Exception;

}
