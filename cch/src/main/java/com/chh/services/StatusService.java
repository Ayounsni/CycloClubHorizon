package com.chh.services;

import com.chh.models.entities.Status;
import com.chh.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {


    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }

    public Status getStatusById(Long id) {
        return statusRepository.findById(id).orElse(null);
    }

    public void createStatus(Status status) {
        statusRepository.save(status);
    }

    public Status updateStatus(Long id, Status statusDetails) {
        Status status = statusRepository.findById(id).orElse(null);
        if (status != null) {
            status.setNom(statusDetails.getNom());
            return statusRepository.save(status);
        }
        return null;
    }

    public void deleteStatus(Long id) {
        statusRepository.deleteById(id);
    }
}

