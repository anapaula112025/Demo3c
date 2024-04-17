package com.example.democ3.controller;

import com.example.democ3.entity.Shipper;
import com.example.democ3.repository.ShipperRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/shipper")
public class ShipperController {

    final ShipperRepository shipperRepository;

    public ShipperController(ShipperRepository shipperRepository){
        this.shipperRepository = shipperRepository;
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<Shipper> shipperList = shipperRepository.findAll();
        model.addAttribute("listaTransportistas",shipperList);
        return "shipper/lista";

    }

    @GetMapping("/new")
    public String nuevoTransportistaFrm(){

        return "shipper/newFrm";

    }

    @PostMapping("/guardar")
    public String guardarNuevoTransportista(Shipper shipper){
        shipperRepository.save(shipper);
        return "redirect:/shipper/listar";
    }

    @GetMapping("/editar")
    public String editarTransportista(Model model,
                                      @RequestParam("id") int id){
        Optional<Shipper> optShipper = shipperRepository.findById(id);//Si recibo valores de la BD
        if(optShipper.isPresent()){
            Shipper shipper =optShipper.get();
            model.addAttribute("transportista",shipper);
            return "shipper/editFrm";
        } else{
            return "redirect:/shipper/listar";
        }

    }

    @GetMapping("/borrar")
    public String borrarTransportista(Model model,
                                      @RequestParam("id") int id){
        Optional<Shipper> optShipper = shipperRepository.findById(id);//Si recibo valores de la BD
        if(optShipper.isPresent()){
            shipperRepository.deleteById(id);
        }
        return "redirect:/shipper/listar";



    }


}
