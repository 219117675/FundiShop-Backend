package za.ac.cput.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class BookingRequest {

    private Long customerId;

    private Long fundiProfileId;

    private LocalDate scheduledDate;

    private LocalTime scheduledTime;

    private String serviceRequired;

    private String jobLocation;

    private BigDecimal estimatedBudget;

    private String jobDescription;
}