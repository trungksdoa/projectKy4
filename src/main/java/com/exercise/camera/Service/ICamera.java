/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.camera.Service;
import java.util.List;
import com.exercise.camera.Model.Camera;
/**
 *
 * @author trung
 */
public interface ICamera {
    List<Camera> findAll();
    List<Camera> findAll(String min, String max);

    List<Camera> findAllMin(String min);

    List<Camera> findAllMax(String max);
    Camera findById(String id);
    void Delete(Camera camera);
    void save(Camera camera);
}
