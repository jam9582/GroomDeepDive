package me.codetiny.java_advanced.securityProject.repository;

public class UserRepository {
}
package me.codetiny.java_advanced.securityProject.repository;

import me.codetiny.java_advanced.securityProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}