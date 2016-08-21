package site.nebulas.dao;


import java.util.List;

import site.nebulas.beans.MessageBoard;


public interface MessageBoardDao {
	public List<MessageBoard> getMessageBoard(MessageBoard messageBoard);
	public void insertMessageBoard(MessageBoard messageBoard);
	
	public void updateMessageBoard(MessageBoard messageBoard);
	public void insertMessageBoardSupport(MessageBoard messageBoard);
}
