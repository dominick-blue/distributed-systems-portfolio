package com.loyalblue.ecommerce.user.repository;

import com.loyalblue.ecommerce.user.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import static org.junit.jupiter.api.Assertions.*;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Rollback(false) // Set to true if you want to roll back after each test
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setName("John Doe");
        testUser.setEmail("john.doe@example.com");
        testUser.setPassword("password123");
    }

    @Test
    public void testSaveUser() {
        User savedUser = userRepository.save(testUser);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindByEmail() {
        userRepository.save(testUser); // Ensure user is saved before finding
        User foundUser = userRepository.findByEmail("john.doe@example.com");
        Assertions.assertThat(foundUser).isNotNull();
        Assertions.assertThat(foundUser.getEmail()).isEqualTo("john.doe@example.com");
    }

    @Test
    public void testFindById() {
        User savedUser = userRepository.save(testUser); // Save the user first
        Optional<User> foundUser = userRepository.findById(savedUser.getId());
        Assertions.assertThat(foundUser).isPresent();
        Assertions.assertThat(foundUser.get().getId()).isEqualTo(savedUser.getId());
    }

    @Test
    public void testDeleteUser() {
        User savedUser = userRepository.save(testUser); // Save the user first
        userRepository.deleteById(savedUser.getId());
        Optional<User> deletedUser = userRepository.findById(savedUser.getId());
        Assertions.assertThat(deletedUser).isNotPresent();
    }
}
