package BEAN;
public class EstadoCiv {
    private int IdEstCiv;
    private String descrip;

    public EstadoCiv() {
    }

    public EstadoCiv(int IdEstCiv, String descrip) {
        this.IdEstCiv = IdEstCiv;
        this.descrip = descrip;
    }

    public int getIdEstCiv() {
        return IdEstCiv;
    }

    public void setIdEstCiv(int IdEstCiv) {
        this.IdEstCiv = IdEstCiv;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}