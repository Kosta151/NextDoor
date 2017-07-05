package kr.co.nextdoor.alarm.controller;
import javax.servlet.http.HttpSession;

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
/*
* @Class : AlarmController
* @Date : 2017. 06. 21 
* @Author : 박찬섭
* @Desc : AlarmController  
*/

@Controller
public class AlarmController {

	@Autowired
	AlarmService alarmservice;

	/*
	 * @method Name : updatealarm
	 * @date : 2017. 06. 21
	 * @author : 박찬섭
	 * @description : 알림 읽음 표시 비동기 처리
	 */
	@RequestMapping(value = "alarm.htm", method=RequestMethod.POST)
	public ModelAndView updatealarm(String alarm_no, String alarm_receiver, HttpSession session){
		ModelAndView model = new ModelAndView();
		alarmservice.updateAlarm(alarm_no);
		model.setViewName("jsonView");
		model.addObject("alarm_count", alarmservice.CountAlarmList(alarm_receiver));
		return model; 
	}

}
