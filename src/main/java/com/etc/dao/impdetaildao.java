package com.etc.dao;

import com.entity.detail;

import java.sql.*;
import java.util.ArrayList;

public class impdetaildao implements detaildao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/tbl_user";
    private static final String DBNAME = "root";
    private static final String DBPASSWRD = "root";
    ResultSet resultSet;

    public impdetaildao() {
    }

    @Override
    public ArrayList alldetail() {
        ArrayList arrayList = new ArrayList();
        String sql = "select * from tbl_user ";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, DBNAME, DBPASSWRD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                detail detail = new detail();
                int id = resultSet.getInt(1);
                String uname = resultSet.getString(2);
                String UserPass = resultSet.getString(3);
                detail.setId(id);
                detail.setUname(uname);
                detail.setUserPass(UserPass);
                arrayList.add(detail);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override
    public void del(int id) {
        String sql = "delete  from tbl_user where userId=?";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, DBNAME, DBPASSWRD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeLargeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(int id, String uname, String userPass) {
        String sql = "INSERT INTO tbl_user(userId,userName,userPass) VALUES (?,?,?)";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, DBNAME, DBPASSWRD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, uname);
            preparedStatement.setString(3, userPass);
            preparedStatement.executeLargeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String uname, String userPass,int oldid) {
        String sql = " UPDATE tbl_user SET userId=?, userName=?,userPass=? WHERE userId =?";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, DBNAME, DBPASSWRD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, uname);
            preparedStatement.setString(3, userPass);
            preparedStatement.setInt(4, oldid);
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList likeselect(String str) {
        ArrayList arrayList = new ArrayList();
        String sql = "SELECT * FROM tbl_user WHERE userName LIKE ?";
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, DBNAME, DBPASSWRD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            str="%"+str+"%";
            preparedStatement.setString(1, str);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                detail detail = new detail();
                int id = resultSet.getInt(1);
                String uname = resultSet.getString(2);
                String UserPass = resultSet.getString(3);
                detail.setId(id);
                detail.setUname(uname);
                detail.setUserPass(UserPass);
                arrayList.add(detail);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
