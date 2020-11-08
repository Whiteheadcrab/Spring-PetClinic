package springpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity
{
    @Builder
    public Pet(Long id, String Petname, PetType petType, Owner owner, LocalDate birthDate, Set<Visit> visits) {
        super(id);
        this.Petname = Petname;
        this.PetType = petType;
        this.owner = owner;
        this.birthDate = birthDate;

        if (visits == null || visits.size() > 0 )
        {
            this.visits = visits;
        }
    }

    @Column(name = "name")
    private String Petname;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType PetType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}
