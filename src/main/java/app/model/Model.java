package app.model;

import app.entities.User;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model extends HttpServlet {
    private static Model instance = new Model();

    private Map<Integer, User> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new HashMap<>();
    }

    public void add(User user) {
        model.put(user.getId(), user);
    }

    public List<User> getListOfUsers() {
        return new ArrayList<>(model.values());
    }

    public void delete(User user) {
        model.remove(user.getId());
    }

    public int size() {
        return model.size();
    }

    public Map<Integer, User> getModel() {
        return model;
    }
}
