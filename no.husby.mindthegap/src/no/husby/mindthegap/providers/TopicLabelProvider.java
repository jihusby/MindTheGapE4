package no.husby.mindthegap.providers;

import java.net.URL;

import no.husby.mindthegap.model.Category;
import no.husby.mindthegap.model.Topic;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

//public class TopicLabelProvider extends StyledCellLabelProvider {
//
//	@Override
//	public void update(ViewerCell cell) {
//		Object element = cell.getElement();
//		StyledString text = new StyledString();
//
//		if (element instanceof Category) {
//			Category category = (Category) element;
//			text.append(category.getTitle());
//			cell.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER));
//			text.append(" (" + category.getTopics().size() + ") ", StyledString.COUNTER_STYLER);
//		} else {
//			Topic topic = (Topic) element;
//			text.append(topic.getTitle());
//			cell.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE));
//		}
//		cell.setText(text.toString());
//		cell.setStyleRanges(text.getStyleRanges());
//		super.update(cell);
//	}
//}

public class TopicLabelProvider extends LabelProvider {

	private static final Image FOLDER = getImage("folder.gif");
	private static final Image FILE = getImage("file.gif");

	@Override
	public String getText(Object element) {
		if (element instanceof Category) {
			Category category = (Category) element;
			return category.getTitle();
		}
		return ((Topic) element).getTitle();
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof Category) {
			return FOLDER;
		}
		return FILE;
	}

	// Helper Method to load the images
	private static Image getImage(String file) {
		Bundle bundle = FrameworkUtil.getBundle(TopicLabelProvider.class);
		URL url = FileLocator.find(bundle, new Path("icons/" + file), null);
		ImageDescriptor image = ImageDescriptor.createFromURL(url);
		return image.createImage();

	}
}
