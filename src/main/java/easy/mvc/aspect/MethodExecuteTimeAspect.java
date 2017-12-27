package easy.mvc.aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import easy.framework.aop.AbstractAspect;

/**
 *
 * @author limengyu
 * @date 2017/9/26
 */
public class MethodExecuteTimeAspect extends AbstractAspect {
	private static final Logger logger = LoggerFactory.getLogger(MethodExecuteTimeAspect.class);
	private long startTime;

	@Override
	protected void end() {
		logger.debug("方法耗时: {}", System.currentTimeMillis() - startTime);
	}
	@Override
	protected void before() {
		startTime = System.currentTimeMillis();
	}
	@Override
	protected boolean intercept() {
		return true;
	}
}
