
import java.util.ArrayList;

public class User{
    private String nombre;
    private int numero;
    private ArrayList<Mascota> userPetList; 
    private ArrayList<Consulta> userConsultasList;

    public User(String nombre, int numero, ArrayList<Mascota> petIdList, ArrayList<Consulta> consultasList){
        this.nombre = nombre;
        this.numero = numero;
        this.userPetList = new ArrayList<>();
        this.userConsultasList = new ArrayList<>();
    }

    public void addUserMascota(Mascota mascota){
        userPetList.add(mascota);
    }

    public void addUserConsulta(Consulta consulta){
        userConsultasList.add(consulta);
    }


    public String getNombre(){
        return nombre;
    }

    public int getNumero(){
        return numero;
    }

    public ArrayList<Mascota> getPetIdList(){
    return userPetList;
    }

    public ArrayList<Consulta> getConsultasList(){
        return userConsultasList;
            }


}