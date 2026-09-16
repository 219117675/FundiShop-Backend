package za.ac.cput.domain;

import za.ac.cput.domain.enums.TradeCategory;
import za.ac.cput.domain.enums.VerificationStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fundi_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class FundiProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private za.ac.cput.domain.User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TradeCategory tradeCategory;

    @Column(length = 1000)
    private String bio;

    @Column(precision = 10, scale = 2)
    private BigDecimal calloutFee;

    @Column(precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    private Integer serviceAreaRadiusKm;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
