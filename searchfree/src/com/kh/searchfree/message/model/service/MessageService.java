package com.kh.searchfree.message.model.service;

import static com.kh.searchfree.common.JDBCTemplate.*;
import static com.kh.searchfree.common.JDBCTemplate.commit;
import static com.kh.searchfree.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.searchfree.message.model.dao.MessageDao;
import com.kh.searchfree.message.model.vo.Message;

public class MessageService {

	public int getListCount(int mNumber) throws Exception{
		
		Connection conn = getConnection();

		int listCount = new MessageDao().getListCount(conn , mNumber);

		close(conn);

		return listCount;
	}

	public List<Message> selectListPage(int currentPage, int limit, int mNumber)throws Exception {
		
		Connection conn = getConnection();

		List<Message> mList = new MessageDao().selectListPage(conn, currentPage, limit , mNumber);

		close(conn);

		return mList;
	}

	public Message selectMessage(int msgNo) throws Exception{
		
		Connection conn = getConnection();
		
		Message msgDetail = new MessageDao().selectMessage(conn, msgNo);
		
		close(conn);
		
		return msgDetail;
	}
	
	public  List selectNick(List<String> seNick)throws Exception {
		Connection conn = getConnection();
		
		String seleNick = null;
		List receiverNo = null;
		for(int i=0; i<seNick.size(); i++) {
			seleNick = seNick.get(i);
		
		receiverNo = new MessageDao().selectNick(conn, seleNick);
		}
		
		return receiverNo;
	}

	public int[] sendMsg(String msgTitle, String content, List receiverNo , int senderNo)throws Exception {
		Connection conn = getConnection();
		
		int[] result  =  new MessageDao().sendMsg(conn, msgTitle, content, receiverNo, senderNo);
		
		System.out.println("전송결과 result " + result);
		
		for(int i=0; i< result.length; i++) {
			
			if(result[i]>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}
		
		return result;
	}

	public int deleteMsg(List<String> seNo) throws Exception{
		
		Connection conn  = getConnection();
		int  input = 0;
		int result = 0;
		for(int i=0; i<seNo.size(); i++) {
			
			 input = Integer.parseInt(seNo.get(i));
			 result  =  new MessageDao().deleteMsg(conn, input);
		
		if(result > 0 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		}
		return result;
		
		
	}




}
