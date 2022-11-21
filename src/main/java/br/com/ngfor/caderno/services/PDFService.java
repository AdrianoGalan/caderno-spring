package br.com.ngfor.caderno.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;
import javax.validation.ReportAsSingleViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.ngfor.caderno.DTO.AlarmeDTO;
import br.com.ngfor.caderno.model.Alarme;
import br.com.ngfor.caderno.model.Usuario;
import br.com.ngfor.caderno.repository.AlarmeRepository;

@Service
public class PDFService {

	@Autowired
	private AlarmeRepository rep;


	public Document gerarPdf(HttpServletResponse response) throws DocumentException, IOException {
		
		Document doc = new Document();
		
		String name = "teste";
		
		
		//tipo de conteúdo
		response.setContentType("application/pdf");
		
		//nome documento
		response.addHeader("Content-Disposition", "inline;filename=\"" + name + "\"");
		//criar o documento
		PdfWriter.getInstance(doc, response.getOutputStream());
		doc.open();
		doc.add(new Paragraph("teste pdf"));
		doc.close();
		
		return doc;
		
		
		
	}
}
