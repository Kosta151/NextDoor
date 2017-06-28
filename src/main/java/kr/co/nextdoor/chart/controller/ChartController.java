package kr.co.nextdoor.chart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.nextdoor.chart.dao.ChartDAO;
import kr.co.nextdoor.chart.dto.ChartDTO;

@Controller
public class ChartController {
	
	@Autowired
	private SqlSession sqlsession;
	
	@RequestMapping(value = "chartlist.htm", method= RequestMethod.GET)
	public String chartList(HttpSession session,Model model){
		System.out.println("안녕 차트얌 나는!");
		String project_no = (String) session.getAttribute("project_no");
		
		System.out.println("너는 누구니 and 너는 몇번이니:?" + project_no);
		
		ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
		List<ChartDTO> slist = chartdao.chartAll();
		
		System.out.println("slist !!!!!!!!!?:" + slist.size());
		System.out.println("말해 뭐해!!!!?:" + slist);
		System.out.println("서~~~브~~~웨~~~이~~~:" + slist.toString());
		ArrayList<String> chart_x = new ArrayList<String>();
		ArrayList<String> chart_y = new ArrayList<String>();
		
		for(int i =0; i<slist.size(); i++){
			chart_x.add(slist.get(i).getOwner());
			chart_y.add(slist.get(i).getPercent());
		}
		
		System.out.println("slist 들어가있니??:" + slist);
		model.addAttribute("chart_x", chart_x);
		model.addAttribute("chart_y", chart_y);
		model.addAttribute("project_no", project_no);

		return "chart.chartList";
		
		
	
		
		
	}
}
