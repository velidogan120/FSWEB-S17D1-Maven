package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals =  new HashMap<>();
    @Value("${course.name}")
    private String courseName;
    @Value("${project.developer.fullname}")
    private String projectDeveloperFullname;

    @GetMapping("/values")
    public String values(){
        return courseName + " - " + projectDeveloperFullname;
    }

    @GetMapping
    public List<Animal> getAnimals(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public String getAnimals(@PathVariable Integer id){
        return animals.get(id).getName();
    }

    @PostMapping
    public Animal addAnimal(@RequestBody String name){
        Integer id = animals.size() + 1;
        Animal animal = new Animal(id,name);
        animals.put(id,animal);
        return animals.get(id);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id,@RequestBody String name){
        Animal animal = new Animal(id,name);
        animals.put(id,animal);
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id){
        animals.remove(id);
    }

}
