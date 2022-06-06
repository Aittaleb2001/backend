package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "sinistre")
public class Sinistre   {

@Id
    @SequenceGenerator(name="sinistre_seq",sequenceName="sinistre_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sinistre_seq")
private Long id;

            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String description;
            @Column(length = 500)
            private String cause;
            @Column(length = 500)
            private String objet;

    @ManyToOne
    private TypeSinistre typeSinistre ;
    @ManyToOne
    private Client client ;


public Sinistre(){
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
            public String getDescription(){
            return this.description;
            }
            public void setDescription(String description){
            this.description = description;
            }
            public String getCause(){
            return this.cause;
            }
            public void setCause(String cause){
            this.cause = cause;
            }
            public String getObjet(){
            return this.objet;
            }
            public void setObjet(String objet){
            this.objet = objet;
            }
            public TypeSinistre getTypeSinistre(){
            return this.typeSinistre;
            }
            public void setTypeSinistre(TypeSinistre typeSinistre){
            this.typeSinistre = typeSinistre;
            }
            public Client getClient(){
            return this.client;
            }
            public void setClient(Client client){
            this.client = client;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sinistre sinistre = (Sinistre) o;
        return id != null && id.equals(sinistre.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

