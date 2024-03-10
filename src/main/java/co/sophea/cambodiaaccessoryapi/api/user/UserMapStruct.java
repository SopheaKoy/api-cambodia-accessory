package co.sophea.cambodiaaccessoryapi.api.user;

import co.sophea.cambodiaaccessoryapi.api.user.web.CreateUserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {

    User toCreateUserDto(CreateUserDto userDto);

}
