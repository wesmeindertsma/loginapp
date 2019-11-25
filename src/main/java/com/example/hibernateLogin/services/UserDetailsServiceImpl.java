package com.example.hibernateLogin.services;

import com.example.hibernateLogin.models.Role;
import com.example.hibernateLogin.models.User;
import com.example.hibernateLogin.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepositories userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(name);
        if (user == null) throw new UsernameNotFoundException(name);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
