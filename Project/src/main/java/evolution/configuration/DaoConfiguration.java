package evolution.configuration;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfiguration {
	@Bean// Inject DataSource
	@ConfigurationProperties("app.datasource")// Automatically reads all the properties from application.properties.
	public DataSource dataSource() {
		 return DataSourceBuilder.create().build();
	}
}
