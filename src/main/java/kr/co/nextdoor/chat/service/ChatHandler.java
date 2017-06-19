package kr.co.nextdoor.chat.service;

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

	//프로젝트 정보를 담고 있는 맵
	private static Map<String, Object> projectmember;
	//웹소켓 사용자 리스트
	private List<WebSocketSession> connectedUsers;

	//생성자 초기화
	public ChatHandler(){
		projectmember = new HashMap<String, Object>();
		connectedUsers = new ArrayList<WebSocketSession>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Map<String, Object> map = session.getAttributes();
		String user_id = (String)map.get("user_id");
		String project_no = (String)map.get("project_no");
		System.out.println("접속ID : " + user_id);
		System.out.println("채팅접속프로젝트번호 : " + project_no);
		
		if(!projectmember.containsKey(project_no)){
			projectmember.put(project_no, new ArrayList<WebSocketSession>());
		}
			List<WebSocketSession> conn = (List<WebSocketSession>) projectmember.get(project_no);
			conn.add(session);
			projectmember.put(project_no, conn);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, Object> map = session.getAttributes();
		String user_id = (String)map.get("user_id");
		String project_no = (String)map.get("project_no");
		System.out.println("----------그룹 채팅방-------------");
		System.out.println("user 이름 : "+user_id);
		System.out.println("session id : " +session.getId());
		System.out.println("Group 번호 : "+project_no);
		System.out.println("메시지 : "+message.getPayload());		
		System.out.println("------------------------------");
		System.out.println();
		List<WebSocketSession> conn = (List<WebSocketSession>) projectmember.get(project_no);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user_id", user_id);
		data.put("message", message.getPayload());
		ObjectMapper om = new ObjectMapper();
		 String jsonStr = om.writeValueAsString(data);
		for(WebSocketSession webSocketSession : conn){
			if(!session.getId().equals(webSocketSession)){
				webSocketSession.sendMessage(new TextMessage(jsonStr));		
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		Map<String, Object> map = session.getAttributes();
		String user_id = (String)map.get("user_id");
		
		String project_no = (String)map.get("project_no");
		System.out.println(user_id + "님 접속종료");
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
