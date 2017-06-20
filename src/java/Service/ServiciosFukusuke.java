/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ClientesDAO;
import DAO.PromocionesDAO;
import DAO.VentasDAO;
import entity.Ventas;
import java.sql.Date;
import org.json.JSONArray;
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
        VentasDAO ventas=new VentasDAO();
        JSONArray arreglo;
        arreglo=ventas.Leer(codigoPedido);
        return arreglo.toString();
    }
    
    @WebMethod(operationName = "getDatosCliente")
    public String getDatosCliente(@WebParam(name = "usuario") String usuario) {
        ClientesDAO cliente=new ClientesDAO();
        JSONArray arreglo;
        arreglo=cliente.Leer(usuario);
        return "{ \"usuarios\": "+arreglo.toString()+"}";
    }
    
    @WebMethod(operationName = "setPedido")
    public boolean setPedido(@WebParam(name = "user") String user,@WebParam(name = "idMenu") int idMenu) {
        try{
            PromocionesDAO menues=new PromocionesDAO();
            ClientesDAO clientes=new ClientesDAO();
            int precio=menues.ObtenerPrecio(idMenu);
            int idSucursal=menues.ObtenerSucursal(idMenu);
            int idCliente=clientes.ObtenerId(user);
            Date fecha=new Date(95, 8, 24);
            Ventas venta=new Ventas(12334, precio, 0, 0, fecha , fecha ,1, 1, idSucursal, idCliente);
            
            VentasDAO ventas=new VentasDAO();
            return ventas.Insertar(venta);
        }catch(Exception e){
            return false;
        }
        
    }
    
    @WebMethod(operationName = "getListaMenu")
    public String getListaMenu() {
        PromocionesDAO promociones=new PromocionesDAO();
        JSONArray arreglo;
        arreglo=promociones.LeerTodo();
        return "{ \"menus\": "+arreglo.toString()+"}";
    }
    
    @WebMethod(operationName = "getIdMenu")
    public int getIdMenu(@WebParam(name = "descripcion") String descripcion) {
        PromocionesDAO promociones=new PromocionesDAO();
        return promociones.obtenerID(descripcion);
    }
    
    @WebMethod(operationName = "setEstadoPedido")
    public boolean setEstadoPedido(@WebParam(name = "codigoPedido") int codigoPedido,@WebParam(name = "estado") int estado) {
        VentasDAO ventas=new VentasDAO();
        return ventas.cambiarEstado(estado,codigoPedido);
    }
    
    @WebMethod(operationName = "getEstadoPedido")
    public int getEstadoPedido(@WebParam(name = "codigoPedido") int codigoPedido) {
        VentasDAO ventas=new VentasDAO();
        return ventas.obtenerEstado(codigoPedido);
    }
}
