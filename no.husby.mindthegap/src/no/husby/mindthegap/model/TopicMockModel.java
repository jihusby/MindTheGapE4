package no.husby.mindthegap.model;

import java.util.ArrayList;
import java.util.List;

public class TopicMockModel {

	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();

		Category category = new Category();
		category.setTitle("Programmering");
		categories.add(category);

		Topic topic = new Topic("Java", 10);
		category.getTopics().add(topic);
		topic = new Topic(".NET", 5);
		category.getTopics().add(topic);
		topic = new Topic("Javascript", 5);
		category.getTopics().add(topic);
		topic = new Topic("Objective-C", 5);
		category.getTopics().add(topic);

		category = new Category();
		category.setTitle("Prosjektverktøy");

		categories.add(category);

		topic = new Topic("Scrum", 7);
		category.getTopics().add(topic);
		topic = new Topic("Kanban", 7);
		category.getTopics().add(topic);

		category = new Category();
		category.setTitle("Domenekunnskap");
		categories.add(category);

		topic = new Topic("Olje", 7);
		category.getTopics().add(topic);
		topic = new Topic("Gass", 7);
		category.getTopics().add(topic);
		topic = new Topic("Transport og kommunikasjon", 7);
		category.getTopics().add(topic);

		return categories;
	}
}
