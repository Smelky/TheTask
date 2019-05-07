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

@WebServlet("/remove")
public class RemoveData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/delete.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idForRemove = req.getParameter("Id");
        String nameForRemove = req.getParameter("name");
        String passwordForRemove = req.getParameter("pass");

        if (passwordForRemove != null && !passwordForRemove.isEmpty() & nameForRemove != null && !nameForRemove.isEmpty() &
                idForRemove != null && !idForRemove.isEmpty()) {
            int id = Integer.parseInt(idForRemove);
            Model model = Model.getInstance();
            List<User> listOfUsers = model.getListOfUsers();
            req.setAttribute("listOfUsers", listOfUsers);
            User user = new User(id, nameForRemove, passwordForRemove);
            for (int i = 0; i < model.size(); i++) {
                if (model.getModel().get(user.getId()) != null) {
                    if (model.getModel().get(user.getId()).equals(user)) {
                        model.delete(user);
                        req.setAttribute("userForRemove", user);
                    }
                } else {
                    req.setAttribute("userForRemove", user);
                }
            }
        }

        doGet(req, resp);
    }
}
