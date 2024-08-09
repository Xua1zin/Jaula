/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Maria Beatriz
 */
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.CadastroPacienteModel;
import model.FiltroPaciente;

public class CadastroPacienteDao implements DaoGenerico<CadastroPacienteModel> {

    private ConexaoBanco conexao;

    public CadastroPacienteDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(CadastroPacienteModel cadastro) {
        String sql = "INSERT INTO patient (patient_name, patient_birthdate, patient_cpf, patient_rg, "
                + "sex_id, nationality_id, patient_telefone, patient_email, patient_cep, patient_pathological, "
                + "patient_allergies, intolerance, patient_mental_history, patient_observation, patient_job) "
                + "VALUES (?,?,?,?, (select sex_id from sex where sex_name = ?), "
                + "(select nationality_id from nationality where country_name = ?),?,?,?,?,?,?,?,?,?)";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, cadastro.getPatientName());
                sentenca.setDate(2, (Date) cadastro.getPatientBirthdate());
                sentenca.setString(3, cadastro.getPatientCPF());
                sentenca.setString(4, cadastro.getPatientRG());
                sentenca.setString(5, cadastro.getSexName());
                sentenca.setString(6, cadastro.getCountryName());
                sentenca.setString(7, cadastro.getPatientTelefone());
                sentenca.setString(8, cadastro.getPatientEmail());
                sentenca.setString(9, cadastro.getPatientCEP());
                sentenca.setString(10, cadastro.getPatientPathological());
                sentenca.setString(11, cadastro.getPatientAllergies());
                sentenca.setString(12, cadastro.getIntolerance());
                sentenca.setString(13, cadastro.getPatientMentalHistory());
                sentenca.setString(14, cadastro.getPatientObservation());
                sentenca.setString(15, cadastro.getPatientJob());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(CadastroPacienteModel cadastro) {
        String sql = "UPDATE patient SET "
                + "patient_name = ?, "
                + "patient_birthdate = ?, "
                + "patient_cpf = ?, "
                + "patient_rg = ?, "
                + "sex_id = (select sex_id from sex where sex_name = ?), "
                + "nationality_id = (select nationality_id from nationality where country_name = ?), "
                + "patient_telefone = ?, "
                + "patient_email = ?, "
                + "patient_cep = ?, "
                + "patient_pathological = ?, "
                + "patient_allergies = ?, "
                + "intolerance = ?, "
                + "patient_mental_history = ?, "
                + "patient_observation = ?, "
                + "patient_job = ? "
                + "WHERE patient_id = ?";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, cadastro.getPatientName());
                sentenca.setDate(2, (Date) cadastro.getPatientBirthdate());
                sentenca.setString(3, cadastro.getPatientCPF());
                sentenca.setString(4, cadastro.getPatientRG());
                sentenca.setString(5, cadastro.getSexName());
                sentenca.setString(6, cadastro.getCountryName());
                sentenca.setString(7, cadastro.getPatientTelefone());
                sentenca.setString(8, cadastro.getPatientEmail());
                sentenca.setString(9, cadastro.getPatientCEP());
                sentenca.setString(10, cadastro.getPatientPathological());
                sentenca.setString(11, cadastro.getPatientAllergies());
                sentenca.setString(12, cadastro.getIntolerance());
                sentenca.setString(13, cadastro.getPatientMentalHistory());
                sentenca.setString(14, cadastro.getPatientObservation());
                sentenca.setString(15, cadastro.getPatientJob());
                sentenca.setInt(16, cadastro.getPatientID());
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
        String sql = "DELETE FROM patient WHERE patient_id = ?";

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
    public ArrayList<CadastroPacienteModel> consultar() {

        ArrayList<CadastroPacienteModel> listaCadastros = new ArrayList<CadastroPacienteModel>();
        String sql = "SELECT p.patient_id, p.patient_name, p.patient_birthdate, p.patient_cpf, p.patient_rg, "
                + "p.patient_telefone, p.patient_email, p.patient_cep, p.patient_observation, p.patient_pathological, "
                + "p.patient_allergies, p.intolerance, p.patient_mental_history, p.sex_id, s.sex_name, p.nationality_id, "
                + "n.country_name, p.patient_job "
                + "FROM patient as p "
                + "LEFT JOIN sex AS s ON (s.sex_id = p.sex_id) "
                + "LEFT JOIN nationality AS n ON (n.nationality_id = p.nationality_id)"
                + "ORDER BY p.patient_id";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroPacienteModel cadastro = new CadastroPacienteModel();
                    cadastro.setPatientID(resultadoSentenca.getInt("patient_id"));
                    cadastro.setPatientName(resultadoSentenca.getString("patient_name"));
                    cadastro.setPatientBirthdate(resultadoSentenca.getDate("patient_birthdate"));
                    cadastro.setPatientCPF(resultadoSentenca.getString("patient_cpf"));
                    cadastro.setPatientRG(resultadoSentenca.getString("patient_rg"));
                    cadastro.setPatientTelefone(resultadoSentenca.getString("patient_telefone"));
                    cadastro.setPatientEmail(resultadoSentenca.getString("patient_email"));
                    cadastro.setPatientCEP(resultadoSentenca.getString("patient_cep"));
                    cadastro.setPatientObservation(resultadoSentenca.getString("patient_observation"));
                    cadastro.setPatientPathological(resultadoSentenca.getString("patient_pathological"));
                    cadastro.setPatientAllergies(resultadoSentenca.getString("patient_allergies"));
                    cadastro.setIntolerance(resultadoSentenca.getString("intolerance"));
                    cadastro.setPatientMentalHistory(resultadoSentenca.getString("patient_mental_history"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));
                    cadastro.setNationalityID(resultadoSentenca.getInt("nationality_id"));
                    cadastro.setCountryName(resultadoSentenca.getString("country_name"));
                    cadastro.setPatientJob(resultadoSentenca.getString("patient_job"));

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

    public ArrayList<CadastroPacienteModel> consultar(String str) {

        ArrayList<CadastroPacienteModel> listaCadastrosStr = new ArrayList<CadastroPacienteModel>();
        String sql = "SELECT p.patient_id, p.patient_name, p.patient_birthdate, p.patient_cpf, p.patient_rg, "
                + "p.patient_telefone, p.patient_email, p.patient_cep, p.patient_observation, p.patient_pathological, "
                + "p.patient_allergies, p.intolerance, p.patient_mental_history, p.sex_id, s.sex_name, p.nationality_id, "
                + "n.country_name, p.patient_job "
                + "FROM patient as p "
                + "LEFT JOIN sex AS s ON (s.sex_id = p.sex_id) "
                + "LEFT JOIN nationality AS n ON (n.nationality_id = p.nationality_id)"
                + "WHERE ( UPPER(p.patient_name like UPPER(?))) "
                + "OR (UPPER(p.patient_id like UPPER (?))) "
                + "ORDER BY p.patient_birthdate";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, "%" + str + "%");
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroPacienteModel cadastro = new CadastroPacienteModel();
                    cadastro.setPatientID(resultadoSentenca.getInt("patient_id"));
                    cadastro.setPatientName(resultadoSentenca.getString("patient_name"));
                    cadastro.setPatientBirthdate(resultadoSentenca.getDate("patient_birthdate"));
                    cadastro.setPatientCPF(resultadoSentenca.getString("patient_cpf"));
                    cadastro.setPatientRG(resultadoSentenca.getString("patient_rg"));
                    cadastro.setPatientTelefone(resultadoSentenca.getString("patient_telefone"));
                    cadastro.setPatientEmail(resultadoSentenca.getString("patient_email"));
                    cadastro.setPatientCEP(resultadoSentenca.getString("patient_cep"));
                    cadastro.setPatientObservation(resultadoSentenca.getString("patient_observation"));
                    cadastro.setPatientPathological(resultadoSentenca.getString("patient_pathological"));
                    cadastro.setPatientAllergies(resultadoSentenca.getString("patient_allergies"));
                    cadastro.setIntolerance(resultadoSentenca.getString("intolerance"));
                    cadastro.setPatientMentalHistory(resultadoSentenca.getString("patient_mental_history"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));
                    cadastro.setNationalityID(resultadoSentenca.getInt("nationality_id"));
                    cadastro.setCountryName(resultadoSentenca.getString("country_name"));
                    cadastro.setPatientJob(resultadoSentenca.getString("patient_job"));

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

    public ArrayList<CadastroPacienteModel> buscarComFiltro(FiltroPaciente filtro) {
        ArrayList<CadastroPacienteModel> listaCadastros = new ArrayList<>();
        String sql = "SELECT p.patient_id, p.patient_name, p.patient_birthdate, p.patient_cpf, p.patient_rg, "
                + "p.patient_telefone, p.patient_email, p.patient_cep, p.patient_observation, p.patient_pathological, "
                + "p.patient_allergies, p.intolerance, p.patient_mental_history, p.sex_id, s.sex_name, p.nationality_id, "
                + "n.country_name, p.patient_job "
                + "FROM patient as p "
                + "LEFT JOIN sex AS s ON (s.sex_id = p.sex_id) "
                + "LEFT JOIN nationality AS n ON (n.nationality_id = p.nationality_id) "
                + "WHERE 1 = 1 ";

        if (filtro.getPatientID() != 0) {
            sql += "AND p.patient_id = " + filtro.getPatientID() + " ";
        }
        if (filtro.getPatientName() != null && !filtro.getPatientName().isEmpty()) {
            sql += "AND UPPER(p.patient_name) LIKE UPPER('%" + filtro.getPatientName() + "%') ";
        }
        if (filtro.getPatientBirthdate() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataFormatada = dateFormat.format(filtro.getPatientBirthdate());
            sql += "AND p.patient_birthdate = '" + dataFormatada + "' ";
        }
        if (filtro.getPatientCPF() != null && !filtro.getPatientCPF().isEmpty()) {
            sql += "AND p.patient_cpf = '" + filtro.getPatientCPF() + "' ";
        }

        sql += "ORDER BY p.patient_id";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroPacienteModel cadastro = new CadastroPacienteModel();
                    cadastro.setPatientID(resultadoSentenca.getInt("patient_id"));
                    cadastro.setPatientName(resultadoSentenca.getString("patient_name"));
                    cadastro.setPatientBirthdate(resultadoSentenca.getDate("patient_birthdate"));
                    cadastro.setPatientCPF(resultadoSentenca.getString("patient_cpf"));
                    cadastro.setPatientRG(resultadoSentenca.getString("patient_rg"));
                    cadastro.setPatientTelefone(resultadoSentenca.getString("patient_telefone"));
                    cadastro.setPatientEmail(resultadoSentenca.getString("patient_email"));
                    cadastro.setPatientCEP(resultadoSentenca.getString("patient_cep"));
                    cadastro.setPatientObservation(resultadoSentenca.getString("patient_observation"));
                    cadastro.setPatientPathological(resultadoSentenca.getString("patient_pathological"));
                    cadastro.setPatientAllergies(resultadoSentenca.getString("patient_allergies"));
                    cadastro.setIntolerance(resultadoSentenca.getString("intolerance"));
                    cadastro.setPatientMentalHistory(resultadoSentenca.getString("patient_mental_history"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));
                    cadastro.setNationalityID(resultadoSentenca.getInt("nationality_id"));
                    cadastro.setCountryName(resultadoSentenca.getString("country_name"));
                    cadastro.setPatientJob(resultadoSentenca.getString("patient_job"));

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

    public ArrayList<CadastroPacienteModel> dashboard() {

        ArrayList<CadastroPacienteModel> ListarDashBoard = new ArrayList<CadastroPacienteModel>();
        String sql = "select FLOOR(RAND()(10-5+1)*10) as numcad, FLOOR(RAND()(10-5+1)10) as sumcad, FLOOR(RAND()(10-5+1)*10) as numsexualidade";

        /*try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while(resultadoSentenca.next()) 
                {
                    CadastroPacienteModel cadastro = new CadastroPacienteModel();
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
