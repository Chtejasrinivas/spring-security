package com.learning.spring_security.service;

import com.learning.spring_security.model.User;
import com.learning.spring_security.model.UserPrincipal;
import com.learning.spring_security.repo.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        } else
            return new UserPrincipal(user);
    }
}
