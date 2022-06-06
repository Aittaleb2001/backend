package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import java.math.BigDecimal;

public class ClientVo {

    private String id ;
    private String reference ;
    private String cin ;
    private String nom ;
    private String prenom ;
    private String activite ;
    private String adresse ;
    private String datedeNaissance ;
    private String numTelephone ;


            private String datedeNaissanceMax ;
            private String datedeNaissanceMin ;
            private String numTelephoneMax ;
            private String numTelephoneMin ;

        private TypeClientVo typeClientVo ;

    private List<ClientSininstreVo> clientSininstresVo ;
    private List<VehiculeVo> vehiculeVo ;
    private List<ContratVo> contratVo ;

    public ClientVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
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
        public String getDatedeNaissance(){
        return this.datedeNaissance;
        }

        public void setDatedeNaissance(String datedeNaissance){
        this.datedeNaissance = datedeNaissance;
        }
        public String getNumTelephone(){
        return this.numTelephone;
        }

        public void setNumTelephone(String numTelephone){
        this.numTelephone = numTelephone;
        }


            public String getDatedeNaissanceMax(){
            return this.datedeNaissanceMax;
            }

            public String getDatedeNaissanceMin(){
            return this.datedeNaissanceMin;
            }

            public void setDatedeNaissanceMax(String datedeNaissanceMax){
            this.datedeNaissanceMax = datedeNaissanceMax;
            }

            public void setDatedeNaissanceMin(String datedeNaissanceMin){
            this.datedeNaissanceMin = datedeNaissanceMin;
            }

            public String getNumTelephoneMax(){
            return this.numTelephoneMax;
            }

            public String getNumTelephoneMin(){
            return this.numTelephoneMin;
            }

            public void setNumTelephoneMax(String numTelephoneMax){
            this.numTelephoneMax = numTelephoneMax;
            }

            public void setNumTelephoneMin(String numTelephoneMin){
            this.numTelephoneMin = numTelephoneMin;
            }


        public TypeClientVo getTypeClientVo(){
        return this.typeClientVo;
        }

        public void setTypeClientVo(TypeClientVo typeClientVo){
        this.typeClientVo = typeClientVo;
        }


        public List<ClientSininstreVo> getClientSininstresVo(){
        return this.clientSininstresVo;
        }

        public void setClientSininstresVo(List<ClientSininstreVo> clientSininstresVo){
            this.clientSininstresVo = clientSininstresVo;
            }

        public List<VehiculeVo> getVehiculeVo(){
        return this.vehiculeVo;
        }

        public void setVehiculeVo(List<VehiculeVo> vehiculeVo){
            this.vehiculeVo = vehiculeVo;
            }

        public List<ContratVo> getContratVo(){
        return this.contratVo;
        }

        public void setContratVo(List<ContratVo> contratVo){
            this.contratVo = contratVo;
            }

            }
