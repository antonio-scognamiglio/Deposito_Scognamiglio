package com.exercise.ecommerce.controller;

import com.exercise.ecommerce.dto.request.OrderRequest;
import com.exercise.ecommerce.dto.response.OrderResponse;
import com.exercise.ecommerce.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test della validazione Bean Validation sul corpo di POST /orders.
 * @MockitoBean sul service → il test è "slice" del controller: MySQL non serve.
 */
@WebMvcTest(OrderController.class)
class OrderControllerValidationTests {

    @MockitoBean
    OrderService orderService;

    @Autowired
    MockMvc mockMvc;

    /** quantity = 0 → viola @Min(1) → HTTP 400 (il service NON viene chiamato) */
    @Test
    void postOrderWithZeroQuantityIsRejected() throws Exception {
        String body = """
                {"userId": 1, "productId": 2, "quantity": 0, "totalPrice": 10.5, "orderDate": "2026-10-29T10:00", "status": "PENDING"}
                """;
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest());
    }

    /** quantity = -5 → viola @Min(1) → HTTP 400 */
    @Test
    void postOrderWithNegativeQuantityIsRejected() throws Exception {
        String body = """
                {"userId": 1, "productId": 2, "quantity": -5, "totalPrice": 10.5, "orderDate": "2026-10-29T10:00", "status": "PENDING"}
                """;
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest());
    }

    /** campo quantity assente → Jackson mappa a 0 (int) → viola @Min(1) → HTTP 400 */
    @Test
    void postOrderWithMissingQuantityIsRejected() throws Exception {
        String body = """
                {"userId": 1, "productId": 2, "totalPrice": 10.5, "orderDate": "2026-10-29T10:00", "status": "PENDING"}
                """;
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isBadRequest());
    }

    /** quantity valida → service chiamato, risposta 201 con il body dell'ordine */
    @Test
    void postOrderWithValidQuantityCallsServiceAndReturns201() throws Exception {
        OrderResponse saved = new OrderResponse(9L, 1L, 2L, 3, new BigDecimal("37.5"),
                LocalDateTime.now(), "PENDING");
        when(orderService.createOrder(any(OrderRequest.class))).thenReturn(saved);

        String body = """
                {"userId": 1, "productId": 2, "quantity": 3, "totalPrice": 37.5, "orderDate": "2026-10-29T10:00", "status": "PENDING"}
                """;
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.quantity").value(3));
    }
}
