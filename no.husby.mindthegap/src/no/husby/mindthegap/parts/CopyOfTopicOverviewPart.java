package no.husby.mindthegap.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import no.husby.mindthegap.model.Topic;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class CopyOfTopicOverviewPart {
	private Logger logger = Logger.getLogger(Class.class);

	@Inject
	@Optional
	private ESelectionService selectionService;

	private TableViewer topicViewer;

	@Inject
	public CopyOfTopicOverviewPart(Composite parent) {
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();

		topicViewer = new TableViewer(parent, SWT.FULL_SELECTION);
		topicViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (selectionService != null) {
					selectionService.setSelection(((IStructuredSelection) event.getSelection()).getFirstElement());
				}
			}
		});

		Topic[] topics = getTopics();
		for (Topic topic : topics) {
			topicViewer.add(new java.awt.Label(topic.getTitle()).getText());
		}
		topicViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));

	}

	private Object getInitalInput() {
		// TODO Auto-generated method stub
		return null;
	}

	private Topic[] getTopics() {
		Topic[] topics = new Topic[4];
		topics[0] = new Topic("Java");
		topics[1] = new Topic(".NET");
		topics[2] = new Topic("Javascript");
		topics[3] = new Topic("PHP");
		return topics;
	}

	@PostConstruct
	public void createControls(Composite parent) {
		logger.debug(this.getClass().getName() + ".createControls()");
	}

	@Focus
	public void setFocus() {
		topicViewer.getTable().setFocus();
	}
}
