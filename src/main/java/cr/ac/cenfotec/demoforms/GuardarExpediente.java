package cr.ac.cenfotec.demoforms;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.sql.PreparedStatement;

@Named
public class GuardarExpediente implements JavaDelegate {
    int cont =0;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String fecha = (String) delegateExecution.getVariable("fechaControl");
        String peso = (String) delegateExecution.getVariable("peso");
        String enfermedades = (String) delegateExecution.getVariable("enfermedades");
        String comportamiento = (String) delegateExecution.getVariable("comportamiento");
        String condicion = (String) delegateExecution.getVariable("condicion");
        String idExpediente = (String) delegateExecution.getVariable("idExpediente");

        int id = Integer.parseInt(idExpediente);



        Expediente tempExpediente = new Expediente(id,fecha,peso,condicion,enfermedades,comportamiento);

        System.out.println(id);
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS EXPEDIENTE(id int ,fecha varchar(255),peso varchar(255),enfermedades varchar(255),comportamiento varchar(255),condicion varchar(255))");

        if(cont==0){
            jdbcTemplate.update("Insert into EXPEDIENTE (id,fecha, peso,enfermedades,comportamiento,condicion) " +
                    " values (?,?,?,?,?,?)",id,fecha,peso,enfermedades,comportamiento,condicion);

        }else{
             String sqlUpdate = "UPDATE EXPEDIENTE SET fecha =?,peso=?,enfermedades=?,comportamiento =?,condicion=? where id =?";
            jdbcTemplate.update(sqlUpdate,fecha,peso,enfermedades,comportamiento,condicion,id);
        }

        cont++;

    }
}

