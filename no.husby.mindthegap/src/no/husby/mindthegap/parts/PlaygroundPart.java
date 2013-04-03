package no.husby.mindthegap.parts;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class PlaygroundPart {
	Logger logger = Logger.getLogger(Class.class);

	private Text label;
	private Browser browser;

	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		label = new Text(parent, SWT.BORDER);
		label.setMessage("Enter City");
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Button button = new Button(parent, SWT.NONE);
		button.setText("Search");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String city = label.getText();
				if (city == null || city.length() == 0) {
					return;
				}
				try {
					browser.setUrl("http://maps.google.com/maps?q="
							+ URLEncoder.encode(city, "UTF-8")
							+ "&output=embed");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			}
		});

		browser = new Browser(parent, SWT.NONE);
		browser.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

		logger.debug(this.getClass().getName() + ".createControls()");

	}

	@Focus
	public void setFocus() {
		label.setFocus();
	}
}