package site.nebulas.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.beans.MessageBoard;
import site.nebulas.dao.MessageBoardDao;
@Service
public class MessageBoardService {
	@Resource
	private MessageBoardDao messageBoardDao;
	
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160821 查询所有留言信息
	 */
	public List<MessageBoard> getMessageBoard(MessageBoard messageBoard){
		return messageBoardDao.getMessageBoard(messageBoard);
	}
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160821 插入用户留言信息
	 */
	public void insertMessageBoard(MessageBoard messageBoard){
		messageBoardDao.insertMessageBoard(messageBoard);
	}
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160821 更新留言板的点赞数量
	 */
	public void updateMessageBoard(MessageBoard messageBoard){
		messageBoardDao.updateMessageBoard(messageBoard);
	}
	/**
	 * @author CaiHonghui
	 * @version 0.1
	 * 20160821 插入留言板用户点赞信息
	 */
	public void insertMessageBoardSupport(MessageBoard messageBoard){
		messageBoardDao.insertMessageBoardSupport(messageBoard);
	}
}
