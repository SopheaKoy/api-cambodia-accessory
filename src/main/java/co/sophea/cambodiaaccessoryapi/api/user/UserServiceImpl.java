package co.sophea.cambodiaaccessoryapi.api.user;

import co.sophea.cambodiaaccessoryapi.api.user.web.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createUser(CreateUserDto userDto) {

        User user = User.builder()
                .uuid(UUID.randomUUID().toString())
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .build();
        userRepository.save(user);
    }

    @Override
    public List<User> findUserStatusTrue() {
        return userRepository.findAllByStatusIsTrue();
    }

}
