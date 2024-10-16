package com.cch.services.implementation;


import com.cch.repository.implementation.StatusDao;
import com.cch.models.entities.Status;

public class  StatusService {

    private StatusDao statusDao;

    public void setStatusDao(StatusDao statusDao) {
        this.statusDao = statusDao;
    }

    public void addStatus(Status status) {
        statusDao.saveStatus(status);
    }
}

