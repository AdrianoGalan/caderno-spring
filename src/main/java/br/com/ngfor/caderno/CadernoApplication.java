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
//			Usuario login = new Usuario(null, "Adriano Galan", "dricoo@hotmail.com", pe.encode("senha"), 1, 0);
//			login.addPerfil(Perfil.ADMIN);
//			
//			ur.save(login);
//			
//			
////			Maquina m = new Maquina(null, "aaa");
////			mr.save(m);
////			
////			Defeito d = new Defeito(null, "outro defeito", "arrumar a maquina",login, m);
////			dr.save(d);
////			
////			Alarme a = new Alarme(null, "al", "maquina não liga", "reset maquina",login, m);
////			ar.save(a);
////			Alarme a1 = new Alarme(null, "al1", "maquina não liga1", "reset maquina1",login, m);
////			ar.save(a1);
////			Alarme a2 = new Alarme(null, "al2", "maquina não liga2", "reset maquina2",login, m);
////			ar.save(a2);
////			Alarme a3 = new Alarme(null, "al3", "maquina não liga3", "reset maquina3",login, m);
////			ar.save(a3);
////			
//			
//	
//
//		};
//
//	}

}
