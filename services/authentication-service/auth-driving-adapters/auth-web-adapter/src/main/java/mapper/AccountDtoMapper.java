package mapper;

import com.example.auth.domain.Account;
import com.example.auth.domain.types.AccountStatus;
import dto.SignUpDto.SignUpRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AccountDtoMapper {
    @Mapping(target = "password", source = "dto.password")
    Account from(SignUpRequestDto dto, AccountStatus status);
}
