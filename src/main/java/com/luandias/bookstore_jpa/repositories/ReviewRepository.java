package com.luandias.bookstore_jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luandias.bookstore_jpa.models.ReviewModel;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {

}
