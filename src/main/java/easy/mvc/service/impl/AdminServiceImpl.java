package easy.mvc.service.impl;

import java.util.Date;
import java.util.List;

import easy.framework.orm.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import easy.framework.annotation.Service;
import easy.framework.orm.helper.SqlHelper;
import easy.framework.utils.JsonUtils;
import easy.mvc.model.User;
import easy.mvc.service.UserService;

/**
 * @author limengyu
 * @date 2017/9/15
 */
@Service
public class AdminServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Override
	public boolean isExistUser(String userPhone) {
		return false;
	}
	@Override
	public boolean addUser(User User) {
		return false;
	}
	@Override
	public void updateUser(User User) {
	}
	@Override
	public User getUserByUserPhone(String userPhone) {
		return null;
	}
	@Override
	public List<User> getAllUser() {
		List<User> userList = SqlHelper.builder(User.class)
				.and(Condition.notEquals("userName","Giggs"))
				.and(Condition.multiAnd(
						Condition.equals("gender","1"),
						Condition.before("createDate",new Date()),
						Condition.in("age","10","11","12","13"))
				)
				.asc("createDate").desc("age")
				.groupBy("userPhone")
				.field("userName", "userPhone", "gender", "age", "createDate")
				.selectList();
		logger.debug("userList: {}", JsonUtils.toJson(userList));
		return userList;
	}
}
