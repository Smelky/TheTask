package app.servlets;

import app.entities.Product;
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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/admin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idForRemove = req.getParameter("Id");
        String nameForRemove = req.getParameter("name");

        if (nameForRemove != null && !nameForRemove.isEmpty() &
                idForRemove != null && !idForRemove.isEmpty()) {
            Model model = Model.getInstance();
            List<Product> listOfUsers = model.getListOfProducts();
            req.setAttribute("listOfUsers", listOfUsers);
            Product product = new Product(idForRemove, nameForRemove);

            model.delete(product);
            req.setAttribute("userForRemove", product);
        }
        doGet(req, resp);
    }
}
