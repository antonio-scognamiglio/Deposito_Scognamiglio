package com.exercise.ecommerce.service;

import com.exercise.ecommerce.dto.request.UserRequest;
import com.exercise.ecommerce.dto.response.UserResponse;
import com.exercise.ecommerce.model.User;
import com.exercise.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service per l'entità User.
 *
 * Responsabilità:
 *   - Business logic (validazioni, orchestrazione)
 *   - Conversione entity→DTO via UserResponse.from() (il controller non vede mai l'entità)
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * GET tutti gli utenti.
     * → userRepository.findAll() → List<User> → map in List<UserResponse>
     */
    public List<UserResponse> findAll() {
        // UserResponse::from è il metodo reference (non un lambda, non un metodo private del service)
        return userRepository.findAll().stream()
                .map(UserResponse::from)
                .toList();
    }

    /**
     * GET un utente per id.
     * → Se non esiste, lancia NoSuchElementException (controller lo trasforma in 404).
     */
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found: " + id));
        return UserResponse.from(user);
    }

    /**
     * CREAZIONE di un nuovo utente.
     * → L'id NON viene dal request (lo genera il DB via @GeneratedValue).
     *
     * Perché setter inline e non una factory come in UserResponse.from(...)?
     *   → Outbound: il DTO guarda l'entità (è una PROIEZIONE di essa) → factory sul record ✅
     *   → Inbound: l'entità NON guarda il DTO (se User sapesse UserRequest, coupling model→dto) ❌
     *   → Quindi i setter stanno qui, nel service: è l'UNICO layer che vede entrambi.
     */
    public UserResponse createUser(UserRequest req) {
        // new User() → id = null → JPA fa INSERT senza la colonna id → DB genera l'id
        User user = new User();
        user.setFirstName(req.firstName());
        user.setLastName(req.lastName());
        user.setEmail(req.email());

        User saved = userRepository.save(user);  // → INSERT INTO users (...) ...
        return UserResponse.from(saved);       // ← l'id è già popolato dal DB
    }

    /**
     * AGGIORNAMENTO di un utente esistente (per id).
     */
    public UserResponse updateUser(Long id, UserRequest req) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found: " + id));

        // Sovrascrive i campi dal request e salva
        user.setFirstName(req.firstName());
        user.setLastName(req.lastName());
        user.setEmail(req.email());

        return UserResponse.from(userRepository.save(user));  // → UPDATE users SET ... WHERE id = ?
    }

    /**
     * CANCELLAZIONE di un utente per id.
     */
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User not found: " + id);
        }
        userRepository.deleteById(id);  // → DELETE FROM users WHERE id = ?
    }
}
