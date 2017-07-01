package kr.co.nextdoor.chart.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.chart.dao.ChartDAO;
import kr.co.nextdoor.chart.dto.ChartDTO;
import kr.co.nextdoor.chart.dto.ChartMemberDTO;

@Service
public class ChartService {
	@Autowired
	private SqlSession sqlsession;
	
		
	//chart memebr
	public List<ChartMemberDTO> listChartMember(String project_no){
		System.out.println("Chartmember");
		ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
		
		
		List<ChartMemberDTO> chartmember = chartdao.listChartMember(project_no);
		System.out.println("Chartmemberlist : "+ chartmember.toString());

		return chartmember;
	}
	
	//업무 뿌려줌
	public List<ChartDTO> chart_x(String project_no){
		ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
		List<ChartDTO> clist = chartdao.chart_x(project_no);
		System.out.println("여기는 서비스:clist:" + clist);
		return clist;
		
	}
	
	//완료안된 갯수
	public List<ChartDTO> chart_y_comp0(String project_no){
	      ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
	      List<ChartDTO> clist1 = chartdao.chart_y_comp0(project_no);
	      System.out.println("여기는 서비스:clist1:" + clist1);
	      return clist1;
	      
	   }
	   
	//완료된 갯수
   public List<ChartDTO> chart_y_comp1(String project_no){
      ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
      List<ChartDTO> clist2 = chartdao.chart_y_comp1(project_no);
      System.out.println("여기는 서비스:clist2:" + clist2);
      return clist2;
      
   }
   //전체 회원 수
   public String countMember(String project_no){
	   ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
	   return chartdao.countMember(project_no);
	   
   }
   
   //총 세부업무 수
   public String countSpecifictask(String project_no){
	   ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
	   return chartdao.countSpecifictask(project_no);
	   
   }
   
   //완료된 총 세부업무 수
   public String countSpecifictask_comp1(String project_no){
	   ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
	   return chartdao.countSpecifictask_comp1(project_no);
	   
   }
}
