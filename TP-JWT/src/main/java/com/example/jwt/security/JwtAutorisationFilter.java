package com.example.jwt.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class JwtAutorisationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        initResponseHeader(response);
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else if (!JwtUtil.validateToken(request)) {
            filterChain.doFilter(request, response);
            return;
        } else {
            try {
                String token = JwtUtil.getToken(request);
                Claims claims = JwtUtil.getAllClaimsGeneratedToken(token);
                String username = claims.getSubject();
                List<String> roles = JwtUtil.getRoles(claims);
                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                roles.forEach(r -> authorities.add(new SimpleGrantedAuthority(r)));
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(username, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            } catch (MalformedJwtException e) {
                throw new RuntimeException("probleme de signature de token");
            }
            filterChain.doFilter(request, response);

        }

    }

    private void initResponseHeader(HttpServletResponse response) {
        response.addHeader("Access-Controll-Allow-Origin", "*");
        response.addHeader("Access-Controll-Allow-Headers",
                "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Reuest-Method, "
                        + "Access-Control-Reuest-Headers, authorization");

        response.addHeader("Access-Controll-Expose-Headers", "Access-Controll-Allow-Origin, "
                + "Access-Controll-Allow-Credentials,authorization");
    }


}