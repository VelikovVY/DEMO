package com.service.demo.demo.controler;
import com.service.demo.demo.dto.role.RoleResponce;
import com.service.demo.demo.dto.role.RoleSaveRequest;
import com.service.demo.demo.dto.role.RoleUpdateRequest;
import com.service.demo.demo.entity.Role;
import com.service.demo.demo.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/roles")
public class RoleController {

    private final RoleService roleService;
    private final com.service.demo.demo.converter.RoleConverter converterRole;

    @GetMapping
    public ResponseEntity<Set<Role>> findAll() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @SneakyThrows
    @PostMapping
    public ResponseEntity<RoleResponce> save(@RequestBody @Valid RoleSaveRequest roleSaveRequest) {
        Role role = converterRole.convert(roleSaveRequest);
        Role savedRole = roleService.save(role);
        RoleResponce response = converterRole.convert(savedRole);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping
    public ResponseEntity<RoleResponce> update(@RequestBody @Valid RoleUpdateRequest roleUpdateRequest){
        Role role = converterRole.convert(roleUpdateRequest);
        Role updateRole = roleService.update(role, role.getId());
        return ResponseEntity.ok(converterRole.convert(updateRole));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delate(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
    @DeleteMapping(value = "/name/{name}")
    public ResponseEntity<HttpStatus> delate(@PathVariable String name) {
        return ResponseEntity.ok().build();
    }

}

