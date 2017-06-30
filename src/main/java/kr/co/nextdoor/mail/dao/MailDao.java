package kr.co.nextdoor.mail.dao;
 

import java.util.HashMap;

import kr.co.nextdoor.mail.dto.MailDto;

/*
* @Class : MailDao
* @Date : 2017. 06. 
* @Author : 문창균, 송지은
* @Desc : mail에 대한 DAO
*/
public interface MailDao {

   
   /*
    * @method Name : searchMember
    * @date : 2017. 06. 25
    * @author : 문창균
    * @description : 멤버 찾기
    * @return : MailDto
    */
   public MailDto searchMember(String member_id);
   
   /*
    * @method Name : updatePassword
    * @date : 2017. 06. 25
    * @author : 문창균, 송지은
    * @description : 비밀번호 수정
    * @return : int
    */
   public int updatePassword(HashMap<String, String> map);
   
   /*
    * @method Name : insertProjectMember
    * @date : 2017. 06. 23
    * @author : 송지은
    * @description : projectmember 테이블에 초대맴버 추가
    * @return : void
    */
   public void insertProjectMember(MailDto maildto);
}