package com.uabc.proyecto.proyecto.service.security;


import com.uabc.proyecto.proyecto.model.secutiry.UserSecurity;

public interface UserService {
    void save(UserSecurity userSecurity);

    UserSecurity findByUsername(String username);
}
