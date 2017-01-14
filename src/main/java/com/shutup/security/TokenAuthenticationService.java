package com.shutup.security;

import com.shutup.model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Tom on 1/11/17.
 */
public class TokenAuthenticationService {
    private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days
    private String secret = "ThisIsASecret";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";
    private String roleNames = "roleNames";
    public void addAuthentication(HttpServletResponse response, Authentication authentication) {
        // We generate a token now.
        String JWT = Jwts.builder()
                .setSubject(authentication.getName())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .claim(roleNames,authentication.getAuthorities())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        response.addHeader(headerString, tokenPrefix + " " + JWT);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerString);
        if (token != null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            List<Role> roles = new ArrayList<>();
            ArrayList<LinkedHashMap> linkedHashMaps = (ArrayList<LinkedHashMap>) Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .get(roleNames);
            for (LinkedHashMap l :
                    linkedHashMaps) {
                roles.add(new Role(l));
            }

            if (username != null && roles.size()!=0) // we managed to retrieve a user
            {
                return new AuthenticatedUser(username,roles);
            }else {
                throw new BadCredentialsException("Username not found.");
            }
        }
        return null;
    }
}
