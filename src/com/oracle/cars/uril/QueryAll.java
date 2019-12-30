package com.oracle.cars.uril;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryAll {
	public static void main(String[] args) {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection  connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/cars?useUnicode=true&characterEncoding=UTF-8","root","root");
				Statement statement=connection.createStatement();
				ResultSet rSet=statement.executeQuery("select * from car");
				while(rSet.next()) {
					System.out.println(rSet.getString("pinpaiming"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
