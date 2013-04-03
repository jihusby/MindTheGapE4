package no.husby.mindthegap.parts;

import javax.annotation.PostConstruct;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class TopicNewPart {

	private Label title;
	private Label registrations;

	@PostConstruct
	public void createControls(Composite parent) {
		title = new Label(parent, SWT.NONE);
		registrations = new Label(parent, SWT.NONE);
		title.setText("Topic");
		registrations.setText("Registrations");
	}

	@Focus
	public void setFocus() {
		title.setFocus();
		registrations.setFocus();
	}
}
