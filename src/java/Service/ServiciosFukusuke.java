/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ClienteDAO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author amlazo
 */
@WebService(serviceName = "ServiciosFukusuke")
public class ServiciosFukusuke {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getDatosPedido")
    public String getDatosPedido(@WebParam(name = "codigoPedido") int codigoPedido) {
        return "Los datos del pedido son " + codigoPedido ;
    }
    
    @WebMethod(operationName = "getDatosCliente")
    public static String getDatosCliente(@WebParam(name = "idCliente") int idCliente) {
        ClienteDAO cliente=new ClienteDAO();
        ArrayList<String> arreglo;
        arreglo=cliente.Leer(idCliente);
        return "Los datos del cliente con id: "+idCliente+" son " + arreglo;
    }
    
    @WebMethod(operationName = "setPedido")
    public boolean setPedido(@WebParam(name = "user") String user,@WebParam(name = "idMenu") int idMenu) {
        return false;
    }
    
    @WebMethod(operationName = "getListaMenu")
    public String getListaMenu() {
        return "Proximamente podra ver las lista de menus";
    }
    
    @WebMethod(operationName = "setEstadoPedido")
    public boolean setEstadoPedido(@WebParam(name = "codigoPedido") int codigoPedido,@WebParam(name = "estado") int estado) {
        return false;
    }
    
    @WebMethod(operationName = "getEstadoPedido")
    public String[] getEstadoPedido(@WebParam(name = "codigoPedido") int codigoPedido) {
        //Pruebas de arreglos en String para WebServices
        String[] estados= new String[2];
        estados[0]=String.valueOf(codigoPedido);
        estados[1]=String.valueOf(codigoPedido);
        
        return estados;
    }
}
