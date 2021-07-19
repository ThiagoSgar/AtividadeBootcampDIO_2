package thiagoSgar.projeto2.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import thiagoSgar.projeto2.Enums.PhoneType;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {
    @Id // anota a variável id como um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // faz com que o programa sempre gere um ID novo para kd objeto
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PhoneType type;
    @Column(nullable = false)
    private String number;
}
