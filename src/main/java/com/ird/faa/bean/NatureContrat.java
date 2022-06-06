package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "nature_contrat")
public class NatureContrat   {

@Id
    @SequenceGenerator(name="nature_contrat_seq",sequenceName="nature_contrat_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="nature_contrat_seq")
private Long id;

            @Column(length = 500)
            private String libelle;



public NatureContrat(){
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
        NatureContrat natureContrat = (NatureContrat) o;
        return id != null && id.equals(natureContrat.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

