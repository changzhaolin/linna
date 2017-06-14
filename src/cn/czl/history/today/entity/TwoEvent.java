package cn.czl.history.today.entity;

import java.io.Serializable;

public class TwoEvent implements Serializable{
	private String day;

	private String date;

	private String title;

	private String e_id;

	public TwoEvent(String day, String date, String title, String e_id) {
		super();
		this.day = day;
		this.date = date;
		this.title = title;
		this.e_id = e_id;
	}

	public TwoEvent() {
		super();
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

	@Override
	public String toString() {
		return "TwoEvent [day=" + day + ", date=" + date + ", title=" + title
				+ ", e_id=" + e_id + "]";
	}
	

}
