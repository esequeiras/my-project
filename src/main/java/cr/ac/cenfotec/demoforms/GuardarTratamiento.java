package cr.ac.cenfotec.demoforms;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class GuardarTratamiento implements JavaDelegate {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {


        String indicaciones = (String) delegateExecution.getVariable("tratamiento");
        String idExpediente = (String) delegateExecution.getVariable("idExpediente");
        String gravedad = (String) delegateExecution.getVariable("gravedadCirugia");
        String cirugia =(String) delegateExecution.getVariable("cirugia");


        Tratamiento tempTratamiento = new Tratamiento(indicaciones,idExpediente);
        if(cirugia.equals("si")){
            delegateExecution.setVariable("tiempoRecuperacion",tempTratamiento.calcularTimpoRecuperacion(gravedad)+"");
        }else{
            String msj ="El animal se esta recuperando con el tratamiento: " +tempTratamiento.getIndicaciones();
            delegateExecution.setVariable("tiempoRecuperacion",msj);
        }


        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS TRATAMIENTO(id int ,indicaciones varchar(255))");

        jdbcTemplate.update("Insert into TRATAMIENTO (id,indicaciones) " +
                " values (?,?)",idExpediente,indicaciones);




    }
}