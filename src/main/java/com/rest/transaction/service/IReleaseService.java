package com.rest.transaction.service;

import com.rest.transaction.model.Ticket;
import com.rest.transaction.model.Release;

import java.util.List;

public interface IReleaseService {

    List<Release> getAllReleases();

    void saveRelease(Release release);

    void updateRelease(Release release);

    Release getReleaseById(Long id);

    void deleteReleaseById(Long id);

}
