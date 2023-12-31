package com.cos.photogramstart.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // JPA Naming Query
    User findByUsername(String username);


}
