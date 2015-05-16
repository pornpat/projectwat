package camt.se331.watduangdee.config.security;

import camt.se331.watduangdee.entity.User;
import camt.se331.watduangdee.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by Dell on 2/5/2558.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("User name "+userName + " not found");
        }

        return new SecurityUser(user);
    }
}