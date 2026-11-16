package order.boot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "ORDINI")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "DATA_CREAZIONE")
    @CurrentTimestamp
    private LocalDateTime localDateTime;
    @Column (name = "TOTALE")
    private BigDecimal total;

    @Column (name = "PRODOTTI")
    private String products;

}
