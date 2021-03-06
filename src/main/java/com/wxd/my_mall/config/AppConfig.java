package com.wxd.my_mall.config;

import com.wxd.my_mall.framework.exception.MallException;
import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.plugin.Interceptor;
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
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.wxd.my_mall")
@MapperScan({"com.wxd.my_mall.mbg.mapper", "com.wxd.my_mall.dao"})
@PropertySource("classpath:application-${profilesActive}.properties")
@EnableAspectJAutoProxy // support aop
@EnableTransactionManagement
@EnableWebMvc
@Import({RedisConfig.class, SecurityConfig.class, Swagger2Config.class})
public class AppConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    DataSource createDataSource(
            @Value("${jdbc.url}") String jdbcUrl,
            @Value("${jdbc.driverClass}") String driverClass,
            @Value("${jdbc.username}") String jdbcUsername,
            @Value("${jdbc.password}") String jdbcPassword,
            @Value("${pool.autoCommit}") String autoCommit,
            @Value("${pool.connectionTimeout}") String connectionTimeout,
            @Value("${pool.idleTimeout}") String idleTimeout
    ) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setDriverClassName(driverClass);
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
        // dataSource
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // mapper xml location
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            List<Resource> resources = new ArrayList<>();
            for (String location : mapperLocations) {
                //getResources support reg (much mapper xml s), But getResource only support one resource file
                Resource[] res = resolver.getResources(location);
                resources.addAll(Arrays.asList(res));
            }
            sqlSessionFactoryBean.setMapperLocations(resources.toArray(new Resource[resources.size()]));
        } catch (Exception e) {
            throw new MallException("get xml mapper Resources failed");
        }
        // mybatis support StdOut type print sql, also has other type
/*        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class);
        sqlSessionFactoryBean.setConfiguration(configuration);*/
        //support PageHelper
        PageInterceptor page = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        page.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{page});
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