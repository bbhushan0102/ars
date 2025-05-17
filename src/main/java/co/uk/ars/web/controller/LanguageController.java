package co.uk.ars.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class LanguageController {

    @GetMapping("/set-language")
    public String setLanguage(@RequestParam("lang") String lang, HttpSession session, HttpServletRequest request) {
        session.setAttribute("lang", new Locale(lang)); // Save selection in session
        // Redirect user back to the page they were on
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "/");
    }

}
