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
public class Mesto implements GenericEntity {

    private int id;
    private String naziv;
    private int ptt;

    public Mesto() {
    }

    public Mesto(int id, String naziv, int ptt) {
        this.id = id;
        this.naziv = naziv;
        this.ptt = ptt;
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

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    @Override
    public String toString() {
        return naziv + ", " + ptt;
    }

    @Override
    public String getTableName() {
        return "mesto";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,naziv,ptt";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(naziv).append("',")
                .append(ptt);
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
        return "";
    }

    @Override
    public String getID() {
        return "mesto.id=" + id;
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        return new Mesto(rs.getInt(getTableName() + ".id"), rs.getString(getTableName() + ".naziv"), rs.getInt(getTableName() + ".ptt"));
    }

}
