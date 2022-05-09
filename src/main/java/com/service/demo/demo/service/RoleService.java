package com.service.demo.demo.service;


import com.service.demo.demo.entity.Role;
import com.service.demo.demo.exception.DublicateRecordException;
import com.service.demo.demo.exception.RecordNotFound;
import com.service.demo.demo.repository.RoleRepository;
import com.service.demo.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
@Transactional
@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Set<Role> findAll(){
        return new HashSet<>(roleRepository.findAll());
    }

    public Role findByName(String name){

       return roleRepository.findByName(name)
                .orElseThrow(() -> new RecordNotFound(String.format("Role %s not found.", name)
                ));

    }

    public Role findById (Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFound(String.format("Role with id: %s not found.", id)
                ));
    }

    // role {id 1, name Admin}
    //role{name:customer}
    @SneakyThrows
    public Role update(Role updatedRole, Long id){
        Objects.requireNonNull(id);
        Objects.requireNonNull(updatedRole);
        Role dbRole = findById(id);
        dbRole.setName(updatedRole.getName());
        return save(dbRole);
    }

    public Role save (Role role) throws IllegalAccessException {
        try {
        } catch (DataIntegrityViolationException ex) {
            throw new DublicateRecordException(
                    String.format("Role %s already exists.", role.getName())
            );
        }
        return roleRepository.save(role);
    }

    public void delete(Long id){
        roleRepository.deleteById(id);
    }

    public void delete(String name) {
        roleRepository.deletebyName(name);
    }



}
