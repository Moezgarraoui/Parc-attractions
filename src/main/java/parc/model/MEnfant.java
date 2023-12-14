package parc.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("a_kid")
public class MEnfant extends Attraction{

}
