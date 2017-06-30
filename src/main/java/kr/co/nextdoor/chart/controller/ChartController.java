package kr.co.nextdoor.chart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.nextdoor.chart.dto.ChartDTO;
import kr.co.nextdoor.chart.service.ChartService;

@Controller
public class ChartController {
	@Autowired
	private ChartService service;
	
	@RequestMapping(value = "chartlist.htm", method= RequestMethod.GET)
	public String chartList(Model model, HttpSession session,ChartDTO chartdto){
		String project_no = (String) session.getAttribute("project_no");
		System.out.println("project_no:" + project_no);
		System.out.println("안녕 차트얌 나는!");
		
		List<ChartDTO> clist = service.chart_x(project_no);
		model.addAttribute("clist", clist);		
		System.out.println("clist 너는 누구냐!!" + clist);
		return "chart.chartList";
		
		
	
		
		
	}
}
