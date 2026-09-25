package in.syntro.TinyLink.controllers;

import in.syntro.TinyLink.dto.ShortenUrlRequest;
import in.syntro.TinyLink.services.RateLimitService;
import in.syntro.TinyLink.services.UrlShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
@Data
@AllArgsConstructor
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;
    private final RateLimitService rateLimitService;

    @PostMapping("/shorten")
    public ResponseEntity<UrlMappingDto> shortenUrl (@Valid @RequestBody Map<String, String> request){

        // {"originalUrl" : "https

        String OriginUrl = request.get("OriginUrl");
        UrlShortenerService
    }


