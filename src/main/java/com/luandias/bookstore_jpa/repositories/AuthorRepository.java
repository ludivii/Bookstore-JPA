package com.luandias.bookstore_jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luandias.bookstore_jpa.models.AuthorModel;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {

}
