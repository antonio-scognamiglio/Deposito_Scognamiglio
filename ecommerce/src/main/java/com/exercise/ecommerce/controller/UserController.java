package com.exercise.ecommerce.controller;

import com.exercise.ecommerce.dto.request.UserRequest;
import com.exercise.ecommerce.dto.response.UserResponse;
import com.exercise.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Controller REST per gli utenti.
 *
 * Endpoints:
 *   GET    /users      → tutti gli utenti
 *   GET    /users/{id} → un utente per id
 *   POST   /users      → crea un nuovo utente
 *   PUT    /users/{id} → aggiorna un utente esistente
 *   DELETE /users/{id} → cancella un utente
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** GET /users → lista tutti gli utenti */
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    /** GET /users/{id} → recupera un utente per id */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    /** POST /users → crea un nuovo utente dal body JSON (UserRequest, senza id) */
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(req));
    }

    /** PUT /users/{id} → aggiorna l'utente con il body JSON (UserRequest, senza id) */
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest req) {
        return ResponseEntity.ok(userService.updateUser(id, req));
    }

    /** DELETE /users/{id} → cancella l'utente (204 No Content) */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /** Handler: trasforma NoSuchElementException in HTTP 404 */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
