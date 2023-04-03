/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Ilija Dumanović
 */
public class Korisnik implements GenericEntity {

    private String username;
    private String password;
    private String ime;
    private String prezime;

    public Korisnik() {
    }

    public Korisnik(String username, String password, String ime, String prezime) {
        this.username = username;
        this.password = password;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        return Objects.equals(this.username, other.username);
    }

    

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime,prezime,username,password";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("' ,")
                .append("'").append(prezime).append("',")
                .append("'").append(username).append("' ,'")
                .append(password).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {
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
        return "";
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        return new Korisnik(rs.getString(getTableName()+".username"), rs.getString(getTableName()+".password"), rs.getString(getTableName()+".ime"), rs.getString(getTableName()+".prezime"));
    }

}
