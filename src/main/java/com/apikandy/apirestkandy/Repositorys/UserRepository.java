package com.apikandy.apirestkandy.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apikandy.apirestkandy.Models.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

}
