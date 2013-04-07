package no.husby.mindthegap.handlers;

import javax.inject.Inject;
import javax.inject.Named;

import no.husby.mindthegap.model.Topic;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

public class OpenTopicHandler {

	@Inject
	private EPartService partService;
	@Inject
	private EModelService modelService;
	@Inject
	private MApplication app;
	@Inject
	private ESelectionService selectionService;

	@Execute
	public void openNode(@Named(IServiceConstants.ACTIVE_SELECTION) Topic selectedItem) {

		String partId = createEditorPartIdFor(selectedItem);
		MPart editorPart = partService.findPart(partId);
		if (editorPart == null) {
			editorPart = createEditorFor(selectedItem);

			MPartStack editorsStack = (MPartStack) modelService.find("no.husby.mindthegap.partstack.right.top", app);
			editorsStack.getChildren().add(editorPart);
		}
		partService.activate(editorPart);
	}

	private String createEditorPartIdFor(Topic selectedItem) {
		return selectedItem.getTitle();
	}

	private MPart createEditorFor(Topic selectedItem) {
		MPart editorPart = MBasicFactory.INSTANCE.createPart();
		editorPart.setElementId(createEditorPartIdFor(selectedItem));
		String shortName = selectedItem.getTitle();
		editorPart.setLabel(shortName);
		editorPart.setTooltip(shortName);
		editorPart.setCloseable(true);
		editorPart.setContributionURI("bundleclass://no.husby.mindthegap/no.husby.mindthegap.parts.TopicEditorPart");
		return editorPart;
	}

}
