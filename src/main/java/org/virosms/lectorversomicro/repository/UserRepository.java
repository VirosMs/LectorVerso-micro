package org.virosms.lectorversomicro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.virosms.lectorversomicro.entity.User;



@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long>{
    User findByName(String name);
    User findByEmail(String email);

    boolean existsByName(String name);

    boolean existsByEmail(String email);

    void deleteByEmail(String email);
}
