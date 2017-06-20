package kr.co.nextdoor.task.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import kr.co.nextdoor.task.dto.TaskDTO;
import kr.co.nextdoor.task.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskservice;
	
	@Autowired
	private View jsonview;

	@RequestMapping(value="task.htm", method=RequestMethod.GET)
	public String listTask(String project_no, Model model, HttpSession session){
		session.setAttribute("project_no", project_no);
		System.out.println("task view 이동");
		return "task.task";
	}
	
	@RequestMapping(value = "tasklist.htm", method=RequestMethod.POST)
	public View listTask(Model model, HttpSession session) {
		String project_no = (String) session.getAttribute("project_no");
		System.out.println("project_no : " +project_no);
		List<TaskDTO> tasklist = taskservice.listTask(project_no);
		model.addAttribute("data", tasklist);
		return jsonview;
	}

	@RequestMapping(value = "insertTask.htm")
	public String insertTask(TaskDTO taskdto, HttpSession session) {
		String project_no = (String) session.getAttribute("project_no");
		taskdto.setProject_no(project_no);
		taskservice.insertTask(taskdto);
		return "redirect:task.htm?project_no="+taskdto.getProject_no();
	}
	
	@RequestMapping("deletetask.htm")
	public String deleteTask(TaskDTO taskdto){
		taskservice.deleteTask(taskdto);
		return "task.task";
	}
}
