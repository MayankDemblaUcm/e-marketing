package com.ucm.adbms.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "refund_request")
public class RefundRequest {
    @Id
    private String id;
    private String orderId;
    private String customerId;
    private List<Product> products;
    private String reason;
    private String status;
    private String createdAt;
    private String updatedAt;
}
