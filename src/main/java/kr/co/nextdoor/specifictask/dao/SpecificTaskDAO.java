package kr.co.nextdoor.specifictask.dao;

import java.util.List;

import kr.co.nextdoor.file.dto.FileDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;

public interface SpecificTaskDAO {

	//상세업무 생성
	public int insertSpecifictask(SpecificTaskDTO specifictaskdto);

	//전체 추가업무리스트
	public List<SpecificTaskDTO> listSpecifictask(String task_no);
	
	//상세업무 수정
	public int updateSpecifictask(SpecificTaskModiDTO specifictaskmodidto);
	
	//상세업무 삭제
	public int deleteSpecifictask(String specifictask_no);
	
	//상세업무 Modi값 insert
	public int insertModiSpecifictask(SpecificTaskModiDTO specifictaskmodidto); 
		
	//상세업무 Modi update
	public int updateModiSpecifictask(SpecificTaskModiDTO specifictaskmodidto);
	
	//추가업무 수정값 불러오기
	public SpecificTaskModiDTO detailModiSpecifictask(String specifictask_no);
	
	//파일업로드
	public int uploadFile(FileDTO filedto);
	//파일리스트 뿌리기 
	public List<FileDTO> listFiles(SpecificTaskDTO specifictaskdto);
	
}
