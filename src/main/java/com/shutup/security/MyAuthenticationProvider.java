package com.shutup.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by shutup on 2017/1/11.
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDetails user = myUserDetailsService.loadUserByUsername(username);

        //密码匹配验证
        if (password.equals(user.getPassword())) {
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
        }else {
            throw new BadCredentialsException("Wrong password.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
