package com.mghita.presentation.transactional.intro.service;

import com.mghita.presentation.transactional.intro.repository.UserRepository;
import com.mghita.presentation.transactional.intro.model.User;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    UserRepository userRepository;

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

//    @SneakyThrows //do not use it with @Transactional
    @Transactional
    public User addUser(User user) throws Exception {
        User savedUser = this.userRepository.save(user);
        if (user.getCareer() == null) {
            throw new RuntimeException("rollback");
//            throw new Exception("rollback");
        }
        return savedUser;
    }

    @Transactional
    public User editUser(Integer id, User userDTO) { //start transaction
        User user = getUser(id);
        user.setFirstName(userDTO.getFirstName()); //this.userRepository.findAll()
        user.setLastName(userDTO.getLastName());
        user.setCareer(userDTO.getCareer());
        if (user.getCareer() != null) {
            this.userRepository.save(user); //saved or not?
        }
        return user;
    }//commit transaction

    private User getUser(Integer id) {
//        return this.userRepository.findOneById(id);
        return this.userRepository.findById(id).get();
    }
}
