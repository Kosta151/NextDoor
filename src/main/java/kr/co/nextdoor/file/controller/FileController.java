package kr.co.nextdoor.file.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import kr.co.nextdoor.file.dto.FileDTO;
import kr.co.nextdoor.file.service.FileDownloadView;
import kr.co.nextdoor.file.service.FileService;

@Controller
@SessionAttributes({"workspace_no", "project_no", "task_no", "specifictask_no"})
public class FileController implements ApplicationContextAware{

	private WebApplicationContext context = null;

	@Autowired
	FileService fileservice;
	
	@Autowired
	FileDownloadView download ;
	
	
	@RequestMapping(value = "uploadfile.htm")
	public String uploadFile(FileDTO filedto, HttpServletRequest request, Principal principal) throws IOException {
		CommonsMultipartFile file = filedto.getFile();
		fileservice.uploadFile(filedto, file, request, principal);
		return "task.task";
	}
	
	@RequestMapping(value = "listfile.htm")
	public String listFile(HttpSession session, FileDTO filedto, Model model) throws Exception {
		filedto.setProject_no((String)session.getAttribute("project_no"));
		model.addAttribute("filelist", fileservice.listFile(filedto));
		return "task.listfile";
	}
	
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
