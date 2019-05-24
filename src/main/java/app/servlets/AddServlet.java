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

@WebServlet(value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/admin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idForAdd = req.getParameter("Id");
        String nameForAdd = req.getParameter("Name");
        String descriptionForAdd = req.getParameter("Description");
        String priceToAdd = req.getParameter("Price");
        if (checkToEmpty(idForAdd, nameForAdd, descriptionForAdd, priceToAdd)) {
            Model model = Model.getInstance();
            List<Product> listOfProducts = model.getListOfProducts();
            req.setAttribute("listOfProducts", listOfProducts);
            Product product = model.getModel().get(idForAdd);
            if (product == null) {
                product = new Product(idForAdd, nameForAdd, descriptionForAdd, priceToAdd);
                model.add(product);
            }
            req.setAttribute("userForAddition", product);
            doGet(req, resp);
        }
    }

    private boolean checkToEmpty(String idForAdd, String nameForAdd,
                                 String descriptionForAdd, String priceToAdd) {
        return nameForAdd != null && !nameForAdd.isEmpty() &
                idForAdd != null && !idForAdd.isEmpty() &
                descriptionForAdd != null && !descriptionForAdd.isEmpty() &
                priceToAdd != null && !priceToAdd.isEmpty();
    }
}
