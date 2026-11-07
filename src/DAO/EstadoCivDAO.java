package DAO;
import BEAN.EstadoCiv;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class EstadoCivDAO {
    public Vector<EstadoCiv> listaEstadosCiviles(String cad)throws java.sql.SQLException{
        ResultSet rst;
        DbBean db;
        db = new DbBean();
        Vector<EstadoCiv> lista;
        lista = new Vector<EstadoCiv>();
        String sql;
        sql = "select IdEstCiv, descrip from dbo.EstadoCiv";
        if(!cad.isEmpty()){
            sql = sql + " where descrip like N'"+ cad.replace("'", "''") +"%'";
        }
        sql += " order by IdEstCiv";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            rst = db.resultadoSQL(sql);
            while(rst.next()){
                EstadoCiv est = new EstadoCiv();
                est.setIdEstCiv(rst.getInt(1));
                est.setDescrip(rst.getString(2));
                lista.addElement(est);
            }
            rst.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            throw e;
        }finally{
            db.desconecta();
        }
        return lista;
    }

    public void insertaEstadoCiv(EstadoCiv est)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "insert into dbo.EstadoCiv (descrip) values (N'";
        sql = sql + est.getDescrip().replace("'", "''") +"')";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            db.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            throw e;
        }finally{
            db.desconecta();
        }
    }

    public void actualizaEstadoCiv(EstadoCiv est)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "update dbo.EstadoCiv set descrip = N'"+ est.getDescrip().replace("'", "''") +"' ";
        sql += " where IdEstCiv = "+ est.getIdEstCiv();
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            db.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            throw e;
        }finally{
            db.desconecta();
        }
    }

    public void eliminaEstadoCiv(int id)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "delete from dbo.EstadoCiv where IdEstCiv = "+ id;
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            db.ejecutaSQL(sql);
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            throw e;
        }finally{
            db.desconecta();
        }
    }
}