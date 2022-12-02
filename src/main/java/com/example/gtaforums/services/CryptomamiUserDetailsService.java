package com.example.gtaforums.services;


import com.example.gtaforums.users.CryptomamiUserDetails;
import com.example.gtaforums.users.User;
import com.example.gtaforums.users.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CryptomamiUserDetailsService implements UserDetailsService {
    //automatically inject users repository dao
    private UserRepository userRepository;

    public CryptomamiUserDetailsService(UserRepository usersRepository){
        this.userRepository = usersRepository;
    }
    //loads user data from the dao and checks it against user input
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("UserDetails Not found");
        } else{
            return new CryptomamiUserDetails(
                    user.getId(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getCryptoAddress());
        }
    }
}
