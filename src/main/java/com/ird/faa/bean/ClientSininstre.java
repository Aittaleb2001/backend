package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "client_sininstre")
public class ClientSininstre   {

@Id
    @SequenceGenerator(name="client_sininstre_seq",sequenceName="client_sininstre_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="client_sininstre_seq")
private Long id;

            @Column(length = 500)
            private String ref;
            @Column(length = 500)
            private String numPolice;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateSinistre ;
            @Column(length = 500)
            private String responsabilite;
            private BigDecimal numOrdre ;
            @Column(length = 500)
            private String refReglement;
            private BigDecimal montantExpertise ;
            private BigDecimal montantIndemniser ;
            @Lob
            @Column(columnDefinition="TEXT")
            private String observation;

    @ManyToOne
    private Client client ;
    @ManyToOne
    private Sinistre sinistre ;
    @ManyToOne
    private QuittanceIndemniser quittanceIndemniser ;


public ClientSininstre(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getRef(){
            return this.ref;
            }
            public void setRef(String ref){
            this.ref = ref;
            }
            public String getNumPolice(){
            return this.numPolice;
            }
            public void setNumPolice(String numPolice){
            this.numPolice = numPolice;
            }
            public Date getDateSinistre(){
            return this.dateSinistre;
            }
            public void setDateSinistre(Date dateSinistre){
            this.dateSinistre = dateSinistre;
            }
            public String getResponsabilite(){
            return this.responsabilite;
            }
            public void setResponsabilite(String responsabilite){
            this.responsabilite = responsabilite;
            }
            public BigDecimal getNumOrdre(){
            return this.numOrdre;
            }
            public void setNumOrdre(BigDecimal numOrdre){
            this.numOrdre = numOrdre;
            }
            public String getRefReglement(){
            return this.refReglement;
            }
            public void setRefReglement(String refReglement){
            this.refReglement = refReglement;
            }
            public BigDecimal getMontantExpertise(){
            return this.montantExpertise;
            }
            public void setMontantExpertise(BigDecimal montantExpertise){
            this.montantExpertise = montantExpertise;
            }
            public BigDecimal getMontantIndemniser(){
            return this.montantIndemniser;
            }
            public void setMontantIndemniser(BigDecimal montantIndemniser){
            this.montantIndemniser = montantIndemniser;
            }
            public String getObservation(){
            return this.observation;
            }
            public void setObservation(String observation){
            this.observation = observation;
            }
            public Client getClient(){
            return this.client;
            }
            public void setClient(Client client){
            this.client = client;
            }
            public Sinistre getSinistre(){
            return this.sinistre;
            }
            public void setSinistre(Sinistre sinistre){
            this.sinistre = sinistre;
            }
            public QuittanceIndemniser getQuittanceIndemniser(){
            return this.quittanceIndemniser;
            }
            public void setQuittanceIndemniser(QuittanceIndemniser quittanceIndemniser){
            this.quittanceIndemniser = quittanceIndemniser;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientSininstre clientSininstre = (ClientSininstre) o;
        return id != null && id.equals(clientSininstre.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

