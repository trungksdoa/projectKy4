/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.camera.Repository;

import com.exercise.camera.Model.Camera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author trung
 */
public interface CameraRepository extends JpaRepository<Camera, String> {

    @Query("Select u from Camera u Where u.price Between :min AND :max")
    List<Camera> findAllByNumber(@PathVariable("min") int min, @PathVariable("max") int max);

    @Query("Select u from Camera u Where u.price >= :min")
    List<Camera> findAllByMin(@PathVariable("min") int min);

    @Query("Select u from Camera u Where u.price <= :max")
    List<Camera> findAllByMax(@PathVariable("min") int max);
    
    Camera getOne(String id);
   
}
