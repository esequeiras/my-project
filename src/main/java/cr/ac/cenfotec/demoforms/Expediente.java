package cr.ac.cenfotec.demoforms;

public class Expediente {
    private String fecha;
    private String peso;
    private String condicion;
    private String enfermedades;
    private String comportamiento;
    private int idAnimal;


    public Expediente(int id,String fecha, String peso, String enfermedades, String comportamiento,String condicion) {
        this.idAnimal = id;
        this.fecha = fecha;
        this.peso = peso;
        this.condicion = condicion;
        this.enfermedades = enfermedades;
        this.comportamiento = comportamiento;

    }



    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(String comportamiento) {
        this.comportamiento = comportamiento;
    }


    @Override
    public String toString() {
        return "Expediente{" +
                "fecha='" + fecha + '\'' +
                ", peso='" + peso + '\'' +
                ", condicion='" + condicion + '\'' +
                ", enfermedades='" + enfermedades + '\'' +
                ", comportamiento='" + comportamiento + '\'' +
                ", idAnimal=" + idAnimal +
                '}';
    }
    public String toString1(){
       return  "fecha: "+fecha+" / "+"peso: "+peso+" / "+"condicion: "+condicion+" / "+"enfemedades: "+enfermedades+" / "+"comportamiento: "+comportamiento+" ";
    }
}
