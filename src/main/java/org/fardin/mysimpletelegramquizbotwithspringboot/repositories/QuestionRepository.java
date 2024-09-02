package org.fardin.mysimpletelegramquizbotwithspringboot.repositories;

import org.fardin.mysimpletelegramquizbotwithspringboot.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
