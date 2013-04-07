package no.husby.mindthegap.model;

public class Topic implements ITopic {

	private String title;
	private int records;

	public Topic(String title) {
		this.setTitle(title);
	}

	public Topic(String title, int records) {
		this.title = title;
		this.records = records;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public int getRecords() {
		return records;
	}

}
