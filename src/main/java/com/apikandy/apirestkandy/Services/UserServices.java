package com.apikandy.apirestkandy.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apikandy.apirestkandy.Models.Usuario;
import com.apikandy.apirestkandy.Repositorys.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServices {

    @Autowired
    private final UserRepository userRepository;

    public Usuario createUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public List<Usuario> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return userRepository.findById(id);
    }

    public Usuario updateUser(Usuario usuario) {
        return userRepository.save(usuario);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
