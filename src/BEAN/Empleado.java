package BEAN;
public class Empleado {
    private int IdEmpleado;
    private String IdEtnia;
    private String IdEstCivil;
    private String IdGenero;
    private String Apellidos;
    private String Nombres;
    private String FechNac;
    private String IdEstado;

    public Empleado() {
    }

    public Empleado(int IdEmpleado, String IdEtnia, String IdEstCivil, String IdGenero, String Apellidos, String Nombres, String FechNac, String IdEstado) {
        this.IdEmpleado = IdEmpleado;
        this.IdEtnia = IdEtnia;
        this.IdEstCivil = IdEstCivil;
        this.IdGenero = IdGenero;
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
        this.FechNac = FechNac;
        this.IdEstado = IdEstado;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getIdEtnia() {
        return IdEtnia;
    }

    public void setIdEtnia(String IdEtnia) {
        this.IdEtnia = IdEtnia;
    }

    public String getIdEstCivil() {
        return IdEstCivil;
    }

    public void setIdEstCivil(String IdEstCivil) {
        this.IdEstCivil = IdEstCivil;
    }

    public String getIdGenero() {
        return IdGenero;
    }

    public void setIdGenero(String IdGenero) {
        this.IdGenero = IdGenero;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getFechNac() {
        return FechNac;
    }

    public void setFechNac(String FechNac) {
        this.FechNac = FechNac;
    }

    public String getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(String IdEstado) {
        this.IdEstado = IdEstado;
    }
}
