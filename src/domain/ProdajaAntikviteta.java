/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Ilija Dumanović
 */
public class ProdajaAntikviteta implements GenericEntity {

    private Antikvitet antikvitet;
    private Aukcija aukcija;
    private BigDecimal cena;
    private Valuta valuta;

    public ProdajaAntikviteta(Antikvitet antikvitet, Aukcija aukcija, BigDecimal cena, Valuta valuta) {
        this.antikvitet = antikvitet;
        this.aukcija = aukcija;
        this.cena = cena;
        this.valuta = valuta;
    }

    public ProdajaAntikviteta() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final ProdajaAntikviteta other = (ProdajaAntikviteta) obj;
        return Objects.equals(this.antikvitet, other.antikvitet);
    }

    public Antikvitet getAntikvitet() {
        return antikvitet;
    }

    public void setAntikvitet(Antikvitet antikvitet) {
        this.antikvitet = antikvitet;
    }

    public Aukcija getAukcija() {
        return aukcija;
    }

    public void setAukcija(Aukcija aukcija) {
        this.aukcija = aukcija;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    @Override
    public String getTableName() {
        return "prodaja_antikviteta";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "antikvitet_id,aukcija_id,cena,valuta";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(antikvitet.getId()).append(",")
                .append(aukcija.getId()).append(",")
                .append(cena).append(",")
                .append("'").append(valuta).append("'");
        return sb.toString();
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public String getUpdateValues() {
        return "cena=" + cena + ",valuta= '" + valuta + "'";
    }

    @Override
    public String getJoinText() {
        return " JOIN antikvitet ON " + getTableName() + ".antikvitet_id=antikvitet.id JOIN aukcija ON aukcija.id=" + getTableName() + ".aukcija_id" + new Antikvitet().getJoinText();
    }

    @Override
    public String getSelectedText() {
        return "";
    }

    @Override
    public String getID() {
        return "aukcija_id=" + aukcija.getId() + " and antikvitet_id=" + antikvitet.getId();
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        antikvitet = new Antikvitet();
        aukcija = new Aukcija();
        return new ProdajaAntikviteta((Antikvitet) antikvitet.getEntity(rs), (Aukcija) aukcija.getEntity(rs), rs.getBigDecimal(getTableName() + ".cena"), Valuta.valueOf(rs.getString(getTableName() + ".valuta")));
    }
}
