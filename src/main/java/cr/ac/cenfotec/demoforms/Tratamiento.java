package cr.ac.cenfotec.demoforms;

public class Tratamiento {
    private String indicaciones;
    private String idExpediente;

    public Tratamiento(String indicaciones, String idExpediente) {
        this.indicaciones = indicaciones;
        this.idExpediente = idExpediente;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(String idExpediente) {
        this.idExpediente = idExpediente;
    }
    public String calcularTimpoRecuperacion(String gravedad){
        String mansaje = "El timpo estimado de recuperacion es de ";
        String msj;
        if(gravedad.equals("muygrave")){
            msj = "90";
        }else if(gravedad.equals("grave")){
            msj ="30";
        }else{
            msj ="15";
        }
        return "El timpo estimado de recuperacion es de "+msj+" dias";
    }
}
