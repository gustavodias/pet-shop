package com.petshop.PetShopAlpha.model.pet;

import com.petshop.PetShopAlpha.model.embeddable.PetServicosPK;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pet_servicos")
@Table(name = "pet_servicos")
@EqualsAndHashCode
public class PetServicos {

    @EmbeddedId
    private PetServicosPK pk = new PetServicosPK();

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "pet_id", nullable = false, updatable = false, insertable = false)
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "servico_id", referencedColumnName = "servico_id", nullable = false, updatable = false, insertable = false)
    private Servicos servicos;

    @Column
    private String descricao;

    public PetServicos(String descricao) {
        this.descricao = descricao;
    }
}
