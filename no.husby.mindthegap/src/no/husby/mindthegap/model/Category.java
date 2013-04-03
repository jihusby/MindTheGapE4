package no.husby.mindthegap.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String title;
	private List<Topic> topics = new ArrayList<Topic>();
	private int sort;

	public Category() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public List<Topic> getTopics() {
		return topics;
	}

}
