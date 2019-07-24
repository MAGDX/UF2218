package com.ipartek.formacion.controller.listener;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.controller.pojo.Alert;

/**
 * Application Lifecycle Listener implementation class LogedUsersListener
 *
 */
@WebListener
public class LogedUsersListener implements HttpSessionListener, HttpSessionAttributeListener {
	
	public static String nombre = "Variable publica estatica, TODO lo mismo pero para una coleccion";
	public static ArrayList<String> logedUsers;
	
	/**
     * Default constructor. 
     */
    public LogedUsersListener() {
    	logedUsers = new ArrayList<String>();
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  {
    	System.out.println("Sesion creada");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  {
    	System.out.println("Sesion destruida");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  {
    	if("user".equalsIgnoreCase(event.getName())) {
    		logedUsers.add((String) event.getValue());
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  {
    	if("user".equalsIgnoreCase(event.getName())) {
    		logedUsers.remove((String) event.getValue());
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  {
    	
    }
}