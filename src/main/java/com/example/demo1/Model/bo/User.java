package com.example.demo1.Model.bo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Locale;

public class User {
    private int _id;
    private Date _dateCreated;
    private String _name,_login,_passHash,_email;

    public User() {
    }

    public User(int _id, Date _dateCreated, String _name, String _login, String _passHash, String _email) {
        this._id = _id;
        this._dateCreated = _dateCreated;
        this._name = _name;
        this._login = _login;
        this._passHash = _passHash;
        this._email = _email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Date get_dateCreated() {
        return _dateCreated;
    }

    public void set_dateCreated(Date _dateCreated) {
        this._dateCreated = _dateCreated;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_login() {
        return _login;
    }

    public void set_login(String _login) {
        this._login = _login;
    }

    public String get_passHash() {
        return _passHash;
    }

    public void set_passHash(String _passHash) {
        this._passHash = _passHash;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }
    public static String HashPass(String pass,String Algo)
    {
        try {
            MessageDigest md=MessageDigest.getInstance(Algo);
            byte[] digest=md.digest(pass.getBytes("UTF-8"));
            return DatatypeConverter.printHexBinary(digest).toLowerCase(Locale.ROOT);
        } catch (NoSuchAlgorithmException e) {
             System.err.println(e);
            return null;
        } catch (UnsupportedEncodingException e) {
            System.err.println(e);
            return null;
        }

    }
    public static User VerifieAuthed(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession se=request.getSession(false);
        if(se!=null)
        {
            User user=(User) se.getAttribute("user");
            if(user!=null)return  user;
        }
        response.sendRedirect(request.getContextPath()+ "/Login");
        return null;

    }
}
