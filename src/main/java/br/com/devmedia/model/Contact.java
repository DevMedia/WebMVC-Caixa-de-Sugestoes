package br.com.devmedia.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(indexes = {
        @Index(name = "UX_NAME", columnList = "name", unique = true)
})
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 40)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    @Valid
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    @Valid
    @OneToOne(mappedBy = "contact", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Suggestion suggestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }
}
