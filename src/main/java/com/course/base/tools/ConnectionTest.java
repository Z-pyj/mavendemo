package com.course.base.tools;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class ConnectionTest {
    /**
     * 连接数据库
     */
    String sql = "SELECT * FROM U_UserBase WHERE UserAccount='17602110388';";
    @Test
    public void testConnection() throws Exception {
        //1.读取配置文件中的4个基本信息
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        System.out.println(user+password+url+driverClass);

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        try{
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                int userId = rs.getInt("UserId");
                String userAccount = rs.getString("UserAccount");
                System.out.println("id："+userId+"userAccount:"+userAccount);
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("连接数据库失败");
        }

    }
}
