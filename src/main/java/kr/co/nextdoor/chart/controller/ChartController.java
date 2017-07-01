package kr.co.nextdoor.chart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import kr.co.nextdoor.chart.dto.ChartDTO;
import kr.co.nextdoor.chart.dto.ChartMemberDTO;
import kr.co.nextdoor.chart.service.ChartService;

@Controller
public class ChartController {
	@Autowired
	private ChartService service;
	
	@RequestMapping(value = "chartlist.htm", method= RequestMethod.GET)
	public String chartList(HttpSession session, Model model){	
		
		String project_no = (String)session.getAttribute("project_no");
        model.addAttribute("countMember", service.countMember(project_no));
        model.addAttribute("countSpecifictask", service.countSpecifictask(project_no));
        model.addAttribute("countSpecifictask_comp1", service.countSpecifictask_comp1(project_no));

       System.out.println("1 : " + service.countMember(project_no));
       System.out.println("2 : " + service.countSpecifictask(project_no));
       System.out.println("3 : " + service.countSpecifictask_comp1(project_no));
		return "chart.chartList";

	}
	
	
	
	//chart member select
	@RequestMapping(value="chartMemberList.htm", method=RequestMethod.POST)
	public ModelAndView listChartMember(HttpSession session){
		System.out.println("chartmember controller");
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
	      System.out.println("project_no:" + project_no);
	      
	      List<ChartDTO> clist = service.chart_x(project_no);
	      List<ChartDTO> clist1 = service.chart_y_comp0(project_no);
	      List<ChartDTO> clist2 = service.chart_y_comp1(project_no);
	      
	      ModelAndView model = new ModelAndView();
	      model.addObject("clist", clist);
	      model.addObject("clist1", clist1);
	      model.addObject("clist2", clist2);
	      System.out.println("너는 누구니:" + clist);
	      System.out.println("clist1:" + clist1);
	      System.out.println("clist2" + clist2);
	      
	      model.setViewName("jsonView");
	      
	      return model;

	   }
}
