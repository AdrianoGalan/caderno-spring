package br.com.ngfor.caderno.controller;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itextpdf.text.DocumentException;

import br.com.ngfor.caderno.DTO.AlarmeDTO;
import br.com.ngfor.caderno.model.Alarme;
import br.com.ngfor.caderno.model.Maquina;
import br.com.ngfor.caderno.services.AlarmeService;
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
	public void gerarRelatorio(HttpServletResponse response) throws DocumentException, IOException {
		
	
		service.gerarPdf(response);
		
		
	}



}