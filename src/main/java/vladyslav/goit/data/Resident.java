package vladyslav.goit.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resident")
public class Resident {
    @Deprecated
    private Resident() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "entry_for_ap", nullable = false)
    private boolean entry;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartament_ID")
    private Apartament apartament;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "participant_ID")
    private ParticipantOsbb participantOsbb;
}