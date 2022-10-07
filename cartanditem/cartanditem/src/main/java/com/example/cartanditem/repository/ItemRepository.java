package com.example.cartanditem.repository;

import com.example.cartanditem.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
   List<ItemEntity> findByName(String name);
}
