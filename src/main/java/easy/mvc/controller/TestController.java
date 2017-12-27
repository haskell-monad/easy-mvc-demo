package easy.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import easy.mvc.service.impl.AdminServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import easy.framework.annotation.Autowired;
import easy.framework.annotation.Controller;
import easy.framework.annotation.Impl;
import easy.framework.annotation.Inject;
import easy.framework.aop.annotation.Aspect;
import easy.framework.database.dao.impl.JdbcTemplate;
import easy.framework.mvc.annotation.Action;
import easy.framework.mvc.annotation.FileBody;
import easy.framework.mvc.annotation.Param;
import easy.framework.mvc.annotation.PathVariable;
import easy.framework.mvc.annotation.RequestBody;
import easy.framework.mvc.common.RequestMethod;
import easy.framework.mvc.model.FileModel;
import easy.framework.mvc.model.Result;
import easy.framework.mvc.model.View;
import easy.mvc.aspect.MethodExecuteTimeAspect;
import easy.mvc.aspect.SayHelloAspect;
import easy.mvc.model.User;
import easy.mvc.service.UserService;
import easy.mvc.service.impl.UserServiceImpl;

/**
 * Created by limengyu on 2017/9/13.
 */
@Controller("testController")
@Action(value = "/test")
@Aspect(value = { MethodExecuteTimeAspect.class, SayHelloAspect.class })
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@Inject
	private UserService userService;
	@Autowired
	@Impl(AdminServiceImpl.class)
	private UserService adminUserService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Action(value = { "/add/{userName}/{passWord}" }, method = RequestMethod.POST)
	public View addUser(@PathVariable String userName, @Param(required = false, defaultValue = "10") Integer age, @Param(required = false, defaultValue = "2017") int year, @PathVariable("passWord") String passWord, @RequestBody(required = false) List<User> users, @RequestBody(required = false) User user) {
		adminUserService.addUser(user);
		Map<String, Object> params = new HashMap<>();
		params.put("company", "iKang");
		params.put("area", "Beijing");
		params.put("users", users);
		View view = new View("/user/del/100", params);
		return view;
	}
	@Action(value = { "/view/{userId}" }, method = RequestMethod.GET)
	public Result userInfo(@PathVariable Integer userId) {
		// logger.debug("jdbcTemplate == null: {}",jdbcTemplate == null);
		User user = new User();
		user.setUserName("BeckHam");
		adminUserService.addUser(user);
		Result result = new Result();
		result.setCode(100);
		result.setMsg("success");
		result.setData(new User());
		return result;
	}
	@Action(value = { "/del/{userId}" }, method = RequestMethod.GET)
	public View delUser(@PathVariable Integer userId) {
		Map<String, Object> param = new HashMap<>();
		param.put("id", userId);
		return new View("user/delete.jsp", param);
	}
	@Action(value = "/upload", method = RequestMethod.POST)
	public void uploadFile(@FileBody FileModel fileModel,@Param String userName,@RequestBody User user,@RequestBody List<User> users) {
		logger.debug("upload......");
	}
	@Action(value = "/uploads", method = RequestMethod.POST)
	public void uploadFiles(@FileBody List<FileModel> fileModel) {
		logger.debug("upload......");
	}


	@Action(value = "/orm",method = RequestMethod.GET)
	public Result testOrm(){
		List<User> allUser = adminUserService.getAllUser();
		Result result = new Result();
		result.setCode(0);
		result.setData(allUser);
		result.setMsg("");
		return result;
	}
}
