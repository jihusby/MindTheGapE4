package no.husby.mindthegap.model;

import java.util.ArrayList;
import java.util.List;

public class TopicMockModel {

	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		Category category = new Category();
		category.setTitle("Programming");
		categories.add(category);
		Topic topic = new Topic("Write more about e4");
		category.getTopics().add(topic);
		topic = new Topic("Android");
		category.getTopics().add(topic);

		category = new Category();
		category.setTitle("Leasure");
		categories.add(category);
		topic = new Topic("Skiing");
		category.getTopics().add(topic);

		return categories;
	}
}
