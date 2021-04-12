package ch.apprentice.chatroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.apprentice.chatroom.dao.MessageDao;
import ch.apprentice.chatroom.entities.MessageEntity;

@RestController(value = "chatroom/messages")
@RequestMapping("chatroom/messages")
@Controller
public class MessageController {
	@Autowired
	MessageDao messageDao;

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/search/user/{username}")
	public List<MessageEntity> searchforUser(@PathVariable String username) {
		return  messageDao.searchUser(username);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/search/message/{message}")
	public List<MessageEntity> searchforMessage(@PathVariable String message) {
		return messageDao.searchMessage(message);
		
		
	}
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/delete/{id}")
	public void deletebyId(@PathVariable int id) {
		
		messageDao.deletebyId(id);
	}
	
	

	@CrossOrigin(origins = "*")
	@GetMapping(path = "")
	public List<MessageEntity> getMassage() {
		return messageDao.getAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/send/name/{name}/message/{message}")
	public void saveMessage(@PathVariable String name, @PathVariable String message) {
		MessageEntity chats = new MessageEntity();
		chats.setUsername(name);
		chats.setMessage(message);
		messageDao.save(chats);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/{id}")
	public MessageEntity sendGetMessageById(@PathVariable int id) {
		return messageDao.getById(id);

	}

}
