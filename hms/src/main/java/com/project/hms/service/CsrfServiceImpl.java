package com.project.hms.service;


import com.project.hms.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
public class CsrfServiceImpl{
    @Autowired
    private TokenRepository tokenRepository;
}
