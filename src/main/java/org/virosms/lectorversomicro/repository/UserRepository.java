package org.virosms.lectorversomicro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.virosms.lectorversomicro.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
