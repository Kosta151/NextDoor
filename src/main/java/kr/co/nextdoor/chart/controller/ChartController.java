package kr.co.nextdoor.chart.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.nextdoor.alarm.service.AlarmService;
import kr.co.nextdoor.chart.dto.ChartDTO;
import kr.co.nextdoor.chart.dto.ChartMemberDTO;
import kr.co.nextdoor.chart.service.ChartService;

/*
* @Class : ChartController
* @Date : 2017. 07. 01 
* @Author : 최성용
* @Desc : 차트Controller  
*/

@Controller
public class ChartController {
	
	@Autowired
	private ChartService service;
	@Autowired
	private AlarmService alarmservice;
	
	/*
	* @method Name :  chartList
	* @Date : 2017. 07 . 05
	* @Author : 최성용,송지은
	* @Desc : 차트 인원,세부완료 갯수, 총 업무 갯수
	*/
	@RequestMapping(value = "chartlist.htm", method= RequestMethod.GET)
	public String chartList(HttpSession session, Model model, Principal principal){	
		
		String project_no = (String)session.getAttribute("project_no");
		model.addAttribute("countMember", service.countMember(project_no));
		model.addAttribute("countSpecifictask", service.countSpecifictask(project_no));
		model.addAttribute("countSpecifictask_comp1", service.countSpecifictask_comp1(project_no));
		session.setAttribute("alarmcount", alarmservice.CountAlarmList(principal.getName()));
		return "chart.chartList";

	}
	
	/*
	 * @method Name : listChartMember
	 * @date : 2017. 07. 01
	 * @author : 최성용,문창균
	 * @description : 초대 받은 멤버들의 리스트를 뿌려주고 각 멤버들의 진행상황을 표시
	 */
	@RequestMapping(value="chartMemberList.htm", method=RequestMethod.POST)
	public ModelAndView listChartMember(HttpSession session){
		String project_no = (String)session.getAttribute("project_no");
		List<ChartMemberDTO> chartmemberlist = service.listChartMember(project_no);
		ModelAndView model = new ModelAndView();
		model.addObject("list",chartmemberlist);
		model.setViewName("jsonView");
		
		return model;
	}
	
	/*
	 * @method Name : listChartMember
	 * @date : 2017. 06. 29
	 * @author : 최성용
	 * @description : 각업무별 , 완료된 갯수 , 미완료된 갯수
	 */	
	@RequestMapping(value = "chartlist.htm", method= RequestMethod.POST)
    public ModelAndView chartList(HttpSession session ){
		
        String project_no = (String) session.getAttribute("project_no");
        List<ChartDTO> clist = service.chart_x(project_no);
        List<ChartDTO> comp0List = service.chart_y_comp0(project_no);
        List<ChartDTO> comp1List = service.chart_y_comp1(project_no);

        ModelAndView model = new ModelAndView();
        model.addObject("clist", clist);
        model.addObject("comp0List", comp0List);
        model.addObject("comp1List", comp1List);
        model.setViewName("jsonView");
       
        return model;

    }
}
