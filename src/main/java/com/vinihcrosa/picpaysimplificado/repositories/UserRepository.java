package com.vinihcrosa.picpaysimplificado.repositories;

import com.vinihcrosa.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUSerByDocument(String document);

    Optional<User> findUSerById(Long id);
}
