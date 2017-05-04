package evolution.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnyController {
	@Autowired
	public DataSource dataSource;
	
	@GetMapping("/get")
	public String get() throws SQLException {
		Connection connection = dataSource.getConnection();// You can fetch connection from data source straight away.
		Statement statement = connection.createStatement();
		statement.execute("drop table if exists any_table;");
		statement.execute("create table any_table(id int primary key auto_increment, name varchar(20));");
		statement.execute("insert into any_table(name) values('Chen');");
		ResultSet resultSet = statement.executeQuery("select * from any_table;");
		while (resultSet.next()) {
			String name = resultSet.getString("name");
			System.out.println(name);
		}
		return "Complete";
	}
}
