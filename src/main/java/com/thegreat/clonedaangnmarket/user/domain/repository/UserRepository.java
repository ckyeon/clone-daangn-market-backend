package com.thegreat.clonedaangnmarket.user.domain.repository;

import com.thegreat.clonedaangnmarket.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
