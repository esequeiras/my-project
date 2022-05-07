package cr.ac.cenfotec.demoforms;

public class Animal {
    private int id;
    private String tipoAnimal;
    private String raza;
    private String sexo;
    private String procedencia;


    public Animal(String tipoAnimal, String raza, String sexo, String procedencia) {

        this.tipoAnimal = tipoAnimal;
        this.raza = raza;
        this.sexo = sexo;
        this.procedencia = procedencia;
    }

    public Animal(int id, String tipoAnimal, String raza, String sexo, String procedencia) {
        this.id = id;
        this.tipoAnimal = tipoAnimal;
        this.raza = raza;
        this.sexo = sexo;
        this.procedencia = procedencia;

    }

    public int generarId(){
        double id = Math.random()*10000;
        return (int) id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", tipoAnimal='" + tipoAnimal + '\'' +
                ", raza='" + raza + '\'' +
                ", sexo='" + sexo + '\'' +
                ", procedencia='" + procedencia + '\'' +
                '}';
    }
}
