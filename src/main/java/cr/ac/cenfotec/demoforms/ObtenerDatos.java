package cr.ac.cenfotec.demoforms;


import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;
import java.util.List;

@Named
public class ObtenerDatos implements JavaDelegate {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String idExpedinte = (String)delegateExecution.getVariable("idExpediente");
        String fechaLiberacion =(String) delegateExecution.getVariable("diaLiberacion");

        Animal tempAnimal = jdbcTemplate.queryForObject("select *  from Animal where id= "+idExpedinte+"", (rs, rowNum) ->
                new Animal(
                        rs.getInt("id"),
                        rs.getString("tipoAnimal"),
                        rs.getString("raza"),
                        rs.getString("sexo"),
                        rs.getString("procedencia")
                ));
        System.out.println("expediente"+idExpedinte);
        Expediente tempExpedinte = jdbcTemplate.queryForObject("select *  from EXPEDIENTE where id= "+idExpedinte+"", (rs, rowNum) ->
                new Expediente(
                        rs.getInt("id"),
                        rs.getString("fecha"),
                        rs.getString("peso"),
                        rs.getString("enfermedades"),
                        rs.getString("comportamiento"),
                        rs.getString("condicion")
                ));

        delegateExecution.setVariable("idAnimal",tempAnimal.getId());
        delegateExecution.setVariable("tipo",tempAnimal.getTipoAnimal());
        delegateExecution.setVariable("expediente",tempExpedinte.toString1());
        delegateExecution.setVariable("fechaLiberacion",fechaLiberacion);

    }
}
