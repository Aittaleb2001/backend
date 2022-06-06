package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "type_vehicule")
public class TypeVehicule   {

@Id
    @SequenceGenerator(name="type_vehicule_seq",sequenceName="type_vehicule_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="type_vehicule_seq")
private Long id;

            @Column(length = 500)
            private String libelle;



public TypeVehicule(){
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
        TypeVehicule typeVehicule = (TypeVehicule) o;
        return id != null && id.equals(typeVehicule.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

