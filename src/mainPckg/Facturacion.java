/*
DDriver de Factura
 */
package mainPckg;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Facturacion {
    private ArrayList<Producto> producto = new ArrayList();
    private ArrayList<Integer> cantidad = new ArrayList();
    private int  numeroFac;
    private double precioTot = 0;

    public Facturacion(int numeroFac, ArrayList<Producto> producto, ArrayList<Integer> cantidad) {
        this.numeroFac = numeroFac;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    public void escribirArchivo() throws IOException {
        Date fechaRaw = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        form.format(fechaRaw);
        File archivo = new File("./Factura "+numeroFac+".txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
                bw.write("        SuperMercado El Barrio\n");
                bw.write("  Factura#: "+numeroFac+"\t"+form.format(fechaRaw)+"\n");
                bw.write("Produc.                Cant      Precio\n");
                for (int i = 0; i < producto.size(); i++) {
                    
                    bw.write(Row(producto.get(i), i)+"\n");
                }
                System.out.println("Holis");
                bw.write("\t\t\tTotal:"+"\n");
                bw.write("\t\t\t  L:"+CountTotal()+"\n");
                bw.newLine();
            
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    private String Row(Producto p, int pos) {
        String format = "%-15s\t\t%2d\tL.%.2f";
        return String.format(format, p.getNombre(), this.cantidad.get(pos), p.getPrecio());
    }
    
    private double CountTotal(){
        for (int i = 0; i < producto.size(); i++) {
            precioTot += producto.get(i).getPrecio() * cantidad.get(i);
        }
        return precioTot;
    }
    
    
}
