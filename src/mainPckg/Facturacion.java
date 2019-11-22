/*
DDriver de Factura
 */
package mainPckg;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Facturacion {
    private ArrayList<Producto> producto = new ArrayList();
    private int cantidad, numeroFac;
    private double precioTot = 0;

    public Facturacion( int cantidad, int numeroFac) {
        this.cantidad = cantidad;
        this.numeroFac = numeroFac;
    }
    
    public void escribirArchivo() throws IOException {
        Date fechaRaw = new Date();
        String Fecha = fechaRaw.getDay() + "/" + fechaRaw.getMonth() + "/" + fechaRaw.getYear();
        File archivo = new File("./Factura "+numeroFac+".txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
                bw.write("        SuperMercado El Barrio");
                bw.write("  Factura#: "+numeroFac+"\t"+Fecha);
                bw.write("Produc.                Cant      Precio");
                for (int i = 0; i < producto.size(); i++) {
                    bw.write(Row(producto.get(i)));
                }
                bw.write("\t\t\tTotal:");
                bw.write("\t\t\t  L:"+CountTotal());
                bw.newLine();
            
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }

    private String Row(Producto p) {
        String format = "%15n\t%2d\tL.%.2f";
        return String.format(format, p.getNombre(), this.cantidad, p.getPrecio());
    }
    
    private double CountTotal(){
        for (Producto producto1 : producto) {
            precioTot += producto1.getPrecio();
        }
        return precioTot;
    }
    
    
}
