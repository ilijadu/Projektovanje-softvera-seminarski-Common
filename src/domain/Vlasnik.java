/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Ilija Dumanović
 */
public class Vlasnik implements GenericEntity {

    private int id;
    private String ime, prezime;
    private LocalDate datumRodjenja;
    private Mesto mesto;

    public Vlasnik(int id, String ime, String prezime, LocalDate datumRodjenja, Mesto mesto) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.mesto = mesto;
    }

    public Vlasnik() {
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "vlasnik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,ime,prezime,datum,mesto_id";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(ime).append("',")
                .append("'").append(prezime).append("', '")
                .append(datumRodjenja).append("' ,")
                .append(mesto.getId());
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUpdateValues() {
        return "ime = '"+ime+"' , prezime= '"+prezime+"' , datum= '"+datumRodjenja+"' ,mesto_id="+mesto.getId();
    }

    @Override
    public String getJoinText() {
        return " JOIN mesto ON mesto.id=vlasnik.mesto_id";
    }

    @Override
    public String getSelectedText() {
        return "";
    }

    @Override
    public String getID() {
        return getTableName() + ".id=" + id;
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        mesto = new Mesto();
        return new Vlasnik(rs.getInt(getTableName() + ".id"), rs.getString(getTableName() + ".ime"), rs.getString(getTableName() + ".prezime"), rs.getDate(getTableName() + ".datum").toLocalDate(), (Mesto) mesto.getEntity(rs));
    }

}
