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
import model.CadastroFormularioModel;
import model.FiltroFormulario;

public class CadastroFormularioDao implements DaoGenerico<CadastroFormularioModel> {

    private ConexaoBanco conexao;

    public CadastroFormularioDao() {
        this.conexao = new ConexaoBanco();
    }

    @Override
    public void inserir(CadastroFormularioModel cadastro) {
        String sql = "INSERT INTO form (form_exam_date, form_status_id, imc_id, form_height, form_weight, form_neck_width, "
                + "form_waist_width, form_objective, form_feeding_pattern, form_habits, form_exercises, form_sintoms, "
                + "form_medication, form_feces, form_urine, form_observation) "
                + "VALUES (?,(select form_status_id from form_status where form_status_name = ?),"
                + "(select imc_id from imc where imc_name = ?),?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setDate(1, (Date) cadastro.getFormExamDate());
                sentenca.setString(2, cadastro.getFormStatusName());
                sentenca.setString(3, cadastro.getImcName());
                sentenca.setDouble(4, cadastro.getFormHeight());
                sentenca.setDouble(5, cadastro.getFormWeight());
                sentenca.setDouble(6, cadastro.getFormNeckWidth());
                sentenca.setDouble(7, cadastro.getFormWaistWidth());
                sentenca.setString(8, cadastro.getFormObjective());
                sentenca.setString(9, cadastro.getFormFeedingPattern());
                sentenca.setString(10, cadastro.getFormHabits());
                sentenca.setString(11, cadastro.getFormExercises());
                sentenca.setString(12, cadastro.getFormSintoms());
                sentenca.setString(13, cadastro.getFormMedication());
                sentenca.setString(14, cadastro.getFormFeces());
                sentenca.setString(15, cadastro.getFormUrine());
                sentenca.setString(16, cadastro.getFormObservation());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void alterar(CadastroFormularioModel cadastro) {
    String sql = "UPDATE form SET form_exam_date = ?, "
               + "form_status_id = (SELECT form_status_id FROM form_status WHERE form_status_name = ?), "
               + "imc_id = (SELECT imc_id FROM imc WHERE imc_name = ?), "
               + "form_height = ?, form_weight = ?, form_neck_width = ?, form_waist_width = ?, "
               + "form_objective = ?, form_feeding_pattern = ?, form_habits = ?, form_exercises = ?, "
               + "form_sintoms = ?, form_medication = ?, form_feces = ?, form_urine = ?, form_observation = ? "
               + "WHERE form_id = ?";

    try {
        if (this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

            sentenca.setDate(1, new java.sql.Date(cadastro.getFormExamDate().getTime()));
            sentenca.setString(2, cadastro.getFormStatusName());
            sentenca.setString(3, cadastro.getImcName());
            sentenca.setDouble(4, cadastro.getFormHeight());
            sentenca.setDouble(5, cadastro.getFormWeight());
            sentenca.setDouble(6, cadastro.getFormNeckWidth());
            sentenca.setDouble(7, cadastro.getFormWaistWidth());
            sentenca.setString(8, cadastro.getFormObjective());
            sentenca.setString(9, cadastro.getFormFeedingPattern());
            sentenca.setString(10, cadastro.getFormHabits());
            sentenca.setString(11, cadastro.getFormExercises());
            sentenca.setString(12, cadastro.getFormSintoms());
            sentenca.setString(13, cadastro.getFormMedication());
            sentenca.setString(14, cadastro.getFormFeces());
            sentenca.setString(15, cadastro.getFormUrine());
            sentenca.setString(16, cadastro.getFormObservation());
            sentenca.setInt(17, cadastro.getFormID());

            sentenca.executeUpdate();
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
    public ArrayList<CadastroFormularioModel> consultar() {

        ArrayList<CadastroFormularioModel> listaCadastros = new ArrayList<CadastroFormularioModel>();
        String sql = "SELECT f.form_id, f.imc_id, imc.imc_name, f.form_height, f.form_weight, f.form_neck_width, "
                + "f.form_waist_width, f.form_objective, f.form_feeding_pattern, f.form_habits, "
                + "f.form_exercises, f.form_feces, f.form_urine, f.form_sintoms, f.form_observation, "
                + "f.form_exam_date, f.form_status_id, fs.form_status_name, f.form_medication, p.patient_id, "
                + "p.patient_name, p.patient_birthdate, s.sex_id, s.sex_name "
                + "FROM form as f "
                + "LEFT JOIN connection_form_patient AS cfp ON (cfp.form_id = f.form_id) "
                + "LEFT JOIN patient AS p ON (p.patient_id = cfp.patient_id) "
                + "LEFT JOIN form_status AS fs ON (fs.form_status_id = f.form_status_id) "
                + "LEFT JOIN sex AS s ON (s.sex_id = p.sex_id) "
                + "LEFT JOIN imc ON (imc.imc_id = f.imc_id) "
                + "ORDER BY f.form_exam_date";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroFormularioModel cadastro = new CadastroFormularioModel();
                    cadastro.setFormID(resultadoSentenca.getInt("form_id"));
                    cadastro.setImcID(resultadoSentenca.getInt("imc_id"));
                    cadastro.setImcName(resultadoSentenca.getString("imc_name"));
                    cadastro.setFormHeight(resultadoSentenca.getDouble("form_height"));
                    cadastro.setFormWeight(resultadoSentenca.getDouble("form_weight"));
                    cadastro.setFormNeckWidth(resultadoSentenca.getDouble("form_neck_width"));
                    cadastro.setFormWaistWidth(resultadoSentenca.getDouble("form_waist_width"));
                    cadastro.setFormObjective(resultadoSentenca.getString("form_objective"));
                    cadastro.setFormFeedingPattern(resultadoSentenca.getString("form_feeding_pattern"));
                    cadastro.setFormHabits(resultadoSentenca.getString("form_habits"));
                    cadastro.setFormExercises(resultadoSentenca.getString("form_exercises"));
                    cadastro.setFormFeces(resultadoSentenca.getString("form_feces"));
                    cadastro.setFormUrine(resultadoSentenca.getString("form_urine"));
                    cadastro.setFormSintoms(resultadoSentenca.getString("form_sintoms"));
                    cadastro.setFormObservation(resultadoSentenca.getString("form_observation"));
                    cadastro.setFormExamDate(resultadoSentenca.getDate("form_exam_date"));
                    cadastro.setFormStatusID(resultadoSentenca.getInt("form_status_id"));
                    cadastro.setFormStatusName(resultadoSentenca.getString("form_status_name"));
                    cadastro.setFormMedication(resultadoSentenca.getString("form_medication"));
                    cadastro.setPatientID(resultadoSentenca.getInt("patient_id"));
                    cadastro.setPatientName(resultadoSentenca.getString("patient_name"));
                    cadastro.setPatientBirthdate(resultadoSentenca.getDate("patient_birthdate"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));

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

    public ArrayList<CadastroFormularioModel> consultar(String str) {

        ArrayList<CadastroFormularioModel> listaCadastrosStr = new ArrayList<CadastroFormularioModel>();
        String sql = "SELECT f.form_id, f.imc_id, imc.imc_name, f.form_height, f.form_weight, f.form_neck_width, "
                + "f.form_waist_width, f.form_objective, f.form_feeding_pattern, f.form_habits, "
                + "f.form_exercises, f.form_feces, f.form_urine, f.form_sintoms, f.form_observation, "
                + "f.form_exam_date, f.form_status_id, fs.form_status_name, f.form_medication, p.patient_id, "
                + "p.patient_birthdate, s.sex_id, s.sex_name "
                + "FROM form as f "
                + "LEFT JOIN connection_form_patient AS cfp ON (cfp.form_id = f.form_id) "
                + "LEFT JOIN patient AS p ON (p.patient_id = cfp.patient_id) "
                + "LEFT JOIN form_status AS fs ON (fs.form_status_id = f.form_status_id) "
                + "LEFT JOIN sex AS s ON (s.sex_id = p.sex_id) "
                + "LEFT JOIN imc ON (imc.imc_id = f.imc_id) "
                + "WHERE ( UPPER(p.patient_name like UPPER(?))) "
                + "OR (f.form_id like (?)) "
                + "ORDER BY f.form_exam_date";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setString(1, "%" + str + "%");
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroFormularioModel cadastro = new CadastroFormularioModel();
                    cadastro.setFormID(resultadoSentenca.getInt("form_id"));
                    cadastro.setImcID(resultadoSentenca.getInt("imc_id"));
                    cadastro.setImcName(resultadoSentenca.getString("imc_name"));
                    cadastro.setFormHeight(resultadoSentenca.getDouble("form_height"));
                    cadastro.setFormWeight(resultadoSentenca.getDouble("form_weight"));
                    cadastro.setFormNeckWidth(resultadoSentenca.getDouble("form_neck_width"));
                    cadastro.setFormWaistWidth(resultadoSentenca.getDouble("form_waist_width"));
                    cadastro.setFormObjective(resultadoSentenca.getString("form_objective"));
                    cadastro.setFormFeedingPattern(resultadoSentenca.getString("form_feeding_pattern"));
                    cadastro.setFormHabits(resultadoSentenca.getString("form_habits"));
                    cadastro.setFormExercises(resultadoSentenca.getString("form_exercises"));
                    cadastro.setFormFeces(resultadoSentenca.getString("form_feces"));
                    cadastro.setFormUrine(resultadoSentenca.getString("form_urine"));
                    cadastro.setFormSintoms(resultadoSentenca.getString("form_sintoms"));
                    cadastro.setFormObservation(resultadoSentenca.getString("form_observation"));
                    cadastro.setFormExamDate(resultadoSentenca.getDate("form_exam_date"));
                    cadastro.setFormStatusID(resultadoSentenca.getInt("form_status_id"));
                    cadastro.setFormStatusName(resultadoSentenca.getString("form_status_name"));
                    cadastro.setFormMedication(resultadoSentenca.getString("form_medication"));
                    cadastro.setPatientID(resultadoSentenca.getInt("patient_id"));
                    cadastro.setPatientName(resultadoSentenca.getString("patient_name"));
                    cadastro.setPatientBirthdate(resultadoSentenca.getDate("patient_birthdate"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));

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

    public ArrayList<CadastroFormularioModel> buscarComFiltro(FiltroFormulario filtro) {
        ArrayList<CadastroFormularioModel> listaCadastros = new ArrayList<>();
        String sql = "SELECT f.form_id, f.imc_id, imc.imc_name, f.form_height, f.form_weight, f.form_neck_width, "
                + "f.form_waist_width, f.form_objective, f.form_feeding_pattern, f.form_habits, "
                + "f.form_exercises, f.form_feces, f.form_urine, f.form_sintoms, f.form_observation, "
                + "f.form_exam_date, f.form_status_id, fs.form_status_name, f.form_medication, "
                + "p.patient_id, p.patient_name, p.patient_birthdate, s.sex_id, s.sex_name "
                + "FROM form AS f "
                + "LEFT JOIN connection_form_patient AS cfp ON (cfp.form_id = f.form_id) "
                + "LEFT JOIN patient AS p ON (p.patient_id = cfp.patient_id) "
                + "LEFT JOIN form_status AS fs ON (fs.form_status_id = f.form_status_id) "
                + "LEFT JOIN sex AS s ON (s.sex_id = p.sex_id) "
                + "LEFT JOIN imc ON (imc.imc_id = f.imc_id) "
                + "WHERE 1 = 1 ";

        if (filtro.getFormID() != 0) {
            sql += "AND f.form_id = " + filtro.getFormID() + " ";
        }
        if (filtro.getPacientID() != 0) {
            sql += "AND p.patient_id = " + filtro.getPacientID() + " ";
        }
        if (filtro.getNome() != null && !filtro.getNome().isEmpty()) {
            sql += "AND UPPER(p.patient_name) LIKE UPPER('%" + filtro.getNome() + "%') ";
        }
        if (filtro.getDataNascimento() != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataFormatada = dateFormat.format(filtro.getDataNascimento());
            sql += "AND p.patient_birthdate = '" + dataFormatada + "' ";
        }
        if (filtro.getStatus() != null && !filtro.getStatus().isEmpty()) {
            sql += "AND fs.form_status_name = '" + filtro.getStatus() + "' ";
        }

        sql += "ORDER BY f.form_exam_date";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while (resultadoSentenca.next()) {
                    CadastroFormularioModel cadastro = new CadastroFormularioModel();
                    cadastro.setFormID(resultadoSentenca.getInt("form_id"));
                    cadastro.setImcID(resultadoSentenca.getInt("imc_id"));
                    cadastro.setImcName(resultadoSentenca.getString("imc_name"));
                    cadastro.setFormHeight(resultadoSentenca.getDouble("form_height"));
                    cadastro.setFormWeight(resultadoSentenca.getDouble("form_weight"));
                    cadastro.setFormNeckWidth(resultadoSentenca.getDouble("form_neck_width"));
                    cadastro.setFormWaistWidth(resultadoSentenca.getDouble("form_waist_width"));
                    cadastro.setFormObjective(resultadoSentenca.getString("form_objective"));
                    cadastro.setFormFeedingPattern(resultadoSentenca.getString("form_feeding_pattern"));
                    cadastro.setFormHabits(resultadoSentenca.getString("form_habits"));
                    cadastro.setFormExercises(resultadoSentenca.getString("form_exercises"));
                    cadastro.setFormFeces(resultadoSentenca.getString("form_feces"));
                    cadastro.setFormUrine(resultadoSentenca.getString("form_urine"));
                    cadastro.setFormSintoms(resultadoSentenca.getString("form_sintoms"));
                    cadastro.setFormObservation(resultadoSentenca.getString("form_observation"));
                    cadastro.setFormExamDate(resultadoSentenca.getDate("form_exam_date"));
                    cadastro.setFormStatusID(resultadoSentenca.getInt("form_status_id"));
                    cadastro.setFormStatusName(resultadoSentenca.getString("form_status_name"));
                    cadastro.setFormMedication(resultadoSentenca.getString("form_medication"));
                    cadastro.setPatientID(resultadoSentenca.getInt("patient_id"));
                    cadastro.setPatientName(resultadoSentenca.getString("patient_name"));
                    cadastro.setPatientBirthdate(resultadoSentenca.getDate("patient_birthdate"));
                    cadastro.setSexID(resultadoSentenca.getInt("sex_id"));
                    cadastro.setSexName(resultadoSentenca.getString("sex_name"));

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
    
    public void vincularFormPaciente(CadastroFormularioModel cadastro) {
        String sql = "INSERT INTO connection_form_patient (form_id, patient_id) "
                + "VALUES (?,?)";

        try {
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

                sentenca.setInt(1, cadastro.getFormID());
                sentenca.setInt(2, cadastro.getPatientID());
                sentenca.execute();
                sentenca.close();
                this.conexao.getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<CadastroFormularioModel> dashboard() {

        ArrayList<CadastroFormularioModel> ListarDashBoard = new ArrayList<CadastroFormularioModel>();
        String sql = "select FLOOR(RAND()(10-5+1)*10) as numcad, FLOOR(RAND()(10-5+1)10) as sumcad, FLOOR(RAND()(10-5+1)*10) as numsexualidade";

        /*try
        {
            if(this.conexao.conectar())
            {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                
                ResultSet resultadoSentenca = sentenca.executeQuery();

                while(resultadoSentenca.next()) 
                {
                    CadastroFormularioModel cadastro = new CadastroFormularioModel();
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
