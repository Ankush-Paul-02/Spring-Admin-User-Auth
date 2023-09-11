package com.devmare.springadminuserauth.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        var authorities =  authentication.getAuthorities();
        var roles = authorities
                .stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst();
        if (roles.orElse("").equals("ADMIN")) {
            response.sendRedirect("/admin-page");
        } else if (roles.orElse("").equals("USER")) {
            response.sendRedirect("/user-page");
        } else {
            response.sendRedirect("/error");
        }
    }
}
