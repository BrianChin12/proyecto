package com.uabc.proyecto.proyecto.repository.security;
import com.uabc.proyecto.proyecto.model.secutiry.UserSecurity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepositorySecurity extends CrudRepository<UserSecurity, Long> {
    UserSecurity findByName(String username);

}
