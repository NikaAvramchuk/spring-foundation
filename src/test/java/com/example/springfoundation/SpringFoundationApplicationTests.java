package com.example.springfoundation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class SpringFoundationApplicationTests {
	@Autowired
	DataSource dataSource;


	@Test
	void shouldReturnDb1AsPrimary() {
		String expectedDataSourceUrl = "jdbc:h2:mem:db1";

		String actualDataSourceUrl = getDataSourceUrl();

		assertEquals(actualDataSourceUrl, expectedDataSourceUrl);
	}

	private String getDataSourceUrl() {
		try (Connection dataSourceConnection = dataSource.getConnection()) {
			var databaseMetaData = dataSourceConnection.getMetaData();
			return databaseMetaData.getURL();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
