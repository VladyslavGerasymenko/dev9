package vladyslav.goit.data;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "apartaments")
public class Apartament {

    @Deprecated
    private Apartament() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "apartament", nullable = false)
    private int apartament;

    @Column(name = "entrance", nullable = false)
    private byte entrance;

    @Column(name = "floor", nullable = false)
    private byte floor;

    @Column(name = "square", nullable = false)
    private float square;

    @OneToMany(mappedBy = "apartament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BuildingForApartament> buildingForApartament = new ArrayList<>();

    @OneToMany(mappedBy = "apartament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resident> resident = new ArrayList<>();


}
