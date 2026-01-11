package com.project.aclub.entity;


import com.project.aclub.entity.Enum.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="participation")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "participation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="roll_number")
    private User user;

    @JoinColumn(name = "club_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Club club;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;
}
