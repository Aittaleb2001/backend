package com.ird.faa.bean;

import java.util.Objects;



    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "vehicule")
public class Vehicule   {

@Id
    @SequenceGenerator(name="vehicule_seq",sequenceName="vehicule_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vehicule_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String codeVerification;
            @Column(length = 500)
            private String matricule;
            private BigDecimal cylindree ;
            @Column(length = 500)
            private String version;
            private BigDecimal poidsEncharge ;
            private BigDecimal nombrePlaces ;
            @Column(length = 500)
            private String puissanceFiscale;

    @ManyToOne
    private Carburant carburant ;
    @ManyToOne
    private TypeVehicule typeVehicule ;
    @ManyToOne
    private Client client ;
    @ManyToOne
    private Contrat contrat ;
    @ManyToOne
    private Marque marque ;


public Vehicule(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getReference(){
            return this.reference;
            }
            public void setReference(String reference){
            this.reference = reference;
            }
            public String getCodeVerification(){
            return this.codeVerification;
            }
            public void setCodeVerification(String codeVerification){
            this.codeVerification = codeVerification;
            }
            public String getMatricule(){
            return this.matricule;
            }
            public void setMatricule(String matricule){
            this.matricule = matricule;
            }
            public BigDecimal getCylindree(){
            return this.cylindree;
            }
            public void setCylindree(BigDecimal cylindree){
            this.cylindree = cylindree;
            }
            public String getVersion(){
            return this.version;
            }
            public void setVersion(String version){
            this.version = version;
            }
            public BigDecimal getPoidsEncharge(){
            return this.poidsEncharge;
            }
            public void setPoidsEncharge(BigDecimal poidsEncharge){
            this.poidsEncharge = poidsEncharge;
            }
            public BigDecimal getNombrePlaces(){
            return this.nombrePlaces;
            }
            public void setNombrePlaces(BigDecimal nombrePlaces){
            this.nombrePlaces = nombrePlaces;
            }
            public String getPuissanceFiscale(){
            return this.puissanceFiscale;
            }
            public void setPuissanceFiscale(String puissanceFiscale){
            this.puissanceFiscale = puissanceFiscale;
            }
            public Carburant getCarburant(){
            return this.carburant;
            }
            public void setCarburant(Carburant carburant){
            this.carburant = carburant;
            }
            public TypeVehicule getTypeVehicule(){
            return this.typeVehicule;
            }
            public void setTypeVehicule(TypeVehicule typeVehicule){
            this.typeVehicule = typeVehicule;
            }
            public Client getClient(){
            return this.client;
            }
            public void setClient(Client client){
            this.client = client;
            }
            public Contrat getContrat(){
            return this.contrat;
            }
            public void setContrat(Contrat contrat){
            this.contrat = contrat;
            }
            public Marque getMarque(){
            return this.marque;
            }
            public void setMarque(Marque marque){
            this.marque = marque;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return id != null && id.equals(vehicule.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

