package camt.se331.watduangdee.controller;

import camt.se331.watduangdee.entity.transfer.TokenTransfer;
import camt.se331.watduangdee.entity.transfer.UserTransfer;
import camt.se331.watduangdee.service.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 2/5/2558.
 */
@RestController
@RequestMapping("/user")
public class UserAuthenticationController {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Retrieves the currently logged in user.
     *
     * @return A transfer containing the username and the roles.
     */

    @RequestMapping(method = RequestMethod.GET)
    public UserTransfer getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        return new UserTransfer(userDetails.getUsername(),this.createRoleMap(userDetails));
    }

    private Map<String, Boolean> createRoleMap(UserDetails userDetails) {
        Map<String,Boolean> roles = new HashMap<String,Boolean>();
        for(GrantedAuthority authority : userDetails.getAuthorities()){
            roles.put(authority.getAuthority(),Boolean.TRUE);
        }
        return roles;

    }

    @RequestMapping(value="/authenticate",method = RequestMethod.POST)
    public TokenTransfer authenticate(@RequestBody String body){
        // the body has been sent by username=a&password=b format
        String [] token = body.split("&");
        String username = token[0].split("=")[1];
        String password = token[1].split("=")[1];
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        /*


         */
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        return new TokenTransfer(TokenUtils.createToken(userDetails));

    }


}
