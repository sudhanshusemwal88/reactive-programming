package com.sudhanshu.reactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServicesTest {

    FluxAndMonoServices fluxAndMonoServices = new FluxAndMonoServices();

    @Test
    void employeeFlux() {
        var employeeFlux = fluxAndMonoServices.employeeFlux();
        StepVerifier.create(employeeFlux)
                .expectNext("sudhanshu","mickey","john")
                .verifyComplete();
    }

    @Test
    void employeeFluxMap() {
        var employeeFluxMap = fluxAndMonoServices.employeeFluxMap();
        StepVerifier.create(employeeFluxMap).expectNext("SUDHANSHU","MICKEY","JOHN").
                verifyComplete();
    }

    @Test
    void employeeFluxFliter() {
        var employeeFluxFilter = fluxAndMonoServices.employeeFluxFilter(5);
        StepVerifier.create(employeeFluxFilter).expectNext("sudhanshu","mickey").
                verifyComplete();
    }


    @Test
    void employeeFluxMapFilter() {
        var employeeFluxMapFilter = fluxAndMonoServices.employeeFluxMapFilter(5);
        StepVerifier.create(employeeFluxMapFilter).expectNext("SUDHANSHU","MICKEY").
                verifyComplete();
    }

    @Test
    void employeeMono() {

        var employeeMono = fluxAndMonoServices.employeeMono();
        StepVerifier.create(employeeMono).expectNext("sudhanshu").
                verifyComplete();

    }

    @Test
    void employeeFluxFlatMap() {
        var employeeFluxFlatMap = fluxAndMonoServices.employeeFluxFlatMap();
        StepVerifier.create(employeeFluxFlatMap).expectNextCount(19).
                verifyComplete();
    }
}