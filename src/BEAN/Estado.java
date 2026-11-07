package BEAN;
public class Estado {
    private int IdEstado;
    private String DescEstado;

    public Estado() {
    }

    public Estado(int IdEstado, String DescEstado) {
        this.IdEstado = IdEstado;
        this.DescEstado = DescEstado;
    }

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    public String getDescEstado() {
        return DescEstado;
    }

    public void setDescEstado(String DescEstado) {
        this.DescEstado = DescEstado;
    }
}