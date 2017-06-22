package kr.co.nextdoor.specifictask.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;
import kr.co.nextdoor.specifictask.service.SpecificTaskService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import kr.co.nextdoor.file.dto.FileDTO;

@Controller
public class SpecificTaskController {

	@Autowired
	SpecificTaskService specifictaskservice;

	@Autowired
	View jsonview;

	@RequestMapping(value = "specifictask.htm", method = RequestMethod.POST)
	public View listSpecificTask(String task_no, Model model) {
		List<SpecificTaskDTO> specifictasklist = specifictaskservice.listSpecificTask(task_no);
		model.addAttribute("data", specifictasklist);
		return jsonview;

	}

	@RequestMapping(value = "file.htm", method = RequestMethod.POST)
	public String uploadFile(FileDTO filedto, HttpServletRequest request) throws IOException {

		System.out.println(filedto.getSpecifictask_no());
		CommonsMultipartFile file = filedto.getFile();
		int result = specifictaskservice.UploadFile(filedto, file, request);

		if (result > 0) {
			return "index.htm";
		} else {
			return "index.htm";
		}

	}
	@RequestMapping("insertpecifictask.htm")
	public String insertSpecificTask(SpecificTaskDTO specifictask){
		specifictaskservice.insertSpecificTask(specifictask);

		return "task.task";
	}

	@RequestMapping(value ="deleteSpecifictask.htm")
	public String deleteSpecifictask(String specifictask_no){
		
		System.out.println("specifictask_no : " + specifictask_no);
		specifictaskservice.deleteSpecifictask(specifictask_no);
		
		return "task.task";
	}
	
	//specifictask_no에 따른 디테일값 받아오기 
	@RequestMapping(value = "detailSpecifictask.htm", method=RequestMethod.GET)
	public String detailModiSpecifictask(SpecificTaskDTO specifictaskdto ,Model model, HttpSession session){
			
		SpecificTaskModiDTO modidto = specifictaskservice.detailModiSpecifictask(specifictaskdto.getSpecifictask_no());
		
		session.setAttribute("modidto", modidto);
		session.setAttribute("specifictask_no", specifictaskdto.getSpecifictask_no());
		session.setAttribute("specifictask_cont", specifictaskdto.getSpecifictask_cont());
					
		return "task.task";
	}
		
	@RequestMapping(value ="updateSpecifictask.htm")
	public String updateSpecifictask(SpecificTaskModiDTO specifictaskmodidto){
							
		System.out.println("specifictaskmodidto.getSpecifictask_no() jjh : "+specifictaskmodidto.getSpecifictask_no());
		SpecificTaskModiDTO modidto = specifictaskservice.detailModiSpecifictask(specifictaskmodidto.getSpecifictask_no());
		
		if(modidto==null){
			specifictaskservice.insertModiSpecifictask(specifictaskmodidto);
		}else{
			specifictaskservice.updateModiSpecifictask(specifictaskmodidto);		
		}
		
		return "task.task";
					
	}
}
