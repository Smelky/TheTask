package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idForAdd = req.getParameter("Id");
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        if (password != null && !password.isEmpty() & name != null && !name.isEmpty() &
                idForAdd != null && !idForAdd.isEmpty()) {
            int id = Integer.parseInt(idForAdd);
            Model model = Model.getInstance();
            List<User> listOfUsers = model.getListOfUsers();
            req.setAttribute("listOfUsers", listOfUsers);
            User user = model.getModel().get(id);
            if (user == null) {
                user = new User(id, name, password);
                model.add(user);
            }
            req.setAttribute("userForAddition", user);
        }

        doGet(req, resp);
    }
}
