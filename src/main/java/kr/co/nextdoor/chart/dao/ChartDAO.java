package kr.co.nextdoor.chart.dao;

import java.util.List;

import kr.co.nextdoor.chart.dto.ChartDTO;
import kr.co.nextdoor.chart.dto.ChartMemberDTO;

public interface ChartDAO {
	
	//업무별 x축
	public List<ChartDTO> chart_x(String project_no);
	
	//차트 맴버
	public List<ChartMemberDTO> listChartMember(String project_no);
	
	//업무별 y축 (세무업무 완료된)
	public List<ChartDTO> chart_y_comp0(String project_no);
		   
	//업무별 y축 (세부업무 완료되지 않은)
    public List<ChartDTO> chart_y_comp1(String project_no);
}
