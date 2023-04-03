/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ilija Dumanović
 */
public class TipAntikviteta implements GenericEntity {

    private int id;
    private String naziv;

    public TipAntikviteta(int id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public TipAntikviteta() {
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getTableName() {
        return "tipantikviteta";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,naziv";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(naziv).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUpdateValues() {
        return "";
    }

    @Override
    public String getJoinText() {
        return "";
    }

    @Override
    public String getSelectedText() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getID() {
        return getTableName() + ".id=" + id;
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        return new TipAntikviteta(rs.getInt(getTableName() + ".id"), rs.getString(getTableName() + ".naziv"));
    }

}
