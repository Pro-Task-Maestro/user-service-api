package org.example.userserviceapi.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long propertyId;
    @Column(name = "user_id" , unique = true)
    private String userId;
    @Column(name = "full_name" , length = 100, nullable = false)
    private String fullName;
    @Column(unique = true)
    private String email;
    @Lob
    @Column(name = "avatar_url")
    private byte[] avatarUrl;
    @Column(name = "status")
    private boolean status;
}
