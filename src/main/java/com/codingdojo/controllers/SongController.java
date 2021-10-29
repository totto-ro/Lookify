package com.codingdojo.controllers;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.Song;
import com.codingdojo.services.SongService;



public class SongController {
	private final SongService songService;
	
	//Constructor
	public SongController( SongService songService ) {
		this.songService = songService;
		
	}
	
	//Retrieving all languages
	@RequestMapping( value = "/dashboard", method = RequestMethod.GET )
	public String displayAllSongs( @ModelAttribute( "song" ) Song song, Model model ) {
		List<Song> songList = songService.getAllSongs();
		
		model.addAttribute( "songList", songList );
		return "playlist.jsp";
	}
	
	//Show
    @RequestMapping( value = "/songs/{id}", method=RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", songService.getSongById( id ) );
        return "show.jsp";
    }
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String Delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/songs";
	}
	
}
