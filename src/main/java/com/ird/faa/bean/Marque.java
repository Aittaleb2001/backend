package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "marque")
public class Marque   {

@Id
    @SequenceGenerator(name="marque_seq",sequenceName="marque_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="marque_seq")
private Long id;

            @Column(length = 500)
            private String libelle;



public Marque(){
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

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque = (Marque) o;
        return id != null && id.equals(marque.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

