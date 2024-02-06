package dto;

import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

public record SignUpDto() {
    @Builder
    public record SignUpRequestDto(

            //gson 추가 SerializedName 추가
            @NotBlank
            String username,
            @NotBlank
            String password,
            @NotBlank
            String nickname


    ) {}

    @Builder
    public record SignUpResponseDto(
            Boolean success
    ) {}
}
