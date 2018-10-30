package fpt.oceanstudy.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fpt.oceanstudy.entity.OsFish;
import fpt.oceanstudy.repository.FishRepository;

@Controller
public class FishController {

    /** For logging. */
    private final static Logger LOG = LoggerFactory.getLogger(FishController.class);
    
    @Autowired
    FishRepository fishRepository;
    
    @GetMapping("/getAllFish")
    @ResponseBody
    public List<OsFish> getAllFish() {
        
        return (List<OsFish>) fishRepository.findAll();
    }
}
