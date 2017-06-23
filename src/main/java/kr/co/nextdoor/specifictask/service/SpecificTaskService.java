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
		System.out.println(specifictaskdto.getSpecifictask_cont());
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
    * @method Name : detailModiSpecifictask
    * @date : 2017. 06. 16
    * @author : 문창균
    * @description : 세부업무수정값 출력
    * @param : specifictask_no
    * @return : SpecificTaskModiDTO
    */
	public SpecificTaskModiDTO detailModiSpecifictask(String specifictask_no){
		System.out.println("jjh:"+specifictask_no);
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
	 * @method Name : UploadFile
	 * @date : 2017. 06. 16
	 * @author : 김선화
	 * @description : 파일업로드
	 * @param : filedto, file, request 
	 * @return : int
	 */
	//파일업로드
	public int uploadFile(FileDTO filedto, CommonsMultipartFile file, HttpServletRequest request) throws IOException{
				
		String fname = file.getOriginalFilename();
		String path = request.getSession().getServletContext().getRealPath("/nextdoor/upload");
		String uploadedFileName = System.currentTimeMillis()+UUID.randomUUID().toString()+"_"+ fname;
		String fullpath = path + "\\" + uploadedFileName;
				
		if (!fname.equals("")) {
			// 서버에 파일 쓰기 작업
			FileOutputStream fs = new FileOutputStream(fullpath);
			fs.write(file.getBytes());
			fs.close();
		}
				
		filedto.setSpecifictask_no(filedto.getSpecifictask_no());
		filedto.setOriginal_name(fname);
		filedto.setFile_name(fullpath);
		filedto.setFile_size(file.getSize());
				
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.uploadFile(filedto);

		return result;
	}
}

