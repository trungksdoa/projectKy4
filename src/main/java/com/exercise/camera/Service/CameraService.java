/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.camera.Service;

import com.exercise.camera.Model.Camera;
import com.exercise.camera.Repository.CameraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trung
 */
@Service
public class CameraService implements ICamera {

    @Autowired

    CameraRepository res;

    @Override
    public List<Camera> findAll() {
        return res.findAll();
    }

    @Override
    public List<Camera> findAll(String min, String max) {
        return res.findAllByNumber(Integer.valueOf(min),Integer.valueOf(max));
    }

    @Override
    public List<Camera> findAllMin(String min) {
        return res.findAllByMin(Integer.valueOf(min));
    }

    @Override
    public List<Camera> findAllMax(String max) {
       return res.findAllByMin(Integer.valueOf(max));
    }

    @Override
    public void Delete(Camera camera) {
       res.delete(camera);
    }

    @Override
    public void save(Camera camera) {
        res.save(camera);
    }

    @Override
    public Camera findById(String id) {
      return res.getOne(id);
    }

}
