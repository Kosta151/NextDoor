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

@Controller
public class ChartController {
	@Autowired
	private ChartService service;
	@Autowired
	   private AlarmService alarmservice;
	
	@RequestMapping(value = "chartlist.htm", method= RequestMethod.GET)
	public String chartList(HttpSession session, Model model, Principal principal){	
		
		String project_no = (String)session.getAttribute("project_no");
		model.addAttribute("countMember", service.countMember(project_no));
		model.addAttribute("countSpecifictask", service.countSpecifictask(project_no));
		model.addAttribute("countSpecifictask_comp1", service.countSpecifictask_comp1(project_no));
		session.setAttribute("alarmcount", alarmservice.CountAlarmList(principal.getName()));
		return "chart.chartList";

	}
	
	@RequestMapping(value="chartMemberList.htm", method=RequestMethod.POST)
	public ModelAndView listChartMember(HttpSession session){
		String project_no = (String)session.getAttribute("project_no");
		List<ChartMemberDTO> chartmemberlist = service.listChartMember(project_no);
		ModelAndView model = new ModelAndView();
		model.addObject("list",chartmemberlist);
		model.setViewName("jsonView");
		
		return model;
	}
	
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
