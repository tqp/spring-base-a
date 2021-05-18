package com.timsanalytics.springbase.controllers;

import com.timsanalytics.springbase.beans.KeyValue;
import com.timsanalytics.springbase.services.MainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/main")
@Tag(name = "Main", description = "Main")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @ResponseBody
    @RequestMapping(value = "/get-header", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Main", summary = "The main endpoint.", tags = {"Main"})
    public ResponseEntity<KeyValue> getMain() {
        try {
            return ResponseEntity.ok()
                    .body(mainService.getMain());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
