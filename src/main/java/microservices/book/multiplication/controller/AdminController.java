package microservices.book.multiplication.controller;

import lombok.RequiredArgsConstructor;
import microservices.book.multiplication.service.AdminService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("test")
@RequiredArgsConstructor
@RequestMapping(path = "/multiplication/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping(path = "/delete-db")
    public ResponseEntity deleteDatabase(){
        adminService.deleteDatabaseContents();
        return ResponseEntity.ok().build();
    }

}
