package com.vinihcrosa.picpaysimplificado.services;

import com.vinihcrosa.picpaysimplificado.domain.user.User;
import com.vinihcrosa.picpaysimplificado.domain.user.UserType;
import com.vinihcrosa.picpaysimplificado.dtos.UserDTO;
import com.vinihcrosa.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Merchant can't send money");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Insufficient funds");
        }
    }

    public User findUserById(Long id) throws Exception {
        return userRepository.findUSerById(id).orElseThrow(() -> new Exception("User not found"));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User createUser(UserDTO data) {
        User user = new User(data);
        this.saveUser(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}