package com.graniumhub.data.repository;

import com.graniumhub.data.domain.Category;
import com.graniumhub.data.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Sasha on 3/28/17.
 */
public interface DishRepository extends JpaRepository<Dish,Integer> {
    Optional<Dish> findOne(int id);
}