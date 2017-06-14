
package cn.czl.history.today.view;

import java.util.List;

import cn.czl.history.today.entity.Events;
import cn.czl.history.today.entity.IdEvents;

public interface IEventView { 
	/**
	 * 显示历史事件
	 * @param events
	 */
	
	void showEvent(List<Events>events);
	/**
	 * 通过历史事件Id搜索
	 * @param events
	 */
	void showIdEvent(List<IdEvents> events);

}
