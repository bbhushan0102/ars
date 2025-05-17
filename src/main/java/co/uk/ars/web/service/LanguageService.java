package co.uk.ars.web.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LanguageService {

    public Locale getCurrentLanguage(HttpSession session) {
        Object lang = session.getAttribute("lang");
        return (lang instanceof Locale) ? (Locale) lang : Locale.ENGLISH;
    }
}