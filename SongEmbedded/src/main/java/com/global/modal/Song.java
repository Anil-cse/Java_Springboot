package com.global.modal;


import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Song {
	
		@EmbeddedId
	    private SongId id;
	    private int duration;
	    private String genre;
	    private LocalDateTime releaseDate;
	    int rating;
	    private String downloadUrl;


}
