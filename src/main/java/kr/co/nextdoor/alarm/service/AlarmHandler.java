package kr.co.nextdoor.alarm.service;
/*
* @Class : AlarmHandler
* @Date : 2017. 06. 20 
* @Author : 박찬섭
* @Desc : Alarm
*/

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;


import kr.co.nextdoor.alarm.dto.AlarmDTO;

public class AlarmHandler extends TextWebSocketHandler{

	static List<WebSocketSession> connectedUsers = new ArrayList<WebSocketSession>();
	
	@Autowired
	AlarmService alarmservice;
	/*
	    * @method Name : afterConnectionEstablished
	    * @date : 2017. 06. 20
	    * @author : 박찬섭
	    * @description : 회원이 접속하면 접속유저세션리스트에 세션 추가
	    */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("접속한 IP : " + session.getRemoteAddress().getHostName());
		
		connectedUsers.add(session);
		
	}

	/*
	    * @method Name : afterConnectionClosed
	    * @date : 2017. 06. 20
	    * @author : 박찬섭
	    * @description : 회원이 접속을 종료하면 접속유저세션리스트에서 세션 제거
	    */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		connectedUsers.remove(session);
		
	}

	/*
	    * @method Name : handleTextMessage
	    * @date : 2017. 06. 20
	    * @author : 박찬섭
	    * @description : view단에서 send()요청이 오면 send파라메타를 처리 
	    */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println("s");
		Map<String, Object> map = session.getAttributes();
		String user_id = (String) map.get("user_id");
		String specifictask_cont = (String) map.get("specifictask_cont");
		String specifictask_no = (String) map.get("specifictask_no");
		String receiver = message.getPayload();
		/*String alarm_cont = user_id+"님이"+receiver+"님에게"+specifictask_cont+"배당하셨습니다.";*/
		/*SimpleDateFormat dayTime = new SimpleDateFormat("yy-MM-dd hh:mm:ss");*/
		/*AlarmDTO alarmdto = null;
		alarmdto.setAlarm_receiver(receiver);
		alarmdto.setAlarm_sender(user_id);
		alarmdto.setSpecifictask_no(specifictask_no); 
		alarmdto.setAlarm_cont(alarm_cont);
		alarmdto.setAlarm_date(dayTime.format(new Date(System.currentTimeMillis())));
		int result=alarmservice.InsertAlarm(alarmdto);
		System.out.println("들어갔음?"+result);*/

		Map<String, Object> data = new HashMap<String, Object>();
		System.out.println(specifictask_cont + "/" +receiver+ "/"+user_id);	//ID와 메세지
		data.put("user_id",user_id);
		data.put("specifictask_cont", specifictask_cont);
		data.put("receiver", receiver);
		ObjectMapper om = new ObjectMapper();
		String jsonStr = om.writeValueAsString(data);
		System.out.println(connectedUsers.size());	//c onnectedUsers 배열의 사이즈를 봄(몇명이 연결되어있는지)
		
		
		
		for (WebSocketSession webSocketSession : connectedUsers) {
			if (!session.getId().equals(webSocketSession)) {
				System.out.println(session.getId()+"//"+ webSocketSession);	//세션에 있는 아이디들에 FOR문 돌면서..
				webSocketSession.sendMessage(new TextMessage(jsonStr));
			}
		}
	}
	
	/*
	    * @method Name : handleTransportError
	    * @date : 2017. 06. 20
	    * @author : 박찬섭
	    * @description : 에러 처리
	    */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
	}
	

}
