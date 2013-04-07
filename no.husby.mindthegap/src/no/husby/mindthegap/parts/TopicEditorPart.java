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
		GridLayout layout = new GridLayout(2, true);
		parent.setLayout(layout);

		Label titleLabel = new Label(parent, SWT.NONE);
		titleLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 1, 1));
		titleLabel.setText("Topic :");

		Label recordLabel = new Label(parent, SWT.NONE);
		recordLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 1, 2));
		recordLabel.setText("Records :");

		titleField = new Text(parent, SWT.BORDER);
		titleField.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1));
		titleField.setText(item.getTitle());

		recordField = new Text(parent, SWT.BORDER);
		recordField.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 2));
		recordField.setText(((Integer) item.getRecords()).toString());
	}

	@Focus
	public void setFocus() {
		titleField.setFocus();
	}

}
