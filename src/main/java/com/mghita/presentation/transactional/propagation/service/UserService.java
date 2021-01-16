package com.mghita.presentation.transactional.propagation.service;

import com.mghita.presentation.transactional.propagation.model.User;
import com.mghita.presentation.transactional.propagation.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    UserRepository userRepository;

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Transactional
    public User addUser(User user) {
        User savedUser = this.userRepository.save(user);
        if (user.getCareer() == null) {
            throw new RuntimeException("rollback");
        }
        return savedUser;
    }

    @Transactional
    public User editUser(Integer id, User userDTO) {
        User user = getUser(id);
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setCareer(userDTO.getCareer());
        if (user.getCareer() != null) {
            this.userRepository.save(user);
        }

        /*user.setFirstName("TF1");
        user.setLastName("TL1");
        user.setCareer("TC1");
        this.userRepository.save(user);*/

        return user;
    }

    private User getUser(Integer id) {
        return this.userRepository.findOneById(id);
    }
}
