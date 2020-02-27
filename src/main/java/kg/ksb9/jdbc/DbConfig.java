package kg.ksb9.jdbc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
@Aspect
@Configuration
public class DbConfig {
    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Before("@annotation(kg.ksb9.aspects.InitDbAspect)")
    public void initDb() {
        String sql = "CREATE  TABLE IF NOT EXISTS persons(person_id int, first_name varchar(255), last_name varchar(255),email varchar(255), PRIMARY KEY (person_id))";
        getJdbcTemplate().update(sql);
    }
}
