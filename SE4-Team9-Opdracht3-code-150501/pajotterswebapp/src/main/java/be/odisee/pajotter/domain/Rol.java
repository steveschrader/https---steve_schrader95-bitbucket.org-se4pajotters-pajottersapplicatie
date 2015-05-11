package be.odisee.pajotter.domain;
import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.Index;

import be.odisee.pajotter.domain.*;

@Entity
@Table(name="rollen")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Rol")
public abstract class Rol implements Serializable{

	 	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    protected int id;

	    // we willen dit even aan de db overlaten
	    // specifieke noden FitLibrary zullen we met een functie oplossen
	    // private static int nextid=1;

	    @Column
	    protected String status;
	    
	    /*@Column
		private String type;*/

	    @Column(unique=true)
	    @Index(name="IRol_usernaam",columnNames="usernaam")
	    protected String usernaam;

	    //@ManyToOne
	    //@JoinColumn(name="sessie_id")
	    //protected Sessie sessie;

	    @ManyToOne
	    @JoinColumn(name="partij_id")
	    protected Partij partij;

	    public Rol(){}

	    public Rol(String status, String usernaam, Partij partij) {
	        this.status = status;
	        this.usernaam = usernaam;
	        //this.sessie = sessie;
	        this.partij = partij;
	    }

	    public Rol(int id, String status, String usernaam, Partij partij) {
	        this.id = id;
	        this.status = status;
	        this.usernaam = usernaam;
	        //this.sessie = sessie;
	        this.partij = partij;
	    }
	   /* public Rol(String status, String usernaam, Partij partij, String type) {
	        this.id = id;
	        this.status = status;
	        this.usernaam = usernaam;
	        this.type = type;
	        this.partij = partij;
	    }*/

	    public int getId() {
	        return id;
	    }

	    //public Sessie getSessie(){
	    //    return sessie;
	    //}

	    public String getUsernaam() {
	        return usernaam;
	    }

	    public abstract String getType();
	   // public abstract String setType();
	    
	    //public void setSessie(Sessie newVal){
	    //    sessie = newVal;
	    //}

	    public Partij getPartij() {
	        return partij;
	    }

	    public void setPartij(Partij partij) {
	        this.partij = partij;
	    }

		/*public void setType(String type) {
			this.type = type;
		}*/
}
