package kr.co.nextdoor.project.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.project.dao.ProjectDAO;
import kr.co.nextdoor.project.dto.ProjectDTO;
/*
* @Class : ProjectService
* @Date : 2017. 06. 13
* @Author : 송지은
* @Desc : project controller에 대한 service
*/
@Service
public class ProjectService {

	@Autowired
	private SqlSession sqlsession;
	/*
    * @method Name : listProject
    * @date : 2017. 06. 13
    * @author : 송지은
    * @description : 프로젝트 목록
    * @param : projectdto
    * @return : List
    */
	public List<ProjectDTO> listProject(ProjectDTO projectdto) throws Exception {
		ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
		return projectdao.listProject(projectdto);
	}
	
	/*
    * @method Name : insertProject
    * @date : 2017. 06. 13
    * @author : 송지은
    * @description : 프로젝트 생성
    * @param : projectdto
    * @return : int
    */
	public int insertProject(ProjectDTO projectdto) throws Exception {
		ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
		return projectdao.insertProject(projectdto);
	}
	
	/*
    * @method Name : insertProjectMember
    * @date : 2017. 06. 15
    * @author : 송지은
    * @description : 프로젝트 멤버 초대
    * @param : projectdto
    * @return : void
    */
	public void insertProjectMember(ProjectDTO projectdto) throws Exception{
		ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
		projectdao.insertProjectMember(projectdto);
		return;
	}
	
	/*
    * @method Name : insertProjectModi
    * @date : 2017. 06.
    * @author : 송지은
    * @description : 프로젝트 수정(시작일, 마감일 추가)
    * @param : project_no
    * @return : int
    */
	public int insertProjectModi(String project_no) throws Exception{
		ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
		return projectdao.insertProjectModi(project_no);
	}
	
	/*
    * @method Name : deleteProject
    * @date : 2017. 06. 16
    * @author : 송지은
    * @description : 프로젝트 삭제
    * @param : project_no
    * @return : int
    */
	public int deleteProject(int project_no) throws Exception{
			ProjectDAO projectdao = sqlsession.getMapper(ProjectDAO.class);
			return projectdao.deleteProject(project_no);
	}
}
