package com.example.a0922i1projectmobilephone.controller;

import com.example.a0922i1projectmobilephone.Config.VNPayService;
import com.example.a0922i1projectmobilephone.dto.VNPayDTO;
import com.example.a0922i1projectmobilephone.dto.VNPayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VNPayController {
    @Autowired
    private VNPayService vnPayService;
//
//    @PostMapping("/submitOrder")
//    public ResponseEntity<String> submidOrder(@RequestParam("amount") int orderTotal,
//                                              @RequestParam("orderInfo") String orderInfo,
//                                              HttpServletRequest request) {
//        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
//        String vnpayUrl = vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
//        return ResponseEntity.status(HttpStatus.FOUND).header("Location", vnpayUrl).build();
//    }
@PostMapping("/submitOrder")
public ResponseEntity<Map<String, String>> submitOrder(@RequestParam("amount") int orderTotal,
                                                       @RequestParam("orderInfo") String orderInfo,
                                                       HttpServletRequest request) {
//    String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    String baseUrl = "";
    String vnpayUrl = vnPayService.createOrder(orderTotal, orderInfo, baseUrl);

    // Create a JSON response
    Map<String, String> response = new HashMap<>();
    response.put("vnpayUrl", vnpayUrl);

    // Return the JSON response with a 200 OK status
    return ResponseEntity.ok(response);
}


    @GetMapping("/vnpay-payment")
    public ResponseEntity<?> VNPay(HttpServletRequest request) {
        VNPayDTO vnPayDTO = new VNPayDTO();
        int paymentStatus = vnPayService.orderReturn(request);

        vnPayDTO.setOrderInfo(request.getParameter("vnp_OrderInfo"));
        vnPayDTO.setPaymentTime(request.getParameter("vnp_PayDate"));
        vnPayDTO.setTransactionId(request.getParameter("vnp_TransactionNo"));
        vnPayDTO.setTotalPrice(request.getParameter("vnp_Amount"));

        VNPayResponse vnPayResponse = new VNPayResponse();
        vnPayResponse.setVnPayDTO(vnPayDTO);
        vnPayResponse.setPaymentStatus(paymentStatus);

        return new ResponseEntity<>(vnPayResponse, HttpStatus.OK);
    }

//    @GetMapping("/vnpay-payment")
//    public String VNPay(HttpServletRequest request) {
//        // Process the payment and retrieve necessary data
//        String orderInfo = request.getParameter("vnp_OrderInfo");
//        String paymentTime = request.getParameter("vnp_PayDate");
//        String transactionId = request.getParameter("vnp_TransactionNo");
//        String totalPrice = request.getParameter("vnp_Amount");
//
//        // Construct the URL with query parameters
//        String redirectUrl = "/payment-success?orderInfo=" + orderInfo +
//                "&paymentTime=" + paymentTime +
//                "&transactionId=" + transactionId +
//                "&totalPrice=" + totalPrice;
//
//        // Redirect to the Angular route
//        return "redirect:" + redirectUrl;
//    }

}
