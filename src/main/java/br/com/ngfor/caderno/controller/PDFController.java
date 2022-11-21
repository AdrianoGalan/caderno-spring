package br.com.ngfor.caderno.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

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
	public HttpEntity<byte[]> gerarRelatorio(HttpServletResponse response) throws DocumentException, IOException {
		
		Document arquivo = service.gerarPdf(response);
		
		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.add("Content-Disposition", "attachment;filename=\"minha-imagem.jpg\"");

		HttpEntity<byte[]> entity = new HttpEntity<byte[]>(httpHeaders);

		return entity;
	
		
		
		
	}



}