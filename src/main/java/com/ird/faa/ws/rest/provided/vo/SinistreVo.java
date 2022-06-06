package  com.ird.faa.ws.rest.provided.vo;


public class SinistreVo {

    private String id ;
    private String reference ;
    private String description ;
    private String cause ;
    private String objet ;



        private TypeSinistreVo typeSinistreVo ;
        private ClientVo clientVo ;


    public SinistreVo(){
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
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getCause(){
        return this.cause;
        }

        public void setCause(String cause){
        this.cause = cause;
        }
        public String getObjet(){
        return this.objet;
        }

        public void setObjet(String objet){
        this.objet = objet;
        }



        public TypeSinistreVo getTypeSinistreVo(){
        return this.typeSinistreVo;
        }

        public void setTypeSinistreVo(TypeSinistreVo typeSinistreVo){
        this.typeSinistreVo = typeSinistreVo;
        }
        public ClientVo getClientVo(){
        return this.clientVo;
        }

        public void setClientVo(ClientVo clientVo){
        this.clientVo = clientVo;
        }


            }
