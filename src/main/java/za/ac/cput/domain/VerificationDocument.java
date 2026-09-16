package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "verification_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString
public class VerificationDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fundi_profile_id", nullable = false)
    private FundiProfile fundiProfile;

    @Column(nullable = false)
    private String documentType;

    @Column(nullable = false)
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "reviewed_by")
    private User reviewedBy;

    private LocalDateTime reviewedAt;

    private String rejectionReason;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime uploadedAt;
}
