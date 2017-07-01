package kr.co.nextdoor.alarm.controller;
/*
* @Class : AlarmController
* @Date : 2017. 06. 13
* @Author : 박찬섭
* @Desc : AlarmController
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import kr.co.nextdoor.alarm.service.AlarmService;

@Controller
public class AlarmController {

	@Autowired
	AlarmService alarmservice;
	
	@RequestMapping(value = "alarm.htm", method=RequestMethod.POST)
	public ModelAndView updatealarm(String alarm_no, String alarm_receiver){
		ModelAndView model = new ModelAndView();
		alarmservice.updateAlarm(alarm_no);
		model.setViewName("jsonView");
		model.addObject("alarm_count",alarmservice.CountAlarmList(alarm_receiver));
		model.addObject("alarm_list", alarmservice.AlarmList(alarm_receiver));
		return model; 
	}
	
	
	/*@RequestMapping()
	public String Alarmcount(String receiver_id, Model model){
		model.addAttribute("alarmcount", alarmservice.CountAlarmList(receiver_id));
		return "";
	}*/
	
}
