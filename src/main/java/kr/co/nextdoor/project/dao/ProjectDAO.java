package kr.co.nextdoor.project.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.nextdoor.member.dto.MemberDTO;
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
    * @description : 프로젝트 수정 리스트
    * @return : ProjectDTO
    */
	public ProjectDTO getProject(String project_no) throws Exception;
	
	/*
    * @method Name : insertProjectModi
    * @date : 2017. 06. 20
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
    * @return : int
    */
	public int updateProjectModi(ProjectModiDTO projectmodidto) throws Exception;
	
	/*
    * @method Name : listProjectModi
    * @date : 2017. 06. 20
    * @author : 송지은
    * @description : 프로젝트 수정페이지 리스트
    * @return : ProjectModiDTO
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
    * @method Name : listMember
    * @date : 2017. 06. 22
    * @author : 송지은
    * @description : 프로젝트에 초대할 멤버 select
    * @return : MemberDTO
    */
	public MemberDTO listMember() throws Exception;
	
	/*
    * @method Name : nameProject
    * @date : 2017. 06. 22
    * @author : 장진환
    * @description : 프로젝트 이름 출력
    * @return : String
    */
	public String nameProject(String project_no) throws Exception;
	
	/*
    * @method Name : searchMember
    * @date : 2017. 06. 29
    * @author : 송지은
    * @description : 프로젝트에 멤버초대할때 autocomplete
    * @return : ArrayList
    */
	public ArrayList<ProjectDTO> searchMember(String member_id);

}
