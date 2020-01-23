package db;

import java.util.List;

import domain.Cadeau;
import domain.Conversation;
import domain.Les;
import domain.Person;

public interface PersonRepository {
//person CRUD

   abstract void add(Person person);

	abstract List<Person> getAll();

	abstract Person get(String userId);

	abstract void update(Person person);

	abstract void delete(String userId);

	//andere person methodes
	abstract Person getAuthenticatedUser(String email, String password);

	void updateStatus(Person person, String status);

	//conversation CRD

	void addConversation(Conversation c);

	List<Conversation> getConversations();

	List<Conversation> getAllConversationsFromThisPerson(String thisPerson);

	void deleteConversation(Conversation c);

	// andere converation methodes
	Conversation getConversationBetweenTwoPersons(String user, String chatBuddy);

//les CRUD

	abstract void addLes(Les l);

	abstract List<Les> getAllLessen();

	abstract Les getLes(String naamLes);

	abstract void updateLes(Les les);

	abstract void deleteLes(String naamLes);

	//cadeau

	abstract void addCadeau(Cadeau c);

	abstract List<Cadeau> getAllCadeaus();

	abstract Cadeau getCadeau(String omschrijving);


}