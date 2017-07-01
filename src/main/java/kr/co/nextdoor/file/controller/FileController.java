package kr.co.nextdoor.file.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;


import kr.co.nextdoor.file.dto.FileDTO;

import kr.co.nextdoor.file.service.FileDownloadView;
import kr.co.nextdoor.file.service.FileService;

/*
* @Class : FileController
* @Date : 2017. 06. 21 
* @Author : 김선화
* @Desc : FileController
*/
@Controller
@SessionAttributes({"workspace_no", "project_no", "task_no", "specifictask_no"})
public class FileController implements ApplicationContextAware{

	private WebApplicationContext context = null;
	
	@Autowired
	FileService fileservice;
	
	@Autowired
	FileDownloadView download ;
	
	/*
    * @method Name : uploadFile
    * @date : 2017. 06. 27
    * @author : 김선화
    * @description : 파일 업로드(비동기)
    */
	@RequestMapping(value = "uploadfile.htm", method = RequestMethod.POST)
	@ResponseBody
	public void uploadFile(HttpSession session, FileDTO filedto, MultipartHttpServletRequest request, Principal principal) 
            throws Exception{
		filedto.setProject_no((String)session.getAttribute("project_no"));
		List<MultipartFile> mfList = request.getFiles("file");
		fileservice.uploadFile(filedto, mfList, request, principal);
	}  
	
	/*
    * @method Name : listFile
    * @date : 2017. 06. 27
    * @author : 김선화
    * @description : 파일 목록 보여주기
    */
	@RequestMapping(value = "listfile.htm")
	public String listFile(HttpSession session, FileDTO filedto, Model model) throws Exception {
		filedto.setProject_no((String)session.getAttribute("project_no"));
		model.addAttribute("filelist", fileservice.listFile(filedto));
		return "task.listfile";
	}
	/*
    * @method Name : donwloadFile
    * @date : 2017. 06. 27
    * @author : 김선화
    * @description : 파일 다운로드
    */
	@RequestMapping(value = "download.htm")
	public ModelAndView donwloadFile(@RequestParam("file_name")String file_name) throws IOException {
		File file = new File(file_name);
		return new ModelAndView("download","downloadFile",file);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context = (WebApplicationContext)context;
	}
	
}
