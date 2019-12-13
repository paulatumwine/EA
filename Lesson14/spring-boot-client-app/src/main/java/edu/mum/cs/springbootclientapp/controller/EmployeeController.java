package edu.mum.cs.springbootclientapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs.springbootclientapp.model.Employee;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Arrays;

@Controller
public class EmployeeController {


    @GetMapping({"/", "/getEmployees"})
    public String getEmployeeInfo() {
        return "employeelist";
    }

    @GetMapping("/showEmployees")
    public String showEmployees(@RequestParam("code") String code, Model model) throws IOException {
        System.out.println("Authorization Code------" + code);
        ResponseEntity<String> response = null;

        RestTemplate restTemplate = new RestTemplate();

        // According OAuth documentation we need to send the client id and secret key in the header for authentication
        String credentials = "cs544:secret";
        String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Basic " + encodedCredentials);

        HttpEntity<String> request = new HttpEntity<String>(headers);

        String access_token_url = "http://localhost:8080/oauth/token";
        access_token_url += "?code=" + code;
        access_token_url += "&grant_type=authorization_code";
        access_token_url += "&redirect_uri=http://localhost:8090/showEmployees";

        response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

        System.out.println("Access Token Response ---------" + response.getBody());


        // Get the Access Token From the recieved JSON response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(response.getBody());
        String token = node.path("access_token").asText();

        String url = "http://localhost:8080/user/getEmployeesList";

        // Use the access token for authentication
        HttpHeaders headers1 = new HttpHeaders();
        headers1.add("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers1);

        ResponseEntity<Employee[]> employees = restTemplate.exchange(url, HttpMethod.GET, entity, Employee[].class);
        System.out.println(employees);
        Employee[] employeeArray = employees.getBody();

        model.addAttribute("employees", Arrays.asList(employeeArray));
        return "showEmployees";
    }

}
