package org.FelipeBert.music;

import org.FelipeBert.music.principal.Principal;
import org.FelipeBert.music.repository.CantorRepository;
import org.FelipeBert.music.service.ICantorService;
import org.FelipeBert.music.service.impl.CantorServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMusicApplication implements CommandLineRunner {

	private final CantorRepository cantorRepository;

	public ScreenMusicApplication(CantorRepository cantorRepository) {
		this.cantorRepository = cantorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ScreenMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ICantorService cantorService = new CantorServiceImpl(cantorRepository);

		Principal principal = new Principal(cantorService);
		principal.exibiMenu();
	}
}
