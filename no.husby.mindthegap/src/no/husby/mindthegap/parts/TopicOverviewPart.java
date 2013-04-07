package no.husby.mindthegap.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import no.husby.mindthegap.model.Topic;
import no.husby.mindthegap.model.TopicMockModel;
import no.husby.mindthegap.providers.TopicContentProvider;
import no.husby.mindthegap.providers.TopicLabelProvider;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.layout.TreeColumnLayout;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class TopicOverviewPart {

	private TreeViewer treeViewer;
	@Inject
	private ESelectionService selectionService;
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;

	@PostConstruct
	public void init(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		ScrolledComposite scrolledComposite = new ScrolledComposite(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new TreeColumnLayout());

		treeViewer = new TreeViewer(composite, SWT.BORDER);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		treeViewer.setContentProvider(new TopicContentProvider());

		treeViewer.setLabelProvider(new TopicLabelProvider());

		treeViewer.setInput(new TopicMockModel());

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent event) {
				Object selectedItem = getSelectedItem(event.getSelection());
				System.out.println("TreePart - Double click on " + selectedItem);
				selectionService.setSelection(selectedItem);
				System.out.println("TreePart - " + selectedItem + " set as global selected item");
				ParameterizedCommand command = commandService.createCommand("no.husby.mindthegap.openTopic.command", null);
				System.out.println(command.getId());
				handlerService.executeHandler(command);
				System.out.println(handlerService.getClass());
				System.out.println("TreePart - Handler invoked");
			}
		});
	}

	private Object getSelectedItem(ISelection sel) {
		IStructuredSelection selection = (IStructuredSelection) sel;
		if (!selection.isEmpty()) {
			return selection.getFirstElement();
		}
		return null;
	}

	@Inject
	@Optional
	public void setProduct(Topic product) {
		System.out.println("TreePart - Recevied injected product. Set in TreeViewer");
		// treeViewer.setInput(product);
		// treeViewer.setInput(new TopicMockModel());
	}

	@Focus
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

}
