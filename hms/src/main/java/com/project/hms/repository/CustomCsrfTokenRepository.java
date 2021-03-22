package com.project.hms.repository;

import com.project.hms.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

public class CustomCsrfTokenRepository implements CsrfTokenRepository {
    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
        String uuid = UUID.randomUUID().toString();
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String identifier = httpServletRequest.getHeader("X-IDENTIFIER");
        Optional<Token> existingToken = tokenRepository.findTokenByIdentifier(identifier);
        System.out.println(identifier);
        if(existingToken.isPresent()){
            Token token = existingToken.get();
            token.setToken(csrfToken.getToken());
        }
        else {
            Token token = new Token();
            token.setToken(csrfToken.getToken());
            token.setIdentifier(identifier);
            tokenRepository.save(token);
        }
    }

    @Override
    public CsrfToken loadToken(HttpServletRequest httpServletRequest) {
        String identifier = httpServletRequest.getHeader("X-Request-ID");
        System.out.println(identifier);
        Optional<Token> existingToken = tokenRepository.findTokenByIdentifier(identifier);
        if(existingToken.isPresent()){
            Token token = existingToken.get();
            return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", token.getToken());
        }

        return null;
    }
}
