package app;

import db.DB;
import db.DbException;
import entities.enums.StatusOcorrencia;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement stUpdateStatus = null;
        PreparedStatement stInsertHistorico = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);

            stUpdateStatus = conn.prepareStatement("UPDATE ocorrencia SET Status = ? WHERE  Id = ?");
            stUpdateStatus.setString(1, StatusOcorrencia.APROVADO.toString());
            stUpdateStatus.setInt(2, 1);
            stUpdateStatus.executeUpdate();


            stInsertHistorico = conn.prepareStatement("INSERT INTO historico (OcorrenciaId, Acao, Datahora ) VALUES (?,?,?)");
            stInsertHistorico.setInt(1, 999);
            stInsertHistorico.setString(2, "Aprovado por Helenna");
            stInsertHistorico.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stInsertHistorico.executeUpdate();

            conn.commit();

            System.out.println("Done");
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                throw new DbException("Erro ao tentar desfazer transação: " + e1.getMessage());
            }
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(stUpdateStatus);
            DB.closeStatement(stInsertHistorico);
            DB.closeConnection();

        }
    }

}
