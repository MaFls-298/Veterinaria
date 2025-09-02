import java.io.*;
import java.util.*;

public class VetController{
    private List<User> responsablesList = new ArrayList<>();
    private List<Mascota>  mascotasList = new ArrayList<>();
    private List<Consulta> consultasList = new ArrayList<>();

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
        saveUsersCSV();
    }

    public void delUser(User responsable){
        responsablesList.remove(responsable);
        mascotasList.removeIf(mascota -> mascota.getResponsable().equals(responsable));
        saveUsersCSV();
        saveMascotasCSV();

    }

    public void addMascota(User responsable, Mascota mascota){
        responsable.addUserMascota(mascota);
        mascotasList.add(mascota);
        saveMascotasCSV();
    }

    public void delMascota(Mascota mascota){
        mascotasList.remove(mascota);
        mascota.getResponsable().getPetIdList().remove(mascota);
        saveMascotasCSV();
    }
    public void addConsulta(Consulta consulta){
        consultasList.add(consulta);
        consulta.getResponsableCita().addUserConsulta(consulta);
    }

    public void delConsulta(Consulta consulta){
        consultasList.remove(consulta);
        consulta.getResponsableCita().getConsultasList().remove(consulta);
    }



////////////////////////

private void saveUsersCSV() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(userFile));
            for (User responsable : responsablesList){
                bw.write(responsable.getNombre() + "," + responsable.getNumero());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e){
        }
    }

    private void loadUsersCSV(){
        File file = new File(userFile);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] col = linea.split(",");
                String nombre = col[1];
                int numero = Integer.parseInt(col[2]);
                responsablesList.add(new User(nombre, numero, new ArrayList<>(), new ArrayList<>()));
            }
            br.close();
        } catch (IOException e){
        }
    }

    private void saveMascotasCSV() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(mascotasFile));
            for (Mascota mascota : mascotasList) {
                bw.write(mascota.getPetID() + "," + mascota.getEspecie() + "," + mascota.getEdad() + "," + mascota.getResponsable().getNumero());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
        }
    }

    private void loadMascotasCSV() {
        File file = new File(mascotasFile);
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String lineaa;
            while ((lineaa = br.readLine()) != null) {
                String[] col = lineaa.split(",");
                int petID = Integer.parseInt(col[0]);
                String especie = col[1];
                int edad = Integer.parseInt(col[2]);
                int numeroResponsable = Integer.parseInt(col[3]);

                User user = null;
                for (User responsable : responsablesList) {
                    if (responsable.getNumero() == numeroResponsable) {
                        user = responsable;
                        break;
                    }
                }

                if (user != null) {
                    Mascota mascota = new Mascota(petID, especie, edad, user);
                    mascotasList.add(mascota);
                    user.addUserMascota(mascota);
                }
            }
            br.close();
        } catch (IOException except) {
            
        }
    }





    public List<User> getResponsablesList(){ 
        return responsablesList; 
    }
    public List<Mascota> getMascotasList(){
        return mascotasList; 
    }
    public List<Consulta> getConsultasList(){ 
        return consultasList; 
    }
    
}
    