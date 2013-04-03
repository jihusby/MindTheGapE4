package no.husby.mindthegap.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import no.husby.mindthegap.model.ITopic;
import no.husby.mindthegap.model.Topic;

import org.apache.log4j.Logger;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ObservablesManager;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class TopicDetailsPart {
	Logger logger = Logger.getLogger(Class.class);

	private DataBindingContext dbc;
	private ObservablesManager manager;
	// private WritableValue topic;
	private Label title;
	private ITopic topic;

	@Inject
	private void TopicDetailsPart(Composite parent) {
		logger.debug("TopicDetailsPart: " + parent.getClass().getName());
		title = new Label(parent, SWT.NONE);
		title.setText("");
	}

	@PostConstruct
	public void createControls(Composite parent) {
		logger.debug(this.getClass().getName() + ".createControls()");
	}

	@Inject
	public void setTopic(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional String topicTitle) {
		logger.debug("TopicDetailsPart.setTopic() is called with topic " + topicTitle);
		if (topicTitle != null) {
			topic = new Topic(topicTitle);
			title.setText(topicTitle);
		}
	}

	@Focus
	public void setFocus() {
		title.setFocus();
	}

}
