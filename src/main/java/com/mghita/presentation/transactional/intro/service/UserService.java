package com.mghita.presentation.transactional.intro.service;

import com.mghita.presentation.transactional.intro.model.User;
import com.mghita.presentation.transactional.intro.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    UserRepository userRepository;

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

//    @SneakyThrows // do not use it with @Transactional
//    @Transactional(noRollbackFor = SQLException.class)
//    @Transactional(rollbackFor = SQLException.class)
    @Transactional
    public User addUser(User user) throws Exception {
        System.out.println(this.getClass()); // UserService.class
        User savedUser = this.userRepository.save(user);
        if (user.getCareer() == null) {
            throw new RuntimeException("rollback for unchecked exceptions");
//            throw new SQLException("no rollback for checked exceptions");
        }
        return savedUser;
    }

    public User addUserInternally(User user) throws Exception {
        return addUser(user);
    }

    @Transactional
    public User editUser(Integer id, User userDTO) { // start transaction
        User user = getUser(id); // persisted or not?
        user.setFirstName(userDTO.getFirstName()); // this.userRepository.findAll()
        user.setLastName(userDTO.getLastName());
        user.setCareer(userDTO.getCareer());
        if (user.getCareer() != null) {
            this.userRepository.save(user); // saved or not?
        }
        return user;
    } // commit transaction

    private User getUser(Integer id) {
//        return this.userRepository.findOneById(id); // readOnly = true
        return this.userRepository.findById(id).get();
    }
}
