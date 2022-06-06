package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class QuittanceIndemniserVo {

    private String id ;
    private String reference ;
    private String dateReception ;
    private String dateAjout ;
    private String objet ;
    private String libelle ;


            private String dateReceptionMax ;
            private String dateReceptionMin ;
            private String dateAjoutMax ;
            private String dateAjoutMin ;

        private DeviseVo deviseVo ;


    public QuittanceIndemniserVo(){
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
        public String getDateReception(){
        return this.dateReception;
        }

        public void setDateReception(String dateReception){
        this.dateReception = dateReception;
        }
        public String getDateAjout(){
        return this.dateAjout;
        }

        public void setDateAjout(String dateAjout){
        this.dateAjout = dateAjout;
        }
        public String getObjet(){
        return this.objet;
        }

        public void setObjet(String objet){
        this.objet = objet;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
        }


            public String getDateReceptionMax(){
            return this.dateReceptionMax;
            }

            public String getDateReceptionMin(){
            return this.dateReceptionMin;
            }

            public void setDateReceptionMax(String dateReceptionMax){
            this.dateReceptionMax = dateReceptionMax;
            }

            public void setDateReceptionMin(String dateReceptionMin){
            this.dateReceptionMin = dateReceptionMin;
            }

            public String getDateAjoutMax(){
            return this.dateAjoutMax;
            }

            public String getDateAjoutMin(){
            return this.dateAjoutMin;
            }

            public void setDateAjoutMax(String dateAjoutMax){
            this.dateAjoutMax = dateAjoutMax;
            }

            public void setDateAjoutMin(String dateAjoutMin){
            this.dateAjoutMin = dateAjoutMin;
            }


        public DeviseVo getDeviseVo(){
        return this.deviseVo;
        }

        public void setDeviseVo(DeviseVo deviseVo){
        this.deviseVo = deviseVo;
        }


            }
