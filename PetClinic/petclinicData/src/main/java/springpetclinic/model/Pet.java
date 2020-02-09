package springpetclinic.model;

import springpetclinic.model.BaseEntity;
import java.time.LocalDate;

public class Pet extends BaseEntity
{
    private PetType getType;
    private Owner owner;
    private LocalDate birthDate;

    public PetType getGetType() {
        return getType;
    }

    public void setGetType(PetType getType) {
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
