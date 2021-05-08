package com.mghita.presentation.transactional.intro.repository;

import com.mghita.presentation.transactional.intro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    User findOneById(Integer id);
}
