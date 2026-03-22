/**
 * @Author: Anirban3030 anirbanmondal3030@gmail.com
 * @Date: 2026-03-21 03:18:04
 * @LastEditors: Anirban3030 anirbanmondal3030@gmail.com
 * @LastEditTime: 2026-03-21 05:06:55
 * @FilePath: D:/Capgemini Training/emsOnetoOnemap/emsOnetoOnemap/src/main/java/com/capgemini/emsOnetoOnemap/dto/EmployeeDTO.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package com.capgemini.emsOnetoOnemap.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "please enter name")
    private String name;
    @NotBlank(message = "please enter email")
    @Email(message = "please enter valid email")
    private String email;
    @NotBlank(message = "please enter phone no.")
    @Pattern(regexp = "\\d{10}", message = "phone no. must be exactly 10 digits")
    private String phone;
    private String gender;
    private String designation;
    @Positive(message = "Salary must be greater than 0")
    private double salary;
    private LocalDate dateOfJoining;
    @Valid
    private AddressDTO address;
}