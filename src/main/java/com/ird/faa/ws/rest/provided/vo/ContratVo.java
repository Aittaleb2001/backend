package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class ContratVo {

    private String id ;
    private String numPolice ;
    private String numAttestation ;
    private String dateEffet ;
    private String dateEcheance ;
    private String dateSignature ;
    private String periode ;


            private String dateEffetMax ;
            private String dateEffetMin ;
            private String dateEcheanceMax ;
            private String dateEcheanceMin ;
            private String dateSignatureMax ;
            private String dateSignatureMin ;

        private QuittancePrimeVo quittancePrimeVo ;
        private NatureContratVo natureContratVo ;
        private VehiculeVo vehiculeVo ;
        private ClientVo clientVo ;

    private List<ContratGarantieVo> contratGarantiesVo ;

    public ContratVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getNumPolice(){
        return this.numPolice;
        }

        public void setNumPolice(String numPolice){
        this.numPolice = numPolice;
        }
        public String getNumAttestation(){
        return this.numAttestation;
        }

        public void setNumAttestation(String numAttestation){
        this.numAttestation = numAttestation;
        }
        public String getDateEffet(){
        return this.dateEffet;
        }

        public void setDateEffet(String dateEffet){
        this.dateEffet = dateEffet;
        }
        public String getDateEcheance(){
        return this.dateEcheance;
        }

        public void setDateEcheance(String dateEcheance){
        this.dateEcheance = dateEcheance;
        }
        public String getDateSignature(){
        return this.dateSignature;
        }

        public void setDateSignature(String dateSignature){
        this.dateSignature = dateSignature;
        }
        public String getPeriode(){
        return this.periode;
        }

        public void setPeriode(String periode){
        this.periode = periode;
        }


            public String getDateEffetMax(){
            return this.dateEffetMax;
            }

            public String getDateEffetMin(){
            return this.dateEffetMin;
            }

            public void setDateEffetMax(String dateEffetMax){
            this.dateEffetMax = dateEffetMax;
            }

            public void setDateEffetMin(String dateEffetMin){
            this.dateEffetMin = dateEffetMin;
            }

            public String getDateEcheanceMax(){
            return this.dateEcheanceMax;
            }

            public String getDateEcheanceMin(){
            return this.dateEcheanceMin;
            }

            public void setDateEcheanceMax(String dateEcheanceMax){
            this.dateEcheanceMax = dateEcheanceMax;
            }

            public void setDateEcheanceMin(String dateEcheanceMin){
            this.dateEcheanceMin = dateEcheanceMin;
            }

            public String getDateSignatureMax(){
            return this.dateSignatureMax;
            }

            public String getDateSignatureMin(){
            return this.dateSignatureMin;
            }

            public void setDateSignatureMax(String dateSignatureMax){
            this.dateSignatureMax = dateSignatureMax;
            }

            public void setDateSignatureMin(String dateSignatureMin){
            this.dateSignatureMin = dateSignatureMin;
            }


        public QuittancePrimeVo getQuittancePrimeVo(){
        return this.quittancePrimeVo;
        }

        public void setQuittancePrimeVo(QuittancePrimeVo quittancePrimeVo){
        this.quittancePrimeVo = quittancePrimeVo;
        }
        public NatureContratVo getNatureContratVo(){
        return this.natureContratVo;
        }

        public void setNatureContratVo(NatureContratVo natureContratVo){
        this.natureContratVo = natureContratVo;
        }
        public VehiculeVo getVehiculeVo(){
        return this.vehiculeVo;
        }

        public void setVehiculeVo(VehiculeVo vehiculeVo){
        this.vehiculeVo = vehiculeVo;
        }
        public ClientVo getClientVo(){
        return this.clientVo;
        }

        public void setClientVo(ClientVo clientVo){
        this.clientVo = clientVo;
        }


        public List<ContratGarantieVo> getContratGarantiesVo(){
        return this.contratGarantiesVo;
        }

        public void setContratGarantiesVo(List<ContratGarantieVo> contratGarantiesVo){
            this.contratGarantiesVo = contratGarantiesVo;
            }

            }
