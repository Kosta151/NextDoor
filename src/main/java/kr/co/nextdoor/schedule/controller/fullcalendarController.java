package kr.co.nextdoor.schedule.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.co.nextdoor.alarm.dto.AlarmDTO;
import kr.co.nextdoor.alarm.service.AlarmService;
import kr.co.nextdoor.member.dto.MemberDTO;
import kr.co.nextdoor.schedule.dao.FullcalendarDAO;
import kr.co.nextdoor.schedule.dto.FullcalendarDTO;
import kr.co.nextdoor.schedule.service.FullcalendarService;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;
import kr.co.nextdoor.task.dto.TaskDTO;
import kr.co.nextdoor.task.service.TaskService;

@Controller
@SessionAttributes({"workspace_no", "project_no", "task_no", "specifictast_no"})
/*
* @Class : FullcalendarController
* @Date : 2017. 06. 21
* @Author : 최성용
* @Desc : fullcalendar insert and list
*/
public class fullcalendarController {
	
	@Autowired
	private TaskService taskservice;
	
	@Autowired
	private FullcalendarService fullcalendarservice;
	
	@Autowired
	private SqlSession sqlsession;
	
	@Autowired
	private AlarmService alarmservice;
	
	//Modal List 
	@RequestMapping(value="calendar.htm", method=RequestMethod.GET)
	public String listTask(Model model, HttpSession session) {
		String project_no = (String) session.getAttribute("project_no");
		String idx = (String) session.getAttribute("idx");
		System.out.println("contoller 프로젝트 " + project_no);
		List<TaskDTO> tasklist = taskservice.list(project_no);
		List<MemberDTO> memberlist = taskservice.listMember(project_no);
		session.setAttribute("tasklist", tasklist);
		session.setAttribute("memberlist", memberlist);
		System.out.println("calendar view 이동");
		return "fullcalendar.fullcalendarTask";
	}
	
	//fullcalendar insert
	@RequestMapping(value="insertfullcalendartask.htm", method=RequestMethod.POST)
	public String fullcalendarTaskInsert(String specifictask_no, String task_no, HttpSession session, SpecificTaskDTO specifictaskdto , SpecificTaskModiDTO specifictaskmodidto ) throws Exception{
		  //알림 관련 추가(박찬섭) start
	      SimpleDateFormat dayTime = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
	      AlarmDTO alarmdto = new AlarmDTO();
	      User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      
	      alarmdto.setAlarm_receiver(specifictaskmodidto.getMember_id()); //
	      System.out.println(specifictaskmodidto.getMember_id());
	      
	      alarmdto.setSpecifictask_no(specifictaskmodidto.getSpecifictask_no());
	      
	      
	      alarmdto.setAlarm_date(dayTime.format(new Date(System.currentTimeMillis()))) ;
	      
	      String alarm_sender=user.getUsername();
	      alarmdto.setAlarm_sender(alarm_sender);
	      
	      String specifictask_name = specifictaskdto.getSpecifictask_cont();
	      String alarm_cont= user.getUsername()+"님이"+specifictaskmodidto.getMember_id()+"님에게"+specifictask_name+"배당하셨습니다";
	      alarmdto.setAlarm_cont(alarm_cont);
	       
	      alarmservice.insertAlarm(alarmdto);
	      
	      session.setAttribute("alarmcount", alarmservice.CountAlarmList(user.getUsername()));
	      
	      //알림 관련 추가(박찬섭) end 
		
		session.setAttribute("task_no", task_no);
		 System.out.println("나는 task 번호!!" + task_no);
		 System.out.println("업무 생성");
		fullcalendarservice.SpecificTaskInsert(specifictaskdto, session);
		fullcalendarservice.SpecificModiTaskInsert(specifictaskmodidto, task_no, specifictaskdto.getSpecifictask_cont());
		return "fullcalendar.fullcalendarTask";
	}
	
	@RequestMapping(value="clist.htm", method=RequestMethod.GET)
	public void listFullcalendar(Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session ) throws ParseException{
		System.out.println("1");
		String project_no = (String) session.getAttribute("project_no");
		String owner = (String) session.getAttribute("owner");
		System.out.println("오너:" + owner);
		System.out.println("달력에서 프로젝트_no:" + project_no);
		model.addAttribute("owner", owner);
		FullcalendarDAO fullcalendardao = sqlsession.getMapper(FullcalendarDAO.class);
		
		ArrayList<FullcalendarDTO> calendarlist = fullcalendardao.calendarList(project_no);
		
		System.out.println("calendarlist:" + calendarlist);
		
		 JSONArray array = new JSONArray();
		 for(int i = 0; i<calendarlist.size(); i++){
	     JSONObject obj = new JSONObject();
	     obj.put("title", calendarlist.get(i).getMember_id());
	     obj.put("content", calendarlist.get(i).getSpecifictask_cont());
	     
	     String start = calendarlist.get(i).getSpecifictask_start();
	     obj.put("start", start);
	     
	     String end = calendarlist.get(i).getSpecifictask_end();
	     SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd"); 
			 
	     Calendar cal = Calendar.getInstance();
	     Date date=sdformat.parse(end);
	     System.out.println("date: " + date);
			 
		cal.setTime(date);
		cal.add(Calendar.DATE, +0);
		System.out.println("before"+end);
	    end = sdformat.format(cal.getTime());  
	          
	    System.out.println("afeter"+end);
	    obj.put("end", end);
	         
	    array.add(obj);
	    System.out.println("22222222222222222");
	    System.out.println("array" + array);
		 }
		 try {
		 		response.getWriter().print(array);

			} catch (Exception e) {
				 e.printStackTrace();

			}
		 	System.out.println("3");

	}
	
	@RequestMapping(value="owner.htm", method=RequestMethod.GET)
	public ModelAndView listFullcalendar(HttpServletRequest request, HttpServletResponse response,HttpSession session,Principal principal ) throws ParseException{
		System.out.println("1");
		
		String project_no = (String) session.getAttribute("project_no");
		String owner = (String) session.getAttribute("owner");
		
		System.out.println("오너:" + owner);
		System.out.println("달력에서 프로젝트_no:" + project_no);
		
		ModelAndView mav = new ModelAndView();
		FullcalendarDAO fullcalendardao = sqlsession.getMapper(FullcalendarDAO.class);
		ArrayList<FullcalendarDTO> calendarlist = fullcalendardao.calendarList(project_no);
		
		System.out.println("calendarlist:" + calendarlist);
		
		/*mav.addObject("on", attributeValue)*/
		mav.addObject("owner", owner);
		mav.addObject("user", principal.getName());
		mav.setViewName("jsonView");
		return mav;
		
		 

	}
}
