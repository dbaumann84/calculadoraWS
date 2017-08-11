
package br.edu.ifc.calculadoraweb;

import javax.faces.bean.ManagedBean;
import javax.xml.ws.WebServiceRef;
import org.tempuri.Calculator;

@ManagedBean
public class CalculadoraBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.dneonline.com/calculator.asmx.wsdl")
    private Calculator service;
    private int valorA,valorB,resultado;

    public void somar(){
        this.resultado = add(valorA, valorB);
    }
    
    //Métodos especiais
    public int getValorA() {
        return valorA;
    }

    public void setValorA(int valorA) {
        this.valorA = valorA;
    }

    public int getValorB() {
        return valorB;
    }

    public void setValorB(int valorB) {
        this.valorB = valorB;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    

    private int add(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap();
        return port.add(intA, intB);
    }
    private int addi(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap();
        return port.add(intA, intB);
    }
    
}
