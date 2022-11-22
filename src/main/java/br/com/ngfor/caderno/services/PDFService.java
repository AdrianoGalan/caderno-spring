package br.com.ngfor.caderno.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import br.com.ngfor.caderno.model.Maquina;

@Service
public class PDFService {

	private MaquinaService serviceMaq;

	public PDFService(MaquinaService serviceMaq) {
		super();
		this.serviceMaq = serviceMaq;
	}

	public ByteArrayInputStream gerarPdf() throws IOException {
		
		List<Maquina> maquinas = this.serviceMaq.getAll();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		PdfDocument pdfDocument = new PdfDocument(new PdfWriter(baos));

		pdfDocument.setDefaultPageSize(PageSize.A4);

		Document document = new Document(pdfDocument);

		Paragraph title = new Paragraph("Relatorio maquinas").setFontSize(20)
				.setFont(PdfFontFactory.createFont(StandardFonts.COURIER_BOLD)).setTextAlignment(TextAlignment.CENTER);

		document.add(title);
		document.add(new Paragraph("\n"));
		
		for (Maquina maquina : maquinas) {
			document.add(new Paragraph(maquina.toString()));
			document.add(new Paragraph("\n"));
		}
	
		
		

		document.close();

		return new ByteArrayInputStream(baos.toByteArray());

	}
}
