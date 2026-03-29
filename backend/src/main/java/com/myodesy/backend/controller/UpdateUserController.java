package com.myodesy.backend.controller;

import com.myodesy.backend.dto.UpdateUserRequest;
import com.myodesy.backend.model.SystemUser;
import com.myodesy.backend.service.UpdateUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/myodesy/update/users")
public class UpdateUserController {

    private final UpdateUserService updateUserService;

    public UpdateUserController(UpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemUser> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UpdateUserRequest request) {

        SystemUser updatedUser = updateUserService.updateUser(id, request);
        return ResponseEntity.ok(updatedUser);
    }
}