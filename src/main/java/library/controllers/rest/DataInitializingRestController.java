package library.controllers.rest;

import library.dao.IBookDAO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DataInitializingRestController implements SampleData {
    private final IBookDAO bookDAO;

    @GetMapping(path = "/add/books")
    public ResponseEntity<Void> postBooks() {
        this.bookDAO.addAll(sampleBooksData);
        return ResponseEntity.ok().build();
    }
}
