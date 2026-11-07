package BEAN;
public class Empresa {
    private int IdEmpresa;
    private String Descrip;
    private String TipoEmp;
    private String Direccion;
    private String Tlf;
    private String PersContacto;
    private String Web;

    public Empresa() {
    }

    public Empresa(int IdEmpresa, String Descrip, String TipoEmp, String Direccion, String Tlf, String PersContacto, String Web) {
        this.IdEmpresa = IdEmpresa;
        this.Descrip = Descrip;
        this.TipoEmp = TipoEmp;
        this.Direccion = Direccion;
        this.Tlf = Tlf;
        this.PersContacto = PersContacto;
        this.Web = Web;
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    public String getTipoEmp() {
        return TipoEmp;
    }

    public void setTipoEmp(String TipoEmp) {
        this.TipoEmp = TipoEmp;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTlf() {
        return Tlf;
    }

    public void setTlf(String Tlf) {
        this.Tlf = Tlf;
    }

    public String getPersContacto() {
        return PersContacto;
    }

    public void setPersContacto(String PersContacto) {
        this.PersContacto = PersContacto;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String Web) {
        this.Web = Web;
    }
}
