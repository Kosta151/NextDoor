package kr.co.nextdoor.file.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import kr.co.nextdoor.file.dao.FileDAO;
import kr.co.nextdoor.file.dto.FileDTO;
import kr.co.nextdoor.specifictask.dao.SpecificTaskDAO;

@Service
public class FileService {

	@Autowired
	SqlSession sqlsession;
	
	/*
	 * @method Name : UploadFile
	 * @date : 2017. 06. 16
	 * @author : 김선화
	 * @description : 파일업로드
	 * @param : filedto, file, request 
	 * @return : int
	 */
	//파일업로드
	public int uploadFile(FileDTO filedto, CommonsMultipartFile file, HttpServletRequest request, Principal principal) throws IOException{
				
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
		filedto.setMember_id(principal.getName());
		System.out.println("프린시팔 : "+principal.getName());
		FileDAO filedao = sqlsession.getMapper(FileDAO.class);
		int result = filedao.uploadFile(filedto);

		return result;
	}
	
	//파일리스트
	public List<FileDTO> listFile(FileDTO filedto) throws Exception{
		FileDAO filedao = sqlsession.getMapper(FileDAO.class);
		return filedao.listFile(filedto);
	}
}
