package org.geektimes.projects.user.web.controller;

import org.geektimes.context.ComponentContext;
import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.UserServiceImpl;
import org.geektimes.projects.user.sql.DBConnectionManager;
import org.geektimes.web.mvc.controller.PageController;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/user")
public class RegisterController implements PageController {

    @Resource(name = "bean/UserService")
    private UserService userService = ComponentContext.getInstance().getComponent("bean/UserService");

    @GET
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");

        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        userService.register(user);

        // Collection<User> users = userService.listAll();
        Collection<User> users = new ArrayList<>();
        request.setAttribute("users", users);

        return "main.jsp";
    }
}
