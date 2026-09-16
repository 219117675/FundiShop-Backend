package za.ac.cput.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationRequest {

    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String role;

    // Fundi-specific information
    private String tradeCategory;
    private String bio;
    private Double calloutFee;
    private Double hourlyRate;
    private Integer serviceAreaRadiusKm;
}