package com.lerucco.thymeleafmvc.model;

import com.lerucco.thymeleafmvc.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digits")
    private String postalCode;

    @CourseCode(value = "Le", message = "Must start with Le")
    private String courseCode;

}
