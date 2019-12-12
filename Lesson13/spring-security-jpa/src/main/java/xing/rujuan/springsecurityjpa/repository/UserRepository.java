package xing.rujuan.springsecurityjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xing.rujuan.springsecurityjpa.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
