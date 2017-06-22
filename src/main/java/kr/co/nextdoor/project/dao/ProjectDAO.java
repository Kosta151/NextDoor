package kr.co.nextdoor.project.dao;

import java.util.List;

import kr.co.nextdoor.project.dto.ProjectDTO;
import kr.co.nextdoor.project.dto.ProjectModiDTO;

/*
* @Class : ProjectDAO
* @Date : 2017. 06. 13
* @Author : 송지은
* @Desc : project에 대한 DAO
*/
public interface ProjectDAO {

    /*
    * @method Name : listProject
    * @date : 2017. 06. 13
    * @author : 송지은
    * @description : 프로젝트 목록
    * @return : List
    */
	public List<ProjectDTO> listProject(ProjectDTO projectdto) throws Exception;

	/*
    * @method Name : insertProjectMember
    * @date : 2017. 06. 14
    * @author : 송지은
    * @description : 프로젝트 멤버 생성
    * @return : void
    */
	public void insertProjectMember(ProjectDTO projectdto) throws Exception;
	
	/*
    * @method Name : insertProject
    * @date : 2017. 06. 13
    * @author : 송지은
    * @description : 프로젝트 생성하기
    * @return : int
    */
	public int insertProject(ProjectDTO projectDTO) throws Exception;

	/*
    * @method Name : getProject
    * @date : 2017. 06. 19
    * @author : 송지은
    * @description : 프로젝트수정 리스트
    * @return : ProjectDTO
    */
	public ProjectDTO getProject(String project_no) throws Exception;
	
	/*
    * @method Name : insertProjectModi
    * @date : 2017. 06. 
    * @author : 송지은
    * @description : 프로젝트 수정하기(시작일, 마감일 추가)
    * @return : int
    */
	public int insertProjectModi(ProjectModiDTO projectmodidto) throws Exception;
	
	/*
    * @method Name : updateProjectModi
    * @date : 2017. 06. 22
    * @author : 송지은
    * @description : 프로젝트 수정하기(시작일, 마감일 수정)
    * @return : String
    */
	public int updateProjectModi(ProjectModiDTO projectmodidto) throws Exception;
	
	/*
    * @method Name : listProjectModi
    * @date : 2017. 06. 20
    * @author : 송지은
    * @description : 프로젝트 수정페이지 리스트
    * @return : String
    */
	public ProjectModiDTO listProjectModi(String project_no) throws Exception;
		
	/*
    * @method Name : updateProject
    * @date : 2017. 06. 
    * @author : 송지은
    * @description : 프로젝트명 수정하기
    * @return : int
    */

	public int updateProject(ProjectDTO projectDTO) throws Exception;
	/*
    * @method Name : deleteProject
    * @date : 2017. 06. 16
    * @author : 송지은
    * @description : 프로젝트 삭제하기
    * @return : int
    */
	public int deleteProject(int project_no) throws Exception;
	
	/*
    * @method Name : sendProjectMember
    * @date : 2017. 06. 
    * @author : 송지은
    * @description : 프로젝트 멤버초대 이메일 전송
    * @return : int
    */
	public int sendProjectMember(ProjectDTO projectDTO) throws Exception;

}
