package com.prodigy.ipaddresses.model;

import com.prodigy.ipaddresses.model.IpAddress;
import com.prodigy.ipaddresses.model.Subnet;
import com.prodigy.ipaddresses.service.IpAddressService;
import com.prodigy.ipaddresses.to.IpAddressView;
import com.prodigy.ipaddresses.to.IpSearch;
import com.prodigy.ipaddresses.utils.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class IpValidator implements Validator {

    @Autowired
    private IpAddressService service;

    @Override
    public boolean supports(Class<?> aClass) {
        return IpAddressView.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        IpAddressView ip = (IpAddressView) o;
        IpAddress ipAddress = DataUtils.clone(ip);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ipAddress", "ip.address.empty");

        Subnet subnet = service.getSubnet(ipAddress.getSubnet().getId());

        String subnetStr = subnet.getName();
        int end = subnetStr.lastIndexOf(".");
        subnetStr = subnetStr.substring(0, end);
        String ipStr = ip.getIpAddress();

        if(ipStr.length() > end){
            if (!subnetStr.equals(ipStr.substring(0, end))) {
                errors.rejectValue("ipAddress", "ip.address.not.equal");
            }
        }else{
            errors.rejectValue("ipAddress", "ip.address.too.short");
        }

        final String IPADDRESS_PATTERN =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);

        if(!pattern.matcher(ipStr).matches()){
            errors.rejectValue("ipAddress", "ip.address.doesnt.match");
        }

        if(ip.getId() == null && service.searchIp(new IpSearch(ipStr)) != null){
            errors.rejectValue("ipAddress", "ip.address.exists");
        }
    }
}
