package mack.controllers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Edson Lomba - 41525388
 * 
 */
public abstract class AbstractController implements Controller{
    public HttpServletRequest request;
    protected String returnPage;
    
    @Override
    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }
    
    public void setReturnPage(String page) {
        returnPage = page;
    }
    
    @Override
    public String getReturnPage() {
        return returnPage;
    }
    
    public HttpServletRequest getRequest() {
        return request;
    }
    
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
