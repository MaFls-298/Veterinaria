public class Mascota{
    private int petID;
    private String especie;
    private int edad;
    private User responsable;

    public Mascota(int petID, String especie, int edad, User responsable){
        this.petID = petID;
        this.especie = especie;
        this.edad = edad;
        this.responsable = responsable;
    }

    public int getPetID(){
        return petID;
    }

    public String  getEspecie(){
        return especie;
    }

    public int getEdad(){
        return edad;
    }

    public User getResponsable(){
        return responsable;
    }

}