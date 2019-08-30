package com.springframework.didemo.config;

import com.springframework.didemo.examplebeans.FakeDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    // environment variable override
    //useful in cases like not wanting to store passwords in a file
    @Autowired
    Environment environment;

    @Value("${com.username}")
    private String username;

    @Value("${com.password}")
    private String password;

    @Value("${com.dburl}")
    private String dburl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        //fakeDataSource.setUser(username);
        fakeDataSource.setUser(environment.getProperty("USERNAME")); // environment variable override
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(dburl);
        return fakeDataSource;
    }

    // going to be reading the file for us.
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

}
