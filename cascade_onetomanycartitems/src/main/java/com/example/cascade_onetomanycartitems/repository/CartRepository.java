package com.example.cascade_onetomanycartitems.repository;


import com.example.cascade_onetomanycartitems.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {
}
