package com.mimi.config;

import com.mimi.repository.LoginRepository;
import com.mimi.modele.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LoginUserDetailsService implements UserDetailsService {
    @Autowired private LoginRepository loginRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = loginRepo.findByEmail(username);
        if (admin == null){
            throw new UsernameNotFoundException("Aucun admin trouvé avec cet email");
        }
        return new LoginUserDetails(admin);
    }
}
