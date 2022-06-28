package com.petshop.PetShopAlpha.model.embeddable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class PetServicosPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pet_id")
    private Long petId;

    @Column(name = "servico_id")
    private Long servicoId;
}
