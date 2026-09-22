package in.syntro.TinyLink.controllers;

import in.syntro.TinyLink.services.RateLimitService;
import in.syntro.TinyLink.services.UrlShortenerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class UrlShortenerController {
    public UrlShortenerController(UrlShortenerService urlShortenerService, RateLimitService rateLimitService) {
        this.urlShortenerService = urlShortenerService;
        this.rateLimitService = rateLimitService;
    }

    private final UrlShortenerService urlShortenerService;
    private final RateLimitService rateLimitService;

    @PostMapping("/shorten")
    public ResponseEntity<?> shorten(@RequestParam("url") String url) {

    }
}
