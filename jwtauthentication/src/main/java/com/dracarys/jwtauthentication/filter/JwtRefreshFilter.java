package com.dracarys.jwtauthentication.filter;

import com.dracarys.jwtauthentication.token.JwtAuthenticationToken;
import com.dracarys.jwtauthentication.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtRefreshFilter extends OncePerRequestFilter {

    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;

    public  JwtRefreshFilter(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(!request.getServletPath().startsWith("/refresh-token")) {
            filterChain.doFilter(request, response);
            return;
        }

        String refreshToken = null;
        for(Cookie cookie : request.getCookies())  {
            if(cookie.getName().equals("refreshToken")) {
                refreshToken = cookie.getValue();
                break;
            }
        }

        if(refreshToken != null) {

            JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(refreshToken);
            Authentication authResult = authenticationManager.authenticate(jwtAuthenticationToken);

            if(authResult.isAuthenticated()) {
                String accessToken = jwtUtil.generateToken(authResult.getName(), 5);
                response.setHeader("Authorization", "Bearer " + accessToken);
                response.setStatus(HttpServletResponse.SC_OK);
            }

        }
    }
}
