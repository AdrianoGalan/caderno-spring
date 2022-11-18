package br.com.ngfor.caderno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.ngfor.caderno.model.Alarme;
import br.com.ngfor.caderno.model.Defeito;
import br.com.ngfor.caderno.model.Maquina;
import br.com.ngfor.caderno.model.Usuario;
import br.com.ngfor.caderno.model.enums.Perfil;
import br.com.ngfor.caderno.repository.AlarmeRepository;
import br.com.ngfor.caderno.repository.DefeitoRepository;
import br.com.ngfor.caderno.repository.MaquinaRepository;
import br.com.ngfor.caderno.repository.UsuarioRepository;

@SpringBootApplication
public class CadernoApplication {

	@Autowired
	private BCryptPasswordEncoder pe;

	public static void main(String[] args) {
		SpringApplication.run(CadernoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner iniciaBaseDados(DefeitoRepository dr, MaquinaRepository mr, AlarmeRepository ar, UsuarioRepository ur) {
//
//		return args -> {
//	
//
//		};
//
//	}

}
