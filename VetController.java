import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class VetController{
    private List<User> responsablesList;
    private List<Mascota> mascotasList;
    private List<Consulta> consultasList;

    private final String userFile = "Users.csv";
    private final String mascotasFile = "Mascotas.csv";

    public VetController(){
        responsablesList = new ArrayList<>();
        mascotasList = new ArrayList<>();
        consultasList = new ArrayList<>();

        loadUsersCSV();
        loadMascotasCSV();
        

    }

    public void addUser(User responsable){
        responsablesList.add(responsable);
        saveUsersToCSV();
    }

    public void delUser(User responsable){
        responsablesList.remove(responsable);
        mascotasList.removeIf(masc -> masc.getResponsable().equals(responsable));
        saveUsersToCSV();
        saveMascotasToCSV();

    }

    public void addMascota(User responsable, Mascota mascota){
        responsable.addUserMascota(mascota);
        mascotasList.add(mascota);
    }

    public void addConsulta(Consulta consulta){
        consulta.getResponsableCita().addUserConsulta(consulta);
    }

    public String sendReminder(User responsable, Consulta c) {
        return "Recordatorio para " + responsable.getNombre() + ": consulta de "
                + c.getMascotaEnConsulta() + " el día " + c.getFechaConsulta() + "para " + c.getMotivoConsulta();
    }

}