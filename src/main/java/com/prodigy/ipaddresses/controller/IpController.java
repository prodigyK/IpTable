package com.prodigy.ipaddresses.controller;


import com.prodigy.ipaddresses.model.*;
import com.prodigy.ipaddresses.to.IpAddressFilter;
import com.prodigy.ipaddresses.service.IpAddressService;
import com.prodigy.ipaddresses.to.IpAddressView;
import com.prodigy.ipaddresses.to.IpSearch;
import com.prodigy.ipaddresses.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "ip")
public class IpController {

    @Autowired
    private IpAddressService service;

    @Autowired
    private IpValidator ipValidator;

    @InitBinder("ipAddressView")
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(ipValidator);
    }

    @RequestMapping(value = "main")
    public String listIpAddressesByDefault(Model model) {

        model.addAttribute("listIpAddresses", service.getByFilter(new IpAddressFilter(1000, null, 1000)));

        return "iptable";
    }

    @RequestMapping(value = "search")
    public String searchIp(@ModelAttribute("ipSearch") IpSearch search, Model model) {

        IpAddress ip = service.searchIp(search);
        List<IpAddress> list = new ArrayList<>();
        if(ip != null){
            list.add(ip);
        }
        model.addAttribute("listIpAddresses", list);

        return "iptable";
    }

    @RequestMapping(value = "addNew", method = RequestMethod.GET)
    public String addIp(Model model) {

        model.addAttribute("ipAddressView", new IpAddressView());
        model.addAttribute("departments", service.getAllDepartments());
        model.addAttribute("deviceTypes", service.getAllDeviceTypes());
        model.addAttribute("subnets", service.getAllSubnets());

        return "edit";
    }

    @RequestMapping(value = "add", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST)
    public String addNewIp(@ModelAttribute("ipAddressView")@Validated IpAddressView ipAddressView, BindingResult result, Model model) {

        if(result.hasErrors()){
            model.addAttribute("departments", service.getAllDepartments());
            model.addAttribute("deviceTypes", service.getAllDeviceTypes());
            model.addAttribute("subnets", service.getAllSubnets());
            return "edit";
        }

        IpAddress ip = DataUtils.clone(ipAddressView);

        ip = service.save(ip);

        model.addAttribute("listIpAddresses", Arrays.asList(service.searchIp(new IpSearch(String.valueOf(ip.getIpAddress())))));


        return "iptable";
    }

    @RequestMapping(value = "showFilter", method = RequestMethod.GET)
    public String filter(Model model) {

        model.addAttribute("ipAddressFilter", new IpAddressFilter());
        model.addAttribute("departments", service.getAllDepartments());
        model.addAttribute("deviceTypes", service.getAllDeviceTypes());
        model.addAttribute("subnets", service.getAllSubnets());
        model.addAttribute("filter", true);

        return "iptable";
    }

    @RequestMapping(value = "filtered", method = RequestMethod.POST)
    public String filter(@ModelAttribute("ipAddressFilter") IpAddressFilter ip, Model model) {

        List<IpAddress> list = service.getByFilter(new IpAddressFilter(ip.getDepartment(), ip.getSubnet(), ip.getDeviceType()));

        model.addAttribute("listIpAddresses", list);
        model.addAttribute("departments", service.getAllDepartments());
        model.addAttribute("deviceTypes", service.getAllDeviceTypes());
        model.addAttribute("subnets", service.getAllSubnets());
        model.addAttribute("filter", true);

        return "iptable";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String showEdit(@PathVariable("id") Integer id, Model model) {

        IpAddress ipAddress = service.get(id);

        IpAddressView ipAddressView = DataUtils.clone(ipAddress);

        model.addAttribute("ipAddressView", ipAddressView);
        model.addAttribute("departments", service.getAllDepartments());
        model.addAttribute("deviceTypes", service.getAllDeviceTypes());
        model.addAttribute("subnets", service.getAllSubnets());
        model.addAttribute("edit", true);


        return "edit";

    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id, Model model) {

        boolean deleted = service.delete(id);

        model.addAttribute("deleted", deleted);
        model.addAttribute("deleteBlock", true);

        return "messages";

    }

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public String history(Model model){

        model.addAttribute("listHistory", service.getHistory());

        return "history";
    }
}
