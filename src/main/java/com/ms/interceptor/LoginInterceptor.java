/**
 * 
 */
package com.ms.interceptor;

/**
 * @author amit
 *
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ms.dto.UserDTO;
import com.ms.util.MSConstant;
import com.ms.util.SessionUtil;

 
public class LoginInterceptor extends HandlerInterceptorAdapter {
 
    private static final Logger logger = LoggerFactory
            .getLogger(LoginInterceptor.class);
 
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        //if returned false, we need to make sure 'response' is sent
        UserDTO userDTO = SessionUtil.getUser();
        if(userDTO == null){
        	logger.info("Session expired. Redirecting to login page");
        	response.sendRedirect("login.do");
        	return false;
        }
        
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	
    	//String requestURI = request.getRequestURI();
    	String pageName = SessionUtil.getPage();
    	if(pageName != null){
    		 modelAndView.getModel().put(MSConstant.PAGE, pageName);
    		 SessionUtil.getSession().removeAttribute(MSConstant.PAGE);
    	}
    	/*if(requestURI != null && !requestURI.isEmpty() && modelAndView != null){
    	   Object ChkSesseion = SessionUtil.getSession().getAttribute(PwcConstant.NOSET);
	       if(ChkSesseion == null){
		       String url = request.getRequestURI().substring(1, request.getRequestURI().length());
		       Byte index= GPCValuationEnum.findCodeByLink(url);
			   modelAndView.getModel().put(PwcConstant.SELECTED_URL, url);
			   modelAndView.getModel().put(PwcConstant.PAGELIST_DROPDOWN, PwcUtils.populateALLGPCValuationData());
			   modelAndView.getModel().put(PwcConstant.PAGELISTGT_DROPDOWN, PwcUtils.populateALLGTValuationData());
			   modelAndView.getModel().put(PwcConstant.PAGEINDEX,index);
	       }else{
	    	   SessionUtil.getSession().removeAttribute(PwcConstant.NOSET);
	       }
    	}*/
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
       // long startTime = (Long) request.getAttribute("startTime");
        /*logger.info("Request URL::" + request.getRequestURL().toString()
                + ":: End Time=" + System.currentTimeMillis());
        logger.info("Request URL::" + request.getRequestURL().toString()
                + ":: Time Taken=" + (System.currentTimeMillis() - startTime));*/
    }
 
}