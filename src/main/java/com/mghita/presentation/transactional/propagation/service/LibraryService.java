package com.mghita.presentation.transactional.propagation.service;

import com.mghita.presentation.transactional.propagation.model.Library;
import com.mghita.presentation.transactional.propagation.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public Library getLibrary(Integer libraryId) {
        return this.libraryRepository.findByLibraryId(libraryId); // start new transaction ?
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Library addLibrary(Library library) {
        return this.libraryRepository.save(library); // Transactional - Propagation.REQUIRED => CRUD methods on repository instances inherited from SimpleJpaRepository
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteOldBooks(Integer libraryId, int minPublishYear) {
        Library library = getLibrary(libraryId);
        library.getBooks().removeIf(book -> book.getPublishYear() > minPublishYear);
        // changes are saved ?
    }
}
