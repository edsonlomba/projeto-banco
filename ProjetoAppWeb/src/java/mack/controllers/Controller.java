package mack.controllers;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author Edson Lomba - 41525388
 * 
 */
public interface Controller {
    public void execute();
    public void init(HttpServletRequest request);
    public String getReturnPage();
}
