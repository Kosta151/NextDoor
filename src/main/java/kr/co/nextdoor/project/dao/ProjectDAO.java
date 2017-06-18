package kr.co.nextdoor.project.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.nextdoor.project.dto.ProjectDTO;

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
    * @method Name : insertProjectModi
    * @date : 2017. 06. 
    * @author : 송지은
    * @description : 프로젝트 수정하기(시작일, 마감일 추가)
    * @return : int
    */
	public int insertProjectModi(String project_no) throws Exception;
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
	
	/*
    * @method Name : insertFullcalendarProject
    * @date : 2017. 06.
    * @author : 최성용
    * @description : 캘린더 프로젝트 생성
    * @return : int
    */
    public int insertFullcalendarProject(ProjectDTO projectDTO)throws Exception;
    
    /*
     * @method Name : fullcalendarProjectList
     * @date : 2017. 06.
     * @author : 최성용
     * @description : 캘린더 프로젝트 전체 리스트
     * @return : ArrayList
     */
    public ArrayList<ProjectDTO> fullcalendarProjectList()throws Exception;

}
