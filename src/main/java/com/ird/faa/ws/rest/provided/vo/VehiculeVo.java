package  com.ird.faa.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class VehiculeVo {

    private String id ;
    private String reference ;
    private String codeVerification ;
    private String matricule ;
    private String cylindree ;
    private String version ;
    private String poidsEncharge ;
    private String nombrePlaces ;
    private String puissanceFiscale ;


            private String cylindreeMax ;
            private String cylindreeMin ;
            private String poidsEnchargeMax ;
            private String poidsEnchargeMin ;
            private String nombrePlacesMax ;
            private String nombrePlacesMin ;

        private CarburantVo carburantVo ;
        private TypeVehiculeVo typeVehiculeVo ;
        private ClientVo clientVo ;
        private ContratVo contratVo ;
        private MarqueVo marqueVo ;


    public VehiculeVo(){
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
        public String getCodeVerification(){
        return this.codeVerification;
        }

        public void setCodeVerification(String codeVerification){
        this.codeVerification = codeVerification;
        }
        public String getMatricule(){
        return this.matricule;
        }

        public void setMatricule(String matricule){
        this.matricule = matricule;
        }
        public String getCylindree(){
        return this.cylindree;
        }

        public void setCylindree(String cylindree){
        this.cylindree = cylindree;
        }
        public String getVersion(){
        return this.version;
        }

        public void setVersion(String version){
        this.version = version;
        }
        public String getPoidsEncharge(){
        return this.poidsEncharge;
        }

        public void setPoidsEncharge(String poidsEncharge){
        this.poidsEncharge = poidsEncharge;
        }
        public String getNombrePlaces(){
        return this.nombrePlaces;
        }

        public void setNombrePlaces(String nombrePlaces){
        this.nombrePlaces = nombrePlaces;
        }
        public String getPuissanceFiscale(){
        return this.puissanceFiscale;
        }

        public void setPuissanceFiscale(String puissanceFiscale){
        this.puissanceFiscale = puissanceFiscale;
        }


            public String getCylindreeMax(){
            return this.cylindreeMax;
            }

            public String getCylindreeMin(){
            return this.cylindreeMin;
            }

            public void setCylindreeMax(String cylindreeMax){
            this.cylindreeMax = cylindreeMax;
            }

            public void setCylindreeMin(String cylindreeMin){
            this.cylindreeMin = cylindreeMin;
            }

            public String getPoidsEnchargeMax(){
            return this.poidsEnchargeMax;
            }

            public String getPoidsEnchargeMin(){
            return this.poidsEnchargeMin;
            }

            public void setPoidsEnchargeMax(String poidsEnchargeMax){
            this.poidsEnchargeMax = poidsEnchargeMax;
            }

            public void setPoidsEnchargeMin(String poidsEnchargeMin){
            this.poidsEnchargeMin = poidsEnchargeMin;
            }

            public String getNombrePlacesMax(){
            return this.nombrePlacesMax;
            }

            public String getNombrePlacesMin(){
            return this.nombrePlacesMin;
            }

            public void setNombrePlacesMax(String nombrePlacesMax){
            this.nombrePlacesMax = nombrePlacesMax;
            }

            public void setNombrePlacesMin(String nombrePlacesMin){
            this.nombrePlacesMin = nombrePlacesMin;
            }


        public CarburantVo getCarburantVo(){
        return this.carburantVo;
        }

        public void setCarburantVo(CarburantVo carburantVo){
        this.carburantVo = carburantVo;
        }
        public TypeVehiculeVo getTypeVehiculeVo(){
        return this.typeVehiculeVo;
        }

        public void setTypeVehiculeVo(TypeVehiculeVo typeVehiculeVo){
        this.typeVehiculeVo = typeVehiculeVo;
        }
        public ClientVo getClientVo(){
        return this.clientVo;
        }

        public void setClientVo(ClientVo clientVo){
        this.clientVo = clientVo;
        }
        public ContratVo getContratVo(){
        return this.contratVo;
        }

        public void setContratVo(ContratVo contratVo){
        this.contratVo = contratVo;
        }
        public MarqueVo getMarqueVo(){
        return this.marqueVo;
        }

        public void setMarqueVo(MarqueVo marqueVo){
        this.marqueVo = marqueVo;
        }


            }
