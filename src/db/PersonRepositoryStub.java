package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.*;

public class PersonRepositoryStub implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	private List<Conversation> conversations = new ArrayList<>();
	private List<Les> lessen = new ArrayList<>();
	private List<Cadeau> cadeaus = new ArrayList<>();




	public PersonRepositoryStub () {

		Cadeau c1 = new Cadeau("Wekker","12/12/18","Keanu",4);
		Cadeau c2 = new Cadeau("Camera","14/12/18","Phloy",6);

		addCadeau(c1);
		addCadeau(c2);

		Les testing = new Les("14/05/20","testing","2");
		Les web3 = new Les("14/05/20","web3","2");

		addLes(testing);
		addLes(web3);

		//person CREATE

		Person administrator = new Person("bib@ucll.be", "t", "Bib", "Liothekaris", Role.BIB);
		add(administrator);//toevogen

		Person jan = new Person("jan@ucll.be", "t", "Jan", "Janssens", Role.LID);
		add(jan);

		Person an = new Person("an@ucll.be", "t", "An", "Cornelissen", Role.LID);
		add(an);

		Person phloy = new Person("phloy@ucll.be", "t", "Phloy", "Vandewyngaert", Role.LID);
		add(phloy);

		//vrienden maken
		administrator.addFriend(jan);
		administrator.addFriend(an);
		administrator.addFriend(phloy);

		jan.addFriend(administrator);
		jan.addFriend(an);

		an.addFriend(administrator);
		an.addFriend(jan);

		phloy.addFriend(administrator);


	}
	public void add(Person person){//persoon toevoegen aan hashmap
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserId())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserId(), person);
	}
	// Person READ
	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}
	
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}


	//Person update
	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		persons.put(person.getUserId(), person);
	}

	//Person DELETE
	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}
	//andere person methodes
	public Person getAuthenticatedUser(String email, String password) {
		Person person = get(email);
		
		if (person != null && person.isCorrectPassword(password)) {
			return person;
		}
		else {
			return null;
		}
	}
	public void updateStatus(Person p, String userStatus){
		if(p == null || userStatus == null)	throw new IllegalArgumentException("No person and/or status given");
		p.setUserStatus(userStatus);
		persons.put(p.getUserId(), p);
	}



	//conversation CREATE
	public void addConversation(Conversation c) {

		conversations.add(c);
	}

	//conversation READ
	public List<Conversation> getConversations() {

		return conversations;
	}

	public List<Conversation> getAllConversationsFromThisPerson(String thisPerson) {

		List<Conversation> conversations = new ArrayList<>();

		for (Conversation c: conversations) {
			if (c.getThisPerson().equals(thisPerson) || c.getMyFriend().equals(thisPerson)) {
				conversations.add(c);
			}
		}

		return conversations;
	}

	public Conversation getConversationBetweenTwoPersons(String thisPerson, String mtFriend) throws IllegalArgumentException {

		for (Conversation c: conversations) {
			if (c.getThisPerson().equals(thisPerson) && c.getMyFriend().equals(mtFriend) ||
					c.getThisPerson().equals(mtFriend) && c.getMyFriend().equals(thisPerson)) {
				return c;
			}
		}

		throw new IllegalArgumentException("Er bestaat nog geen conversatie");
	}

	//les
	@Override
	public void addLes(Les l) {
		lessen.add(l);
	}

	@Override
	public List<Les> getAllLessen() {
		return lessen;
	}

	@Override
	public Les getLes(String naamLes) {
		Les les = null;
		if(this.lessen.contains(naamLes)){
			for (Les l: lessen) {
				if (l.getNaamLes().equals(naamLes)) {
					les=l;
				}
			}
		} else {
			throw new IllegalArgumentException("deze les bestaat niet");
		}
			return les;
	}

	@Override
	public void updateLes(Les les) {
		if(les == null){
			throw new IllegalArgumentException("No les given");
		}
		lessen.add(les);
	}

	@Override
	public void deleteLes(String naamLes) {
		if(naamLes == null){
			throw new IllegalArgumentException("No naamLes given");
		}
		lessen.remove(naamLes);
	}

	//conversation DELETE
	public void deleteConversation(Conversation c) {
		conversations.remove(c);
	}

	//cadeau

	@Override
	public void addCadeau(Cadeau c) {
		this.cadeaus.add(c);
	}

	@Override
	public List<Cadeau> getAllCadeaus() {
		return this.cadeaus;
	}

	@Override
	public Cadeau getCadeau(String omschrijving) {
		Cadeau cad = null;
		if(this.cadeaus.contains(omschrijving)){
			for (Cadeau c:cadeaus) {
				if (c.getOmschrijving().equals(omschrijving)) {
					cad=c;
				}
			}
		} else {
			throw new IllegalArgumentException("deze cadeau bestaat niet");
		}
		return cad;
	}
}
