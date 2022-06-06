package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "client")
public class Client   {

@Id
    @SequenceGenerator(name="client_seq",sequenceName="client_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="client_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String cin;
            @Column(length = 500)
            private String nom;
            @Column(length = 500)
            private String prenom;
            @Column(length = 500)
            private String activite;
            @Column(length = 500)
            private String adresse;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date datedeNaissance ;
            private BigDecimal numTelephone ;

    @ManyToOne
    private TypeClient typeClient ;

                @OneToMany(mappedBy = "client")
            private List<ClientSininstre> clientSininstres ;
                @OneToMany(mappedBy = "client")
            private List<Vehicule> vehicule ;
                @OneToMany(mappedBy = "client")
            private List<Contrat> contrat ;

public Client(){
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
            public String getCin(){
            return this.cin;
            }
            public void setCin(String cin){
            this.cin = cin;
            }
            public String getNom(){
            return this.nom;
            }
            public void setNom(String nom){
            this.nom = nom;
            }
            public String getPrenom(){
            return this.prenom;
            }
            public void setPrenom(String prenom){
            this.prenom = prenom;
            }
            public String getActivite(){
            return this.activite;
            }
            public void setActivite(String activite){
            this.activite = activite;
            }
            public String getAdresse(){
            return this.adresse;
            }
            public void setAdresse(String adresse){
            this.adresse = adresse;
            }
            public Date getDatedeNaissance(){
            return this.datedeNaissance;
            }
            public void setDatedeNaissance(Date datedeNaissance){
            this.datedeNaissance = datedeNaissance;
            }
            public BigDecimal getNumTelephone(){
            return this.numTelephone;
            }
            public void setNumTelephone(BigDecimal numTelephone){
            this.numTelephone = numTelephone;
            }
            public TypeClient getTypeClient(){
            return this.typeClient;
            }
            public void setTypeClient(TypeClient typeClient){
            this.typeClient = typeClient;
            }
            public List<ClientSininstre> getClientSininstres(){
            return this.clientSininstres;
            }
            public void setClientSininstres(List<ClientSininstre> clientSininstres){
            this.clientSininstres = clientSininstres;
            }
            public List<Vehicule> getVehicule(){
            return this.vehicule;
            }
            public void setVehicule(List<Vehicule> vehicule){
            this.vehicule = vehicule;
            }
            public List<Contrat> getContrat(){
            return this.contrat;
            }
            public void setContrat(List<Contrat> contrat){
            this.contrat = contrat;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id != null && id.equals(client.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

