package com.codingdojo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.models.Song;
import com.codingdojo.services.SongService;


@Controller
public class SongController {
	private final SongService songService;
	
	//Constructor
	public SongController( SongService songService ) {
		this.songService = songService;
		
	}
	
	
	//Index
	@RequestMapping( value = "/", method = RequestMethod.GET )
	public String indexPage() {
		return "index.jsp";
	}
	
	//Retrieving all songs
	@RequestMapping( value = "/dashboard", method = RequestMethod.GET )
	public String displayAllSongs( @ModelAttribute( "song" ) Song song, Model model ) {
		List<Song> songList = songService.getAllSongs();
		
		model.addAttribute( "songList", songList );
		return "playlist.jsp";
	}
	
	//Show Top 10 songs
    @RequestMapping( value = "/songs/topTen", method=RequestMethod.GET )
	public String TopTen( Model model ) {
    	List<Song> songTop = songService.topTenByRating( );
    	
		model.addAttribute("songTop", songTop );
		return "topTen.jsp";
	}
	
	//Display form to create song
	@RequestMapping( value = "/songs/new", method = RequestMethod.GET )
	public String New(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	//Creating a language
	@RequestMapping( value = "/songs/new", method = RequestMethod.POST )
	public String createSong( @Valid @ModelAttribute( "song" ) Song song,
									  BindingResult result,
									  RedirectAttributes redirectAttributes ) {
		if( result.hasErrors() ) {
			return "new.jsp";
		}
		songService.createSong( song );
		return "redirect:/dashboard";
	}
	
	//Show
    @RequestMapping( value = "/songs/{id}", method=RequestMethod.GET )
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("song", songService.getSongById( id ) );
        return "show.jsp";
    }
    
    @RequestMapping(value = "/search", method=RequestMethod.GET )
	public String search( @RequestParam( value ="artist", required = false ) String artist, Model model ) {
    	List<Song> songSearhByArtist = songService.songsContainingArtist( artist );
    	
    	model.addAttribute( "artist", artist );
		model.addAttribute("songList",	songSearhByArtist );
		return "searh.jsp";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String Delete(@PathVariable("id") Long id) {
		songService.deleteSong( id );
		return "redirect:/dashboard";
	}
	
}
