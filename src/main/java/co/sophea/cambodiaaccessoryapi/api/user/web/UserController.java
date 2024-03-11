package co.sophea.cambodiaaccessoryapi.api.user.web;

import co.sophea.cambodiaaccessoryapi.api.user.User;
import co.sophea.cambodiaaccessoryapi.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping
    void createUser(@RequestBody CreateUserDto userDto){
        userService.createUser(userDto);
    }

    // This using for user Find active
    @GetMapping("/user-active")
    List<User> getAllUserByStatus (){
        return userService.findUserStatusTrue();
    }

}
