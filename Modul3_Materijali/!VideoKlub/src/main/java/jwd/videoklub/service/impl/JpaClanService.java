package jwd.videoklub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.videoklub.model.Clan;
import jwd.videoklub.repository.ClanRepository;
import jwd.videoklub.service.ClanService;

@Service
public class JpaClanService implements ClanService {

	@Autowired
	ClanRepository clanRepository;
	
	@Override
	public Clan findOne(Long id) {		
		return clanRepository.findOne(id);
	}

	@Override
	public Page<Clan> findAll(int page) {		
		return clanRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Clan save(Clan clan) {		
		return clanRepository.save(clan);
	}

	@Override
	public Clan delete(Long id) {
		Clan retVal = findOne(id);
		if(retVal == null) {
			throw new IllegalArgumentException("Tried to delete"
					+ " non-existing clan");
		}
		clanRepository.delete(id);
		return retVal;
	}

	@Override
	public Page<Clan> findByName(String name, int page) {		
		return clanRepository.findByImeContainingOrPrezimeContaining(name, name, new PageRequest(page, 10));
	}

}
