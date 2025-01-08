package com.karan.property.service;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorPayService {



    @Value("${razorpay.api.key}")
    private String Api_key;

    @Value("${razorpay.api.secret}")
    private String secret;

    public String createOrder(int amount , String currency , String receiptId) throws RazorpayException, RazorpayException {
        RazorpayClient razorpayClient = new RazorpayClient(Api_key,secret);
        JSONObject orderRequest  = new JSONObject();
        orderRequest.put("amount", amount *100);
        orderRequest.put("currency",currency);
        orderRequest.put("receipt", receiptId);

        Order order = razorpayClient.orders.create(orderRequest);
        return order.toString();
    }

}
