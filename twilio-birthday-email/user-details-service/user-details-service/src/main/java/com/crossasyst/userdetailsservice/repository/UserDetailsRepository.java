package com.crossasyst.userdetailsservice.repository;

import com.crossasyst.userdetailsservice.enitity.UsersEntity;
import com.crossasyst.userdetailsservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UsersEntity, Long> {

    @Query(value = "select * from users_details where to_char(CURRENT_DATE, 'MM-dd')=to_char(day_month, 'MM-dd')", nativeQuery = true)
    List<UsersEntity> findAllByDayMonth();
}
