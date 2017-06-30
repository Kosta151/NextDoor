package kr.co.nextdoor.mail.dto;
 
/*
* @Class : MailDto
* @Date : 2017. 06. 25
* @Author : 문창균
* @Desc : MailDto
*/
public class MailDto {
   private String member_id;
   private String name;
   private String project_no;
   private String subject;
   private String template;
   private String content;
   private String specifictask_end; //마감일
   private String specifictast_cont; //업무내용
   private String password;
   
   public String getMember_id() {
      return member_id;
   }
   public void setMember_id(String member_id) {
      this.member_id = member_id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getProject_no() {
      return project_no;
   }
   public void setProject_no(String project_no) {
      this.project_no = project_no;
   }
   public String getSubject() {
      return subject;
   }
   public void setSubject(String subject) {
      this.subject = subject;
   }
   public String getTemplate() {
      return template;
   }
   public void setTemplate(String template) {
      this.template = template;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public String getSpecifictask_end() {
      return specifictask_end;
   }
   public void setSpecifictask_end(String specifictask_end) {
      this.specifictask_end = specifictask_end;
   }
   public String getSpecifictast_cont() {
      return specifictast_cont;
   }
   public void setSpecifictast_cont(String specifictast_cont) {
      this.specifictast_cont = specifictast_cont;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
}