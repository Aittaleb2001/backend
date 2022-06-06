package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class ClientSininstreVo {

    private String id ;
    private String ref ;
    private String numPolice ;
    private String dateSinistre ;
    private String responsabilite ;
    private String numOrdre ;
    private String refReglement ;
    private String montantExpertise ;
    private String montantIndemniser ;
    private String observation ;


            private String dateSinistreMax ;
            private String dateSinistreMin ;
            private String numOrdreMax ;
            private String numOrdreMin ;
            private String montantExpertiseMax ;
            private String montantExpertiseMin ;
            private String montantIndemniserMax ;
            private String montantIndemniserMin ;

        private ClientVo clientVo ;
        private SinistreVo sinistreVo ;
        private QuittanceIndemniserVo quittanceIndemniserVo ;


    public ClientSininstreVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
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
        public String getDateSinistre(){
        return this.dateSinistre;
        }

        public void setDateSinistre(String dateSinistre){
        this.dateSinistre = dateSinistre;
        }
        public String getResponsabilite(){
        return this.responsabilite;
        }

        public void setResponsabilite(String responsabilite){
        this.responsabilite = responsabilite;
        }
        public String getNumOrdre(){
        return this.numOrdre;
        }

        public void setNumOrdre(String numOrdre){
        this.numOrdre = numOrdre;
        }
        public String getRefReglement(){
        return this.refReglement;
        }

        public void setRefReglement(String refReglement){
        this.refReglement = refReglement;
        }
        public String getMontantExpertise(){
        return this.montantExpertise;
        }

        public void setMontantExpertise(String montantExpertise){
        this.montantExpertise = montantExpertise;
        }
        public String getMontantIndemniser(){
        return this.montantIndemniser;
        }

        public void setMontantIndemniser(String montantIndemniser){
        this.montantIndemniser = montantIndemniser;
        }
        public String getObservation(){
        return this.observation;
        }

        public void setObservation(String observation){
        this.observation = observation;
        }


            public String getDateSinistreMax(){
            return this.dateSinistreMax;
            }

            public String getDateSinistreMin(){
            return this.dateSinistreMin;
            }

            public void setDateSinistreMax(String dateSinistreMax){
            this.dateSinistreMax = dateSinistreMax;
            }

            public void setDateSinistreMin(String dateSinistreMin){
            this.dateSinistreMin = dateSinistreMin;
            }

            public String getNumOrdreMax(){
            return this.numOrdreMax;
            }

            public String getNumOrdreMin(){
            return this.numOrdreMin;
            }

            public void setNumOrdreMax(String numOrdreMax){
            this.numOrdreMax = numOrdreMax;
            }

            public void setNumOrdreMin(String numOrdreMin){
            this.numOrdreMin = numOrdreMin;
            }

            public String getMontantExpertiseMax(){
            return this.montantExpertiseMax;
            }

            public String getMontantExpertiseMin(){
            return this.montantExpertiseMin;
            }

            public void setMontantExpertiseMax(String montantExpertiseMax){
            this.montantExpertiseMax = montantExpertiseMax;
            }

            public void setMontantExpertiseMin(String montantExpertiseMin){
            this.montantExpertiseMin = montantExpertiseMin;
            }

            public String getMontantIndemniserMax(){
            return this.montantIndemniserMax;
            }

            public String getMontantIndemniserMin(){
            return this.montantIndemniserMin;
            }

            public void setMontantIndemniserMax(String montantIndemniserMax){
            this.montantIndemniserMax = montantIndemniserMax;
            }

            public void setMontantIndemniserMin(String montantIndemniserMin){
            this.montantIndemniserMin = montantIndemniserMin;
            }


        public ClientVo getClientVo(){
        return this.clientVo;
        }

        public void setClientVo(ClientVo clientVo){
        this.clientVo = clientVo;
        }
        public SinistreVo getSinistreVo(){
        return this.sinistreVo;
        }

        public void setSinistreVo(SinistreVo sinistreVo){
        this.sinistreVo = sinistreVo;
        }
        public QuittanceIndemniserVo getQuittanceIndemniserVo(){
        return this.quittanceIndemniserVo;
        }

        public void setQuittanceIndemniserVo(QuittanceIndemniserVo quittanceIndemniserVo){
        this.quittanceIndemniserVo = quittanceIndemniserVo;
        }


            }
