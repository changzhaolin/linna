package cn.czl.history.today.entity;

 

public class Pic_Url {
	
	 private String  pic_title;//": "»Â¬‘¿˙",
	 private int id;//": 1,
	 private String url;//": "http://images.juheapi.com/history/1_1.jpg"
	public Pic_Url(String pic_title, int id, String url) {
		super();
		this.pic_title = pic_title;
		this.id = id;
		this.url = url;
	}
	public Pic_Url() {
		super();
	}
	public String getPic_title() {
		return pic_title;
	}
	public void setPic_title(String pic_title) {
		this.pic_title = pic_title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Pic_Url [pic_title=" + pic_title + ", id=" + id + ", url="
				+ url + "]";
	}
	 

	 
	 

}
