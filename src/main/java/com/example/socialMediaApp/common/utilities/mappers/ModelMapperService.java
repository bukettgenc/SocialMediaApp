package com.example.socialMediaApp.common.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	
	ModelMapper forRequest();

	ModelMapper forResponse();
	
}
