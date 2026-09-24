package in.syntro.TinyLink.services;

import in.syntro.TinyLink.models.RateLimitData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class RateLimitService {

    private int requestPerMinute;
    private int requestPerHour;

    private final ConcurrentHashMap<String, RateLimitData> rateLimitData = new ConcurrentHashMap<>();

    private static final String REDIS_KEY_PREFIX = "rate_limit_";


    public boolean isAllowed(String clientsIp) {
        String redisKey = REDIS_KEY_PREFIX + clientsIp;
        // 192.168.1.10
        // rateLimit : 192.168.0.10

        LocalDateTime now = LocalDateTime.now();


        if (data == null) {
            data = rateLimitData.computeIfAbsent(clientsIp, k -> RateLimitData.builder()
                    .minuteCount(0)
                    .hourCount(0)
                    .minuteWidowsStart(now)
                    .hourWidowsEnd(now)

                    .build());
        }
        return clientsIp.equals("127.0.0.1");
    }

    private Mono<Object> getRateLimitDataFromRedis(String redisKey) {

        try{
            ReactiveRedisOperations<Object, Object> redisTamplate = null;
            return redisTamplate.opsForValue().get(redisKey);
        }catch (Exception e){
            log.warn("Failed to get rate limit data from redis : {}", e.getMessage());
            return  null;
        }
    }
}
