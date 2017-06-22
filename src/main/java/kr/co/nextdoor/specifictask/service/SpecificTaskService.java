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



@Service
public class SpecificTaskService {
	
	@Autowired
	SqlSession sqlsession;
	
	public List<SpecificTaskDTO> listSpecificTask(String task_no){
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		List<SpecificTaskDTO> specifictasklist = specifictaskdao.listSpecifictask(task_no);	
		return specifictasklist;
	}

	public int UploadFile(FileDTO filedto, CommonsMultipartFile file, HttpServletRequest request) throws IOException{
		
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
		
		System.out.println(filedto.getSpecifictask_no());
		filedto.setSpecifictask_no(filedto.getSpecifictask_no());
		filedto.setOriginal_name(fname);
		filedto.setFile_name(fullpath);
		filedto.setFile_size("12");
		
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.uploadFile(filedto);

		return result;
	}
	
	public int insertSpecificTask(SpecificTaskDTO specifictaskdto){
		System.out.println(specifictaskdto.getSpecifictask_cont());
		SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
		int result = specifictaskdao.insertSpecifictask(specifictaskdto);
		
		return result;
	}
	
	//수정값 insert
	public int insertModiSpecifictask(SpecificTaskModiDTO specifictaskmodidto)
	{
			SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
			int result = specifictaskdao.insertModiSpecifictask(specifictaskmodidto);	
			return result;			
	};  
		
	//수정값 업데이트
	public int updateModiSpecifictask(SpecificTaskModiDTO specifictaskmodidto)
	{
			SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
			int result = specifictaskdao.updateModiSpecifictask(specifictaskmodidto);	
			return result;			
	};  
		
	//수정값 받아오기
	public SpecificTaskModiDTO detailModiSpecifictask(String specifictask_no){
			System.out.println("jjh:"+specifictask_no);
			SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
			SpecificTaskModiDTO specifictaskdto = specifictaskdao.detailModiSpecifictask(specifictask_no);		
			return specifictaskdto;		
	}
			
	//세부업무 삭제
	public int deleteSpecifictask(String specifictask_no){
				
			SpecificTaskDAO specifictaskdao = sqlsession.getMapper(SpecificTaskDAO.class);
			int result = specifictaskdao.deleteSpecifictask(specifictask_no);
			return result;
	}
}

