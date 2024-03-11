package co.sophea.cambodiaaccessoryapi.api.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User , Integer> {

    List<User> findAllByStatusIsTrue();

}
