package com.codingdojo.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.codingdojo.models.Song;

public interface SongRepository extends Repository <Song, Long> {
	
	List<Song> findAll();
	
	Optional<Song> findById( Long id );
	
	Song save( Song song );
	
	// DELETE FROM hobbies WHERE identifier = id
	Long deleteById( Long id );

}