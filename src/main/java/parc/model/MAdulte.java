package parc.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("a_adult")
public class MAdulte extends Attraction{
		@Column
		private int minAge;
		@Column
		private double minTaille;
		@Column
		private boolean interdictionPersonnesRisque;
		public MAdulte() {
		}
		public int getMinAge() {
			return minAge;
		}
		public void setMinAge(int minAge) {
			this.minAge = minAge;
		}
		public double getMinTaille() {
			return minTaille;
		}
		public void setMinTaille(double minTaille) {
			this.minTaille = minTaille;
		}
		public boolean isInterdictionPersonnesRisque() {
			return interdictionPersonnesRisque;
		}
		public void setInterdictionPersonnesRisque(boolean interdictionPersonnesRisque) {
			this.interdictionPersonnesRisque = interdictionPersonnesRisque;
		}
		
		
}
