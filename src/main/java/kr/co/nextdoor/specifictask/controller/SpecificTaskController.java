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

/*
* @Class : SpecificTaskController
* @Date : 2017. 06. 16
* @Author : 문창균
* @Desc : 세부업무 controller
*/
@Controller
public class SpecificTaskController {

	@Autowired
	SpecificTaskService specifictaskservice;

	@Autowired
	View jsonview;

   /*
   * @method Name : listSpecificTask
   * @date : 2017. 06. 16
   * @author : 문창균
   * @description : 세부업무리스트의 비동기 출력
   */
	@RequestMapping(value = "specifictask.htm", method = RequestMethod.POST)
	public View listSpecificTask(String task_no, Model model) {
		List<SpecificTaskDTO> specifictasklist = specifictaskservice.listSpecificTask(task_no);
		model.addAttribute("data", specifictasklist);
		return jsonview;

	}
	
	/*
   * @method Name : insertSpecificTask
   * @date : 2017. 06. 16
   * @author : 문창균
   * @description : 세부업무 추가
   */
	@RequestMapping("insertSpecifictask.htm")
	public String insertSpecificTask(SpecificTaskDTO specifictask){
		specifictaskservice.insertSpecificTask(specifictask);

		return "task.task";
	}

	/*
   * @method Name : deleteSpecifictask
   * @date : 2017. 06. 16
   * @author : 문창균
   * @description : 세부업무 삭제
   */
	@RequestMapping(value ="deleteSpecifictask.htm")
	public String deleteSpecifictask(String specifictask_no){
		
		System.out.println("specifictask_no : " + specifictask_no);
		specifictaskservice.deleteSpecifictask(specifictask_no);
		
		return "task.task";
	}
	
	/*
   * @method Name : detailModiSpecifictask
   * @date : 2017. 06. 16
   * @author : 장진환
   * @description : 세부업무 수정값 출력
   */
	@RequestMapping(value = "detailSpecifictask.htm", method=RequestMethod.GET)
	public String detailModiSpecifictask(SpecificTaskDTO specifictaskdto ,Model model, HttpSession session){
			
		SpecificTaskModiDTO modidto = specifictaskservice.detailModiSpecifictask(specifictaskdto.getSpecifictask_no());
		
		session.setAttribute("modidto", modidto);
		session.setAttribute("specifictask_no", specifictaskdto.getSpecifictask_no());
		session.setAttribute("specifictask_cont", specifictaskdto.getSpecifictask_cont());
					
		return "task.task";
	}
		
	/*
   * @method Name : updateSpecifictask
   * @date : 2017. 06. 16
   * @author : 장진환
   * @description : 세부업무 수정값 업데이트
   */
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
	
	//업무별 파일 업로드
	@RequestMapping(value = "uploadfile.htm")
	public String uploadFile(FileDTO filedto, HttpServletRequest request) throws IOException {
		CommonsMultipartFile file = filedto.getFile();
		specifictaskservice.uploadFile(filedto, file, request);
		return "task.task";
	}
			
	//프로젝트 별 파일리스트 목록 보여주기
	@RequestMapping(value = "listfile.htm")
	public String listFile() throws IOException {
			
		return "task.listfile";

	}
	
}
