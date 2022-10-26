package com.mimi.config;

import com.mimi.repository.UserRepository;
import com.mimi.modele.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepo.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Aucun user trouvé avec cet email");
        }
        return new LoginUserDetails(user);
    }



}
