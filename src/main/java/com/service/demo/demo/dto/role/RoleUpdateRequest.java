package com.service.demo.demo.dto.role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
public class RoleUpdateRequest {

    @NotNull
    private Long id;
    @NotNull
    public Spring name;
}
