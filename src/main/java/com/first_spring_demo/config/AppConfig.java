package com.first_spring_demo.config;

import com.first_spring_demo.common.exception.MallException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.first_spring_demo")
@MapperScan({"com.first_spring_demo.mbg.mapper", "com.first_spring_demo.dao"})
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy // support aop
@EnableTransactionManagement
@EnableWebMvc
@Import({RedisConfig.class, SecurityConfig.class, Swagger2Config.class})
public class AppConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    DataSource createDataSource(
            @Value("${jdbc.url}") String jdbcUrl,
            @Value("${jdbc.username}") String jdbcUsername,
            @Value("${jdbc.password}") String jdbcPassword,
            @Value("${pool.autoCommit}") String autoCommit,
            @Value("${pool.connectionTimeout}") String connectionTimeout,
            @Value("${pool.idleTimeout}") String idleTimeout
    ) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(jdbcUsername);
        config.setPassword(jdbcPassword);
        config.addDataSourceProperty("autoCommit", autoCommit);
        config.addDataSourceProperty("connectionTimeout", connectionTimeout);
        config.addDataSourceProperty("idleTimeout", idleTimeout);
        return new HikariDataSource(config);
    }

    @Bean
    SqlSessionFactoryBean createSqlSessionFactory(
            @Autowired DataSource dataSource,
            @Value("#{'${mapper-locations}'.split(';')}") List<String> mapperLocations) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // mapper xml location
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            List<Resource> resources = new ArrayList<>();
            for (String location : mapperLocations) {
                //getResources support reg (much mapper xml s), But getResource only support one resource file
                resources.addAll(List.of(resolver.getResources(location)));
            }
            sqlSessionFactoryBean.setMapperLocations(resources.toArray(new Resource[resources.size()]));
        } catch (IOException e) {
            throw new MallException("get xml mapper Resources failed");
        }
        return sqlSessionFactoryBean;
    }


    @Bean
    PlatformTransactionManager createTxManager(@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}