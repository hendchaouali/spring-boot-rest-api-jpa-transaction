package com.rest.transaction.web.resource;

import com.rest.transaction.model.Release;
import com.rest.transaction.service.IReleaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/releases")
public class ReleaseResource {

    private final IReleaseService releaseService;

    public ReleaseResource(IReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping
    public ResponseEntity<List<Release>> getAllReleases(){
        return new ResponseEntity<>(releaseService.getAllReleases(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveRelease(@Valid @RequestBody Release release){
        releaseService.saveRelease(release);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateRelease(@Valid @RequestBody Release release){
        releaseService.updateRelease(release);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getReleaseById(@PathVariable Long id){
        releaseService.getReleaseById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReleaseById(@PathVariable Long id){
        releaseService.deleteReleaseById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
