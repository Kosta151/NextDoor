package kr.co.nextdoor.specifictask.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.nextdoor.file.dto.FileDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;
import kr.co.nextdoor.task.dto.TaskDTO;

/*
* @Class : SpecificTaskDAO
* @Date : 2017. 06. 16
* @Author : 문창균
* @Desc : 세부업무에 대한 DAO
*/
public interface SpecificTaskDAO {

	/*
    * @method Name : insertSpecifictask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무 추가
    * @return : int
    */
	public int insertSpecifictask(SpecificTaskDTO specifictaskdto);

	/*
    * @method Name : listSpecifictask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무리스트 출력
    * @return : List<SpecificTaskDTO>
    */
	public List<SpecificTaskDTO> listSpecifictask(String task_no);
	
	/*
	    * @method Name : updateSpecifictask
	    * @date : 2017. 06. 16
	    * @author : 문창균
	    * @description : 세부업무 수정
	    * @return : int
	    */
	public int updateSpecifictask(SpecificTaskModiDTO specifictaskmodidto);
	
	/*
	    * @method Name : deleteSpecifictask
	    * @date : 2017. 06. 16
	    * @author : 문창균
	    * @description : 세부업무 삭제
	    * @return : int
	    */
	public int deleteSpecifictask(String specifictask_no);
	
	/*
	    * @method Name : insertModiSpecifictask
	    * @date : 2017. 06. 16
	    * @author : 문창균
	    * @description : 세부업무수정값 추가
	    * @return : int
	    */
	public int insertModiSpecifictask(SpecificTaskModiDTO specifictaskmodidto); 
		
	/*
	    * @method Name : updateModiSpecifictask
	    * @date : 2017. 06. 16
	    * @author : 문창균
	    * @description : 세부업무수정값 업데이트
	    * @return : int
	    */
	public int updateModiSpecifictask(SpecificTaskModiDTO specifictaskmodidto);
	
	/*
	    * @method Name : detailModiSpecifictask
	    * @date : 2017. 06. 16
	    * @author : 문창균
	    * @description : 세부업무수정값 출력
	    * @return : SpecificTaskModiDTO
	    */
	public SpecificTaskModiDTO detailModiSpecifictask(String specifictask_no);
	
	//insert를 위한 select(specifictask_no를 얻기위한 DAO)
	public SpecificTaskDTO seleteSpecificTaskComp(String specifictask_no);
	
	//업무 확인
	public int checkSpecifcitask(SpecificTaskDTO specifictaskdto);
	
	public List<TaskDTO> personalspecifictask(String task_no, String member_id);
	
	//마감 하루전 메일 보내기
	public ArrayList<SpecificTaskModiDTO> selectTaskdeadline();
	
}
