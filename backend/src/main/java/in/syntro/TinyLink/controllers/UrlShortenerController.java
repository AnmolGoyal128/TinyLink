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
    public ResponseEntity<?> shortenUrl (@Valid @RequestBody ShortenUrlRequest request,
                                         HttpServletRequest httpServletRequest){

        String clientsIp = getClientIp(httpServletRequest);
        if(!rateLimitService.isAllowed(clientsIp)){
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(Map.of());
        }

        return null;
    }

    private String getClientIp(HttpServletRequest httpServletRequest) {
        String XForwardFor = httpServletRequest.getHeader("X-Forwarded-For");
        if(XForwardFor == null || XForwardFor.isEmpty()){
            return httpServletRequest.getRemoteAddr();
        }

        String xRealip = httpServletRequest.getHeader("X-Real-IP");
        if(xRealip == null || xRealip.isEmpty()){
            return xRealip;
        }

        return httpServletRequest.getRemoteAddr();
    }
}
