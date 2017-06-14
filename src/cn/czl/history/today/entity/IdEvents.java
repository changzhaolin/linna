package cn.czl.history.today.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class IdEvents {
 

	private String content;

	 private String day;// 1,  /*��*/
	 private String des;// "1907��11��1�� ��Ӱ���������յ��� ���������գ�1907��11��1�����ڽ������ء�1932���μ�ӰƬ������Ħ��Ů�ԡ�����ĸ��֮�⡷�����㹤����1934��������ӰƬ��˾�ർ��Ů������Ů����һ�ٳ�����...",  /*����*/
	 @JSONField(name="id")
	 private String _id;//9000,  /*�¼�ID*/
	 private String lunar;// "��δ�����إ��",
	 private String month;// 11,  /*�·�*/
	 private String pic;//  /*ͼƬ*/
	 private String title;//��Ӱ���������յ���",  /*�¼�����*/
	 private String year;// 1907  /*���*/
	public IdEvents(String content, String day, String des, String _id,
			String lunar, String month, String pic, String title, String year) {
		super();
		this.content = content;
		this.day = day;
		this.des = des;
		this._id = _id;
		this.lunar = lunar;
		this.month = month;
		this.pic = pic;
		this.title = title;
		this.year = year;
	}
	public IdEvents() {
		super();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getId() {
		return _id;
	}
	public void setId(String _id) {
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "IdEvents [content=" + content + ", day=" + day + ", des=" + des
				+ ", id=" + _id + ", lunar=" + lunar + ", month=" + month
				+ ", pic=" + pic + ", title=" + title + ", year=" + year + "]";
	}
	 
	  

}
