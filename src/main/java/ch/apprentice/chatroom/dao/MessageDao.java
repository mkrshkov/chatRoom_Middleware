package ch.apprentice.chatroom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.apprentice.chatroom.entities.MessageEntity;
import ch.apprentice.chatroom.repositories.MessageRepository;

@Service
public class MessageDao {
	@Autowired
	MessageRepository messageRepository;

	public MessageEntity getById(int id) {
		return messageRepository.getOne(id);
	}

	public List<MessageEntity> getAll() {
		return messageRepository.findAll();
	}

	public void save(MessageEntity chats) {
		messageRepository.save(chats);

	}

	public List<MessageEntity> searchUser(String username) {
		return messageRepository.searchUser(username);
	}

	public List<MessageEntity> searchMessage(String message) {
		return messageRepository.searchMessage(message);
	}

	public void deletebyId(int id) {
		if (messageRepository.existsById(id)) {
			messageRepository.deleteById(id);
		}
	}
}
