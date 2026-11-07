package DAO;
import BEAN.Estado;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class EstadoDAO {
    public Vector<Estado> listaEstados(String cad)throws java.sql.SQLException{
        ResultSet rst;
        DbBean db;
        db = new DbBean();
        Vector<Estado> lista;
        lista = new Vector<Estado>();
        String sql;
        sql = "select IdEstado, DescEstado from dbo.Estado";
        if(!cad.isEmpty()){
            sql = sql + " where DescEstado like N'"+ cad.replace("'", "''") +"%'";
        }
        sql += " order by IdEstado";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            rst = db.resultadoSQL(sql);
            while(rst.next()){
                Estado est = new Estado();
                est.setIdEstado(rst.getInt(1));
                est.setDescEstado(rst.getString(2));
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

    public void insertaEstado(Estado est)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "insert into dbo.Estado (DescEstado) values (N'";
        sql = sql + est.getDescEstado().replace("'", "''") +"')";
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

    public void actualizaEstado(Estado est)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "update dbo.Estado set DescEstado = N'"+ est.getDescEstado().replace("'", "''") +"' ";
        sql += " where IdEstado = "+ est.getIdEstado();
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

    public void eliminaEstado(int id)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "delete from dbo.Estado where IdEstado = "+ id;
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