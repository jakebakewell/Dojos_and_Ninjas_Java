package com.jb.dojoninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jb.dojoninjas.models.Dojo;
import com.jb.dojoninjas.models.Ninja;
import com.jb.dojoninjas.repositories.DojoRepository;
import com.jb.dojoninjas.repositories.NinjaRepository;

@Service
public class DNService {
	private final NinjaRepository ninjaRepository;
	private final DojoRepository dojoRepository;
	public DNService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
	
	public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
	
	public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
	
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }
    
	public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
	
	public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
	
	public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
	
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
    }
}
