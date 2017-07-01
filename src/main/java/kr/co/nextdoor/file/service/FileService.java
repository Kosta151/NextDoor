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
import org.springframework.web.multipart.MultipartFile;


import kr.co.nextdoor.file.dao.FileDAO;
import kr.co.nextdoor.file.dto.FileDTO;


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
	public int uploadFile(FileDTO filedto, List<MultipartFile> mfList, HttpServletRequest request, Principal principal) throws IOException{
		
		int result = 0;
		String project_no = filedto.getProject_no();
		
		if(mfList != null && mfList.size() > 0){
		for(MultipartFile mf:mfList){			
			
			String member_id = principal.getName();
			String original_name = mf.getOriginalFilename(); //파일명 얻기

			//업로드 파일명을 변경후 저장			
			String uploadedFileName = System.currentTimeMillis()+UUID.randomUUID().toString()+"_"+ original_name;
		    String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
		    String fullpath = uploadPath+"/"+uploadedFileName;
		    //지정한주소에 파일 저장	    
		    if(mf.getSize() != 0) {	    	
		    	FileOutputStream fs = new FileOutputStream(fullpath);
				fs.write(mf.getBytes());
				fs.close();
		    }

		    filedto.setProject_no(project_no);
		    filedto.setOriginal_name(original_name);
		    filedto.setFile_name(fullpath);
		    filedto.setFile_size(mf.getSize());
		    filedto.setMember_id(member_id);
		    
		    FileDAO filedao = sqlsession.getMapper(FileDAO.class);
			result = filedao.uploadFile(filedto);
			}
		}

		return result;
				
	}
	
	/*
	 * @method Name : listFile
	 * @date : 2017. 06. 16
	 * @author : 김선화
	 * @description : 파일 리스트
	 * @param : filedto 
	 * @return : List
	 */
	public List<FileDTO> listFile(FileDTO filedto) throws Exception{
		FileDAO filedao = sqlsession.getMapper(FileDAO.class);
		return filedao.listFile(filedto);
	}
}
