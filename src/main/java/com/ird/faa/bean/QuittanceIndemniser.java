package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "quittance_indemniser")
public class QuittanceIndemniser   {

@Id
    @SequenceGenerator(name="quittance_indemniser_seq",sequenceName="quittance_indemniser_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="quittance_indemniser_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateReception ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateAjout ;
            @Column(length = 500)
            private String objet;
            @Column(length = 500)
            private String libelle;

    @ManyToOne
    private Devise devise ;


public QuittanceIndemniser(){
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
            public Date getDateReception(){
            return this.dateReception;
            }
            public void setDateReception(Date dateReception){
            this.dateReception = dateReception;
            }
            public Date getDateAjout(){
            return this.dateAjout;
            }
            public void setDateAjout(Date dateAjout){
            this.dateAjout = dateAjout;
            }
            public String getObjet(){
            return this.objet;
            }
            public void setObjet(String objet){
            this.objet = objet;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public Devise getDevise(){
            return this.devise;
            }
            public void setDevise(Devise devise){
            this.devise = devise;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuittanceIndemniser quittanceIndemniser = (QuittanceIndemniser) o;
        return id != null && id.equals(quittanceIndemniser.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

