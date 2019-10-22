package com.tReAsures.demo.entity;
import com.tReAsures.demo.utils.Cache;
import com.tReAsures.demo.utils.CacheManager;
import net.sf.json.JSONObject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
public class OperationUserId {

	private static final String CAP_MANAGER_LOGIN="CAP_MANAGER_LOGIN";
	
	public static Integer getUserId(HttpServletRequest request)  {
		String key = getToken(request);
		if(key!=null){
	           Cache cacheInfo = CacheManager.getCacheInfo(key);
	           	   if(cacheInfo==null){
	                  return null;
	              }
	                return Integer.valueOf(cacheInfo.getKey());
	       }
		
		return null;
	}
	
	
	public static String getUserName(HttpServletRequest request) {
		String key = getToken(request);
			if(key!=null){
	                Cache cacheInfo = CacheManager.getCacheInfo(key);
                	   if(cacheInfo==null){
                		   return null;
                	   }
                	   return (String) cacheInfo.getValue();
                }
	     return null;
	}
	
	public static boolean isLogin(HttpServletRequest request){
		//System.out.println(request.getSession().getId());
		String token = getToken(request);
		if(token==null){
			return false;
	         }
		return CacheManager.hasCache(token);
	}
	
	
	public static JSONObject getUser(User user){
		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("id",user.getId());
		map.put("name",user.getUsername());
		
		return JSONObject.fromObject(map);
		
	}
	
	public static String getToken(HttpServletRequest request){
		Cookie[] cookieList = request.getCookies();
        if (cookieList == null) {
            return null;
        }
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(CAP_MANAGER_LOGIN)) {
                     String key =cookieList[i].getValue();
                     cookieList[i].setMaxAge(60*60*24);//每一次请求都会进行时间的重置
                    return key;
                }
            }
        
	return null;
	}
	
	public static void setMaxAge(HttpServletRequest request){
		Cookie[] cookieList = request.getCookies();
        if (cookieList != null) {
        	for (int i = 0; i < cookieList.length; i++) {
        		if (cookieList[i].getName().equals(CAP_MANAGER_LOGIN)) {
        			cookieList[i].setMaxAge(60*60*24);
        		}
        	}
        }
        
	}
}
