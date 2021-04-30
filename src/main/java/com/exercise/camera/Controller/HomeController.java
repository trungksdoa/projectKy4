/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.camera.Controller;

import com.exercise.camera.Model.Camera;
import com.exercise.camera.Service.CameraService;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author trung
 */
@Controller
public class HomeController {

    @Autowired

    CameraService service;

    @RequestMapping("/home")
    public String index(Model model) {
        model.addAttribute("list", service.findAll());
        return "index";
    }

    @RequestMapping("/search")
    public String Search(@PathParam("min") String min, @PathParam("max") String max, Model model) {

        if (!min.isEmpty() && max.isEmpty()) {
            model.addAttribute("list", service.findAllMin(min));
        } else if (!max.isEmpty() && min.isEmpty()) {
            model.addAttribute("list", service.findAllMax(max));
        } else if (max.isEmpty() && min.isEmpty()) {
            model.addAttribute("list", service.findAll());
        } else if (!min.isEmpty() && !max.isEmpty()) {
            model.addAttribute("list", service.findAll(min, max));
        }
        return "index";

    }

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("camera", new Camera());
        return "create_form";
    }

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String processAdd(@Valid @ModelAttribute("camera") Camera camera, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "create_form";
        } else {
            service.save(camera);
            return "redirect:/";
        }

    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes model) {
        Camera camera = service.findById(id);
        if (camera != null) {
            service.Delete(camera);

        }
        model.addFlashAttribute("message", "xoa thanh cong");
        return "redirect:/";
    }
}
