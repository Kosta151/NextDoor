package kr.co.nextdoor.chart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartController {
	
	@RequestMapping("chartlist.htm")
	public String chartList(){
		System.out.println("안녕 나는 차트야");
		return "chart.chartList";
	}
}
