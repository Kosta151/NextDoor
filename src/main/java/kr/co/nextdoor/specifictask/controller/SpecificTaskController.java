package kr.co.nextdoor.specifictask.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import kr.co.nextdoor.file.dto.FileDTO;
import kr.co.nextdoor.specifictask.service.SpecificTaskService;


@Controller
public class SpecificTaskController {
	
	@Autowired
	private SpecificTaskService specifictaskservice;
	
	@RequestMapping(value="file.htm", method = RequestMethod.POST)
	public String uploadFile(FileDTO filedto, HttpServletRequest request) throws IOException { 
		
		System.out.println(filedto.getSpecifictask_no());
		CommonsMultipartFile file = filedto.getFile();
		int result =  specifictaskservice.UploadFile(filedto, file, request);
		
		if(result>0){
			return "index.htm";
		}else{
			return "index.htm";
		}
	}
	
	
}
