package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "devise")
public class Devise   {

@Id
    @SequenceGenerator(name="devise_seq",sequenceName="devise_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="devise_seq")
private Long id;

            @Column(length = 500)
            private String libelle;
            @Column(length = 500)
            private String reference;
            @Column(length = 500)
            private String unite;



public Devise(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getLibelle(){
            return this.libelle;
            }
            public void setLibelle(String libelle){
            this.libelle = libelle;
            }
            public String getReference(){
            return this.reference;
            }
            public void setReference(String reference){
            this.reference = reference;
            }
            public String getUnite(){
            return this.unite;
            }
            public void setUnite(String unite){
            this.unite = unite;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devise devise = (Devise) o;
        return id != null && id.equals(devise.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

