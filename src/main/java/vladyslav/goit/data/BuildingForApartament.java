package vladyslav.goit.data;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "building_for_apartament")
public class BuildingForApartament {
    @Deprecated
    private BuildingForApartament() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartament_id", nullable = false)
    private Apartament apartament;
}