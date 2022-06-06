package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "contrat")
public class Contrat   {

@Id
    @SequenceGenerator(name="contrat_seq",sequenceName="contrat_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="contrat_seq")
private Long id;

            @Column(length = 500)
            private String numPolice;
            @Column(length = 500)
            private String numAttestation;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateEffet ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateEcheance ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateSignature ;
            @Column(length = 500)
            private String periode;

    @ManyToOne
    private QuittancePrime quittancePrime ;
    @ManyToOne
    private NatureContrat natureContrat ;
    @ManyToOne
    private Vehicule vehicule ;
    @ManyToOne
    private Client client ;

                @OneToMany(mappedBy = "contrat")
            private List<ContratGarantie> contratGaranties ;

public Contrat(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getNumPolice(){
            return this.numPolice;
            }
            public void setNumPolice(String numPolice){
            this.numPolice = numPolice;
            }
            public String getNumAttestation(){
            return this.numAttestation;
            }
            public void setNumAttestation(String numAttestation){
            this.numAttestation = numAttestation;
            }
            public Date getDateEffet(){
            return this.dateEffet;
            }
            public void setDateEffet(Date dateEffet){
            this.dateEffet = dateEffet;
            }
            public Date getDateEcheance(){
            return this.dateEcheance;
            }
            public void setDateEcheance(Date dateEcheance){
            this.dateEcheance = dateEcheance;
            }
            public Date getDateSignature(){
            return this.dateSignature;
            }
            public void setDateSignature(Date dateSignature){
            this.dateSignature = dateSignature;
            }
            public String getPeriode(){
            return this.periode;
            }
            public void setPeriode(String periode){
            this.periode = periode;
            }
            public QuittancePrime getQuittancePrime(){
            return this.quittancePrime;
            }
            public void setQuittancePrime(QuittancePrime quittancePrime){
            this.quittancePrime = quittancePrime;
            }
            public NatureContrat getNatureContrat(){
            return this.natureContrat;
            }
            public void setNatureContrat(NatureContrat natureContrat){
            this.natureContrat = natureContrat;
            }
            public Vehicule getVehicule(){
            return this.vehicule;
            }
            public void setVehicule(Vehicule vehicule){
            this.vehicule = vehicule;
            }
            public Client getClient(){
            return this.client;
            }
            public void setClient(Client client){
            this.client = client;
            }
            public List<ContratGarantie> getContratGaranties(){
            return this.contratGaranties;
            }
            public void setContratGaranties(List<ContratGarantie> contratGaranties){
            this.contratGaranties = contratGaranties;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrat contrat = (Contrat) o;
        return id != null && id.equals(contrat.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

