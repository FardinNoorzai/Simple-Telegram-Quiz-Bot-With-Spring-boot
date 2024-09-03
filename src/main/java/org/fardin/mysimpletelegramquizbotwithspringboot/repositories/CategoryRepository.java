package org.fardin.mysimpletelegramquizbotwithspringboot.repositories;

import org.fardin.mysimpletelegramquizbotwithspringboot.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    public Category findByName(String name);
}
