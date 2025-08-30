import java.util.ArrayList;
import java.util.List;

public class VetController{
    private List<User> responsablesList;
    private List<Mascota> mascotasList;
    private List<Consulta> consultasList;

    public VetController(List<User> responsableList, List<Mascota> mascotaList, List<Consulta> consultaList) {
        this.responsablesList = new ArrayList<>();
        this.mascotasList = new ArrayList<>();
        this.consultasList = new ArrayList<>();

    }

    public void addUser(User responsable){
        responsablesList.add(responsable);
    }

    public void addMascota(User responsable, Mascota mascota){
        responsable.addUserMascota(mascota);
        mascotasList.add(mascota);
    }

    public void addConsulta(Consulta c){
        c.getResponsableCita().addUserConsulta(c);
    }

    public String sendReminder(User responsable, Consulta c) {
        return "Recordatorio para " + responsable.getNombre() + ": consulta de "
                + c.getMascotaEnConsulta() + " el día " + c.getFechaConsulta() + "para " + c.getMotivoConsulta();
    }

}