package com.mghita.presentation.transactional.propagation;

import com.mghita.presentation.transactional.propagation.model.Book;
import com.mghita.presentation.transactional.propagation.model.Library;
import com.mghita.presentation.transactional.propagation.service.LibraryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropagationTest {

    @Autowired
    private LibraryService libraryService;

    @Test
    void saveAndDeleteLibraryBooks() {
        Library newLibrary = getNewLibrary();

        Library library = libraryService.addLibrary(newLibrary);

        Assertions.assertEquals(2, library.getBooks().size());

        libraryService.deleteOldBooks(library.getLibraryId(), 2017);

        Assertions.assertEquals(1, libraryService.getLibrary(library.getLibraryId()).getBooks().size());
    }

    private Library getNewLibrary() {
        Library newLibrary = new Library();
        newLibrary.setName("National Library");

        Book firstBook = createBook("Book Title 1", "978-1-40289-462-6", 2015);
        newLibrary.getBooks().add(firstBook);

        Book secondBook = createBook("Book Title 2", "978-1-56619-909-4", 2020);
        newLibrary.getBooks().add(secondBook);
        return newLibrary;
    }

    private Book createBook(String title, String isbn, int publishYear) {
        return Book.builder()
                .title(title)
                .isbn(isbn)
                .publishYear(publishYear)
                .build();
    }
}
