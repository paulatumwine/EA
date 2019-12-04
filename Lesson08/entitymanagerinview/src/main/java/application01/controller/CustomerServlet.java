package application01.controller;

import application01.domain.Address;
import application01.domain.Customer;
import application01.service.CustomerServiceWithTransaction;
import application01.service.CustomerServiceWithoutTransaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        CustomerServiceWithTransaction customerService = new CustomerServiceWithTransaction(request.getServletContext());
        CustomerServiceWithoutTransaction customerService = new CustomerServiceWithoutTransaction(request.getServletContext());
        Customer customer = new Customer(request.getParameter("name"));
        Address address = new Address(request.getParameter("street"), request.getParameter("city"), request.getParameter("state"), request.getParameter("zip"));
        customerService.addCustomer(customer, address);
        request.getSession().setAttribute("customerId", customer.getId());
        response.sendRedirect("customer");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        CustomerServiceWithTransaction customerService = new CustomerServiceWithTransaction(request.getServletContext());
        CustomerServiceWithoutTransaction customerService = new CustomerServiceWithoutTransaction(request.getServletContext());
        Long customerId = (Long) request.getSession().getAttribute("customerId");
        System.out.println("customerID: " + customerId);
        Customer customer = customerService.getCustomer(customerId);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("customer.jsp").forward(request, response);

    }
}
