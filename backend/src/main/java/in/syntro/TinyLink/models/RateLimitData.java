package in.syntro.TinyLink.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class RateLimitData {
    private int minuteCount;
    private int hourCount;

    private LocalDateTime minuteWidowsStart;
    private LocalDateTime hourWidowsEnd;
}
