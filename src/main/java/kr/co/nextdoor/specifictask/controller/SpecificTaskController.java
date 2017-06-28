package kr.co.nextdoor.specifictask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;
import kr.co.nextdoor.specifictask.service.SpecificTaskService;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.co.nextdoor.alarm.dto.AlarmDTO;
import kr.co.nextdoor.alarm.service.AlarmService;
import kr.co.nextdoor.file.dto.FileDTO;

/*
* @Class : SpecificTaskController
* @Date : 2017. 06. 16
* @Author : 문창균
* @Desc : 세부업무 controller
*/

@Controller
public class SpecificTaskController {

	@Autowired
	SpecificTaskService specifictaskservice;

	@Autowired
	AlarmService alarmservice;
   /*
   * @method Name : listSpecificTask
   * @date : 2017. 06. 16
   * @author : 문창균
   * @description : 세부업무리스트의 비동기 출력
   */
	@RequestMapping(value = "specifictask.htm", method = RequestMethod.POST)
	public ModelAndView listSpecificTask(String task_no, Model model) {
		List<SpecificTaskDTO> specifictasklist = specifictaskservice.listSpecificTask(task_no);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsonView");
		mv.addObject("data", specifictasklist);
		
		return mv;

	}
	
	/*
   * @method Name : insertSpecificTask
   * @date : 2017. 06. 16
   * @author : 문창균
   * @description : 세부업무 추가
   */
	@RequestMapping("insertspecifictask.htm")
	public String insertSpecificTask(SpecificTaskDTO specifictask){
		specifictaskservice.insertSpecificTask(specifictask);

		return "task.task";
	}

	/*
   * @method Name : deleteSpecifictask
   * @date : 2017. 06. 16
   * @author : 문창균
   * @description : 세부업무 삭제
   */
	@RequestMapping(value ="deleteSpecifictask.htm")
	public String deleteSpecifictask(String specifictask_no, HttpSession session){
		
		specifictaskservice.deleteSpecifictask(specifictask_no);
		
		SpecificTaskModiDTO modidto = specifictaskservice.detailModiSpecifictask(specifictask_no);
		session.setAttribute("modidto", modidto);
		
		return "task.task";
	}
	
	/*
   * @method Name : detailModiSpecifictask
   * @date : 2017. 06. 16
   * @author : 장진환
   * @description : 세부업무 수정값 출력
   */
	@RequestMapping(value = "detailSpecifictask.htm", method=RequestMethod.GET)
	public String detailModiSpecifictask(SpecificTaskDTO specifictaskdto ,Model model, HttpSession session){
			
		SpecificTaskModiDTO modidto = specifictaskservice.detailModiSpecifictask(specifictaskdto.getSpecifictask_no());
		
		session.setAttribute("modidto", modidto);
		session.setAttribute("specifictask_no", specifictaskdto.getSpecifictask_no());
		session.setAttribute("specifictask_cont", specifictaskdto.getSpecifictask_cont());
					
		return "task.task";
	}
	
	@RequestMapping(value = "detailSpecifictaskajax.htm", method=RequestMethod.POST)
	public ModelAndView detailModiSpecifictask(String specifictask_no, Model model){
			
		SpecificTaskModiDTO modidto = specifictaskservice.detailModiSpecifictask(specifictask_no);
		ModelAndView mv = new ModelAndView();	
		mv.addObject("data", modidto);
		mv.setViewName("jsonView");
		
		return mv;
	}
	
		
	/*
   * @method Name : updateSpecifictask
   * @date : 2017. 06. 16
   * @author : 장진환
   * @description : 세부업무 수정값 업데이트
   */
	@RequestMapping(value ="updateSpecifictask.htm")
	public String updateSpecifictask(SpecificTaskModiDTO specifictaskmodidto, SpecificTaskDTO specifictaskdto ,HttpSession session){
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
		SpecificTaskModiDTO modidto = specifictaskservice.detailModiSpecifictask(specifictaskmodidto.getSpecifictask_no());
		//알림 관련 추가(박찬섭) end
		if(modidto==null){
			specifictaskservice.insertModiSpecifictask(specifictaskmodidto);
		}else{
			specifictaskservice.updateModiSpecifictask(specifictaskmodidto);		
		}
		
		modidto = specifictaskservice.detailModiSpecifictask(specifictaskmodidto.getSpecifictask_no());
		session.setAttribute("modidto", modidto);
		
		return "task.task";
					
	}
	
	/*
	   * @method Name : checkSpecificTask
	   * @date : 2017. 06. 23
	   * @author : 문창균
	   * @description : 세부업무 작업 확인
	   */
	@RequestMapping("checkspecifictask.htm")
	public String checkSpecificTask(String specifictask_no){
		
		SpecificTaskDTO specifictaskdto = specifictaskservice.seleteSpecificTaskComp(specifictask_no);
		specifictaskdto.setSpecifictask_no(specifictask_no);
		specifictaskservice.checkSpecifcitask(specifictaskdto);
		
		return "task.task";
	}
	
	
}
