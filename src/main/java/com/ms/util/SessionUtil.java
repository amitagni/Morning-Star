package com.ms.util;

import java.io.File;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import com.ms.dto.UserDTO;


public class SessionUtil{
	HttpSession session;
	
	private static final String usrDTO = "userDTO";
	private static final String msg = "validationmessage";
	private static final String pageUrl = "url";
	private static String deploymentPath = null;

	
	/**
	 * @return
	 */
	public static HttpSession getSession() {
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    attr.getRequest().getServletPath();
	    if(deploymentPath == null){
	    	setDeploymentPath(getServerDeploymentPath(attr.getRequest()));
	    }
	   
	    return attr.getRequest().getSession(true); // true == allow create
	}
	
	
	/**
	 * @param httpServletRequest
	 * @return
	 */
	public static String getServerDeploymentPath(HttpServletRequest httpServletRequest){
		@SuppressWarnings("deprecation")
		File fl = new File(httpServletRequest.getRealPath(File.separator));
		//File fl = new File("C:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps");
		return fl.getParent();
		
	}
	
	
	/**
	 * @param userDTO
	 */
	public static void setUser(UserDTO userDTO){
		getSession().setAttribute(usrDTO, userDTO);
	}
	
	/**
	 * @return
	 */
	public static UserDTO getUser(){
		return (UserDTO)getSession().getAttribute(usrDTO);
	}
	

	
	/**
	 * @param message
	 */
	public static void setMessage(String message){
		getSession().setAttribute(msg, message);
	}
	
	
	/**
	 * 
	 */
	public static void removeMessage(){
		getSession().removeAttribute(msg);
	}
	
	/**
	 * @return
	 */
	public static String getMessage(){
		return (String)getSession().getAttribute(msg);
	}
	
	/**
	 * @param url
	 */
	public static void setUrl(String url){
		getSession().setAttribute(pageUrl, url);
	}
	
	
	/**
	 * @return
	 */
	public static String getUrl(){
		return (String)getSession().getAttribute(pageUrl);
	}
	
	/**
	 * @return
	 */
	private static ServletContext getServletContext(){
		return getSession().getServletContext();
	}
	
	


	/**
	 * @return the deploymentPath
	 */
	public static String getDeploymentPath() {
		return deploymentPath;
	}


	/**
	 * @param deploymentPath the deploymentPath to set
	 */
	public static void setDeploymentPath(String deploymentPath) {
		SessionUtil.deploymentPath = deploymentPath;
	}
	
	/**
	 * @param userId
	 * @param userDataMap
	 */
	public static void setUserDataMap(String userId,Map<String,Object> userDataMap){
		getSession().setAttribute(userId, userDataMap);
	}
	
	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> getUserDataMap(String userId){
		return (Map<String,Object>) getSession().getAttribute(userId);
	}
	
	
	/**
	 * @param userId
	 * @param clientMap
	 */
	public static void setClientMap(String userId,Map<Integer,String> clientMap){
		getSession().setAttribute(userId+"_clientMap", clientMap);
	}
	
	/**
	 * @param userId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<Integer,String> getClientMap(String userId){
		return (Map<Integer, String>) getSession().getAttribute(userId+"_clientMap");
	}
	
	
	
}
