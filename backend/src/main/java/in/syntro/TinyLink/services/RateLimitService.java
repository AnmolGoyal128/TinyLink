package in.syntro.TinyLink.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateLimitService {
    public boolean isAllowed(String clientsIp) {

        return clientsIp.equals("127.0.0.1");
    }
}
