package com.ird.faa.bean;

import java.util.Objects;



    import java.math.BigDecimal;
import javax.persistence.*;



@Entity
@Table(name = "quittance_prime")
public class QuittancePrime   {

@Id
    @SequenceGenerator(name="quittance_prime_seq",sequenceName="quittance_prime_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="quittance_prime_seq")
private Long id;

            private BigDecimal primeNette ;
            private BigDecimal taxe ;
            @Column(length = 500)
            private String accessoires;
            private BigDecimal totalTtc ;
            private BigDecimal totalQuittance ;
            private BigDecimal totalPaye ;
            private BigDecimal rest ;

    @ManyToOne
    private Contrat contrat ;


public QuittancePrime(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public BigDecimal getPrimeNette(){
            return this.primeNette;
            }
            public void setPrimeNette(BigDecimal primeNette){
            this.primeNette = primeNette;
            }
            public BigDecimal getTaxe(){
            return this.taxe;
            }
            public void setTaxe(BigDecimal taxe){
            this.taxe = taxe;
            }
            public String getAccessoires(){
            return this.accessoires;
            }
            public void setAccessoires(String accessoires){
            this.accessoires = accessoires;
            }
            public BigDecimal getTotalTtc(){
            return this.totalTtc;
            }
            public void setTotalTtc(BigDecimal totalTtc){
            this.totalTtc = totalTtc;
            }
            public BigDecimal getTotalQuittance(){
            return this.totalQuittance;
            }
            public void setTotalQuittance(BigDecimal totalQuittance){
            this.totalQuittance = totalQuittance;
            }
            public BigDecimal getTotalPaye(){
            return this.totalPaye;
            }
            public void setTotalPaye(BigDecimal totalPaye){
            this.totalPaye = totalPaye;
            }
            public BigDecimal getRest(){
            return this.rest;
            }
            public void setRest(BigDecimal rest){
            this.rest = rest;
            }
            public Contrat getContrat(){
            return this.contrat;
            }
            public void setContrat(Contrat contrat){
            this.contrat = contrat;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuittancePrime quittancePrime = (QuittancePrime) o;
        return id != null && id.equals(quittancePrime.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

