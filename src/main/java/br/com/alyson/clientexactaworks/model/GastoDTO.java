package br.com.alyson.clientexactaworks.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 * description: Classe representante do Model Gastos de uma Pessoa
 */
public class GastoDTO {

    /**
     * description: Id do Gasto.
     */
    private Integer id;

    /**
     * description: Descrição do gasto.
     */
    private String description;

    /**
     * description: Data e hora do gasto.
     */
    private String dtHour;

    /**
     * description: Valor do gasto.
     */
    private BigDecimal value;

    /**
     * description: Tags do Gasto.
     */
    private String tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDtHour() {
        return dtHour;
    }

    public void setDtHour(String dtHour) {
        this.dtHour = dtHour;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GastoDTO)) return false;
        GastoDTO gasto = (GastoDTO) o;
        return getId().equals(gasto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
