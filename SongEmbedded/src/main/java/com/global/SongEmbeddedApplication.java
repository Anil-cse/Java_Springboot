package com.global;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.global.modal.Song;
import com.global.modal.SongId;
import com.global.repo.SongRepo;

@SpringBootApplication
public class SongEmbeddedApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SongEmbeddedApplication.class, args);
	}

	@Autowired
	SongRepo songRepo;
	
	@Override
	public void run(String... args) throws Exception {

		LocalDateTime releaseDate = LocalDateTime.now();
		
		SongId songId2 = new SongId("jane na", "emotional", "arjit");
		Song song1 = new Song(songId2, 23, "romantic",releaseDate, 3, "http://download.this.song1");
		songRepo.save(song1);

		
	}

}
