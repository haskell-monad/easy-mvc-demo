package easy.mvc.provider;

import easy.mvc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author limengyu
 * @create 2017/10/24
 */
@Path("/order")
public class OrderService {
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Path("/user/{userId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getOrderUserList(@PathParam("userId") String userId) {
		logger.debug("getOrderUserList....{}", userId);
		User user = new User();
		return user;
	}
}
