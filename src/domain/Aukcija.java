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
public class Aukcija implements GenericEntity {
    private int id;
    private String naziv;
    private LocalDate datumOdrzavanja;
    private Mesto mesto;

    public Aukcija() {
    }

    public Aukcija(int id, String naziv, LocalDate datumOdrzavanja, Mesto mesto) {
        this.id = id;
        this.naziv = naziv;
        this.datumOdrzavanja = datumOdrzavanja;
        this.mesto = mesto;
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

    public LocalDate getDatumOdrzavanja() {
        return datumOdrzavanja;
    }

    public void setDatumOdrzavanja(LocalDate datumOdrzavanja) {
        this.datumOdrzavanja = datumOdrzavanja;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return "Aukcija{" + "id=" + id + ", naziv=" + naziv + '}';
    }

    @Override
    public String getTableName() {
        return "aukcija";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,naziv,datum,mesto_id";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(naziv).append("', '")
                .append(datumOdrzavanja).append("' ,")
                .append(mesto.getId());
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public String getUpdateValues() {
        return "naziv = '"+naziv+"' , datum= '"+datumOdrzavanja+"' ,mesto_id="+mesto.getId();
    }

    @Override
    public String getID() {
        return "aukcija.id="+id;
    }

    @Override
    public String getJoinText() {
        return " JOIN mesto ON mesto.id=aukcija.mesto_id";
    }

    @Override
    public String getSelectedText() {
        return "";
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        mesto = new Mesto();
        return new Aukcija(rs.getInt(getTableName()+".id"), rs.getString(getTableName()+".naziv"), rs.getDate(getTableName()+".datum").toLocalDate(), (Mesto)mesto.getEntity(rs));
    }
}
