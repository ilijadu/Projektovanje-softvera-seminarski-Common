/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;
import operation.Operation;

/**
 *
 * @author Ilija Dumanović
 */
public class Request implements Serializable {
    private Object obj;
    private operation.Operation operation;

    public Request() {
    }

    public Request(Object obj, Operation operation) {
        this.obj = obj;
        this.operation = operation;
    }

    public Object getObj() {
        return obj;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    
}
