package vladyslav.goit.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "participant_osbb")
public class ParticipantOsbb {
    @Deprecated
    private ParticipantOsbb() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "FIO", nullable = false, length = 100)
    private String fio;

    @Column(name = "Email", nullable = false, length = 45, unique = true)
    private String email;

    @Column(name = "phone", nullable = false, length = 25)
    private String phone;

    @Column(name = "data_of_birth")
    private String data;

    @OneToMany(mappedBy = "participant_osbb", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resident> residents = new ArrayList<>();

    @OneToMany(mappedBy = "participant_osbb", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Role> role = new ArrayList<>();
}