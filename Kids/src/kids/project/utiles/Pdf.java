/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kids.project.utiles;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javafx.collections.ObservableList;
import kids.project.entities.enfant;
import kids.project.entities.enfantClasse;
import kids.project.services.ServiceEnfant;

/**
 *
 * @author ferjani
 */
public class Pdf {
     //webcam.main(args);  
    public void GeneratePdf(String filename) throws FileNotFoundException, DocumentException, BadElementException, IOException, InterruptedException, SQLException
    {
        Document document=new  Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename+".pdf"));
        
        document.open();
   Date date = (Date) Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String strDate = dateFormat.format(date);  
                System.out.println("Converted String: " + strDate);  
        
         document.add(new Paragraph("Kidzyy"));
          document.add(new Paragraph( strDate));
         document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
        ServiceEnfant us=new ServiceEnfant();
        ObservableList<enfantClasse> list=us.readAll();
//        for(enfantClasse u:list)
//        {
//        document.add(new Paragraph("Nom :"+u.getNom_enfant()));
//        document.add(new Paragraph("Prenom :"+u.getPrenom_enfant()));
//        document.add(new Paragraph("Classe :"+u.getLibelle_cla()));
//        document.add(new Paragraph("Date de naissance :"+u.getDateN_enfant()));
//       
//        
//        document.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
//        }//Notification.main(args);
             Paragraph intro = new Paragraph("La liste des enfants");
             Paragraph space  = new Paragraph("");
             
             //create table
             
             PdfPTable table = new PdfPTable(4);
             
             //create cell
             
             PdfPCell c1 = new PdfPCell(new Paragraph("Nom"));
             PdfPCell c2 = new PdfPCell(new Paragraph("Prenom"));
             PdfPCell c3 = new PdfPCell(new Paragraph("Classe"));
             PdfPCell c4 = new PdfPCell(new Paragraph("Date de naissance"));
             
             table.addCell(c1);
             table.addCell(c2);
             table.addCell(c3);
             table.addCell(c4);
             
              for(enfantClasse u:list)
        {
             c1 = new PdfPCell(new Paragraph("Nom :"+u.getNom_enfant()));
             c2 = new PdfPCell(new Paragraph("Prenom :"+u.getPrenom_enfant()));
             c3 = new PdfPCell(new Paragraph("Classe :"+u.getLibelle_cla()));
             c4 = new PdfPCell(new Paragraph("Date de naissance :"+u.getDateN_enfant()));
             
             table.addCell(c1);
             table.addCell(c2);
             table.addCell(c3);
             table.addCell(c4);
        }
                 
             
              document.add(intro);
              document.add(space);
              document.add(table);
              
        document.close();
        Process pro=Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+filename+".pdf");
    }
}
