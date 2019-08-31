package com.springframework.didemo.config;

import com.springframework.didemo.examplebeans.FakeDataSource;
import com.springframework.didemo.examplebeans.FakeJmsBroker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
// spring 4 annotation
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    // environment variable override
    // useful in cases like not wanting to store passwords in a file
    @Autowired
    Environment environment;

    @Value("${com.username}")
    private String username;

    @Value("${com.password}")
    private String password;

    @Value("${com.dburl}")
    private String dburl;

    @Value("${com.jms.username}")
    private String jmsUsername;

    @Value("${com.jms.password}")
    private String jmsPassword;

    @Value("${com.jms.dburl}")
    private String jmsDburl;

    @Bean
    public FakeDataSource fakeDataSource() {
        FakeDataSource fakeDataSource = new FakeDataSource();
        //fakeDataSource.setUser(username);
        fakeDataSource.setUser(environment.getProperty("USERNAME")); // environment variable override
        fakeDataSource.setPassword(password);
        fakeDataSource.setDburl(dburl);
        return fakeDataSource;
    }

    @Bean
    public FakeJmsBroker fakeJmsBroker() {
        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setUser(jmsUsername);
        fakeJmsBroker.setPassword(jmsPassword);
        fakeJmsBroker.setDburl(jmsDburl);
        return fakeJmsBroker;
    }

    // going to be reading the file for us.
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

}
