package co.software.apiinventory.model.security;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
public class Role {
    @Id
    @Column(name = "id_role")
    private int idRole;

    @Column(unique = true, length = 20, name = "role_name")
    private String roleName;
}
