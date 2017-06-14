package cn.czl.history.today.util;

import java.text.SimpleDateFormat;

/**
 * 
 * @ClassName: Config
 *   椤圭洰浣嶇疆鍙傛暟
 * @author wqr
 * @date 2014-11-3 涓嬪崍5:25:03
 * 
 */
public class CommonConstants {
	
	// 鏃ュ織寮曟搸 tag
	public static String LogTag = "[Cabinet]";
	public static int LOG_INFO = 0;
	public static int LOG_DEBUG = 1;
	public static int LOG_WARNING = 2;
	public static int LOG_ERROR = 3;
	public static int LOG_LEVEL = LOG_INFO;
	public static String logpath = "/jlb/Log/";

	
	// 鏃ュ織寮曟搸 鏃ユ湡鏍煎紡鍖栫殑鏍煎紡
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat SDF3 = new SimpleDateFormat("HH:mm:ss");
	
	/**
	 * 鎺ㄩ�乤ction
	 */
	public static final String ACTION_PUSH = "cn.jlb.pro.intelligentcabinet.push";
	
	/**
	 * 鎺ㄩ�乤ction
	 */
	public static final String ACTION_UPDATE = "cn.jlb.pro.intelligentcabinet.update";
	
	/**
	 * 鍚姩鎺ㄩ�乤ction
	 */
	public static final String ACTION_START = "com.jlb.cabinet.start";
	
	/**
	 * update package
	 */
	public static final String PACKAGE_NAME_UPDATE = "cn.jlb.pro.update";
	
	/**
	 * cabinet package
	 */
	public static final String PACKAGE_NAME_CABINET = "cn.jlb.pro.intelligentcabinet";
	
	/**
	 * push service name
	 */
	public static final String SERVICE_NAME_UPDATE_PUSH = "cn.jlb.pro.update.PushService";
	/**
	 * key MsgResult
	 */
	public static final String KEY_MSGRESULT = "MsgResult";
	
	/**
	 * key cabinet_code
	 */
	public static final String KEY_CABINET_CODE = "cabinet_code";
	
	/**
	 * key net change
	 */
	public static final String KEY_NET_CHANGE = "key_net_change";
	
}