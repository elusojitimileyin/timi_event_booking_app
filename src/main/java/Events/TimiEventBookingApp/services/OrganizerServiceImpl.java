package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.data.models.Organizer;
import Events.TimiEventBookingApp.data.repositories.OrganizerRepository;
import Events.TimiEventBookingApp.dtos.requests.RegisterOrganizerRequest;
import Events.TimiEventBookingApp.dtos.responses.RegisterOrganizerResponse;
import org.modelmapper.ModelMapper;


import org.springframework.stereotype.Service;


@Service
public class OrganizerServiceImpl implements OrganizerService {
    private final OrganizerRepository organizerRepository;
    private final ModelMapper modelMapper;



    public OrganizerServiceImpl(OrganizerRepository organizerRepository,  ModelMapper modelMapper) {
        this.organizerRepository = organizerRepository;
        this.modelMapper = modelMapper;

    }
    @Override
    public RegisterOrganizerResponse register(RegisterOrganizerRequest registerOrganizerRequest) {
        Organizer newOrganizer = modelMapper.map(registerOrganizerRequest, Organizer.class);
        newOrganizer.setPassword((registerOrganizerRequest.getPassword()));
        newOrganizer = organizerRepository.save(newOrganizer);
        var registerOrganizerResponse = modelMapper.map(newOrganizer, RegisterOrganizerResponse.class);
        registerOrganizerResponse.setMessage("Organizer registered successfully");
        return registerOrganizerResponse;
    }


}