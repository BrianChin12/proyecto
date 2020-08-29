package com.uabc.proyecto.proyecto;

import com.uabc.proyecto.proyecto.model.secutiry.UserSecurity;
import com.uabc.proyecto.proyecto.repository.security.UserRepositorySecurity;
import com.uabc.proyecto.proyecto.service.security.UserServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ProyectoApplication {
    @Autowired
    UserRepositorySecurity userRepositorySecurity;



    public static void main(String[] args) {
        SpringApplication.run(ProyectoApplication.class, args);


    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
        };
    }
    @Configuration
    protected static class AuthenticationSecurity extends
            GlobalAuthenticationConfigurerAdapter {

        @Autowired
        private UserServiceImpl users;

        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(users);
        }
    }
}
