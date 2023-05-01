package com.global.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Song;
import com.global.modal.SongId;


@Repository
public interface SongRepo extends JpaRepository<Song, SongId>{

}
