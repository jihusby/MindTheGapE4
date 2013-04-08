package no.husby.mindthegap.parts;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import no.husby.mindthegap.model.Topic;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TopicEditorPart {
	private Text titleField;
	private Text recordField;

	@PostConstruct
	public void init(Composite parent, @Named(IServiceConstants.ACTIVE_SELECTION) Topic item) {
		GridLayout layout = new GridLayout(2, false);
		parent.setLayout(layout);

		Label titleLabel = new Label(parent, SWT.NONE);
		titleLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		titleLabel.setText("Topic :");

		titleField = new Text(parent, SWT.BORDER);
		titleField.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		titleField.setText(item.getTitle());

		Label recordLabel = new Label(parent, SWT.NONE);
		recordLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		recordLabel.setText("Records :");

		recordField = new Text(parent, SWT.BORDER);
		recordField.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		recordField.setText(((Integer) item.getRecords()).toString());

		// Text extraText = new Text(parent, SWT.NONE);
		// extraText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
		// 1, 2));
		// extraText
		// .setText("In my try to move an 3.x RCP Application to 4 I managed to bump into another issue. "
		// +
		// "I created a simple test part with a simple Text on it. When I start the application, "
		// +
		// " it displays fine and does not show any errors. But when I try typing in the field I get a null pointer in the KeyBindingDispatcher.");

	}

	@Focus
	public void setFocus() {
		titleField.setFocus();
	}

}
