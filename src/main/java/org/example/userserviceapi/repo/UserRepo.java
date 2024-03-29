package org.example.userserviceapi.repo;

import org.example.userserviceapi.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public Optional<User> findUserByUserId(String userId);

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE full_name LIKE %?1% OR email LIKE %?1%")
    public List<User> findAllUsers(String searchText, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM user WHERE full_name LIKE %?1% OR email LIKE ?1")
    public Long findAllUserCount(String searchText);
}
