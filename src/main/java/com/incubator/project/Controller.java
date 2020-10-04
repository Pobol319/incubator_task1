package com.incubator.project;

import com.incubator.project.command.Command;
import com.incubator.project.command.CommandFactory;
import com.incubator.project.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final String MAIN_PAGE = "/index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter("command");
        Command command = CommandFactory.create(commandName);
        try {
            command.execute(req, resp);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(MAIN_PAGE);
        requestDispatcher.forward(req, resp);
    }

}
