import java.time.LocalDate;
import java.time.LocalTime;


public class Consulta{
    private Mascota mascotaEnConsulta;
    private User responsableCita;
    private String motivoConsutla;
    private LocalTime horaConsulta;
    private LocalDate fechaConsulta;
    private Boolean consultaPendiente;
    

    public Consulta(Mascota mascotaEnConsulta, User responsableCita, String motivoConsutla, LocalTime horaConsulta, LocalDate fechaConsulta){
        this.mascotaEnConsulta = mascotaEnConsulta;
        this.responsableCita = responsableCita;
        this.motivoConsutla = motivoConsutla;
        this.horaConsulta = horaConsulta;
        this.fechaConsulta = fechaConsulta;
        this.consultaPendiente = true;
    }


    public String showInfoConsulta() {
    return "• Responsable" + responsableCita + 
            "• Mascota" + mascotaEnConsulta + 
            "• Motivo" + motivoConsutla + 
            "• Fecha" + fechaConsulta;
    }

    public Mascota getMascotaEnConsulta(){
        return mascotaEnConsulta;
    }

    public User getResponsableCita(){
        return responsableCita;
    }

    public String getMotivoConsulta(){
        return motivoConsutla;
    }

    public LocalDate getFechaConsulta(){
        return fechaConsulta;
    }

    public LocalTime getHoraConsulta(){
        return horaConsulta;
    }

    public boolean isPendiente(){
        return consultaPendiente;
    }

    public void marcarCompletada(){
        this.consultaPendiente = false;
    }
}