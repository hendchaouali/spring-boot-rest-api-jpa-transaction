package com.rest.transaction.service;

import com.rest.transaction.model.Release;
import com.rest.transaction.repository.ReleaseRepository;
import com.rest.transaction.web.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReleaseServiceImpl implements IReleaseService {

    private static final Logger log = LoggerFactory.getLogger(ReleaseServiceImpl.class);

    private final ReleaseRepository releaseRepository;


    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Release> getAllReleases() {
        return releaseRepository.findAll();
    }

    @Override
    public void saveRelease(Release release) {
        releaseRepository.save(release);
    }

    @Override
    public void updateRelease(Release release) {
        releaseRepository.findById(release.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Not found release with id = " + release.getId()));
        releaseRepository.save(release);
    }

    @Override
    @Transactional(readOnly = true)
    public Release getReleaseById(Long id) {
        return releaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found release with id = " + id));
    }

    @Override
    public void deleteReleaseById(Long id) {
        releaseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found release with id = " + id));
        releaseRepository.deleteById(id);
    }
}
