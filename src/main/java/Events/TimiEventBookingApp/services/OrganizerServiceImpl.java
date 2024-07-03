package Events.TimiEventBookingApp.services;

import Events.TimiEventBookingApp.data.models.Organizer;
import Events.TimiEventBookingApp.data.repositories.OrganizerRepository;
import Events.TimiEventBookingApp.dtos.requests.RegisterOrganizerRequest;
import Events.TimiEventBookingApp.dtos.responses.RegisterOrganizerResponse;
import org.modelmapper.ModelMapper;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class OrganizerServiceImpl implements OrganizerService {
    private final OrganizerRepository organizerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;



    public OrganizerServiceImpl(OrganizerRepository organizerRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.organizerRepository = organizerRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public RegisterOrganizerResponse register(RegisterOrganizerRequest registerOrganizerRequest) {
        Organizer newOrganizer = modelMapper.map(registerOrganizerRequest, Organizer.class);
        newOrganizer.setPassword(passwordEncoder.encode(registerOrganizerRequest.getPassword()));
        newOrganizer = organizerRepository.save(newOrganizer);
        var registerOrganizerResponse = modelMapper.map(newOrganizer, RegisterOrganizerResponse.class);
        registerOrganizerResponse.setMessage("Organizer registered successfully");
        return registerOrganizerResponse;
    }
    }