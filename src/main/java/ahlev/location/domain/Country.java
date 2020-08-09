package ahlev.location.domain;
/*
 * User: ohahlev@gmail.com
 * Project: api
 * Date: 8/9/20
 * Country Domain
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "country")
public class Country extends AbstractEntity {

    @Size(min = 3, max = 32, message = "{name.SizeRange}")
    @NotNull(message = "{name.NotNull}")
    @NotEmpty(message = "{name.NotEmpty}")
    @Column(name = "name", unique = true)
    private String name;

    public Country() {}

    public Country(String name) {
        this.name = name;
    }
}
