package no.husby.mindthegap.model;

public class Topic implements ITopic {

	private String title;

	public Topic(String title) {
		super();
		this.setTitle(title);
	}

	private void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}

}
