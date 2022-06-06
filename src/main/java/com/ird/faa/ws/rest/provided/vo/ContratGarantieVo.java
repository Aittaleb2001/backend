package  com.ird.faa.ws.rest.provided.vo;


public class ContratGarantieVo {

    private String id ;



        private ContratVo contratVo ;
        private GarantieVo garantieVo ;


    public ContratGarantieVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public ContratVo getContratVo(){
        return this.contratVo;
        }

        public void setContratVo(ContratVo contratVo){
        this.contratVo = contratVo;
        }
        public GarantieVo getGarantieVo(){
        return this.garantieVo;
        }

        public void setGarantieVo(GarantieVo garantieVo){
        this.garantieVo = garantieVo;
        }


            }
