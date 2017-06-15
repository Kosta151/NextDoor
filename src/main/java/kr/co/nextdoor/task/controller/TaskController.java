package kr.co.nextdoor.task.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.nextdoor.task.dto.TaskDTO;
import kr.co.nextdoor.task.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskservice;

	@RequestMapping(value = "task.htm")
	public ModelAndView listTask(@RequestParam("project_no") String project_no, TaskDTO taskdto,
			ModelAndView mv) {
		
		taskdto.setProject_no(project_no);
		mv.addObject("tasklist", taskservice.TaskList(project_no));
		mv.setViewName("task.task");

		return mv;
	}

	@RequestMapping(value = "insertTask.htm")
	public String insertTask(TaskDTO taskdto) {

		System.out.println(taskdto.toString());

		taskservice.TaskInsert(taskdto);

		return "redirect:task.htm";
	}

}
