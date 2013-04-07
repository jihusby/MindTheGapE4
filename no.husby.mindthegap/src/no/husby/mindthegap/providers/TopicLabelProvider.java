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

public class TopicLabelProvider extends LabelProvider {

	private static final Image FOLDER = getImage("folder.png");
	private static final Image FILE = getImage("file.png");

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
