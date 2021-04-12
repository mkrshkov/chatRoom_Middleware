package ch.apprentice.chatroom.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ch.apprentice.chatroom.entities.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer>{    

	@Query("SELECT m FROM MessageEntity m WHERE username LIKE %:username%")
    List<MessageEntity> searchUser(@Param("username") String username);
	
	
	@Query("SELECT m FROM MessageEntity m WHERE message LIKE %:message%")
    List<MessageEntity> searchMessage(@Param("message") String message);
	
	@Query("SELECT m FROM MessageEntity m WHERE id LIKE %:id%")
    List<MessageEntity> searchId(@Param("id") String id);


	}
