package  com.ird.faa.ws.rest.provided.vo;

    import java.math.BigDecimal;

public class QuittancePrimeVo {

    private String id ;
    private String primeNette ;
    private String taxe ;
    private String accessoires ;
    private String totalTtc ;
    private String totalQuittance ;
    private String totalPaye ;
    private String rest ;


            private String primeNetteMax ;
            private String primeNetteMin ;
            private String taxeMax ;
            private String taxeMin ;
            private String totalTtcMax ;
            private String totalTtcMin ;
            private String totalQuittanceMax ;
            private String totalQuittanceMin ;
            private String totalPayeMax ;
            private String totalPayeMin ;
            private String restMax ;
            private String restMin ;

        private ContratVo contratVo ;


    public QuittancePrimeVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getPrimeNette(){
        return this.primeNette;
        }

        public void setPrimeNette(String primeNette){
        this.primeNette = primeNette;
        }
        public String getTaxe(){
        return this.taxe;
        }

        public void setTaxe(String taxe){
        this.taxe = taxe;
        }
        public String getAccessoires(){
        return this.accessoires;
        }

        public void setAccessoires(String accessoires){
        this.accessoires = accessoires;
        }
        public String getTotalTtc(){
        return this.totalTtc;
        }

        public void setTotalTtc(String totalTtc){
        this.totalTtc = totalTtc;
        }
        public String getTotalQuittance(){
        return this.totalQuittance;
        }

        public void setTotalQuittance(String totalQuittance){
        this.totalQuittance = totalQuittance;
        }
        public String getTotalPaye(){
        return this.totalPaye;
        }

        public void setTotalPaye(String totalPaye){
        this.totalPaye = totalPaye;
        }
        public String getRest(){
        return this.rest;
        }

        public void setRest(String rest){
        this.rest = rest;
        }


            public String getPrimeNetteMax(){
            return this.primeNetteMax;
            }

            public String getPrimeNetteMin(){
            return this.primeNetteMin;
            }

            public void setPrimeNetteMax(String primeNetteMax){
            this.primeNetteMax = primeNetteMax;
            }

            public void setPrimeNetteMin(String primeNetteMin){
            this.primeNetteMin = primeNetteMin;
            }

            public String getTaxeMax(){
            return this.taxeMax;
            }

            public String getTaxeMin(){
            return this.taxeMin;
            }

            public void setTaxeMax(String taxeMax){
            this.taxeMax = taxeMax;
            }

            public void setTaxeMin(String taxeMin){
            this.taxeMin = taxeMin;
            }

            public String getTotalTtcMax(){
            return this.totalTtcMax;
            }

            public String getTotalTtcMin(){
            return this.totalTtcMin;
            }

            public void setTotalTtcMax(String totalTtcMax){
            this.totalTtcMax = totalTtcMax;
            }

            public void setTotalTtcMin(String totalTtcMin){
            this.totalTtcMin = totalTtcMin;
            }

            public String getTotalQuittanceMax(){
            return this.totalQuittanceMax;
            }

            public String getTotalQuittanceMin(){
            return this.totalQuittanceMin;
            }

            public void setTotalQuittanceMax(String totalQuittanceMax){
            this.totalQuittanceMax = totalQuittanceMax;
            }

            public void setTotalQuittanceMin(String totalQuittanceMin){
            this.totalQuittanceMin = totalQuittanceMin;
            }

            public String getTotalPayeMax(){
            return this.totalPayeMax;
            }

            public String getTotalPayeMin(){
            return this.totalPayeMin;
            }

            public void setTotalPayeMax(String totalPayeMax){
            this.totalPayeMax = totalPayeMax;
            }

            public void setTotalPayeMin(String totalPayeMin){
            this.totalPayeMin = totalPayeMin;
            }

            public String getRestMax(){
            return this.restMax;
            }

            public String getRestMin(){
            return this.restMin;
            }

            public void setRestMax(String restMax){
            this.restMax = restMax;
            }

            public void setRestMin(String restMin){
            this.restMin = restMin;
            }


        public ContratVo getContratVo(){
        return this.contratVo;
        }

        public void setContratVo(ContratVo contratVo){
        this.contratVo = contratVo;
        }


            }
