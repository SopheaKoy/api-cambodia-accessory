package co.sophea.cambodiaaccessoryapi.api.user;

import co.sophea.cambodiaaccessoryapi.api.user.web.CreateUserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    /**
     *
     * @return List of users
     */
    List<User> findAllUsers();

    /**
     *
     * @return as UserDto
     */
    void createUser(CreateUserDto userDto);

}
