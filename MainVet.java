import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class MainVet{

    private VetController controller = new VetController();

    public void iniciar(){
        JFrame frame = new JFrame("VVETERINARIA");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(); 
        JButton addUserB = new JButton("Anaidr un nuevo cliente");
        JButton addPetB = new JButton("Anadir mascota");
        JButton verResponsableB = new JButton("Ver mascotas y usuarios");
        JButton verConsultasB = new JButton("Ver consultas");
        JButton delUsuarioB = new JButton("Eliminar usuario");
        JButton delMascotaB = new JButton("Eliminar mascota");

        panel.add(addUserB);
        panel.add(addPetB);
        panel.add(verResponsableB);
        panel.add(verConsultasB);
        panel.add(delUsuarioB);
        panel.add(delMascotaB);

        addUserB.addActionListener(e -> {
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String numero = JOptionPane.showInputDialog("Numero:");
            controller.addUser(new User(nombre, Integer.parseInt(numero), new ArrayList<>(), new ArrayList<>()));
        });

    
        addPetB.addActionListener(e -> {
            List<User> users = controller.getResponsablesList();
            String petId = JOptionPane.showInputDialog("PetID");
            String especie = JOptionPane.showInputDialog("Especie");
            String edad = JOptionPane.showInputDialog("Edad:");
            String nResponsable = JOptionPane.showInputDialog("Nombre Responsable:");

            for (User responsable : users) {
                if (responsable.getNombre().equals(nResponsable)) {
                    controller.addMascota(responsable, new Mascota(Integer.parseInt(petId), especie, Integer.parseInt(edad), responsable));
                }
            }
        });

        verResponsableB.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (User responsable : controller.getResponsablesList()) {
                sb.append("Responsable: ").append(responsable.getNombre()).append(" (").append(responsable.getNumero()).append(")\n");
                for (Mascota mascota : responsable.getPetIdList()) {
                    sb.append("   Mascota: ").append(mascota.getEspecie()).append(", ID ").append(mascota.getPetID()).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        });

        verConsultasB.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (Consulta consulta : controller.getConsultasList()) {
                sb.append(consulta.showInfoConsulta()).append("\n");
            }

        });


        delUsuarioB.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nombre del usuario a borrrar");
            for (User responsable : controller.getResponsablesList()) {
                if (responsable.getNombre().equals(name)) {
                    controller.delUser(responsable);
                    break;
                }
            }
        });

        delMascotaB.addActionListener(e -> {
            String petId = JOptionPane.showInputDialog("ID Mascota a borrar");
            for (Mascota mascota : controller.getMascotasList()) {
                if (mascota.getPetID() == Integer.parseInt(petId)) {
                    controller.delMascota(mascota);
                    break;
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainVet().iniciar();
    }
}