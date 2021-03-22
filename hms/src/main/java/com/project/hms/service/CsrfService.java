package com.project.hms.service;


import org.springframework.security.web.server.csrf.CsrfToken;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CsrfService {
    void saveCsrfToken(CsrfToken csrfToken);
    void updateCsrfToken(CsrfToken csrfToken);
    void deleteCsrfToken(int id);
    CsrfToken getCsrfToken(int id);
    List<CsrfToken> getAllCsrfToken();

    CsrfToken generateToken(HttpServletRequest httpServletRequest);
}
