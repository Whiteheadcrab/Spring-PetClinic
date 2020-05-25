package springpetclinic.model;

import springpetclinic.model.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity
{
    @Column(name = "name")
    private String Petname;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType getType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public PetType getGetType() {
        return getType;
    }

    public void setGetType(PetType getType) {
        this.getType = getType;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }

    public String getPetname() {
        return Petname;
    }

    public void setPetname(String petname) {
        Petname = petname;
    }

    public PetType getPetType() {
        return getType;
    }

    public void setPetType(PetType getType) {
        this.getType = getType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
