package cn.czl.history.today.presenter;

public interface IEventPresenter {
	
	
	/**
	 * 下载要显示的事件
	 * @param info
	 */
	public void loadEnvents(int mouth,int day);
	/**
	 * 通过事件id查询历史事件
	 * @param id
	 */
	public void SearchEnvents(int id);
	

}
