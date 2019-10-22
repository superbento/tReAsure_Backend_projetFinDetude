package com.tReAsures.demo.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;




/**
 * @Description 基础工具类
 */
public class BaseUtil {

	public static boolean objectNotNull(Object object) {
		if (null == object) {
			return false;
		}
		return true;
	}
	public static <T> Object [] listToArry(List<T> list){
		if(listNotNull(list)){
			Object [] obj = new Object[list.size()];
			for (int i = 0; i < list.size(); i++) {
				obj[i] = list.get(i);
			}
			return obj;
		}
		return null;

	}

	/**
	 * 该方法用于将传入的日期加几个月
	 * 
	 * @param
	 * @return
	 * @throws
	 */
	public static Date incMonthsto(Date date, int months) {

		if (date != null) {

			Calendar calendar = new GregorianCalendar();

			calendar.setTime(date);

			calendar.add(Calendar.MONTH, months);

			return calendar.getTime();

		}

		else {

			return null;
		}
	}

	/**
	 * 判断List 是否为空
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isListEmpty(List list) {
		return list == null || list.size() == 0;
	}

	/**
	 * @Description 判断List是否为空
	 * @param list
	 * @return
	 * 
	 */
	public static <T> boolean listNotNull(List<T> list) {
		if (list != null && list.size() != 0) {
			return true;
		}
		return false;
	}

	/**
	 * @Description 数组是否为空
	 * @param arr
	 * @return
	 */
	public static boolean arrayNotNull(Object[] arr) {
		if(null != arr && 0 != arr.length) {
			return true;
		} 
		return false;
	}
	/**
	 * 判读集合对象是否为空
	 * @param con
	 * @return
	 */
	public static <T> boolean collectionNotNull(Collection<T> con) {
		if (con != null && con.size() != 0) {
			return true;
		}
		return false;
	}


	/**
	 * @Description 判断Set是否为空
	 * @param set
	 * @return
	 */
	public static <T> boolean setNotNull(Set<T> set) {
		if (set != null && set.size() > 0) {
			return true;
		}

		return false;
	}

	/**
	 * @Description 判断Map是否为空
	 * @param map
	 * @return
	 */
	public static <T, K> boolean mapNotNull(Map<T,K> map) {
		if(null != map && 0 != map.size()) {
			return true;
		}

		return false;
	}

	public static int objectToInt(Object obj) {
		int rtnInt = 0;
		if (obj == null || "".equals(obj)) {
			rtnInt = 1;
		} else {
			rtnInt = Integer.parseInt(obj + "");
		}
		return rtnInt;
	}

	/**
	 * 将两个list集合合并成一个，没有判断两个list中是否有重复元素的问题。
	 * 
	 * @param list1
	 * @param list2
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List listAddList(List list1, List list2) {
		if (!BaseUtil.listNotNull(list1) && !BaseUtil.listNotNull(list2)) {
			return new ArrayList();
		}
		if (!BaseUtil.listNotNull(list1) && BaseUtil.listNotNull(list2)) {
			return list2;
		}
		if (BaseUtil.listNotNull(list1) && !BaseUtil.listNotNull(list2)) {
			return list1;
		}
		if (BaseUtil.listNotNull(list1) && BaseUtil.listNotNull(list2)) {
			for (int i = 0; i < list2.size(); i++) {
				list1.add(list2.get(i));
			}
			return list1;
		}
		return null;
	}

	/**
	 * 将2个字符串数组 转换成一个list集合，未盘定重复性
	 * 
	 * @param ob1
	 * @param ob2
	 * @return
	 */
	public static List<String> arrayToList(String[] ob1, String[] ob2) {
		List<String> list = new ArrayList<String>();
		if (ob1 != null && ob1.length > 0) {
			for (String ob : ob1) {
				list.add(ob.trim());
			}
		}
		if (ob2 != null && ob2.length > 0) {
			for (String ob : ob2) {
				list.add(ob.trim());
			}
		}
		return list;
	}

	/**
	 * 将list转化成set
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set listToSet(List list) {
		Set set = new HashSet();
		if (BaseUtil.listNotNull(list)) {
			for (int i = 0; i < list.size(); i++) {
				set.add(list.get(i));
			}
		}
		return set;
	}
	/**
	 * @Description: 将set转化成string
	 * @param set
	 * @return
	 */
	public static String setToStirng(Set<String> set){
		StringBuffer sb = new StringBuffer();
		if(BaseUtil.setNotNull(set)){
			Iterator<String> iterator = set.iterator();
			while(iterator.hasNext()){
				sb.append(iterator.next()).append(",");
			}
			return sb.substring(0, sb.length()-1);
		}
		return sb.toString();
	}
	/**
	 * 将list转化成string
	 * 
	 * @param list
	 * @return
	 */
	public static String listToString(List<String> list) {
		StringBuffer sb = new StringBuffer();
		if (BaseUtil.listNotNull(list)) {
			for (int i = 0; i < list.size(); i++) {
				if(i>0){
					sb.append(",");
				}

				sb.append(list.get(i));
			}
		}
		return sb.toString();
	}
	public static String listToString_L(List<Long> list) {
		StringBuffer sb = new StringBuffer();
		if (BaseUtil.listNotNull(list)) {
			for (int i = 0; i < list.size(); i++) {
				if(i>0){
					sb.append(",");
				}

				sb.append(list.get(i));
			}
		}
		return sb.toString();
	}
	/**
	 * 把set转化成list
	 * 
	 * @param set
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List setTolist(Set set) {
		List list = new ArrayList();
		if (BaseUtil.setNotNull(set)) {
			Iterator it = set.iterator();
			while (it.hasNext()) {
				list.add(it.next());
			}
		}
		return list;
	}

	/**
	 * 将object转换为BigDecimal
	 */
	public static BigDecimal getBigDecimal(Object value) {
		BigDecimal ret = null;
		if (value != null) {
			if (value instanceof BigDecimal) {
				ret = (BigDecimal) value;
			} else if (value instanceof String) {
				ret = new BigDecimal((String) value);
			} else if (value instanceof BigInteger) {
				ret = new BigDecimal((BigInteger) value);
			} else if (value instanceof Number) {
				ret = new BigDecimal(((Number) value).doubleValue());
			} else {
				throw new ClassCastException("Not possible to coerce [" + value
						+ "] from class " + value.getClass()
						+ " into a BigDecimal.");
			}
		}
		return ret;
	}

	/**
	 * 将object转换为Integer
	 * 
	 */
	public static int getInt(Object value) {
		int i = 0;
		if (value != null && !value.equals("")) {
			i = Integer.parseInt(value.toString());
			return i;
		} else {
			return i;
		}
	}

	public static boolean stringNotNull(String string) {
		if ((null == string) || (string.trim().equals(""))) {
			return false;
		}
		return true;
	}

	public static String dateToString(Date date) {

		if (BaseUtil.objectNotNull(date)) {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			return sdf.format(date);
		}

		return null;
	}

	public static String timeToString(Date date){

		if(BaseUtil.objectNotNull(date)){

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			return sdf.format(date);
		}

		return null;
	}

	public static String formatToString(String format,Date date){

		if(BaseUtil.objectNotNull(date)){

			SimpleDateFormat sdf = new SimpleDateFormat(format);

			return sdf.format(date);
		}

		return null;
	}

	public static Date stringToDate(String string) throws Exception {

		if (!stringNotNull(string)) {

			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;

		try {

			date = sdf.parse(string);

		} catch (ParseException e) {
			// TODO 自动生成 catch 块
			// e.printStackTrace();
			throw new Exception();
		}

		if (!BaseUtil.dateToString(date).equals(string)) {

			throw new Exception();
		}

		return date;

	}

	public static int stringToInt(String string) throws Exception {
		try {

			return Integer.parseInt(string);

		} catch (NumberFormatException e) {
			// TODO 自动生成 catch 块
			// e.printStackTrace();
			throw new Exception();
		}

	}

	public static String intToString(int it) throws Exception {
		try {

			return "" + it;

		} catch (NumberFormatException e) {
			// TODO 自动生成 catch 块
			// e.printStackTrace();
			throw new Exception();
		}

	}

	public static Double stringToDouble(String num) throws Exception {

		if (!stringNotNull(num)) {

			return null;
		}

		try {

			Double dx = new Double(num);
			return dx;

		} catch (NumberFormatException e) {
			// TODO 自动生成 catch 块
			// e.printStackTrace();
			throw new Exception();
		}

	}

	public static String doubleToString(Double num) throws Exception {

		if (num == null) {

			return null;
		}

		try {
			DecimalFormat dFormat = new DecimalFormat();
			dFormat.applyPattern("####0.00");

			return dFormat.format(num);

		} catch (NumberFormatException e) {
			// TODO 自动生成 catch 块
			// e.printStackTrace();
			throw new Exception();
		}

	}

	public static String stringToNull(String str) {
		if (!"".equals(str)) {
			return str;
		}
		return null;
	}

	public static String bigDecimalToString(BigDecimal bigDecimal) {

		if (!objectNotNull(bigDecimal)) {

			return null;
		}

		return bigDecimal.toString();
	}

	/**
	 * 集合转换成List类型
	 * 
	 * @param collection
	 * @return List集合
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List convertToList(Collection collection) {
		List list = null;
		if (null != collection) {
			list = new ArrayList();
			Iterator it = collection.iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				list.add(obj);
			}
		}

		return list;
	}


	/**
	 * 获取客户端IP   
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {   
		String ipAddress = "";   
		ipAddress = request.getRemoteAddr();   
		ipAddress = request.getHeader("x-forwarded-for");   
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {   
			ipAddress = request.getHeader("Proxy-Client-IP");   
		}   
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {   
			ipAddress = request.getHeader("WL-Proxy-Client-IP");   
		}   
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {   
			ipAddress = request.getRemoteAddr();   
		}   

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割   
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length() = 15   
			if (ipAddress.indexOf(",") > 0) {   
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));   
			}   
		}   
		return ipAddress;   
	} 



	/**
	 * 集合转换成Set类型
	 * 
	 * @param collection
	 * @return Set集合
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Set convertToSet(Collection collection) {
		Set set = null;

		if (null != collection) {
			set = new HashSet();
			Iterator it = collection.iterator();
			while (it.hasNext()) {
				Object obj = it.next();
				set.add(obj);
			}
		}

		return set;
	}
	/**
	 * 
	 * 方法说明
	 * @Description:工具方法，字符串集合转换成字符串数组  
	 * @param collection
	 * @return
	 */
	public static String[] convertToArray(Collection<String> collection) {
		String[] array = null;
		int i = 0;
		if(collectionNotNull(collection)) {
			array = new String[collection.size()];
			for (String string : collection) {
				array[i] = string;
				i++;
			}
		}

		return array;
	}

	/**
	 * 
	 * 方法说明
	 * @Description:修改上级套餐权限时，修改下级套餐权限
	 * @param parentfunctions
	 * @param sonfunctions
	 * @return
	 */
	public static String getSonSuiteFunctions(String parentfunctions, String sonfunctions){
		StringBuffer seccmd=new StringBuffer();
		//如果把上级权限全部取消，那么下级权限也应该为空
		if(!BaseUtil.stringNotNull(parentfunctions)||!BaseUtil.stringNotNull(sonfunctions)){
			return seccmd.toString();
		}
		String sonfuns[]=sonfunctions.split(",");
		String parentfuns[]=parentfunctions.split(",");

		//遍历二次套餐的功能权限列表
		//如果二次套餐有某个权限，且系统套餐也有这个权限，那么二次套餐的这个权限保存
		//如果二次套餐有某个权限，但系统套餐没有这个权限，那么二次套餐的这个权限应该删除
		for(int i=0;i<sonfuns.length;i++){
			String sonfun=sonfuns[i].trim();
			for(int j=0;j<parentfuns.length;j++){
				String parentfun=parentfuns[j].trim();
				if(parentfun.equals(sonfun)){
					if(i==0){
						seccmd=seccmd.append(sonfun);
						break;
					}else{
						seccmd=seccmd.append(","+sonfun);
						break;
					}
				}
			}
		}
		return seccmd.toString();
	}


	/**
	 * @Description 存储时添加两端的,
	 * @param src
	 * @return
	 */
	public static String makeSplitStr(String src) {
		if(stringNotNull(src)) {
			char[] arr = src.toCharArray();
			if(arr.length > 0 && arr[0] != ',') {
				src = ',' + src;
			}
			if(src.length() > 0 && arr.length > 0 && arr[arr.length-1] != ',') {
				src = src + ',';
			}
		}
		return src;
	}

	/**
	 * @Description 显示时取出两端的,
	 * @param tar
	 * @return
	 */
	public static String showSplitStr(String tar) {
		if(stringNotNull(tar)) {
			char[] arr = tar.toCharArray();
			if(arr.length > 0 && arr[0] == ',') {
				tar = tar.substring(1);
			}
			if(tar.length() > 0 && arr.length > 0 && arr[arr.length-1] == ',') {
				tar = tar.substring(0,tar.length()-1);
			}
		}
		return tar;
	}

	/**
	 * @Description 判断sure01,sure02,sure01中是否有重复
	 * @param codes 逗号分隔的字符串
	 * @return 重复的
	 */
	public static List<String> getRepeat(String codes) {
		if(!BaseUtil.stringNotNull(codes)) {
			return null;
		}
		List<String> res = new ArrayList<String>();
		//去除两端的,
		codes = BaseUtil.showSplitStr(codes);
		String[] arrCodes = codes.split(",");
		for(int i = 0;i < arrCodes.length;i++) {
			for(int j = i+1;j < arrCodes.length;j++) {
				if(arrCodes[i].equals(arrCodes[j])) {
					res.add(arrCodes[i]);
					break;
				}
			}
		}
		return res;
	}
	public static String[] trimStringArray(String[] strings) {
		if(strings.length>0){
			String [] strs = new String [strings.length];
			for (int i = 0; i < strings.length; i++) {
				String str = strings[i];
				/*if(str.contains("\t")){
					str = str.replace("\t", "");
				}*/
				strs [i] = str.trim();
				if(stringNotNull(strs [i])){
					char ch = strs [i].charAt(0);
					if("_".equals(ch+"")){
						strs[i] = strs [i].substring(1);
					}
				}
			}
			return strs;
		}
		return null;
	}
	public static List<String> trimStringList(List<String> account) {
		if(listNotNull(account)){
			List<String> list = new ArrayList<String>();
			for (int i = 0; i < account.size(); i++) {
				if(stringNotNull(account.get(i))){
					list.add(account.get(i));
				}
			}
			return list;
		}
		return null;
	}
	public static List<Long> stringListToLongList(List<String> account) {
		if(listNotNull(account)){
			List<Long> list = new ArrayList<Long>();
			for (int i = 0; i < account.size(); i++) {
				if(stringNotNull(account.get(i))){
					list.add(Long.parseLong(account.get(i)));
				}
			}
			return list;
		}
		return null;
	}
	public static <T> List<T> getRidOfNullObject(List<T> list) {
		if(BaseUtil.listNotNull(list)){	
			List<T> list_new = new ArrayList<T>();
			for (T t : list) {
				if(BaseUtil.objectNotNull(t)){
					list_new.add(t);
				}
			}
			return list_new;
		}
		return null;
	}
	/**
	 * @Description 格式化逗号分隔的字符串，将中文逗号替换成英文逗号，去除多余逗号，多余的空格
	 * @param csString
	 * @return
	 */
	public static String formatCommaSepearteString(String csString){
		if(!BaseUtil.stringNotNull(csString)){
			return null;
		}else{
			csString = csString.replaceAll("，", ",");
			StringBuffer retString = new StringBuffer();
			String[] css = csString.split(",");
			if(0 == css.length){
				return null;
			}
			for (int i = 0; i < css.length; i++) {
				css[i] = css[i].trim();
				if (!"".equals(css[i])) {
					retString.append(css[i]);
					retString.append(",");
				}
			}
			//去除最后一个多余的逗号
			if(stringNotNull(retString.toString())) {
				retString.deleteCharAt(retString.length() - 1);
			}
			return retString.toString();
		}
	}
	public static List<String> toUpperList(List<String> account_List) {
		List<String> retList = new ArrayList<String>();
		for (String string : account_List) {
			retList.add(string.toUpperCase());
		}
		return retList;
	}

	/** @DESC 将null转化成""
	 * @param str
	 * @return String
	 */
	public static String transNullToString(String str){

		if(null == str){
			str = "";
		}
		return str;

	}

	public static List<Long> bigDecimalToLong(List<BigDecimal> bigDecimals){

		if(!listNotNull(bigDecimals)){
			return null;
		}
		List<Long> longValues = new ArrayList<Long>();
		for (BigDecimal bigDecimal : bigDecimals) {
			longValues.add(bigDecimal.longValue());
		}
		return longValues;
	}

	/**
	 * 
	 * @Description 判断对象是否为null
	 * @param object
	 * @return true/false
	 */
	public static boolean isNull(Object object){
		return object==null?true:false;
	}

	/**
	 * @Description 判断对象是否不为null
	 * @param object
	 * @return true/false
	 */
	public static boolean isNotNull(Object object){
		return object != null ?true:false;
	}

	/**
	 * @Description 判断该字符串是否为空，为null 或者为 空字符串 都视为空
	 * @param str 字符串
	 * @return true/false
	 */
	public static boolean isEmpty(String str){
		if(null == str || "".equals(str.trim())){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @Description 判断该字符串是否不为空，为null 或者为 空字符串 都视为空
	 * @param str 字符串
	 * @return true/false
	 */
	public static boolean isNotEmpty(String str){
		if(null == str || "".equals(str.trim())){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * @Description 隐藏证件信息
	 * @param cardNo
	 * @return
	 */
	public static String processCardNo(String cardNo) {
		if(!BaseUtil.stringNotNull(cardNo)) {
			return null;
		}

		if(cardNo.length() > 10) {
			// 如果超过10位，则隐藏规则不变（前6后4显示，中间隐藏）；
			return strEncrypt(6, 4, cardNo);
		} else {
			// 否则隐藏规则为：前3后2显示，中间隐藏
			return strEncrypt(3, 2, cardNo);
		}
	}

	/**
	 * 给字符中加密，用*号代替
	 * 
	 * @param startLen 前面保留位数
	 * @param endLen 后面保留们数
	 * @param //加密的字符串
	 * @return
	 */
	private static String strEncrypt(int startLen, int endLen, String source) {
		if (source == null) {
			return "";
		} else if (startLen + endLen > source.length()) {
			return source;
		} else {
			int times = source.length() - startLen - endLen;
			StringBuilder newStr = new StringBuilder();
			for (int i = 0; i < times; i++) {
				newStr.append("*");
			}
			String s1 = source.substring(0, startLen);
			String s2 = source.substring(source.length() - endLen);
			return s1 + newStr + s2;
		}
	}

	/**
	 * @Description 替换html的字符
	 * @param theString
	 * @return
	 */
	public static String htmlEncode(String theString){
		if(BaseUtil.stringNotNull(theString)){
			return theString.replace(">", "&gt;").replace("<", "&lt;")
					.replace(" ", " &nbsp;").replace(" ", " &nbsp;")
					.replace("\"", "&quot;").replace("\'", "&#39;").replace("\n", "<br/> ");
		}
		return null;
	}

	/**
	 * @Description 恢复html中的字符
	 * @param theString
	 * @return
	 */
	public static String htmlDiscode(String theString){
		if(BaseUtil.stringNotNull(theString)){
			return theString.replace("&gt;", ">").replace("&lt;", "<").replace("&nbsp;", " ")
					.replace(" &nbsp;", " ").replace("&quot;", "\"").replace("&#39;", "\'").replace("<br/> ", "\n");
		}

		return null;
	}

	/**
	 * @Description 去除字符串中的空格，包括全角和半角
	 * @param oriStr
	 * @return
	 */
	public static String strTrim(String oriStr){
		String destStr=null;
		if(BaseUtil.stringNotNull(oriStr)){
			destStr=oriStr.replace(" ", "").replace("　","");
		}
		return destStr;
	}
}
