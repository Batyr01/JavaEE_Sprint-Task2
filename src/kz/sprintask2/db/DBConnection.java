package kz.sprintask2.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {

    private static Connection connection;

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sprint-task2", "root", "");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Items> getItems(){

        ArrayList<Items> items = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items"
            );

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Items item = new Items();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setPrice(resultSet.getDouble("price"));

                items.add(item);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static Users getUser(String email, String password){

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ? AND password = ?"
            );
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Users user = new Users();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFullName(resultSet.getString("full_name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
