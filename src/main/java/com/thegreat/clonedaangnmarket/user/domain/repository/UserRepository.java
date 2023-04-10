package com.thegreat.clonedaangnmarket.user.domain.repository;

import com.thegreat.clonedaangnmarket.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmailAndProviderId(String providerId, String email);
}
