package easy.mvc.service;

import easy.mvc.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author limengyu
 * @date 2017/9/15
 */
public interface UserService {

	/**
	 * 检测
	 * @param userPhone
	 */
	public boolean isExistUser(String userPhone);

	/**
	 * 添加用户
	 * @param user
	 */
	public boolean addUser(User user);

	/**
	 * 更新用户
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 查询用户
	 * @param userPhone
	 * @return
	 */
	public User getUserByUserPhone(String userPhone);

	/**
	 * 查询用户
	 * @return
	 */
	public List<User> getAllUser();
}
