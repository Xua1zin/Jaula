/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.CadastroUsuarioModel;
import model.FiltroUsuario;

public class CadastroUsuarioDao implements DaoGenerico<CadastroUsuarioModel> {

    private ConexaoBanco conexao;

    public CadastroUsuarioDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(CadastroUsuarioModel cadastro) {
        String sql = "INSERT INTO usuario (user_login, user_password, user_name, user_birthdate, user_cpf, user_rg, "
                + "sex_id, crn, nationality_id, user_telefone, user_email, user_observation, permissions_id, "
                + "user_status_id, region_id) "
                + "VALUES (?,?,?,?,?,?,(select sex_id from sex where sex_name = ?),"
                + "?,(select nationality_id from nationality where country_name = ?),?,?,?,"
                + "(select permissions_id from permissions where permissions_type = ?),"
                + "(select user_status_id from user_status where user_status_name = ?),"
                + "(select region_id from region where region_name = ?))";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, cadastro.getUserLogin());
                sentenca.setString(2, cadastro.getUserPassword());
                sentenca.setString(3, cadastro.getUserName());
                sentenca.setDate(4, (Date) cadastro.getUserBirthdate());
                sentenca.setString(5, cadastro.getUserCPF());
                sentenca.setString(6, cadastro.getUserRG());
                sentenca.setString(7, cadastro.getSexName());
                sentenca.setString(8, cadastro.getCRN());
                sentenca.setString(9, cadastro.getCountryName());
                sentenca.setString(10, cadastro.getUserTelefone());
                sentenca.setString(11, cadastro.getUserEmail());
                sentenca.setString(12, cadastro.getUserObservation());
                sentenca.setString(13, cadastro.getPermissionsType());
                sentenca.setString(14, cadastro.getUserStatusName());
                sentenca.setString(15, cadastro.getRegionName());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(CadastroUsuarioModel cadastro) {
        String sql = "UPDATE usuario SET user_login = ?, "
                + "user_password = ?, "
                + "user_name = ?, "
                + "user_birthdate = ?, "
                + "user_cpf = ?, "
                + "user_rg = ?, "
                + "sex_id = (select sex_id from sex where sex_name = ?), "
                + "crn = ?, "
                + "nationality_id = (select nationality_id from nationality where country_name = ?), "
                + "user_telefone = ?, "
                + "user_email = ?, "
                + "user_observation = ?, "
                + "permissions_id = (select permissions_id from permissions where permissions_type = ?), "
                + "user_status_id = (select user_status_id from user_status where user_status_name = ?), "
                + "region_id = (select region_id from region where region_name = ?) "
                + "WHERE (user_id = ?)";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, cadastro.getUserLogin());
                sentenca.setString(2, cadastro.getUserPassword());
                sentenca.setString(3, cadastro.getUserName());
                sentenca.setDate(4, (Date) cadastro.getUserBirthdate());
                sentenca.setString(5, cadastro.getUserCPF());
                sentenca.setString(6, cadastro.getUserRG());
                sentenca.setString(7, cadastro.getSexName());
                sentenca.setString(8, cadastro.getCRN());
                sentenca.setString(9, cadastro.getCountryName());
                sentenca.setString(10, cadastro.getUserTelefone());
                sentenca.setString(11, cadastro.getUserEmail());
                sentenca.setString(12, cadastro.getUserObservation());
                sentenca.setString(13, cadastro.getPermissionsType());
                sentenca.setString(14, cadastro.getUserStatusName());
                sentenca.setString(15, cadastro.getRegionName());
                sentenca.setInt(16, cadastro.getUserID());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void excluir() {
        String sql = "DELETE FROM ESCOLA";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluirID(int id) {
        String sql = "DELETE FROM usuario WHERE user_id = ?";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setInt(1, id);

                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ArrayList<CadastroUsuarioModel> consultar() {

        ArrayList<CadastroUsuarioModel> listaCadastros = new ArrayList<CadastroUsuarioModel>();
        String sql = "SELECT u.user_id, u.user_login, u.user_password, u.user_name, "
                + "u.user_birthdate, u.user_cpf, u.user_rg, u.sex_id, s.sex_name, "
                + "u.crn, u.nationality_id, n.country_name, u.user_telefone, u.user_email, "
                + "u.user_observation, u.permissions_id, p.permissions_type, "
                + "u.user_status_id, us.user_status_name, u.region_id, r.region_name "
                + "FROM usuario as u "
                + "LEFT JOIN sex AS s ON (s.sex_id = u.sex_id) "
                + "LEFT JOIN nationality AS n ON (n.nationality_id = u.nationality_id) "
                + "LEFT JOIN permissions AS p ON (p.permissions_id = u.permissions_id) "
                + "LEFT JOIN user_status AS us ON (us.user_status_id = u.user_status_id) "
                + "LEFT JOIN region AS r ON (u.region_id = r.region_id) "
                + "ORDER BY u.user_id";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroUsuarioModel cadastro = new CadastroUsuarioModel();
                    cadastro.setUserID(resultadoSentenca.getInt("user_id"));
                    cadastro.setUserLogin(resultadoSentenca.getString("user_login"));
                    cadastro.setUserPassword(resultadoSentenca.getString("user_password"));
                    cadastro.setUserName(resultadoSentenca.getString("user_name"));
                    cadastro.setUserBirthdate(resultadoSentenca.getDate("user_birthdate"));
                    cadastro.setUserCPF(resultadoSentenca.getString("user_cpf"));
                    cadastro.setUserRG(resultadoSentenca.getString("user_rg"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));
                    cadastro.setCRN(resultadoSentenca.getString("CRN"));
                    cadastro.setNationalityID(resultadoSentenca.getInt("nationality_id"));
                    cadastro.setCountryName(resultadoSentenca.getString("country_name"));
                    cadastro.setUserTelefone(resultadoSentenca.getString("user_telefone"));
                    cadastro.setUserEmail(resultadoSentenca.getString("user_email"));
                    cadastro.setUserObservation(resultadoSentenca.getString("user_observation"));
                    cadastro.setPermissionsID(resultadoSentenca.getInt("permissions_id"));
                    cadastro.setPermissionsType(resultadoSentenca.getString("permissions_type"));
                    cadastro.setUserStatusID(resultadoSentenca.getInt("user_status_id"));
                    cadastro.setUserStatusName(resultadoSentenca.getString("user_status_name"));
                    cadastro.setRegionID(resultadoSentenca.getInt("region_id"));
                    cadastro.setRegionName(resultadoSentenca.getString("region_name"));

                    listaCadastros.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaCadastros;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<CadastroUsuarioModel> consultar(String str) {

        ArrayList<CadastroUsuarioModel> listaCadastrosStr = new ArrayList<CadastroUsuarioModel>();
        String sql = "SELECT u.user_id, u.user_login, u.user_password, u.user_name, "
                + "u.user_birthdate, u.user_cpf, u.user_rg, u.sex_id, s.sex_name, "
                + "u.crn, u.nationality_id, n.country_name, u.user_telefone, u.user_email, "
                + "u.user_observation, u.permissions_id, p.permissions_type, "
                + "u.user_status_id, us.user_status_name, u.region_id, r.region_name "
                + "FROM usuario as u "
                + "LEFT JOIN sex AS s ON (s.sex_id = u.sex_id) "
                + "LEFT JOIN nationality AS n ON (n.nationality_id = u.nationality_id) "
                + "LEFT JOIN permissions AS p ON (p.permissions_id = u.permissions_id) "
                + "LEFT JOIN user_status AS us ON (us.user_status_id = u.user_status_id) "
                + "LEFT JOIN region AS r ON (u.region_id = r.region_id) "
                + "WHERE ( UPPER(u.user_name like UPPER(?))) "
                + "OR (UPPER(u.user_id like UPPER (?))) "
                + "ORDER BY us.user_status_name";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, "%" + str + "%");
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroUsuarioModel cadastro = new CadastroUsuarioModel();
                    cadastro.setUserID(resultadoSentenca.getInt("user_id"));
                    cadastro.setUserLogin(resultadoSentenca.getString("user_login"));
                    cadastro.setUserPassword(resultadoSentenca.getString("user_password"));
                    cadastro.setUserName(resultadoSentenca.getString("user_name"));
                    cadastro.setUserBirthdate(resultadoSentenca.getDate("user_birthdate"));
                    cadastro.setUserCPF(resultadoSentenca.getString("user_cpf"));
                    cadastro.setUserRG(resultadoSentenca.getString("user_rg"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));
                    cadastro.setCRN(resultadoSentenca.getString("CRN"));
                    cadastro.setNationalityID(resultadoSentenca.getInt("nationality_id"));
                    cadastro.setCountryName(resultadoSentenca.getString("country_name"));
                    cadastro.setUserTelefone(resultadoSentenca.getString("user_telefone"));
                    cadastro.setUserEmail(resultadoSentenca.getString("user_email"));
                    cadastro.setUserObservation(resultadoSentenca.getString("user_observation"));
                    cadastro.setPermissionsID(resultadoSentenca.getInt("permissions_id"));
                    cadastro.setPermissionsType(resultadoSentenca.getString("permissions_type"));
                    cadastro.setUserStatusID(resultadoSentenca.getInt("user_status_id"));
                    cadastro.setUserStatusName(resultadoSentenca.getString("user_status_name"));
                    cadastro.setRegionID(resultadoSentenca.getInt("region_id"));
                    cadastro.setRegionName(resultadoSentenca.getString("region_name"));

                    listaCadastrosStr.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaCadastrosStr;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<CadastroUsuarioModel> buscarComFiltro(FiltroUsuario filtro) {
        ArrayList<CadastroUsuarioModel> listaCadastros = new ArrayList<>();
        String sql = "SELECT u.user_id, u.user_login, u.user_password, u.user_name, "
                + "u.user_birthdate, u.user_cpf, u.user_rg, u.sex_id, s.sex_name, "
                + "u.crn, u.nationality_id, n.country_name, u.user_telefone, u.user_email, "
                + "u.user_observation, u.permissions_id, p.permissions_type, "
                + "u.user_status_id, us.user_status_name, u.region_id, r.region_name "
                + "FROM usuario as u "
                + "LEFT JOIN sex AS s ON (s.sex_id = u.sex_id) "
                + "LEFT JOIN nationality AS n ON (n.nationality_id = u.nationality_id) "
                + "LEFT JOIN permissions AS p ON (p.permissions_id = u.permissions_id) "
                + "LEFT JOIN user_status AS us ON (us.user_status_id = u.user_status_id) "
                + "LEFT JOIN region AS r ON (u.region_id = r.region_id) "
                + "WHERE 1 = 1 ";

        List<Object> parametros = new ArrayList<>();

        if (filtro.getUserID() != 0) {
            sql += "AND u.user_id = ? ";
            parametros.add(filtro.getUserID());
        }
        if (filtro.getCRN() != null && !filtro.getCRN().isEmpty()) {
            sql += "AND u.crn = ? ";
            parametros.add(filtro.getCRN());
        }
        if (filtro.getUserName() != null && !filtro.getUserName().isEmpty()) {
            sql += "AND UPPER(u.user_name) LIKE UPPER(?) ";
            parametros.add("%" + filtro.getUserName() + "%");
        }
        if (filtro.getUserBirthdate() != null) {
            sql += "AND u.user_birthdate = ? ";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataFormatada = dateFormat.format(filtro.getUserBirthdate());
            parametros.add(Date.valueOf(dataFormatada));
        }
        if (filtro.getUserStatusName() != null && !filtro.getUserStatusName().isEmpty()) {
            sql += "AND us.user_status_name = ? ";
            parametros.add(filtro.getUserStatusName());
        }

        sql += "ORDER BY u.user_id";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                for (int i = 0; i < parametros.size(); i++) {
                    sentenca.setObject(i + 1, parametros.get(i));
                }

                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroUsuarioModel cadastro = new CadastroUsuarioModel();
                    cadastro.setUserID(resultadoSentenca.getInt("user_id"));
                    cadastro.setUserLogin(resultadoSentenca.getString("user_login"));
                    cadastro.setUserPassword(resultadoSentenca.getString("user_password"));
                    cadastro.setUserName(resultadoSentenca.getString("user_name"));
                    cadastro.setUserBirthdate(resultadoSentenca.getDate("user_birthdate"));
                    cadastro.setUserCPF(resultadoSentenca.getString("user_cpf"));
                    cadastro.setUserRG(resultadoSentenca.getString("user_rg"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));
                    cadastro.setCRN(resultadoSentenca.getString("crn"));
                    cadastro.setNationalityID(resultadoSentenca.getInt("nationality_id"));
                    cadastro.setCountryName(resultadoSentenca.getString("country_name"));
                    cadastro.setUserTelefone(resultadoSentenca.getString("user_telefone"));
                    cadastro.setUserEmail(resultadoSentenca.getString("user_email"));
                    cadastro.setUserObservation(resultadoSentenca.getString("user_observation"));
                    cadastro.setPermissionsID(resultadoSentenca.getInt("permissions_id"));
                    cadastro.setPermissionsType(resultadoSentenca.getString("permissions_type"));
                    cadastro.setUserStatusID(resultadoSentenca.getInt("user_status_id"));
                    cadastro.setUserStatusName(resultadoSentenca.getString("user_status_name"));
                    cadastro.setRegionID(resultadoSentenca.getInt("region_id"));
                    cadastro.setRegionName(resultadoSentenca.getString("region_name"));

                    listaCadastros.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }

            return listaCadastros;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<CadastroUsuarioModel> dashboard() {

        ArrayList<CadastroUsuarioModel> ListarDashBoard = new ArrayList<CadastroUsuarioModel>();
        String sql = "select FLOOR(RAND()(10-5+1)*10) as numcad, FLOOR(RAND()(10-5+1)10) as sumcad, FLOOR(RAND()(10-5+1)*10) as numsexualidade";

        /*try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while(resultadoSentenca.next()) 
                {
                    CadastroUsuarioModel cadastro = new CadastroUsuarioModel();
                    cadastro.setTotalCadastros(resultadoSentenca.getInt("numcad"));
                    cadastro.SetSomaCodigos(resultadoSentenca.getInt("sumcad"));
                    cadastro.SetNumSexualidade(resultadoSentenca.getInt("numsexualidade"));
                    
                    ListarDashBoard.add(cadastro);
                }

                sentenca.close();
                this.conexao.getConnection().close();
            }
            
            return ListarDashBoard;
        }
        catch(SQLException ex)
        {
           throw new RuntimeException(ex);
        }*/
        return null;
    }

}
