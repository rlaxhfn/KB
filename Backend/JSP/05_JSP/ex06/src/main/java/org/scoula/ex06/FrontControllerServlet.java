package org.scoula.ex06;

import org.scoula.ex06.command.Command;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "frontControllerServlet", value = "/")
public class FrontControllerServlet extends DispatcherServlet {
    HomeController homeController = new HomeController();
    TodoController todoController = new TodoController();
    @Override
    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {
        getMap.put("/", homeController::getIndex);
        getMap.put("/todo/list",todoController::getList);
        getMap.put("/todo/view",todoController::getView);
        getMap.put("/todo/create",todoController::getCreate);
        getMap.put("/todo/update",todoController::getUpdate);
        postMap.put("/todo/create",todoController::postCreate);
        postMap.put("/todo/update",todoController::postUpdate);
        postMap.put("/todo/delete",todoController::postDelete);
    }
    private String getCommandName(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        return requestURI.substring(contextPath.length());
    }
    private Command getCommand(HttpServletRequest request) {
        String commandName = getCommandName(request);
        System.out.println(commandName);
        Command command;
        if(request.getMethod().equalsIgnoreCase("GET")) {
            command = getMap.get(commandName);
            System.out.println(command);
        } else {
            command = postMap.get(commandName);
        }
        return command;
    }
    private void execute(Command cmd, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String viewName = cmd.execute(request, response);
        if(viewName.startsWith("redirect:")) { // redirect
            response.sendRedirect(viewName.substring("redirect:".length()));
        } else { // forward
            String view = prefix + viewName + suffix;
            request.getRequestDispatcher(view).forward(request, response);
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Command cmd = getCommand(request);
        if(cmd != null) {
            execute(cmd, request, response);
        } else {
            String view = prefix + "404" + suffix;
            request.getRequestDispatcher(view).forward(request, response);
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
