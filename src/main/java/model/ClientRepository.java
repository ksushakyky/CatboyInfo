package model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}

//public interface ClientRepository extends JpaRepository<Client, Long> {
//    List<Client> findAllUser();
//}
