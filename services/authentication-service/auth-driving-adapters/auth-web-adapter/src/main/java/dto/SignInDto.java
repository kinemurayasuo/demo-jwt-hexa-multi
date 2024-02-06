package dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public record SignInDto() {
    @Builder
    public record SignInRequestDto(

            @JsonProperty("username")
            @NotBlank
            String username,

            @JsonProperty("password")
            @NotBlank
            String password
    ) {}
    @Builder
    public record SignInResponseDto(
            @JsonProperty("access_token")
            String accessToken,

            @JsonInclude(Include.NON_DEFAULT)
            Boolean requires2Fa
    ) {}
}
