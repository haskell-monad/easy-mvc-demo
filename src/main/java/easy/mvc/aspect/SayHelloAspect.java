package easy.mvc.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import easy.framework.aop.AbstractAspect;

/**
 *
 * @author limengyu
 * @date 2017/9/26
 */
public class SayHelloAspect extends AbstractAspect {
	private static final Logger logger = LoggerFactory.getLogger(SayHelloAspect.class);

	@Override
	protected void end() {
		logger.debug("方法执行完成....");
	}
}
