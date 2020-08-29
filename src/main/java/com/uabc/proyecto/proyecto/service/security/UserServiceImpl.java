package com.uabc.proyecto.proyecto.service.security;

import com.uabc.proyecto.proyecto.model.Producto;
import com.uabc.proyecto.proyecto.model.secutiry.UserSecurity;
import com.uabc.proyecto.proyecto.repository.security.UserRepositorySecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepositorySecurity repo;



    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserSecurity userSecurity = repo.findByName(username);
        if (userSecurity == null) {
            return null;
        }
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");
        if (username.equals("admin")) {
            auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String password = userSecurity.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        return new org.springframework.security.core.userdetails.User(username, hashedPassword,
                auth);
    }

    public String actual(){

        String envio = SecurityContextHolder.getContext().getAuthentication().getName();
        return envio;

    }


}
