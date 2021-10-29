package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Song;
import com.codingdojo.repositories.SongRepository;


@Service
public class SongService {
	//Attribute
	private final SongRepository songRepository;
	
	//Constructor
	public SongService( SongRepository songRepository ) {
		this.songRepository = songRepository;
	}
	
	//Create
	public Song createSong( Song song ) {
		return songRepository.save( song );
	}
	
	//Update
		public Song updateSong( Song song ) {
			return songRepository.save( song );
		}
	
	
	
	//Retrieve all languages
	public List<Song> getAllSongs(){
			return songRepository.findAll();
		}
	
	//Retrieve by Id
	public Song getSongById( Long id ) {
		Optional<Song> optionalLanguage = songRepository.findById( id );
		if( optionalLanguage.isPresent() ) {
			return optionalLanguage.get();
		}
		else {
			return null;
		}
	}
	
	//Delete
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}

}

