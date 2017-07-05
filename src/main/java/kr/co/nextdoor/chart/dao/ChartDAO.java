package kr.co.nextdoor.chart.dao;

import java.util.List;

import kr.co.nextdoor.chart.dto.ChartDTO;
import kr.co.nextdoor.chart.dto.ChartMemberDTO;

/*
* @Class : ChartDao
* @Date : 2017. 06. 27
* @Author : 최성용, 송지은
* @Desc : chart에 대한 DAO
*/

public interface ChartDAO {
	
   /*
    * @method Name : chart_x
    * @date : 2017. 07 . 02
    * @author : 최성용
    * @description : 업부별 x 축
    * @return : list
    */
	public List<ChartDTO> chart_x(String project_no);
	
   /*
    * @method Name : chart_x
    * @date : 2017. 07 . 02
    * @author : 최성용
    * @description : 업부별 x 축
    * @return : list
    */
	public List<ChartMemberDTO> listChartMember(String project_no);
    
   /*
    * @method Name : chart_y_comp1
    * @date : 2017. 07 . 02
    * @author : 최성용
    * @description : 업무별 y축 (세무업무 완료된)
    * @return : list
    */
    public List<ChartDTO> chart_y_comp1(String project_no);
         
    /*
     * @method Name : chart_y_comp0
     * @date : 2017. 07 . 02
     * @author : 최성용
     * @description : 업무별 y축 (세무업무 미완료된)
     * @return : list
     */
    public List<ChartDTO> chart_y_comp0(String project_no);
    
    /*
     * @method Name : countMember
     * @date : 2017. 07 . 02
     * @author : 송지은
     * @description : 전체 회원수 
     * @return : String
     */
    public String countMember(String project_no);
    
    /*
     * @method Name : countSpecifictask
     * @date : 2017. 07 . 02
     * @author : 송지은
     * @description : 총 세부 업무 수 
     * @return : String
     */
    public String countSpecifictask(String project_no);
    
    /*
     * @method Name : countSpecifictask_comp1
     * @date : 2017. 07 . 02
     * @author : 송지은
     * @description: 완료된 총 업무 수 
     * @return : String
     */
    public String countSpecifictask_comp1(String project_no);
    
}
