package com.jobscheduler.springbootjobscheduler.repository;

import com.jobscheduler.springbootjobscheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
