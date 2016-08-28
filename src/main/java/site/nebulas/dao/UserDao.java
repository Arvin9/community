package site.nebulas.dao;

import java.util.Set;
import site.nebulas.beans.User;

/**
 * @author CaiHonghui
 * @date 20160818
 */
public interface UserDao {

    public void createUser(User user);
    
    public void updateUser(User user);

    User findByUserAccount(String userAccount);


}

