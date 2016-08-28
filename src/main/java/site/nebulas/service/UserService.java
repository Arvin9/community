package site.nebulas.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.beans.User;
import site.nebulas.dao.UserDao;


@Service
public class UserService {
	@Resource
	private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Resource
    private PasswordHelper passwordHelper;

    public void setPasswordHelper(PasswordHelper passwordHelper) {
        this.passwordHelper = passwordHelper;
    }

    /**
     * @author Honghui
     * @param username
     * @return
     * 根据用户名查找用户
     */
    public User findByUserAccount(String userAccount) {
        return userDao.findByUserAccount(userAccount);
    }
    
    /**
     * @author Honghui
     * 创建用户
     * @param user
     */
    public void createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        userDao.createUser(user);
    }
    

    /**
     * 修改密码
     * @param userAccount
     * @param newPassword
     */
    public void changePassword(String userAccount, String newPassword) {
        User user =userDao.findByUserAccount(userAccount);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }

    
    
    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     
    public void correlationRoles(Long userId, Long... roleIds) {
        userDao.correlationRoles(userId, roleIds);
    }
     */
    
    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleIds
     
    public void uncorrelationRoles(Long userId, Long... roleIds) {
        userDao.uncorrelationRoles(userId, roleIds);
    }
     */
    

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }
     */
    
    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
	*/
}


