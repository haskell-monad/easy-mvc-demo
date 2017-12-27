package easy.mvc.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import easy.framework.annotation.Inject;
import easy.framework.annotation.Service;
import easy.framework.database.dao.impl.JdbcTemplate;
import easy.framework.transaction.annotation.Transaction;
import easy.framework.utils.JsonUtils;
import easy.mvc.model.User;
import easy.mvc.service.UserService;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author limengyu
 * @date 2017/9/15
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean isExistUser(String userPhone) {
		User user = this.getUserByUserPhone(userPhone);
		if(user == null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	@Transaction
	public boolean addUser(User user){
		boolean existUser = isExistUser(user.getUserPhone());
		if(existUser){
			return true;
		}
		logger.debug("addUser: {}", JsonUtils.toJson(user));
		String sql = "insert into user (USER_NAME,USER_PHONE,USER_STATUS,DEPARTMENT,CREATE_DATE) values (?,?,?,?,?);";
		jdbcTemplate.update(sql,user.getUserName(), user.getUserPhone(), 1, user.getDepartment(), new Date());
		return false;
	}
	@Override
	public void updateUser(User user) {
	}
	@Override
	public User getUserByUserPhone(String userPhone) {
		String sql = "select * from user where USER_PHONE = ?";
		User user = jdbcTemplate.select(sql, User.class, userPhone);
		logger.debug("getUser: {}", JsonUtils.toJson(user));
		return user;
	}
	@Override
	public List<User> getAllUser() {
		String sql = "select * from user";
		List<User> result = jdbcTemplate.selectList(sql,User.class);
		logger.debug("getAllUser: {}", JsonUtils.toJson(result));
		return result;
	}
}
