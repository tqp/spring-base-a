package com.timsanalytics.springbase.controllers;

import com.timsanalytics.springbase.beans.KeyValue;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/diagnostics")
@Tag(name = "Diagnostics", description = "Diagnostics")
public class DiagnosticsController {

    @ResponseBody
    @RequestMapping(value = "/health-check", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get Server Health Check Response", description = "Get Server Health Check Response", tags = {"App"}, security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<KeyValue> getServerHealthCheck() {
        try {
            return ResponseEntity.ok()
                    .body(new KeyValue("server-health-check", "success"));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
