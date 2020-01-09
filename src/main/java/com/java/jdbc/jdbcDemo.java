package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合：
 *         类与类的依赖
 *         方法之间的依赖
 */
public class jdbcDemo {
    public static void main(String[] args) throws Exception{

          //     DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //编译时依赖，运行时才依赖
             Class.forName("com.mysql.jdbc.Driver");

           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?useUnicode=true&characterEncoding=utf8","root","root");

           PreparedStatement pstm = conn.prepareStatement("SELECT * FROM account ");

           ResultSet resultSet = pstm.executeQuery();


        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        pstm.close();
        conn.close();


    }
}
