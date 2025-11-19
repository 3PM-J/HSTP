package upeu.edu.pe.hst.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource(HikariConfig hikariConfig) {
        hikariConfig.setJdbcUrl(System.getenv("DATABASE_URL") != null
                ? System.getenv("DATABASE_URL")
                : "jdbc:mysql://localhost:3306/hst_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&autoReconnect=true");
        hikariConfig.setUsername(System.getenv("DATABASE_USERNAME") != null
                ? System.getenv("DATABASE_USERNAME")
                : "root");
        hikariConfig.setPassword(System.getenv("DATABASE_PASSWORD") != null
                ? System.getenv("DATABASE_PASSWORD")
                : "");
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return new HikariDataSource(hikariConfig);
    }
}
