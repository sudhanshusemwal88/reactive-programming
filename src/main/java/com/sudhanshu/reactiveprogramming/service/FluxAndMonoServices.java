package com.sudhanshu.reactiveprogramming.service;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxAndMonoServices {

    public Flux<String> employeeFlux(){
        return Flux.fromIterable(List.of("sudhanshu","mickey","john")).log();
    }

    public Flux<String> employeeFluxMap(){
        return Flux.fromIterable(List.of("sudhanshu","mickey","john")).
                map(String::toUpperCase).log();
    }

    public Flux<String> employeeFluxFilter(int num){
        return Flux.fromIterable(List.of("sudhanshu","mickey","john")).
                filter(s -> s.length()>num).log();
    }

    public Flux<String> employeeFluxMapFilter(int num){
        return Flux.fromIterable(List.of("sudhanshu","mickey","john")).
                filter(s -> s.length()>num).map(String::toUpperCase).log();
    }

    public Flux<String> employeeFluxFlatMap(){
        return Flux.fromIterable(List.of("sudhanshu","mickey","john")).
                flatMap(s -> Flux.just(s.split(""))).log();
    }

    public Flux<String> employeeMono(){
        return Flux.fromIterable(List.of("sudhanshu")).log();
    }
}
