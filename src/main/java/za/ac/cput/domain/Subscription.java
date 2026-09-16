package za.ac.cput.domain;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "fundi_profile_id", nullable = false, unique = true)
    private FundiProfile fundiProfile;

    @Column(nullable = false)
    private String planName;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal monthlyFee;

    @Builder.Default
    private boolean active = true;

    private LocalDate startDate;

    private LocalDate nextBillingDate;
}
