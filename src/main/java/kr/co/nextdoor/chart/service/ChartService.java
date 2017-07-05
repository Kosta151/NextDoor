package kr.co.nextdoor.chart.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.chart.dao.ChartDAO;
import kr.co.nextdoor.chart.dto.ChartDTO;
import kr.co.nextdoor.chart.dto.ChartMemberDTO;

/*
* @Class : ChartService
* @Date : 2017. 06. 30
* @Author : 최성용
* @Desc : chart controller에 대한 service
*/

@Service
public class ChartService {
	@Autowired
	private SqlSession sqlsession;
	
	/*
    * @method Name : listChartMember
    * @date : 2017. 06 . 30
    * @author : 최성용
    * @description : 초대 받은 멤버 출력 리스트
    * @param : project_no
    * @return : List<ChartMemberDTO>
    */
	public List<ChartMemberDTO> listChartMember(String project_no){
		
		ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);		
		List<ChartMemberDTO> chartmember = chartdao.listChartMember(project_no);
		return chartmember;
	}	
	
	/*
    * @method Name : chart_x
    * @date : 2017. 07. 01
    * @author : 최성용
    * @description : x축 업무 출력
    * @param : project_no
    * @return : List<ChartDTO>
    */
	public List<ChartDTO> chart_x(String project_no){
		
		ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
		List<ChartDTO> clist = chartdao.chart_x(project_no);
		return clist;
		
	}
	
	/*
    * @method Name : chart_y_comp0
    * @date : 2017. 07.01
    * @author : 최성용
    * @description : y축 완료 되지 않은 갯수
    * @param : project_no
    * @return : List<ChartDTO>
    */
   public List<ChartDTO> chart_y_comp0(String project_no){
         
	   ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
         List<ChartDTO> comp0list = chartdao.chart_y_comp0(project_no);
         return comp0list;
         
      }
      
	/*
    * @method Name : chart_y_comp1
    * @date : 2017. 07.01
    * @author : 최성용
    * @description : y축 완료 된 갯수
    * @param : project_no
    * @return : List<ChartDTO>
    */   
   public List<ChartDTO> chart_y_comp1(String project_no){
      ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
      List<ChartDTO> comp1list = chartdao.chart_y_comp1(project_no);
      System.out.println("서비스 comp_1_list" + comp1list);
      return comp1list;
      
   }
	/*
    * @method Name : countMember
    * @date : 2017. 06.27
    * @author : 송지은
    * @description : 멤버 수
    * @param : project_no
    * @return : String
    */ 
   public String countMember(String project_no){
	   ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
	   return chartdao.countMember(project_no);
	   
   }
   
	/*
	* @method Name : countSpecifictask
	* @date : 2017. 06.27
	* @author : 송지은
	* @description : 총 세부 업무수
	* @param : project_no
	* @return : String
	*/
    public String countSpecifictask(String project_no){
	   ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
	   return chartdao.countSpecifictask(project_no);
	   
   }
   
	/*
	* @method Name : countSpecifictask_comp1
	* @date : 2017. 06.27
	* @author : 송지은
	* @description : 완료된 총 세부 업무 수
	* @param : project_no
	* @return : String
	*/
   public String countSpecifictask_comp1(String project_no){
	   ChartDAO chartdao = sqlsession.getMapper(ChartDAO.class);
	   return chartdao.countSpecifictask_comp1(project_no);
	   
   }
}
