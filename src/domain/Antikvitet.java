/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ilija Dumanović
 */
public class Antikvitet implements GenericEntity {

    private int id;
    private String naziv;
    private BigDecimal vrednost;
    private Valuta valuta;
    private Vlasnik vlasnik;
    private TipAntikviteta tipAntikviteta;

    public Antikvitet() {
    }

    public Antikvitet(int id, String naziv, BigDecimal vrednost, Valuta valuta, Vlasnik vlasnik, TipAntikviteta tipAntikviteta) {
        this.id = id;
        this.naziv = naziv;
        this.vrednost = vrednost;
        this.valuta = valuta;
        this.vlasnik = vlasnik;
        this.tipAntikviteta = tipAntikviteta;
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

    public BigDecimal getVrednost() {
        return vrednost;
    }

    public void setVrednost(BigDecimal vrednost) {
        this.vrednost = vrednost;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public Vlasnik getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(Vlasnik vlasnik) {
        this.vlasnik = vlasnik;
    }

    public TipAntikviteta getTipAntikviteta() {
        return tipAntikviteta;
    }

    public void setTipAntikviteta(TipAntikviteta tipAntikviteta) {
        this.tipAntikviteta = tipAntikviteta;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getTableName() {
        return "antikvitet";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id,naziv,vrednost,valuta,vlasnik_id,tip_id";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(naziv).append("',")
                .append(vrednost)
                .append(",'").append(valuta.toString()).append("',")
                .append(vlasnik.getId()).append(",")
                .append(tipAntikviteta.getId());
        return sb.toString();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUpdateValues() {
        return "naziv = '"+ naziv +"' , vrednost= "+vrednost+", valuta= '"+valuta+"' ,vlasnik_id="+vlasnik.getId()+" ,tip_id= "+tipAntikviteta.getId();
    }

    @Override
    public String getJoinText() {
        return " JOIN vlasnik ON antikvitet.vlasnik_id=vlasnik.id JOIN mesto ON vlasnik.mesto_id=mesto.id JOIN tipantikviteta ON tipantikviteta.id=antikvitet.tip_id";
    }

    @Override
    public String getSelectedText() {
        return "";
    }

    @Override
    public String getID() {
        return "antikvitet.id="+id;
    }

    @Override
    public GenericEntity getEntity(ResultSet rs) throws SQLException {
        vlasnik = new Vlasnik();
        tipAntikviteta = new TipAntikviteta();
        return new Antikvitet(rs.getInt(getTableName() + ".id"), rs.getString(getTableName() + ".naziv"), rs.getBigDecimal(getTableName() + ".vrednost"), Valuta.valueOf(rs.getString(getTableName() + ".valuta")), (Vlasnik) vlasnik.getEntity(rs), (TipAntikviteta) tipAntikviteta.getEntity(rs));
    }
}
