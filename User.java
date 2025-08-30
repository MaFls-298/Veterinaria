
import java.util.ArrayList;

public class User{
    private String nombre;
    private int numero;
    private ArrayList<Mascota> petIdList; 
    private ArrayList<Consulta> consultasList;

    public User(String nombre, int numero, ArrayList<Mascota> petIdList, ArrayList<Consulta> consultasList){
        this.nombre = nombre;
        this.numero = numero;
        this. petIdList = new ArrayList<>();
        this.consultasList = new ArrayList<>();
    }

    public String getNombre(){
        return nombre;
    }

    public int getNumero(){
        return numero;
    }

    public ArrayList<Mascota> getPetIdList(){
    return petIdList;
    }

    public ArrayList<Consulta> getConsultasList(){
        return consultasList;
            }


}