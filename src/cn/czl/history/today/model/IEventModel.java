package cn.czl.history.today.model;

 

public interface IEventModel extends IModel{
	/**
	 * �����¼���Դ
	 * @param info
	 */
	public void LoadInfo(AsyncCallback callback,int mouth,int day);
	/**
	 * id��ѯ
	 * @param callback
	 * @param id
	 */
	public void SearchInfo(AsyncCallback callback,int id);

}
