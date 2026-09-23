package in.syntro.TinyLink.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder  //
@NoArgsConstructor
@AllArgsConstructor
public class ShortenUrlRequest{
    @NotBlank(message = "Original Url is required")
    //@Pattern(regexp = )
    private String OriginalUrl;
    private String customAlias;
    private LocalDateTime expiration;
}
