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
	
	//Append an optional numeric value to top or first to specify the maximum result size to be returned:
	
	//Slice<Song> findTop3ByName(String name, Pageable pageable);
	//Song findFirstByOrderByLastnameAsc();
	//Song findTopByOrderByAgeDesc();
	//List<Song> findFirst10ByName(String name, Sort sort);
	List<Song> findTop10ByOrderByRatingDesc();
	
	List<Song> findByArtistContaining(String artist);
	
	//directly ….filter(…) and ….map(…) over the elements and concatenate the Streamable to others:
	
	// Streamable<Person> findByFirstnameContaining(String firstname);
	// Streamable<Person> findByLastnameContaining(String lastname);
	
	//Streamable<Person> result = repository.findByFirstnameContaining("av")
	//  .and(repository.findByLastnameContaining("ea"));
}