package mk.ukim.finki.wp.eshop.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import mk.ukim.finki.wp.eshop.config.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/login")
public class LoginRESTController {
    private final JwtAuthenticationFilter filter;

    public LoginRESTController(JwtAuthenticationFilter filter) {
        this.filter = filter;
    }


    @PostMapping
    public String doLogin(HttpServletRequest request,
                          HttpServletResponse response) throws JsonProcessingException {
        Authentication auth = this.filter.attemptAuthentication(request, response);
        return this.filter.generateJwt(response, auth);

    }
}

