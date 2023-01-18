/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionModelo;


import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author Frank E Gil M
 */
public class GestorPdf {

    private static String ruta = System.getProperty("user.home") + "/Desktop/";

    public void crearPdf(String numeroGuia, String correo, String procedimiento, String materiales, String saberes, ArrayList<String> datos) throws FileNotFoundException, DocumentException {
        FileOutputStream archivo = new FileOutputStream(GestorPdf.ruta + correo + ".pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, archivo);
        //Fuentes y tamaño:
        Font tituloPricipal = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
        Font tituloSecundario = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD);
        Font texto = new Font(Font.FontFamily.TIMES_ROMAN, 15);

        documento.open();

        Paragraph parrafo = new Paragraph(("PRACTICA DE LABORATORIO #" + numeroGuia + "_GUIA DEL ESTUDIANTE:" + correo), tituloPricipal);
        parrafo.setAlignment(1);
        documento.add(parrafo);

        documento.add(new Paragraph("Materiales: ", tituloSecundario));
        documento.add(new Chunk(materiales, texto));
        documento.add(new Paragraph("Procedimientos: ", tituloSecundario));
        documento.add(new Chunk(procedimiento, texto));
        documento.add(new Paragraph("Saberes: ", tituloSecundario));
  //      documento.add(new Chunk(saberes, texto));
        documento.close();

        JOptionPane.showMessageDialog(null, "pdf creado", "Aviso", 1);
    }

    public void abrirPdf(String nombrePdf) {
        if (!nombrePdf.isEmpty()) {
            try {
                File path = new File(GestorPdf.ruta + nombrePdf + ".pdf");
                Desktop.getDesktop().open(path);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Alerta", 1);
            }
        } else {
            JOptionPane.showMessageDialog(null, "pdf creado", "Alerta", 1);
        }
    }
}
