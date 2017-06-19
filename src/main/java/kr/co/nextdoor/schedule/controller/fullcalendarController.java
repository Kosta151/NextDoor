package kr.co.nextdoor.schedule.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.nextdoor.member.dto.MemberDTO;
import kr.co.nextdoor.schedule.service.FullcalendarService;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;
import kr.co.nextdoor.task.dto.TaskDTO;
import kr.co.nextdoor.task.service.TaskService;

@Controller
@SessionAttributes({"workspace_no", "project_no", "task_no", "specifictast_no"})
public class fullcalendarController {
	
	@Autowired
	private TaskService taskservice;
	
	@Autowired
	private FullcalendarService fullcalendarservice;
	
	@RequestMapping(value="calendar.htm", method=RequestMethod.GET)
	public String listTask(Model model, HttpSession session) {
		String project_no = (String) session.getAttribute("project_no");
		System.out.println("contoller 프로젝트 " + project_no);
		List<TaskDTO> tasklist = taskservice.TaskList(project_no);
		List<MemberDTO> memberlist = taskservice.MemberList(project_no);
		model.addAttribute("tasklist", tasklist);
		model.addAttribute("memberlist", memberlist);
		System.out.println("calendar view 이동");
		return "fullcalendar.fullcalendarTask";
	}
	
	@RequestMapping(value="insertfullcalendartask.htm", method=RequestMethod.POST)
	public String fullcalendarTaskInsert(SpecificTaskModiDTO specificmoditaskdto, SpecificTaskDTO specifictaskdto, HttpSession session) throws Exception{
		System.out.println("업무 생성");
		specifictaskdto.setSpecifictask_no(specifictaskdto.getSpecifictask_no());
		System.out.println("넌 누구"+specifictaskdto.getTask_no());
		System.out.println("나는 누구"+specifictaskdto.getSpecifictask_no());
		
		/*specifictaskdto.setTask_no(specifictaskdto.getTask_no());
		specificmoditaskdto.setMember_id(specificmoditaskdto.getMember_id());*/
		fullcalendarservice.SpecificTaskInsert(specifictaskdto);
		fullcalendarservice.SpecificModiTaskInsert(specificmoditaskdto);
		return "fullcalendar.fullcalendarTask";
	}
	
}
