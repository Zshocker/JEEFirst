package com.example.demo1.Model.dao;

import com.example.demo1.Model.bo.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DAOUser implements IDAOUser{
    private static DAOUser daoUser=null;
    public static DAOUser getDAOUser(){
       if(daoUser==null)daoUser=new DAOUser();
       return  daoUser;
    }
    private DAOUser(){

    }
    @Override
    public void Create(User user) {
        try {
            PreparedStatement pr=Connexion.getCon().prepareStatement("insert into users(login,passHash,email,name) values(?,?,?,?) ");
            pr.setString(1,user.get_login());
            pr.setString(2,user.get_passHash());
            pr.setString(3,user.get_email());
            pr.setString(4,user.get_name());
            pr.executeUpdate();
        }catch (SQLException e){
            System.err.println(e);
        }
    }

    @Override
    public Collection<User> Retrieve() {
        List<User> users=new LinkedList<User>();
        try {
            PreparedStatement pr=Connexion.getCon().prepareStatement("select * from users");
            ResultSet resultSet=pr.executeQuery();
            while (resultSet.next())
            {
                User user=ExtractUser(resultSet);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
          return null;
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement pr=Connexion.getCon().prepareStatement("Update users SET login=?,passHash=?,email=?,name=?,dateCreated=? where id=? ");
            pr.setString(1,user.get_login());
            pr.setString(2,user.get_passHash());
            pr.setString(3,user.get_email());
            pr.setString(4,user.get_name());
            pr.setDate(5, (Date) user.get_dateCreated());
            pr.setInt(6,user.get_id());
            pr.executeUpdate();
        }catch (SQLException e){
            System.err.println(e);
        }
    }

    @Override
    public boolean delete(User user) {
        try {
            PreparedStatement pr=Connexion.getCon().prepareStatement("Delete FROM users where id=?");
            pr.setInt(1,user.get_id());
            pr.executeUpdate();
            return true;
        }catch (SQLException e){
            System.err.println(e);
            return false;
        }
    }
    public User Authenticate(String login,String passHashe){
        User user=null;
        try {
            PreparedStatement pr=Connexion.getCon().prepareStatement("select * from users where login=? and passhash=?");
            pr.setString(1,login);
            pr.setString(2,passHashe);
            ResultSet resultSet=pr.executeQuery();
            while (resultSet.next())
            {
                user=ExtractUser(resultSet);
                return user;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
        return null;
    }

    private User ExtractUser( ResultSet resultSet) throws SQLException {
        User user=new User();
        user.set_id(resultSet.getInt("Id"));
        user.set_dateCreated(resultSet.getDate("dateCreated"));
        user.set_login(resultSet.getString("login"));
        user.set_name(resultSet.getString("name"));
        user.set_passHash(resultSet.getString("passHash"));
        user.set_email(resultSet.getString("email"));
        return user;
    }
}
