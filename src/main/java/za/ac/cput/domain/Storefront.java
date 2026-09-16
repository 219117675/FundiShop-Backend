package za.ac.cput.domain;



import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "storefronts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class Storefront {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "fundi_profile_id", nullable = false, unique = true)
    private FundiProfile fundiProfile;

    @Column(nullable = false)
    private String name;

    private String logoUrl;

    @Column(length = 1000)
    private String description;

    private String serviceArea;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}

