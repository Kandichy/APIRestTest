package com.apikandy.apirestkandy.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apikandy.apirestkandy.Models.Usuario;
import com.apikandy.apirestkandy.Services.UserServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserServices userServices;

    @GetMapping("/users")
    public List<Usuario> getAllUsers() {
        return userServices.findAllUsers();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") Long id) {
        Optional<Usuario> user = userServices.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        Usuario newUser = userServices.createUser(usuario);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Usuario actualUser = userServices.updateUser(usuario);
        return new ResponseEntity<>(actualUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id) {
        Optional<Usuario> user = userServices.findById(id);
        if (user.isPresent()) {
            Usuario usuarioActual = user.get();
            userServices.deleteUserById(usuarioActual.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
