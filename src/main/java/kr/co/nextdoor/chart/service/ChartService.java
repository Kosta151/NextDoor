package kr.co.nextdoor.chart.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.chart.dao.ChartDAO;
import kr.co.nextdoor.chart.dto.ChartDTO;

@Service
public class ChartService {
	@Autowired
	private SqlSession sqlsession;
	
	public List<ChartDTO> chart_x(String project_no){
		ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
		List<ChartDTO> clist = chartdao.chart_x(project_no);
		System.out.println("여기는 서비스:clist:" + clist);
		return clist;
		
	}
}
