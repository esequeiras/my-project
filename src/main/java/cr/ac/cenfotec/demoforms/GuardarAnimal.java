package cr.ac.cenfotec.demoforms;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Named;

@Named
public class GuardarAnimal implements JavaDelegate {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String tipoAnimal = (String) delegateExecution.getVariable("tipoAnimal");
        String raza = (String) delegateExecution.getVariable("raza");
        String sexo = (String) delegateExecution.getVariable("sexo");
        String procedencia = (String) delegateExecution.getVariable("procedencia");



        Animal tempAnimal = new Animal(tipoAnimal,raza,sexo,procedencia);
        Helper helper = new Helper();
        int id = helper.crearId();
        delegateExecution.setVariable("idExpediente",id+"");;

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS ANIMAL(id int ,tipoAnimal varchar(255),raza varchar(255),sexo varchar(255),procedencia varchar(255))");

        jdbcTemplate.update("Insert into ANIMAL (id,tipoAnimal, raza,sexo,procedencia) " +
                " values (?,?,?,?,?)",id,tipoAnimal,raza, sexo,procedencia);



    }
}
