import com.example.auth.domain.types.AccountStatus;
import dto.SignInDto.SignInRequestDto;
import dto.SignInDto.SignInResponseDto;
import dto.SignUpDto;
import dto.SignUpDto.SignUpResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import service.SignInProxyService;
import service.SignUpProxyService;

@RestController
@RequiredArgsConstructor
public class AuthenticaitonAPI {
    private final SignInProxyService signInProxyService;
    private final SignUpProxyService signUpProxyService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public SignUpResponseDto signUp(@RequestBody @Valid SignUpDto.SignUpRequestDto body){
        signUpProxyService.SignUp(body, AccountStatus.ACTIVE);

        return SignUpResponseDto.builder()
                .success(true)
                .build();

    }

    @PostMapping("/sign-in")
    public SignInResponseDto signIn(@RequestBody @Valid SignInRequestDto body, HttpServletResponse response){
        String accessToken = signInProxyService.SignIn(body, response);

        return SignInResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }

}
