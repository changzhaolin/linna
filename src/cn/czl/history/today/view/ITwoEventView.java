package cn.czl.history.today.view;

import java.util.List;

import cn.czl.history.today.entity.TwoEvent;

public interface ITwoEventView {
	/**
	 * 显示2.0版本的推荐的历史事件
	 * @param twoEvents
	 */
	
	void showTwoEvent(List<TwoEvent>twoEvents);

}
