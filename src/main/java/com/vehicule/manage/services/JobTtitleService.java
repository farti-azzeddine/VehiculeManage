package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.JobTitle;
import com.vehicule.manage.repositories.JobTitleRepository;

@Service
public class JobTtitleService {
	
	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	
//	return list of Job Title 
	public List<JobTitle> getJobTitle(){
		return jobTitleRepository.findAll();
	}

	//save a new state
	public void save(JobTitle jobTitle) {
		jobTitleRepository.save(jobTitle);
	}
	
//	find country by id
	public Optional<JobTitle> findById(int id) {
		return jobTitleRepository.findById(id); 
	}

	public void delete(int id) {
		jobTitleRepository.deleteById(id);	
	}

}
