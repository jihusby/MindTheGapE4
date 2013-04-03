package no.husby.mindthegap.handlers;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;

public class NewTopicHandler {
	Logger logger = Logger.getLogger(Class.class);

	@Execute
	public void execute(MApplication application) {
		logger.debug(this.getClass().getName() + ".execute");
		// Create a new window and set its size
		MWindow window = MBasicFactory.INSTANCE.createTrimmedWindow();
		window.setWidth(200);
		window.setHeight(300);

		MPart part = MBasicFactory.INSTANCE.createPart();
		part.setElementId("mynewid");
		part.setLabel("A new Part");
		part.setContributionURI("bundleclass://no.husby.mindthegap/no.husby.mindthegap.parts.TopicNewPart");
		window.getChildren().add(part);

		// Add new Window to the application
		application.getChildren().add(window);
	}
	// public void execute(MWindow window) {
	// MPart part = MBasicFactory.INSTANCE.createPart();
	// part.setElementId("mynewid");
	// part.setLabel("A new Part");
	// part.setContributionURI("bundleclass://no.husby.mindthegap/no.husby.mindthegap.parts.TopicNewPart");
	// window.getChildren().add(part);
	// }
}
