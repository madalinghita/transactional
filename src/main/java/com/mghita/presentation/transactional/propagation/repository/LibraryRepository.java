package com.mghita.presentation.transactional.propagation.repository;

import com.mghita.presentation.transactional.propagation.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    @Transactional(propagation = Propagation.REQUIRED) // REQUIRED, REQUIRES_NEW, MANDATORY, NOT_SUPPORTED
    Library findByLibraryId(Integer libraryId);
}
