package cn.czl.history.today.entity;

public class Events {
	
	 private String day;// 1,  /*日*/
	 private String des;// "1907年11月1日 电影导演吴永刚诞生 　　吴永刚，1907年11月1日生于江苏吴县。1932年后参加影片《三个摩登女性》、《母性之光》的拍摄工作。1934年在联华影片公司编导处女作《神女》，一举成名，...",  /*描述*/
	 private String _id;//9000,  /*事件ID*/
	 private String lunar;// "丁未年九月廿六",
	 private String month;// 11,  /*月份*/
	 private String pic;//  /*图片*/
	 private String title;//电影导演吴永刚诞生",  /*事件标题*/
	 private String year;// 1907  /*年份*/
	public Events(String day, String des, String _id, String lunar,
			String month, String pic, String title, String year) {
		super();
		this.day = day;
		this.des = des;
		this._id = _id;
		this.lunar = lunar;
		this.month = month;
		this.pic = pic;
		this.title = title;
		this.year = year;
	}
	public Events() {
		super();
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getLunar() {
		return lunar;
	}
	public void setLunar(String lunar) {
		this.lunar = lunar;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Events [day=" + day + ", des=" + des + ", _id=" + _id
				+ ", lunar=" + lunar + ", month=" + month + ", pic=" + pic
				+ ", title=" + title + ", year=" + year + "]";
	}
	 
          
}
