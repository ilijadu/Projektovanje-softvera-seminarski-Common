/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ilija Dumanović
 */


public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues();

    void setId(int id);
    
    String getUpdateValues();
    
    String getJoinText();
    
    String getSelectedText();
    
    String getID();
    
    GenericEntity getEntity(ResultSet rs) throws SQLException;
}
