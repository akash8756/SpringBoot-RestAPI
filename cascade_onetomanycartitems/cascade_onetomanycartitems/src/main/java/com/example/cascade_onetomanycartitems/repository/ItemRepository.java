package com.example.cascade_onetomanycartitems.repository;

import com.example.cascade_onetomanycartitems.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
}
