package no.husby.mindthegap.handlers;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;

public class TopicDetailHandler {
	Logger logger = Logger.getLogger(Class.class);

	@Execute
	public void execute() {
		logger.debug("TOPICDETAILHANDLER! " + this.getClass().getName() + ".execute");
	}
}
