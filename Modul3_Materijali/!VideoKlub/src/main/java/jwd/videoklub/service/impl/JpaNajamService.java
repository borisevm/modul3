package jwd.videoklub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.videoklub.model.Najam;
import jwd.videoklub.repository.NajamRepository;
import jwd.videoklub.service.NajamService;

@Service
public class JpaNajamService implements NajamService {

	@Autowired
	NajamRepository najamRepository;
	
	@Override
	public Najam findOne(Long id) {		
		return najamRepository.findOne(id); 
	}

	@Override
	public Page<Najam> findAll(int page) {		
		return najamRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Najam save(Najam najam) {		
		return najamRepository.save(najam);
	}

	@Override
	public Najam delete(Long id) {
		Najam retVal = findOne(id);
		if(retVal == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ " non-existing najam");
		}
		najamRepository.delete(id);
		return retVal;
	}

}
