package kr.co.nextdoor.specifictask.dao;

import java.util.List;

import kr.co.nextdoor.file.dto.FileDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;

public interface SpecificTaskDAO {

	//추가업무 생성
	public int insertSpecifictask(SpecificTaskDTO specifictaskdto);
	//업무 배정
	public int giveTask(SpecificTaskDTO specifictaskdto);
	//전체 추가업무리스트
	public List<SpecificTaskDTO> getSpecifictasks(SpecificTaskDTO specifictaskdto);
	//추가업무 수정
	public int updateSpecifictask(SpecificTaskModiDTO specifictaskmodidto);
	//추가업무 삭제
	public int deleteSpecifictask(int specifictaskno);
	//파일업로드
	public int uploadFile(FileDTO filedto);
	//파일리스트 뿌리기 
	public List<FileDTO> listFiles(SpecificTaskDTO specifictaskdto);
	
}