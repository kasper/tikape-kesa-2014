package fi.helsinki.cs.vaestorekisteri.controller;

import fi.helsinki.cs.vaestorekisteri.model.Citizen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CitizenController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {

        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String read(Model model, @RequestParam String id) throws Exception {

        Class.forName("org.sqlite.JDBC");
        final Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/khirviko/vaestorekisteri.sqlite");

        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT * FROM citizens WHERE id = '" + id + "';");

        final List<Citizen> citizens = new ArrayList<Citizen>();

        while (resultSet.next()) {

            citizens.add(new Citizen(resultSet.getString("id"),
                                     resultSet.getString("firstname"),
                                     resultSet.getString("lastname")));
        }

        model.addAttribute("citizens", citizens);

        return "index";
    }
}
