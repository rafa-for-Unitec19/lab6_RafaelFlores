/*
Clase para escritura/Lectura de Archivo
 */
package mainPckg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class ManejoProducto {
    private ArrayList<Producto> listaProducto = new ArrayList<>();
    private File archivo = null;

    public ManejoProducto(String path) {
        archivo = new File(path);
    }

    public ArrayList<Producto> getListaPersona() {
        return listaProducto;
    }

    public void setListaPersona(ArrayList<Producto> listaPersona) {
        this.listaProducto = listaPersona;
    }
    
    public void setPersona(Producto p) {
        this.listaProducto.add(p);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Producto p : listaProducto) {
                bw.write(p.getCodigo() + ";");
                bw.write(p.getCantAzucar()+ ";");
                bw.write(p.getCantAlcohol()+ ";");
                bw.write(p.getNumLote()+ ";");
                bw.write(p.getCantidad()+ ";");
                bw.write(p.getMarca()+ ";");
                bw.write(p.getNombre()+ ";");
                bw.write(p.getColorantes()+ ";");
                bw.write(p.getPrecio()+ ";");
                bw.write(p.getVence()+ ";");
                bw.write(p.isNacional()+ ";");
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
    
    public void cargarArchivo(){
        listaProducto = new ArrayList<>();
        if (archivo.exists()) {
            try {
                String linea;
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);
                while ((linea=br.readLine()) != null) {
                    String[] tokens = linea.split(";");
                    listaProducto.add(new Producto(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), tokens[5], tokens[6], tokens[7], Double.parseDouble(tokens[8]),
                    tokens[9], Boolean.parseBoolean(tokens[10])));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "listaPersona=" + listaProducto;
    }
}
