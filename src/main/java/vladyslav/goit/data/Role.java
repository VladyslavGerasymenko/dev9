package vladyslav.goit.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Deprecated
    private Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "participant_ID")
    private ParticipantOsbb participantOsbb;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleParticipant roleParticipant;

    public enum RoleParticipant{
        PARTICIPANT,
        WORKER,
        MANAGEMENT_MEMBER,
        PRESIDENT
    }
}