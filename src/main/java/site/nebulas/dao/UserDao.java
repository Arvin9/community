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
    public void deleteUser(Long userId);

    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUserAccount(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}

