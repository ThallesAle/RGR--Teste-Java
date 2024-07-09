package org.rgrThalles.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Column(name = "number", nullable = false, length = 20)
    private String number;

    @Column(name = "complement", length = 250)
    private String complement;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "city", length = 250)
    private String city;

    @Column(name = "state", length = 250)
    private String state;

    @Column(name = "country", length = 250)
    private String country;

}

