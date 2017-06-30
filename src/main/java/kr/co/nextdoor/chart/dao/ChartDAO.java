package kr.co.nextdoor.chart.dao;

import java.util.List;

import kr.co.nextdoor.chart.dto.ChartDTO;

public interface ChartDAO {
	
	//업무별 x축
	public List<ChartDTO> chart_x(String project_no);
	

}
