package com.capgemini.emsOnetoOnemap.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String country;
    @NotBlank(message = "please enter pincode")
    @Pattern(regexp = "\\d{6}", message = "pincode must be exactly 6 digits")
    private String pincode;
}