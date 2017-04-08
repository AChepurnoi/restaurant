package com.graniumhub.data.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sasha on 4/6/17.
 */
@Entity
@Table(name = "Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double posx;
    private double posy;


    @OneToMany(mappedBy = "table", fetch = FetchType.LAZY,
            orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Booking> bookings = new HashSet<>();


}
