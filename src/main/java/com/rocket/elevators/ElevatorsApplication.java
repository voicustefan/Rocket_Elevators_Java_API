package com.rocket.elevators;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootApplication
@RestController
public class ElevatorsApplication {
    public static String url = "jdbc:mysql://localhost:3306/rocketElevatorGroupWebsite_development";
    public static String user = "root";
    public static String password = "password";

    @GetMapping("/api/users")
    public static String users() {
        ArrayList<String> emails = new ArrayList<String>();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
//                System.out.println(resultSet.getString("email"));
                emails.add(resultSet.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String JSONemails = gson.toJson(emails);
        return (JSONemails);
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        SpringApplication.run(ElevatorsApplication.class, args);
        users();
    }

}
