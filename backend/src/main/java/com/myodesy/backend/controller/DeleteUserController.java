package com.myodesy.backend.controller;

import com.myodesy.backend.service.DeleteUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/myodesy/delete/users")
public class DeleteUserController {

    private final DeleteUserService deleteUserService;

    public DeleteUserController(DeleteUserService deleteUserService) {
        this.deleteUserService = deleteUserService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        deleteUserService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}