package kr.hs.dgsw.springcrmpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String email;

    private String path;

    private String origin;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, String path, String origin) {
        this.username = username;
        this.email = email;
        this.path = path;
        this.origin = origin;
    }
}
