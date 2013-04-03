package no.husby.mindthegap.model;

public class TopicFactory {

	public static ITopic createTopic(String title) {
		return new Topic(title);
	}

}
