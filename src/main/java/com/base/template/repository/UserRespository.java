package com.base.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.template.entity.User;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
}
