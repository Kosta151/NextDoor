package kr.co.nextdoor.file.dao;

import java.util.List;

import kr.co.nextdoor.file.dto.FileDTO;

public interface FileDAO {

	/*
	 * @method Name : uploadFile
	 * @date : 2017. 06. 16
	 * @author : 김선화
	 * @description : 파일업로드
	 * @return : int
	 */
	public int uploadFile(FileDTO filedto);
	
	/*
	 * @method Name : uploadFile
	 * @date : 2017. 06. 16
	 * @author : 김선화
	 * @description : 파일업로드
	 * @return : int
	 */
	public List<FileDTO> listFile(FileDTO filedto) throws Exception;
}
