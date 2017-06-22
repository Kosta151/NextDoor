   package kr.co.nextdoor.project.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.nextdoor.project.dto.ProjectDTO;
import kr.co.nextdoor.project.dto.ProjectModiDTO;
import kr.co.nextdoor.project.service.ProjectService;

/*
* @Class : ProjectController
* @Date : 2017. 06. 13 
* @Author : 송지은
* @Desc : project
*/

@Controller
@SessionAttributes({"workspace_no", "project_no", "task_no", "specifictask_no"})
public class ProjectController {

   @Autowired
   private ProjectService service;

   /*
    * @method Name : projectList
    * @date : 2017. 06. 13
    * @author : 송지은
    * @description : 워크스페이스 선택시 프로젝트 선택화면으로 이동
    */
   @RequestMapping("projectList.htm")
   public String listProject(ProjectDTO projectdto, Principal principal, Model model) throws Exception {
      projectdto.setMember_id(principal.getName());
      model.addAttribute("projectlist", service.listProject(projectdto));
      model.addAttribute("workspace_no", projectdto.getWorkspace_no());
      return "project.projectList";
   }

   /*
    * @method Name : projectInsert
    * @date : 2017. 06. 13
    * @author : 송지은
    * @description : 프로젝트 생성 후 프로젝트 리스트 화면으로 이동
    */
   @RequestMapping(value = "insertProject.htm", method = RequestMethod.POST)
   public String insertProject(ProjectDTO projectdto, Principal principal, Model model, HttpSession session) throws Exception {
      String workspace_no = (String) session.getAttribute("workspace_no");
      projectdto.setWorkspace_no(workspace_no);
      projectdto.setMember_id(principal.getName());
      service.insertProject(projectdto);
      service.insertProjectMember(projectdto);
      model.addAttribute("projectlist", service.listProject(projectdto));
      return "project.projectList";
   }
   
   /*
    * @method Name : projectDelete
    * @date : 2017. 06. 16
    * @author : 송지은
    * @description : 프로젝트 삭제 후 프로젝트 리스트 화면으로 이동
    */
   @RequestMapping("projectDelete.htm")
   public String deleteProject(int project_no) throws Exception{
      service.deleteProject(project_no);
      return "redirect:projectList.htm";
   }
   
   /*
    * @method Name : projectUpdate
    * @date : 2017. 06. 18
    * @author : 송지은
    * @description : 프로젝트 생성 후 프로젝트 수정 화면으로 이동
    */
    @RequestMapping(value = "projectUpdate.htm", method = RequestMethod.GET)
    public String projectUpdate(String project_no, Model model) throws Exception{
       /*service.insertProjectModi(project_no);*/
       System.out.println("ㅌㅌ너는 누구:" + project_no);
       model.addAttribute("project_no", project_no);
       model.addAttribute("projectlist", service.listProject(project_no));
       System.out.println("service.listProject(project_no)"+ service.listProject(project_no));
       model.addAttribute("projectmodilist", service.listProjectModi(project_no));
       System.out.println("service.listProjectModi(projectmodi_no) mm :" + service.listProjectModi(project_no));
       /* model.addAttribute("workspace_no", projectdto.getWorkspace_no()); */
       return "project.projectUpdate";
    }
    
    /*
     * @method Name : projectUpdate
     * @date : 2017. 06. 18
     * @author : 송지은
     * @description : 프로젝트 수정 후에 프로젝트 리스트 화면으로 이동
     */
    @RequestMapping(value = "projectUpdate.htm", method = RequestMethod.POST)
    public String projectUpdate(ProjectModiDTO projectmodidto, HttpSession session) throws Exception{
       String project_no = (String) session.getAttribute("project_no");
       projectmodidto.setProject_no(project_no);
       System.out.println("projectUpdateController");
       ProjectModiDTO modidto = service.listProjectModi(project_no);
       
       if(modidto == null){
    	   System.out.println("insert탈거야?");
    	   service.insertProjectModi(projectmodidto);
       }else{
    	   System.out.println("update탈거야?");
    	   service.updateProjectModi(projectmodidto);
       }
       
       return "redirect:projectList.htm";
    }

}