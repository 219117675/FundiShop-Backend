package za.ac.cput.domain;

import za.ac.cput.domain.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private za.ac.cput.domain.User customer;

    @ManyToOne
    @JoinColumn(name = "fundi_profile_id", nullable = false)
    private FundiProfile fundiProfile;

    @Column(nullable = false)
    private LocalDate scheduledDate;

    @Column(nullable = false)
    private LocalTime scheduledTime;

    @Column(length = 100)
    private String serviceRequired;

    @Column(length = 500)
    private String jobLocation;

    @Column(precision = 10, scale = 2)
    private BigDecimal estimatedBudget;

    @Column(length = 1000)
    private String jobDescription;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private BookingStatus status = BookingStatus.REQUESTED;

    @Column(precision = 10, scale = 2)
    private BigDecimal calloutFee;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}