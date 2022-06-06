package com.ird.faa.bean;

import java.util.Objects;



import javax.persistence.*;



@Entity
@Table(name = "contrat_garantie")
public class ContratGarantie   {

@Id
    @SequenceGenerator(name="contrat_garantie_seq",sequenceName="contrat_garantie_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="contrat_garantie_seq")
private Long id;


    @ManyToOne
    private Contrat contrat ;
    @ManyToOne
    private Garantie garantie ;


public ContratGarantie(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Contrat getContrat(){
            return this.contrat;
            }
            public void setContrat(Contrat contrat){
            this.contrat = contrat;
            }
            public Garantie getGarantie(){
            return this.garantie;
            }
            public void setGarantie(Garantie garantie){
            this.garantie = garantie;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratGarantie contratGarantie = (ContratGarantie) o;
        return id != null && id.equals(contratGarantie.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

