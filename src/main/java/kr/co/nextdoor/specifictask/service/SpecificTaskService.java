package kr.co.nextdoor.specifictask.service;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.nextdoor.specifictask.dao.SpecificTaskDAO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.co.nextdoor.file.dto.FileDTO;

/*
* @Class : SpecificTaskService
* @Date : 2017. 06. 16
* @Author : 문창균
* @Desc : SpecificTaskController에 대한 service
*/
@Service
public class SpecificTaskService {
	
	@Autowired
	SqlSession sqlsession;
	
	/*
    * @method Name : listSpecificTask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무출력
    * @param : task_no
    * @return : List<SpecificTaskDTO>
    */
	public List<SpecificTaskDTO> listSpecificTask(String task_no){
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		List<SpecificTaskDTO> specifictasklist = specifictaskdao.listSpecifictask(task_no);	
		return specifictasklist;
	}

	
	
	/*
    * @method Name : insertSpecificTask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무추가
    * @param : specifictaskdto
    * @return : int
    */
	public int insertSpecificTask(SpecificTaskDTO specifictaskdto){
		
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.insertSpecifictask(specifictaskdto);
		
		return result;
	}
	
	/*
    * @method Name : insertModiSpecifictask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무수정값 추가
    * @param : specifictaskmodidto
    * @return : int
    */
	public int insertModiSpecifictask(SpecificTaskModiDTO specifictaskmodidto){
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.insertModiSpecifictask(specifictaskmodidto);	
		
		return result;			
	}
		
	/*
    * @method Name : updateModiSpecifictask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무수정값 업데이트
    * @param : specifictaskmodidto
    * @return : int
    */
	public int updateModiSpecifictask(SpecificTaskModiDTO specifictaskmodidto){
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.updateModiSpecifictask(specifictaskmodidto);	
		
		return result;			
	}  
	
	/*
    * @method Name : updateSpecifictask
    * @date : 2017. 07. 01
    * @author : 문창균
    * @description : 세부업무명 수정
    * @param : specifictaskmodidto
    * @return : int
    */
	public int updateSpecifictask(SpecificTaskDTO specifictaskdto){
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.updateSpecifictask(specifictaskdto);	
		
		return result;			
	}  
		
	/*
    * @method Name : detailModiSpecifictask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무수정값 출력
    * @param : specifictask_no
    * @return : SpecificTaskModiDTO
    */
	public SpecificTaskModiDTO detailModiSpecifictask(String specifictask_no){
		
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		SpecificTaskModiDTO specifictaskdto = specifictaskdao.detailModiSpecifictask(specifictask_no);		
		
		return specifictaskdto;		
	}
			
	/*
    * @method Name : deleteSpecifictask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무 삭제
    * @param : specifictask_no
    * @return : int
    */
	public int deleteSpecifictask(String specifictask_no){	
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.deleteSpecifictask(specifictask_no);
		
		return result;
	}

	
	/*
	 * @method Name : checkSpecifcitask
	 * @date : 2017. 06. 23
	 * @author : 문창균
	 * @description : 세부업무 확인
	 * @param : SpecificTaskDTO 
	 * @return : int
	 */
	public int checkSpecifcitask(SpecificTaskDTO specifictaskdto){
		
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.checkSpecifcitask(specifictaskdto);
		return result;
		
	}
	
	public SpecificTaskDTO seleteSpecificTaskComp(String specifictask_no){
		
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		SpecificTaskDTO specifictask = specifictaskdao.seleteSpecificTaskComp(specifictask_no);
		
		return specifictask;
	}
	
	//selectspecifictask
   public SpecificTaskDTO selectSpecificTask(String task_no){
      SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
      SpecificTaskDTO specificyaskdto = specifictaskdao.selectSpecificTask(task_no);
      return specificyaskdto;
   }
	
}

