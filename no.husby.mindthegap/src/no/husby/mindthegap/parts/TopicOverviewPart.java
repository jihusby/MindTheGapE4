package no.husby.mindthegap.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import no.husby.mindthegap.model.Category;
import no.husby.mindthegap.model.Topic;
import no.husby.mindthegap.model.TopicMockModel;
import no.husby.mindthegap.providers.TopicContentProvider;
import no.husby.mindthegap.providers.TopicLabelProvider;

import org.apache.log4j.Logger;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class TopicOverviewPart {
	private Logger logger = Logger.getLogger(Class.class);
	public static final String ID = "no.husby.mindthegap.overviewpart";
	private TreeViewer viewer;
	private EHandlerService handlerService;

	@Inject
	@Optional
	private ESelectionService selectionService;

	@PostConstruct
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new TopicContentProvider());
		viewer.setLabelProvider(new TopicLabelProvider());
		viewer.setAutoExpandLevel(SWT.Expand);
		// Provide the input to the ContentProvider
		viewer.setInput(new TopicMockModel());

		viewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				TreeViewer viewer = (TreeViewer) event.getViewer();
				IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
				Object selectedNode = thisSelection.getFirstElement();
				viewer.setExpandedState(selectedNode, !viewer.getExpandedState(selectedNode));
			}
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@SuppressWarnings("restriction")
			public void selectionChanged(SelectionChangedEvent event) {
				Object selection = ((IStructuredSelection) event.getSelection()).getFirstElement();
				setSelection(selection);
			}

			private void setSelection(Object selection) {
				if (selection instanceof Topic) {
					Topic t = (Topic) selection;
					if (selectionService != null) {
						selectionService.setSelection(t.getTitle());
						// selectionService.setSelection(new TopicElement(t));

					}
				} else {
					Category c = (Category) selection;
					selectionService.setSelection("");
				}

			}
		});
	}

	@Focus
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}