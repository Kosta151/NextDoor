package kr.co.nextdoor.chat.service;
/*
* @Class : ChatHandler
* @Date : 2017. 06. 20 
* @Author : 이재민
* @Desc : Chat
*/
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ChatHandler extends TextWebSocketHandler {

	private List<WebSocketSession> connectedUsers;
	
	private static Map<String, Object> projectmember;

    static{
    	projectmember = new HashMap<String, Object>();
    }
    /*
	    * @method Name : ChatHandler
	    * @date : 2017. 06. 20
	    * @author : 이재민
	    * @description : 생성자 초기화
	    */
	public ChatHandler(){
		
		connectedUsers = new ArrayList<WebSocketSession>();
	}
	
	   /*
	    * @method Name : afterConnectionEstablished
	    * @date : 2017. 06. 20
	    * @author : 이재민
	    * @description : map에서 key를 통해  group 번호에 connectUsers리스트를 가져온후 -> websocketsession을 connectUsers에 추가
	    */
	@Override
	@SuppressWarnings("unchecked")
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Map<String, Object> map = session.getAttributes();
		String user_id = (String)map.get("user_id");
		String project_no = (String)map.get("project_no");
		
		//project_no로 생성되어 있는 채팅방이 없으면 새로운 배열을 생성해주고
		if(!projectmember.containsKey(project_no)){
			projectmember.put(project_no, new ArrayList<WebSocketSession>());
		}
			List<WebSocketSession> conn = (List<WebSocketSession>) projectmember.get(project_no);
			conn.add(session);
			projectmember.put(project_no, conn);
	}
	
	/*
	    * @method Name : handleTextMessage
	    * @date : 2017. 06. 20
	    * @author : 이재민
	    * @description : send함수가 실행될때 interceptor 값과 message 값을 이용하여 onmessage함수로 값을 보내주는 함수
	    */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, Object> map = session.getAttributes();
		String user_id = (String)map.get("user_id");
		String project_no = (String)map.get("project_no");
		SimpleDateFormat dayTime = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		String date = dayTime.format(new Date(System.currentTimeMillis()));
		List<WebSocketSession> conn = (List<WebSocketSession>) projectmember.get(project_no);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_id", user_id);
		data.put("message", message.getPayload());
		data.put("date", date);
		ObjectMapper om = new ObjectMapper();
		String jsonStr = om.writeValueAsString(data);
		for(WebSocketSession webSocketSession : conn){
			webSocketSession.sendMessage(new TextMessage(jsonStr));		
		}
	}
	
	/*
	    * @method Name : afterConnectionClosed
	    * @date : 2017. 06. 20
	    * @author : 이재민
	    * @description : 접속종료시 프로젝트 채팅창, 유저 session값 삭제
	    */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Map<String, Object> map = session.getAttributes();
		String user_id = (String)map.get("user_id");
		
		String project_no = (String)map.get("project_no");
		List<WebSocketSession> conn = (List<WebSocketSession>) projectmember.get(project_no);
		Map<String, Object> data = new HashMap<String, Object>();
	
		
		conn.remove(session);
		session.close();
		projectmember.remove(project_no);
		projectmember.put(project_no, conn);
		
		data.put("user_id", user_id);
		data.put("message", "님이 접속을 종료하였습니다.");
		ObjectMapper om = new ObjectMapper();
		String jsonStr = om.writeValueAsString(data);
		for(WebSocketSession webSocketSession : conn){
			if(!session.getId().equals(webSocketSession)){
				webSocketSession.sendMessage(new TextMessage(jsonStr));		
			}
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
	}

}