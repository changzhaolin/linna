package cn.czl.history.today.model;

 

public interface IEventModel extends IModel{
	/**
	 * 下载事件资源
	 * @param info
	 */
	public void LoadInfo(AsyncCallback callback,int mouth,int day);
	/**
	 * id查询
	 * @param callback
	 * @param id
	 */
	public void SearchInfo(AsyncCallback callback,int id);

}
