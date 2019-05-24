package app.model;

import app.entities.Product;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model extends HttpServlet {
    private static Model instance = new Model();

    private Map<String, Product> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashMap<>();
    }

    public void add(Product product) {
        model.put(product.getId(), product);
    }

    public List<Product> getListOfProducts() {
        return new ArrayList<>(model.values());
    }

    public void delete(Product user) {
        model.remove(user.getId());
    }

    public int size() {
        return model.size();
    }

    public Map<String, Product> getModel() {
        return model;
    }
}
