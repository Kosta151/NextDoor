package kr.co.nextdoor.chat.service;

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
	
	//프로젝트 정보를 담고 있는 맵 key=group번호, data=그룹에 접속한 웹소켓 세션리스트
	private static Map<String, Object> projectmember;

    static{
    	projectmember = new HashMap<String, Object>();
    }
	//생성자 초기화
	public ChatHandler(){
		
		connectedUsers = new ArrayList<WebSocketSession>();
	}
	
	//map에서 key를 통해  group 번호에 connectUsers리스트를 가져온후 -> websocketsession을 connectUsers에 추가
	@Override
	@SuppressWarnings("unchecked")
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Map<String, Object> map = session.getAttributes();
		String user_id = (String)map.get("user_id");
		String project_no = (String)map.get("project_no");
		System.out.println("접속ID : " + user_id);
		System.out.println("채팅접속프로젝트번호 : " + project_no);
		
		//project_no로 생성되어 있는 채팅방이 없으면 새로운 배열을 생성해주고
		System.out.println("Map에 Key값이 있는지 확인 2번째 접속부턴 true"+projectmember.containsKey(project_no));
		System.out.println("Map이 비어있는지 확인 비어있으면 True" + projectmember.isEmpty());
		if(!projectmember.containsKey(project_no)){
			System.out.println("Map에 있는 Key의 size 배열 넣기 전 : " + projectmember.size());
			projectmember.put(project_no, new ArrayList<WebSocketSession>());
			System.out.println("Map에 있는 Key의 size 배열 넣은 후 : " + projectmember.size());
		}
			List<WebSocketSession> conn = (List<WebSocketSession>) projectmember.get(project_no);
			conn.add(session);
			System.out.println(project_no +" / "+ conn.iterator() + "/" + projectmember.toString());
			projectmember.put(project_no, conn);
			System.out.println("Map에 Session을 넣은 후 Map size : " + projectmember.size());
	}

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