package br.com.ngfor.caderno.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ngfor.caderno.services.PDFService;

@RestController
@RequestMapping("/api/pdf")
public class PDFController {

	private final PDFService service;

	public PDFController(PDFService service) {
		super();
		this.service = service;

	}

	@GetMapping("/gerar")
	public ResponseEntity<InputStreamResource> report() {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Disposition", "inline; filename=relatorio.pdf");

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
					.body(new InputStreamResource(this.service.gerarPdf()));

		} catch (Exception e) {
		
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}