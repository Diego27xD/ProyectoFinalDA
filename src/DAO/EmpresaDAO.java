package DAO;
import BEAN.Empresa;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class EmpresaDAO {
    public Vector<Empresa> listaEmpresas(String cad)throws java.sql.SQLException{
        ResultSet rstEmpresas;
        DbBean db;
        db = new DbBean();
        Vector<Empresa> lista;
        lista = new Vector<Empresa>();
        String sql;
        sql = "select IdEmpresa, Descrip, TipoEmp, Direccion, Tlf, PersContacto, Web from dbo.Empresa";
        if(!cad.isEmpty()){
            sql = sql + " where Descrip like N'"+ cad.replace("'", "''") +"%'";
        }
        sql += " order by IdEmpresa";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            rstEmpresas = db.resultadoSQL(sql);
            while(rstEmpresas.next()){
                Empresa empr = new Empresa();
                empr.setIdEmpresa(rstEmpresas.getInt(1));
                empr.setDescrip(rstEmpresas.getString(2));
                empr.setTipoEmp(rstEmpresas.getString(3));
                empr.setDireccion(rstEmpresas.getString(4));
                empr.setTlf(rstEmpresas.getString(5));
                empr.setPersContacto(rstEmpresas.getString(6));
                empr.setWeb(rstEmpresas.getString(7));
                lista.addElement(empr);
            }
            rstEmpresas.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            throw e;
        }finally{
            db.desconecta();
        }
        return lista;
    }

    public void insertaEmpresa(Empresa empr)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String descrip;
        if(empr.getDescrip() == null || empr.getDescrip().isEmpty()){
            descrip = "NULL";
        }else{
            descrip = "N'"+ empr.getDescrip().replace("'", "''") +"'";
        }
        String tipoEmp;
        if(empr.getTipoEmp() == null || empr.getTipoEmp().isEmpty()){
            tipoEmp = "NULL";
        }else{
            tipoEmp = "N'"+ empr.getTipoEmp().replace("'", "''") +"'";
        }
        String direccion;
        if(empr.getDireccion() == null || empr.getDireccion().isEmpty()){
            direccion = "NULL";
        }else{
            direccion = "N'"+ empr.getDireccion().replace("'", "''") +"'";
        }
        String tlf;
        if(empr.getTlf() == null || empr.getTlf().isEmpty()){
            tlf = "NULL";
        }else{
            tlf = "N'"+ empr.getTlf().replace("'", "''") +"'";
        }
        String persContacto;
        if(empr.getPersContacto() == null || empr.getPersContacto().isEmpty()){
            persContacto = "NULL";
        }else{
            persContacto = "N'"+ empr.getPersContacto().replace("'", "''") +"'";
        }
        String web;
        if(empr.getWeb() == null || empr.getWeb().isEmpty()){
            web = "NULL";
        }else{
            web = "N'"+ empr.getWeb().replace("'", "''") +"'";
        }
        String sql;
        sql = "insert into dbo.Empresa (Descrip, TipoEmp, Direccion, Tlf, PersContacto, Web) values (";
        sql = sql + descrip +", "+ tipoEmp +", "+ direccion +", "+ tlf +", "+ persContacto +", "+ web +")";
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

    public void actualizaEmpresa(Empresa empr)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String descrip;
        if(empr.getDescrip() == null || empr.getDescrip().isEmpty()){
            descrip = "NULL";
        }else{
            descrip = "N'"+ empr.getDescrip().replace("'", "''") +"'";
        }
        String tipoEmp;
        if(empr.getTipoEmp() == null || empr.getTipoEmp().isEmpty()){
            tipoEmp = "NULL";
        }else{
            tipoEmp = "N'"+ empr.getTipoEmp().replace("'", "''") +"'";
        }
        String direccion;
        if(empr.getDireccion() == null || empr.getDireccion().isEmpty()){
            direccion = "NULL";
        }else{
            direccion = "N'"+ empr.getDireccion().replace("'", "''") +"'";
        }
        String tlf;
        if(empr.getTlf() == null || empr.getTlf().isEmpty()){
            tlf = "NULL";
        }else{
            tlf = "N'"+ empr.getTlf().replace("'", "''") +"'";
        }
        String persContacto;
        if(empr.getPersContacto() == null || empr.getPersContacto().isEmpty()){
            persContacto = "NULL";
        }else{
            persContacto = "N'"+ empr.getPersContacto().replace("'", "''") +"'";
        }
        String web;
        if(empr.getWeb() == null || empr.getWeb().isEmpty()){
            web = "NULL";
        }else{
            web = "N'"+ empr.getWeb().replace("'", "''") +"'";
        }
        String sql;
        sql = "update dbo.Empresa set ";
        sql = sql + "Descrip = "+ descrip +", "+ "TipoEmp = "+ tipoEmp +", "+ "Direccion = "+ direccion +", "+ "Tlf = "+ tlf +", "+ "PersContacto = "+ persContacto +", "+ "Web = "+ web;
        sql += " where IdEmpresa = "+ empr.getIdEmpresa() +"";
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

    public void eliminaEmpresa(int id)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "delete from dbo.Empresa where IdEmpresa = "+ id;
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
