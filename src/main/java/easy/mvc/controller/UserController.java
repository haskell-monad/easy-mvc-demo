package easy.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import easy.framework.mvc.model.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import easy.framework.annotation.Autowired;
import easy.framework.annotation.Controller;
import easy.framework.annotation.Impl;
import easy.framework.mvc.annotation.Action;
import easy.framework.mvc.annotation.PathVariable;
import easy.framework.mvc.annotation.RequestBody;
import easy.framework.mvc.common.RequestMethod;
import easy.framework.mvc.model.View;
import easy.mvc.model.User;
import easy.mvc.service.UserService;
import easy.mvc.service.impl.UserServiceImpl;

/**
 * Created by limengyu on 2017/9/13.
 */
@Controller("userController")
@Action(value = "/user")
// @Aspect(value = { MethodExecuteTimeAspect.class, SayHelloAspect.class })
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	@Impl(UserServiceImpl.class)
	private UserService userServices;

	@Action(value = "/index", method = RequestMethod.GET)
	public View index() {
		Map<String, Object> params = new HashMap<>(16);
		return new View("user/index", params);
	}
	@Action(value = "/info", method = RequestMethod.GET)
	public View addUserInfo() {
		Map<String, Object> params = new HashMap<>(16);
		return new View("user/add", params);
	}
//	@Action(value = "/check/{userPhone}", method = RequestMethod.GET)
//	public Result checkUser(@PathVariable String userPhone) {
//		boolean existUser = userServices.isExistUser(userPhone);
//		Result result = new Result();
//		result.setCode(0);
//		result.setData(userPhone);
//		if(existUser){
//			result.setCode(1);
//			result.setMsg("不可以重复报名");
//		}
//		return result;
//	}

	@Action(value = "/add", method = RequestMethod.POST)
	public Result addUser(@RequestBody User user) {
		Result result = new Result();
		if(StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getUserPhone())){
			result.setCode(1);
			result.setMsg("姓名手机号不可以为空");
			return result;
		}
		boolean flag = userServices.addUser(user);
		if(flag){
			result.setCode(2);
			result.setMsg("不可以重复报名");
			return result;
		}
		result.setCode(0);
		result.setMsg("报名成功");
		return result;
	}
	@Action(value = "/list", method = RequestMethod.GET)
	public View selectUser(@PathVariable String u,@PathVariable String p) {
		if(!"chenjialin".equals(u) && !"jianlin.chen".equals(p)) {
			throw new RuntimeException("没有权限访问");
		}
		Map<String,Object> params = new HashMap<>(16);
		List<User> allUser = userServices.getAllUser();
		params.put("userList", allUser);
		return new View("user/list",params);
	}
}
