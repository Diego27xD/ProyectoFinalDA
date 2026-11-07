package DAO;
import BEAN.Empleado;
import UTIL.DbBean;
import java.sql.ResultSet;
import java.util.Vector;

public class EmpleadoDAO {
    public Vector<Empleado> listaEmpleados(String cad)throws java.sql.SQLException{
        ResultSet rstEmpleados;
        DbBean db;
        db = new DbBean();
        Vector<Empleado> lista;
        lista = new Vector<Empleado>();
        String sql;
        sql = "select IdEmpleado, IdEtnia, IdEstCivil, IdGenero, Apellidos, Nombres, convert(varchar(10), FechNac, 23) as FechNac, IdEstado from dbo.Empleado";
        if(!cad.isEmpty()){
            sql = sql + " where Apellidos like N'"+ cad.replace("'", "''") +"%' or Nombres like N'"+ cad.replace("'", "''") +"%'";
        }
        sql += " order by IdEmpleado";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            rstEmpleados = db.resultadoSQL(sql);
            while(rstEmpleados.next()){
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rstEmpleados.getInt(1));
                emp.setIdEtnia(rstEmpleados.getString(2));
                emp.setIdEstCivil(rstEmpleados.getString(3));
                emp.setIdGenero(rstEmpleados.getString(4));
                emp.setApellidos(rstEmpleados.getString(5));
                emp.setNombres(rstEmpleados.getString(6));
                emp.setFechNac(rstEmpleados.getString(7));
                emp.setIdEstado(rstEmpleados.getString(8));
                lista.addElement(emp);
            }
            rstEmpleados.close();
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            throw e;
        }finally{
            db.desconecta();
        }
        return lista;
    }

    public void insertaEmpleado(Empleado emp)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String idEtnia;
        if(emp.getIdEtnia() == null || emp.getIdEtnia().isEmpty()){
            idEtnia = "NULL";
        }else{
            idEtnia = ""+ Integer.parseInt(emp.getIdEtnia());
        }
        String idEstCivil;
        if(emp.getIdEstCivil() == null || emp.getIdEstCivil().isEmpty()){
            idEstCivil = "NULL";
        }else{
            idEstCivil = ""+ Integer.parseInt(emp.getIdEstCivil());
        }
        String idGenero;
        if(emp.getIdGenero() == null || emp.getIdGenero().isEmpty()){
            idGenero = "NULL";
        }else{
            idGenero = ""+ Integer.parseInt(emp.getIdGenero());
        }
        String apellidos;
        if(emp.getApellidos() == null || emp.getApellidos().isEmpty()){
            apellidos = "NULL";
        }else{
            apellidos = "N'"+ emp.getApellidos().replace("'", "''") +"'";
        }
        String nombres;
        if(emp.getNombres() == null || emp.getNombres().isEmpty()){
            nombres = "NULL";
        }else{
            nombres = "N'"+ emp.getNombres().replace("'", "''") +"'";
        }
        String fechNac;
        if(emp.getFechNac() == null || emp.getFechNac().isEmpty()){
            fechNac = "NULL";
        }else{
            fechNac = "N'"+ emp.getFechNac().replace("'", "''") +"'";
        }
        String idEstado;
        if(emp.getIdEstado() == null || emp.getIdEstado().isEmpty()){
            idEstado = "NULL";
        }else{
            idEstado = ""+ Integer.parseInt(emp.getIdEstado());
        }
        String sql;
        sql = "insert into dbo.Empleado (IdEtnia, IdEstCivil, IdGenero, Apellidos, Nombres, FechNac, IdEstado) values (";
        sql = sql + idEtnia +", "+ idEstCivil +", "+ idGenero +", "+ apellidos +", "+ nombres +", "+ "convert(date, "+ fechNac +", 23)" +", "+ idEstado +")";
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

    public void actualizaEmpleado(Empleado emp)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String idEtnia;
        if(emp.getIdEtnia() == null || emp.getIdEtnia().isEmpty()){
            idEtnia = "NULL";
        }else{
            idEtnia = ""+ Integer.parseInt(emp.getIdEtnia());
        }
        String idEstCivil;
        if(emp.getIdEstCivil() == null || emp.getIdEstCivil().isEmpty()){
            idEstCivil = "NULL";
        }else{
            idEstCivil = ""+ Integer.parseInt(emp.getIdEstCivil());
        }
        String idGenero;
        if(emp.getIdGenero() == null || emp.getIdGenero().isEmpty()){
            idGenero = "NULL";
        }else{
            idGenero = ""+ Integer.parseInt(emp.getIdGenero());
        }
        String apellidos;
        if(emp.getApellidos() == null || emp.getApellidos().isEmpty()){
            apellidos = "NULL";
        }else{
            apellidos = "N'"+ emp.getApellidos().replace("'", "''") +"'";
        }
        String nombres;
        if(emp.getNombres() == null || emp.getNombres().isEmpty()){
            nombres = "NULL";
        }else{
            nombres = "N'"+ emp.getNombres().replace("'", "''") +"'";
        }
        String fechNac;
        if(emp.getFechNac() == null || emp.getFechNac().isEmpty()){
            fechNac = "NULL";
        }else{
            fechNac = "N'"+ emp.getFechNac().replace("'", "''") +"'";
        }
        String idEstado;
        if(emp.getIdEstado() == null || emp.getIdEstado().isEmpty()){
            idEstado = "NULL";
        }else{
            idEstado = ""+ Integer.parseInt(emp.getIdEstado());
        }
        String sql;
        sql = "update dbo.Empleado set ";
        sql = sql + "IdEtnia = "+ idEtnia +", "+ "IdEstCivil = "+ idEstCivil +", "+ "IdGenero = "+ idGenero +", "+ "Apellidos = "+ apellidos +", "+ "Nombres = "+ nombres +", "+ "FechNac = "+ "convert(date, "+ fechNac +", 23)" +", "+ "IdEstado = "+ idEstado;
        sql += " where IdEmpleado = "+ emp.getIdEmpleado() +"";
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

    public void eliminaEmpleado(int id)throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        String sql;
        sql = "delete from dbo.Empleado where IdEmpleado = "+ id;
        sql += " and not exists (select 1 from dbo.HabilEmpleado where IdEmpleado = "+ id +")";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            if(db.ejecutaSQL(sql)==0){
                throw new java.sql.SQLException("El empleado no existe o tiene habilidades relacionadas.");
            }
        }catch(java.sql.SQLException e){
            e.printStackTrace();
            throw e;
        }finally{
            db.desconecta();
        }
    }

    public Vector<Vector> listaEtnias()throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        Vector<Vector> lista;
        lista = new Vector<Vector>();
        String sql;
        sql = "select IdEtnia, descripcion from dbo.Etnia order by descripcion";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            ResultSet rst = db.resultadoSQL(sql);
            while(rst.next()){
                Vector vec = new Vector();
                vec.addElement(rst.getInt(1));
                vec.addElement(rst.getString(2));
                lista.addElement(vec);
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

    public Vector<Vector> listaEstadosCiviles()throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        Vector<Vector> lista;
        lista = new Vector<Vector>();
        String sql;
        sql = "select IdEstCiv, descrip from dbo.EstadoCiv order by descrip";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            ResultSet rst = db.resultadoSQL(sql);
            while(rst.next()){
                Vector vec = new Vector();
                vec.addElement(rst.getInt(1));
                vec.addElement(rst.getString(2));
                lista.addElement(vec);
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

    public Vector<Vector> listaGeneros()throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        Vector<Vector> lista;
        lista = new Vector<Vector>();
        String sql;
        sql = "select IdGenero, Descrip from dbo.Genero order by Descrip";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            ResultSet rst = db.resultadoSQL(sql);
            while(rst.next()){
                Vector vec = new Vector();
                vec.addElement(rst.getInt(1));
                vec.addElement(rst.getString(2));
                lista.addElement(vec);
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

    public Vector<Vector> listaEstados()throws java.sql.SQLException{
        DbBean db;
        db = new DbBean();
        Vector<Vector> lista;
        lista = new Vector<Vector>();
        String sql;
        sql = "select IdEstado, DescEstado from dbo.Estado order by DescEstado";
        try{
            if(!db.conecta()){
                throw new java.sql.SQLException("No se pudo conectar a BD_RRHH.");
            }
            ResultSet rst = db.resultadoSQL(sql);
            while(rst.next()){
                Vector vec = new Vector();
                vec.addElement(rst.getInt(1));
                vec.addElement(rst.getString(2));
                lista.addElement(vec);
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
}
