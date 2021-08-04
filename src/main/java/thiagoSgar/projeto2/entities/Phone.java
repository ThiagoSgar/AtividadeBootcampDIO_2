package thiagoSgar.projeto2.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import thiagoSgar.projeto2.enums.PhoneType;

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
