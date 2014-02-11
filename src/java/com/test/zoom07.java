package com.test;

import javax.portlet.GenericPortlet;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * zoom06 Portlet Class
 */
public class zoom07 extends GenericPortlet {
    
    public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
        
    }
    
    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        //Uncomment below lines to see the output
        //response.setContentType("text/html");
        //PrintWriter writer = response.getWriter(); 
        //writer.println("View Mode");
    }

    public void doEdit(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        //Uncomment below lines to see the output
        //response.setContentType("text/html");
        //PrintWriter writer = response.getWriter(); 
        //writer.println("Edit Mode");
    }

    public void doHelp(RenderRequest request, RenderResponse response) throws PortletException, IOException {

        //Uncomment below lines to see the output
        //response.setContentType("text/html");
        //PrintWriter writer = response.getWriter(); 
        //writer.println("Help Mode");
    }
}