package cs428.project.gather.data;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cs428.project.gather.data.model.Category;
import cs428.project.gather.data.model.Event;
import cs428.project.gather.data.model.Location;
import cs428.project.gather.data.model.Occurrence;
import cs428.project.gather.data.model.Registrant;
import cs428.project.gather.data.repo.CategoryRepository;
import cs428.project.gather.data.repo.EventRepository;
import cs428.project.gather.data.repo.RegistrantRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EventRepository eventRepo;
	private final RegistrantRepository registrantRepo;
	private final CategoryRepository categoryRepo;

	@Autowired
	public DatabaseLoader(EventRepository eventRepo, RegistrantRepository registrantRepo,
			CategoryRepository categoryRepo) {
		this.eventRepo = eventRepo;
		this.registrantRepo = registrantRepo;
		this.categoryRepo = categoryRepo;
	}

	@Override
	public void run(String... strings) throws Exception {
		// Registrant aUser = new
		// Registrant("testuser@email.com","password","testDisplayName",3,91942);
		// Registrant registrantResult = this.registrantRepo.save(aUser);

		Category arts = new Category("Arts & Culture");
		Category book = new Category("Book Clubs");
		Category community = new Category("Community & Environment");
		Category education = new Category("Education & Learning");
		Category fitness = new Category("Fitness");
		Category food = new Category("Food & Drink");
		Category games = new Category("Games");
		Category hobbies = new Category("Hobbies & Crafts");
		Category movies = new Category("Movies & Film");
		Category music = new Category("Music");
		Category outdoors = new Category("Outdoors & Adventure");
		Category sports = new Category("Sports & Recreation");
		Category tech = new Category("Tech");

		this.categoryRepo.save(arts);
		this.categoryRepo.save(book);
		this.categoryRepo.save(community);
		this.categoryRepo.save(education);
		this.categoryRepo.save(fitness);
		this.categoryRepo.save(food);
		this.categoryRepo.save(games);
		this.categoryRepo.save(hobbies);
		this.categoryRepo.save(movies);
		this.categoryRepo.save(music);
		this.categoryRepo.save(outdoors);
		this.categoryRepo.save(sports);
		this.categoryRepo.save(tech);

		// Category soccer = new Category("Soccer");

		// Event testEvent = new Event("Test Event");
		// Location location = new Location("Test Location", "6542 Nowhere
		// Blvd", "Los Angeles", "CA", "90005", 34.0498, -118.2498);
		// testEvent.setLocation(location);
		// Occurrence occur=new Occurrence("Test Occurrence",new
		// Timestamp(DateTime.now().getMillis()));
		// Category testCategory = new Category("testCategory");
		// this.categoryRepo.save(testCategory);
		// testEvent.addOccurrence(occur);
		// testEvent.setCategory(testCategory);
		// Event eventResult = this.eventRepo.save(testEvent);

		// Right now, Event owns all relationships, so Event must be saved for
		// data to be put in DB.
		// testEvent.addParticipant(aUser);
		// It is recommended you also add the Event to the Registrant, so that
		// the in memory state of the objects is consistent with the DB
		// We can make either function do the opposite add if we wish, to
		// simplify usage elsewhere
		// aUser.joinEvent(testEvent);
		// this.eventRepo.save(testEvent);

		// Event newEvent = new Event("Test1");
		// Location newLoc = new Location("Test Location", "6000 Yeswhere Blvd",
		// "Los Angeles", "CA", "90007", 32.770, -117.04);
		// newEvent.addOwner(aUser);
		// newEvent.addParticipant(aUser);
		// newEvent.setLocation(newLoc);
		// Occurrence newOccur = new Occurrence("First", new
		// Timestamp(DateTime.now().plusDays(1).getMillis()));
		// newEvent.addOccurrence(newOccur);
		// newEvent.setDescription("lets play soccer!");
		// Category soccer = new Category("Soccer");
		// this.categoryRepo.save(soccer);
		// newEvent.setCategory(soccer);
		// this.eventRepo.save(newEvent);
		//
		// Event newEventa = new Event("Test2");
		// Location newLoca = new Location("Test Location", "6542 Nowhere Blvd",
		// "Los Angeles", "CA", "90005", 32.780, -117.03);
		// newEvent.addOwner(aUser);
		// newEventa.setLocation(newLoca);
		// Occurrence newOccura = new Occurrence("Second", new
		// Timestamp(DateTime.now().plusDays(2).getMillis()));
		// newEventa.addOccurrence(newOccura);
		// Occurrence newOccurb = new Occurrence("Second2", new
		// Timestamp(DateTime.now().plusDays(5).getMillis()));
		// newEventa.addOccurrence(newOccurb);
		// newEventa.setDescription("lets swim!");
		// Category swim = new Category("Swim");
		// this.categoryRepo.save(swim);
		// newEventa.setCategory(swim);

		Registrant User0 = new Registrant("testuser@email.com", "password", "larkinelza", 730, 92193);
		this.registrantRepo.save(User0);
		Registrant User1 = new Registrant("fwunsch@beer.org", "password", "rhilll", 2, 91945);
		this.registrantRepo.save(User1);
		Registrant User2 = new Registrant("tyra05@king.biz", "password", "juliousosinski", 3, 92075);
		this.registrantRepo.save(User2);
		Registrant User3 = new Registrant("rodgerwhite@gmail.com", "password", "mariantowne", 4, 92147);
		this.registrantRepo.save(User3);
		Registrant User4 = new Registrant("achsah55@yost.com", "password", "waelchiodalys", 8, 92114);
		this.registrantRepo.save(User4);
		Registrant User5 = new Registrant("jaylincartwright@yahoo.com", "password", "jcollins", 12, 91978);
		this.registrantRepo.save(User5);
		Registrant User6 = new Registrant("srolfson@gmail.com", "password", "eziemann", 24, 92132);
		this.registrantRepo.save(User6);
		Registrant User7 = new Registrant("fentonvandervort@carter-goldner.net", "password", "swiftphoebe", 72, 92096);
		this.registrantRepo.save(User7);
		Registrant User8 = new Registrant("marvinbrooklynn@hotmail.com", "password", "reecesawayn", 168, 91912);
		this.registrantRepo.save(User8);
		Registrant User9 = new Registrant("elizabet86@gmail.com", "password", "oosinski", 336, 92024);
		this.registrantRepo.save(User9);
		Registrant User10 = new Registrant("wizaty@gleichner.net", "password", "khagenes", 730, 92197);
		this.registrantRepo.save(User10);
		Registrant User11 = new Registrant("estefaniawaelchi@heaney-spencer.com", "password", "ereilly", 2190, 92022);
		this.registrantRepo.save(User11);
		Registrant User12 = new Registrant("oconneromar@gmail.com", "password", "rigoberto24", 8760, 92182);
		this.registrantRepo.save(User12);
		Registrant User13 = new Registrant("friesendijon@gmail.com", "password", "miley57", 2, 92190);
		this.registrantRepo.save(User13);
		Registrant User14 = new Registrant("signedavis@shanahan.info", "password", "trinitylind", 4, 92038);
		this.registrantRepo.save(User14);
		Registrant User15 = new Registrant("pschneider@gmail.com", "password", "fritschdanna", 730, 91931);
		this.registrantRepo.save(User15);
		Registrant User16 = new Registrant("albertusziemann@hotmail.com", "password", "considineloreen", 730, 92169);
		this.registrantRepo.save(User16);
		Registrant User17 = new Registrant("hermancharlottie@hotmail.com", "password", "wolfftinnie", 12, 92170);
		this.registrantRepo.save(User17);
		Registrant User18 = new Registrant("thetarempel@stehr-waters.net", "password", "vernia68", 3, 92004);
		this.registrantRepo.save(User18);
		Registrant User19 = new Registrant("franklin49@douglas.net", "password", "lenbartoletti", 72, 92030);
		this.registrantRepo.save(User19);
		Registrant User20 = new Registrant("rippinrolando@yahoo.com", "password", "vella09", 1, 92071);
		this.registrantRepo.save(User20);
		Registrant User21 = new Registrant("tierrahoppe@yahoo.com", "password", "carlakirlin", 168, 92007);
		this.registrantRepo.save(User21);
		Registrant User22 = new Registrant("zgrant@hotmail.com", "password", "hideohills", 24, 92129);
		this.registrantRepo.save(User22);
		Registrant User23 = new Registrant("hermanfremont@yahoo.com", "password", "maebellhauck", 24, 92086);
		this.registrantRepo.save(User23);
		Registrant User24 = new Registrant("mittie50@mertz.net", "password", "ruthelittel", 8760, 92130);
		this.registrantRepo.save(User24);
		Registrant User25 = new Registrant("hermanjensen@gmail.com", "password", "sarai69", 730, 92115);
		this.registrantRepo.save(User25);
		Registrant User26 = new Registrant("sengerbradyn@yahoo.com", "password", "wunscheula", 168, 92092);
		this.registrantRepo.save(User26);
		Registrant User27 = new Registrant("herzogquinton@gmail.com", "password", "welchcassie", 2, 92003);
		this.registrantRepo.save(User27);
		Registrant User28 = new Registrant("erdmannaomi@rutherford-padberg.com", "password", "hillsmurl", 336, 92025);
		this.registrantRepo.save(User28);
		Registrant User29 = new Registrant("melva27@hackett-wehner.com", "password", "vrath", 2, 92113);
		this.registrantRepo.save(User29);
		Registrant User30 = new Registrant("maddison93@yahoo.com", "password", "eulabartell", 168, 92130);
		this.registrantRepo.save(User30);
		Registrant User31 = new Registrant("quint46@waters-effertz.com", "password", "eaufderhar", 8760, 91913);
		this.registrantRepo.save(User31);
		Registrant User32 = new Registrant("fkoss@williamson-gorczany.com", "password", "frogahn", 1, 91908);
		this.registrantRepo.save(User32);
		Registrant User33 = new Registrant("drenner@yahoo.com", "password", "cronakaley", 8760, 91913);
		this.registrantRepo.save(User33);
		Registrant User34 = new Registrant("geroldberge@yahoo.com", "password", "payten33", 3, 92024);
		this.registrantRepo.save(User34);
		Registrant User35 = new Registrant("cherrie56@hotmail.com", "password", "donell39", 24, 92113);
		this.registrantRepo.save(User35);
		Registrant User36 = new Registrant("mcclureomer@yahoo.com", "password", "ilegros", 24, 92163);
		this.registrantRepo.save(User36);
		Registrant User37 = new Registrant("lennyoconner@schulist.com", "password", "idaniel", 3, 91913);
		this.registrantRepo.save(User37);
		Registrant User38 = new Registrant("lmacejkovic@yahoo.com", "password", "lockmanadaline", 8, 92038);
		this.registrantRepo.save(User38);
		Registrant User39 = new Registrant("ckeebler@gmail.com", "password", "cormiershara", 8, 91905);
		this.registrantRepo.save(User39);
		Registrant User40 = new Registrant("wmorar@hayes.info", "password", "bbashirian", 2190, 92182);
		this.registrantRepo.save(User40);
		Registrant User41 = new Registrant("srunolfsdottir@schaefer.net", "password", "pdonnelly", 8, 91914);
		this.registrantRepo.save(User41);
		Registrant User42 = new Registrant("isobelwalter@gleichner-rodriguez.com", "password", "isatterfield", 8,
				91909);
		this.registrantRepo.save(User42);
		Registrant User43 = new Registrant("stoltenbergtatianna@lakin.com", "password", "ruthann51", 168, 92194);
		this.registrantRepo.save(User43);
		Registrant User44 = new Registrant("cornellbode@price.com", "password", "jonescatrina", 12, 91945);
		this.registrantRepo.save(User44);
		Registrant User45 = new Registrant("shelvakovacek@hotmail.com", "password", "adda56", 8, 91946);
		this.registrantRepo.save(User45);
		Registrant User46 = new Registrant("zitabeahan@windler-zieme.com", "password", "brunomarvin", 1, 92192);
		this.registrantRepo.save(User46);
		Registrant User47 = new Registrant("hbergnaum@gmail.com", "password", "yundthollie", 336, 92079);
		this.registrantRepo.save(User47);
		Registrant User48 = new Registrant("tahjstanton@hirthe.com", "password", "bergnaumasha", 3, 92051);
		this.registrantRepo.save(User48);
		Registrant User49 = new Registrant("yrempel@reichel.com", "password", "rempelivey", 8760, 92168);
		this.registrantRepo.save(User49);

		Event newEvent0 = new Event("Et at deserunt ad sint libero quam.");
		Location newLoc0 = new Location("Quia necessitatibus voluptatem.", "344 Beckett Club", "Escondido", "CA",
				"92029", 32.539166, -117.127969);
		newEvent0.addOwner(User0);
		newEvent0.addParticipant(User0);
		newEvent0.addParticipant(User7);
		newEvent0.addParticipant(User46);
		newEvent0.setLocation(newLoc0);
		Occurrence newOccur0_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(54).getMillis()));
		newEvent0.addOccurrence(newOccur0_0);
		Occurrence newOccur0_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(125).getMillis()));
		newEvent0.addOccurrence(newOccur0_1);
		Occurrence newOccur0_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(71).getMillis()));
		newEvent0.addOccurrence(newOccur0_2);
		newEvent0.setDescription(
				"Natus nemo nam modi. Officia omnis harum quo nostrum iusto iste. Ut tempore nostrum recusandae.");
		newEvent0.setCategory(games);
		this.eventRepo.save(newEvent0);
		Event newEvent1 = new Event("Ea quos excepturi aliquid.");
		Location newLoc1 = new Location("Odit veniam autem optio.", "9905 Will Unions", "Santee", "CA", "92059",
				32.528791, -116.880998);
		newEvent1.addOwner(User0);
		newEvent1.addParticipant(User0);
		newEvent1.addParticipant(User23);
		newEvent1.addParticipant(User34);
		newEvent1.addParticipant(User21);
		newEvent1.addParticipant(User18);
		newEvent1.addParticipant(User28);
		newEvent1.setLocation(newLoc1);
		Occurrence newOccur1_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(67).getMillis()));
		newEvent1.addOccurrence(newOccur1_0);
		Occurrence newOccur1_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(2).getMillis()));
		newEvent1.addOccurrence(newOccur1_1);
		Occurrence newOccur1_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(45).getMillis()));
		newEvent1.addOccurrence(newOccur1_2);
		newEvent1.setDescription(
				"Dignissimos temporibus alias aut repellat aliquam. Dolorem dolore corporis cumque impedit numquam.");
		newEvent1.setCategory(hobbies);
		this.eventRepo.save(newEvent1);
		Event newEvent2 = new Event("Consectetur quaerat voluptate eum cum.");
		Location newLoc2 = new Location("Sapiente molestias praesentium totam.", "08926 Runolfsson Inlet", "Imperial",
				"CA", "92066", 32.947412, -117.226415);
		newEvent2.addOwner(User45);
		newEvent2.addParticipant(User45);
		newEvent2.addParticipant(User27);
		newEvent2.addParticipant(User32);
		newEvent2.addParticipant(User10);
		newEvent2.addParticipant(User40);
		newEvent2.addParticipant(User18);
		newEvent2.setLocation(newLoc2);
		Occurrence newOccur2_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(81).getMillis()));
		newEvent2.addOccurrence(newOccur2_0);
		Occurrence newOccur2_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(140).getMillis()));
		newEvent2.addOccurrence(newOccur2_1);
		Occurrence newOccur2_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(34).getMillis()));
		newEvent2.addOccurrence(newOccur2_2);
		Occurrence newOccur2_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(69).getMillis()));
		newEvent2.addOccurrence(newOccur2_3);
		newEvent2.setDescription(
				"Reiciendis molestiae officia labore dolor at. Dicta odit repudiandae officia rerum doloribus vitae.");
		newEvent2.setCategory(sports);
		this.eventRepo.save(newEvent2);
		Event newEvent3 = new Event("Minus sunt labore laboriosam.");
		Location newLoc3 = new Location("Minus corrupti laudantium.", "003 Charlie Garden", "Leucadia", "CA", "92138",
				32.786707, -117.223852);
		newEvent3.addOwner(User0);
		newEvent3.addParticipant(User16);
		newEvent3.addParticipant(User21);
		newEvent3.addParticipant(User13);
		newEvent3.addParticipant(User34);
		newEvent3.addParticipant(User19);
		newEvent3.addParticipant(User12);
		newEvent3.addParticipant(User40);
		newEvent3.addParticipant(User9);
		newEvent3.setLocation(newLoc3);
		Occurrence newOccur3_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(136).getMillis()));
		newEvent3.addOccurrence(newOccur3_0);
		Occurrence newOccur3_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(6).getMillis()));
		newEvent3.addOccurrence(newOccur3_1);
		Occurrence newOccur3_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(106).getMillis()));
		newEvent3.addOccurrence(newOccur3_2);
		Occurrence newOccur3_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(76).getMillis()));
		newEvent3.addOccurrence(newOccur3_3);
		newEvent3.setDescription("Cum molestiae reiciendis assumenda nisi eius. Neque illo in atque porro deleniti.");
		newEvent3.setCategory(movies);
		this.eventRepo.save(newEvent3);
		Event newEvent4 = new Event("Ipsa amet aliquam facere voluptas.");
		Location newLoc4 = new Location("Quos magni possimus illum.", "559 Juliet Hollow", "Hillcrest", "CA", "92192",
				32.639064, -116.961251);
		newEvent4.addOwner(User24);
		newEvent4.addParticipant(User24);
		newEvent4.addParticipant(User13);
		newEvent4.addParticipant(User40);
		newEvent4.addParticipant(User0);
		newEvent4.addParticipant(User4);
		newEvent4.addParticipant(User28);
		newEvent4.addParticipant(User18);
		newEvent4.addParticipant(User28);
		newEvent4.setLocation(newLoc4);
		Occurrence newOccur4_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(25).getMillis()));
		newEvent4.addOccurrence(newOccur4_0);
		Occurrence newOccur4_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(70).getMillis()));
		newEvent4.addOccurrence(newOccur4_1);
		Occurrence newOccur4_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(125).getMillis()));
		newEvent4.addOccurrence(newOccur4_2);
		newEvent4.setDescription(
				"Alias quae reiciendis necessitatibus dolorum sed nesciunt. Dolores ab a in consequatur soluta.");
		newEvent4.setCategory(outdoors);
		this.eventRepo.save(newEvent4);
		Event newEvent5 = new Event("Pariatur autem corrupti nam ullam.");
		Location newLoc5 = new Location("Officiis provident quos vitae.", "19523 Jeffery Vista Suite 184",
				"Rancho Bernardo", "CA", "92112", 32.936604, -117.172020);
		newEvent5.addOwner(User16);
		newEvent5.addParticipant(User16);
		newEvent5.addParticipant(User36);
		newEvent5.addParticipant(User47);
		newEvent5.addParticipant(User21);
		newEvent5.setLocation(newLoc5);
		Occurrence newOccur5_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(9).getMillis()));
		newEvent5.addOccurrence(newOccur5_0);
		Occurrence newOccur5_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(60).getMillis()));
		newEvent5.addOccurrence(newOccur5_1);
		Occurrence newOccur5_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(94).getMillis()));
		newEvent5.addOccurrence(newOccur5_2);
		Occurrence newOccur5_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(77).getMillis()));
		newEvent5.addOccurrence(newOccur5_3);
		newEvent5.setDescription(
				"Atque sapiente architecto distinctio autem. Adipisci porro omnis delectus praesentium hic nisi.");
		newEvent5.setCategory(fitness);
		this.eventRepo.save(newEvent5);
		Event newEvent6 = new Event("Officia dolores voluptatibus error.");
		Location newLoc6 = new Location("Inventore tempora nulla.", "61858 Kerluke Estate", "Alpine", "CA", "91944",
				32.513557, -117.074010);
		newEvent6.addOwner(User41);
		newEvent6.addParticipant(User41);
		newEvent6.addParticipant(User36);
		newEvent6.setLocation(newLoc6);
		Occurrence newOccur6_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(121).getMillis()));
		newEvent6.addOccurrence(newOccur6_0);
		Occurrence newOccur6_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(63).getMillis()));
		newEvent6.addOccurrence(newOccur6_1);
		Occurrence newOccur6_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(124).getMillis()));
		newEvent6.addOccurrence(newOccur6_2);
		newEvent6.setDescription(
				"Error nesciunt totam eaque aliquam a voluptatum pariatur. Architecto alias amet illo soluta quis.");
		newEvent6.setCategory(tech);
		this.eventRepo.save(newEvent6);
		Event newEvent7 = new Event("Rerum modi explicabo cupiditate totam.");
		Location newLoc7 = new Location("Minus itaque iste quod.", "775 Zoey Glens", "San Ysidro", "CA", "92025",
				32.879925, -117.164417);
		newEvent7.addOwner(User48);
		newEvent7.addParticipant(User48);
		newEvent7.addParticipant(User45);
		newEvent7.addParticipant(User29);
		newEvent7.setLocation(newLoc7);
		Occurrence newOccur7_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(9).getMillis()));
		newEvent7.addOccurrence(newOccur7_0);
		newEvent7.setDescription(
				"Nulla in itaque ea ad vitae vero. Culpa consequatur asperiores repellendus impedit beatae.");
		newEvent7.setCategory(music);
		this.eventRepo.save(newEvent7);
		Event newEvent8 = new Event("Velit possimus soluta odio aspernatur.");
		Location newLoc8 = new Location("Cupiditate maiores vero.", "908 Alcee Lane Apt. 357", "San Marcos", "CA",
				"92128", 32.818558, -117.051896);
		newEvent8.addOwner(User40);
		newEvent8.addParticipant(User40);
		newEvent8.addParticipant(User23);
		newEvent8.addParticipant(User13);
		newEvent8.addParticipant(User15);
		newEvent8.addParticipant(User8);
		newEvent8.addParticipant(User3);
		newEvent8.setLocation(newLoc8);
		Occurrence newOccur8_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(10).getMillis()));
		newEvent8.addOccurrence(newOccur8_0);
		Occurrence newOccur8_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(27).getMillis()));
		newEvent8.addOccurrence(newOccur8_1);
		newEvent8.setDescription(
				"Amet similique amet dicta. Voluptatibus impedit voluptate amet culpa. Dicta nobis animi quam.");
		newEvent8.setCategory(book);
		this.eventRepo.save(newEvent8);
		Event newEvent9 = new Event("Illo aliquam culpa saepe consequuntur.");
		Location newLoc9 = new Location("Accusantium corporis nihil iusto.", "55649 Kessler Route", "Borrego Springs",
				"CA", "91947", 32.871764, -116.919017);
		newEvent9.addOwner(User49);
		newEvent9.addParticipant(User49);
		newEvent9.addParticipant(User24);
		newEvent9.addParticipant(User1);
		newEvent9.addParticipant(User47);
		newEvent9.setLocation(newLoc9);
		Occurrence newOccur9_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(24).getMillis()));
		newEvent9.addOccurrence(newOccur9_0);
		Occurrence newOccur9_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(19).getMillis()));
		newEvent9.addOccurrence(newOccur9_1);
		newEvent9.setDescription(
				"Quam doloribus sint officia at similique iste iusto culpa. Harum dolorem culpa vero sed.");
		newEvent9.setCategory(hobbies);
		this.eventRepo.save(newEvent9);
		Event newEvent10 = new Event("Ipsam veniam pariatur odit doloribus.");
		Location newLoc10 = new Location("Adipisci libero accusamus sed.", "085 Senger Roads Apt. 538",
				"Rancho Santa Fe", "CA", "92142", 32.670796, -117.028630);
		newEvent10.addOwner(User24);
		newEvent10.addParticipant(User24);
		newEvent10.addParticipant(User48);
		newEvent10.addParticipant(User9);
		newEvent10.addParticipant(User9);
		newEvent10.addParticipant(User41);
		newEvent10.addParticipant(User32);
		newEvent10.addParticipant(User9);
		newEvent10.setLocation(newLoc10);
		Occurrence newOccur10_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(117).getMillis()));
		newEvent10.addOccurrence(newOccur10_0);
		Occurrence newOccur10_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(2).getMillis()));
		newEvent10.addOccurrence(newOccur10_1);
		Occurrence newOccur10_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(68).getMillis()));
		newEvent10.addOccurrence(newOccur10_2);
		newEvent10.setDescription(
				"Rerum sint nam repudiandae itaque. Deleniti fugit eveniet laudantium in incidunt accusamus.");
		newEvent10.setCategory(music);
		this.eventRepo.save(newEvent10);
		Event newEvent11 = new Event("Aperiam vel quasi provident.");
		Location newLoc11 = new Location("Dolor expedita similique cumque.", "1476 Little Ford", "San Marco", "CA",
				"92022", 32.899495, -117.138730);
		newEvent11.addOwner(User3);
		newEvent11.addParticipant(User3);
		newEvent11.addParticipant(User21);
		newEvent11.addParticipant(User7);
		newEvent11.addParticipant(User42);
		newEvent11.setLocation(newLoc11);
		Occurrence newOccur11_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(5).getMillis()));
		newEvent11.addOccurrence(newOccur11_0);
		Occurrence newOccur11_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(76).getMillis()));
		newEvent11.addOccurrence(newOccur11_1);
		Occurrence newOccur11_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(80).getMillis()));
		newEvent11.addOccurrence(newOccur11_2);
		Occurrence newOccur11_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(13).getMillis()));
		newEvent11.addOccurrence(newOccur11_3);
		newEvent11.setDescription(
				"Atque tempore sint velit ratione. Quis hic fugit molestiae cumque consectetur quibusdam deserunt.");
		newEvent11.setCategory(hobbies);
		this.eventRepo.save(newEvent11);
		Event newEvent12 = new Event("Odio ipsam maiores minima.");
		Location newLoc12 = new Location("Libero esse ipsum.", "06874 Gorczany Estate Suite 883", "San Clemente Island",
				"CA", "92090", 32.835098, -117.170385);
		newEvent12.addOwner(User9);
		newEvent12.addParticipant(User9);
		newEvent12.addParticipant(User2);
		newEvent12.addParticipant(User16);
		newEvent12.addParticipant(User2);
		newEvent12.setLocation(newLoc12);
		Occurrence newOccur12_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(119).getMillis()));
		newEvent12.addOccurrence(newOccur12_0);
		Occurrence newOccur12_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(106).getMillis()));
		newEvent12.addOccurrence(newOccur12_1);
		newEvent12.setDescription(
				"Aut saepe enim voluptatum qui voluptas molestias. Labore doloribus autem voluptatibus architecto.");
		newEvent12.setCategory(sports);
		this.eventRepo.save(newEvent12);
		Event newEvent13 = new Event("Nam culpa totam sequi est velit.");
		Location newLoc13 = new Location("Perspiciatis dicta.", "81908 Pollich Throughway Apt. 064", "Spring Valley",
				"CA", "92056", 32.699183, -117.243790);
		newEvent13.addOwner(User21);
		newEvent13.addParticipant(User21);
		newEvent13.addParticipant(User31);
		newEvent13.addParticipant(User3);
		newEvent13.addParticipant(User41);
		newEvent13.addParticipant(User44);
		newEvent13.addParticipant(User23);
		newEvent13.addParticipant(User8);
		newEvent13.setLocation(newLoc13);
		Occurrence newOccur13_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(99).getMillis()));
		newEvent13.addOccurrence(newOccur13_0);
		Occurrence newOccur13_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(10).getMillis()));
		newEvent13.addOccurrence(newOccur13_1);
		Occurrence newOccur13_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(4).getMillis()));
		newEvent13.addOccurrence(newOccur13_2);
		Occurrence newOccur13_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(94).getMillis()));
		newEvent13.addOccurrence(newOccur13_3);
		newEvent13.setDescription("Voluptatibus eligendi et non. Neque rerum magni odit corrupti.");
		newEvent13.setCategory(community);
		this.eventRepo.save(newEvent13);
		Event newEvent14 = new Event("Ullam harum ab atque illo esse unde.");
		Location newLoc14 = new Location("Architecto aperiam doloribus aliquam.", "561 Auer Knolls", "Santee", "CA",
				"91912", 32.964354, -117.198679);
		newEvent14.addOwner(User39);
		newEvent14.addParticipant(User39);
		newEvent14.addParticipant(User43);
		newEvent14.addParticipant(User10);
		newEvent14.addParticipant(User31);
		newEvent14.addParticipant(User25);
		newEvent14.addParticipant(User1);
		newEvent14.addParticipant(User47);
		newEvent14.addParticipant(User46);
		newEvent14.addParticipant(User6);
		newEvent14.setLocation(newLoc14);
		Occurrence newOccur14_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(29).getMillis()));
		newEvent14.addOccurrence(newOccur14_0);
		Occurrence newOccur14_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(91).getMillis()));
		newEvent14.addOccurrence(newOccur14_1);
		Occurrence newOccur14_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(45).getMillis()));
		newEvent14.addOccurrence(newOccur14_2);
		Occurrence newOccur14_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(90).getMillis()));
		newEvent14.addOccurrence(newOccur14_3);
		newEvent14.setDescription(
				"Ad possimus consectetur autem. Perspiciatis temporibus molestias quibusdam cum dignissimos.");
		newEvent14.setCategory(hobbies);
		this.eventRepo.save(newEvent14);
		Event newEvent15 = new Event("Tempora sint mollitia unde sit facere.");
		Location newLoc15 = new Location("Earum minima inventore tempore.", "412 O'Conner Lock", "El Cajon", "CA",
				"92096", 32.559137, -117.004293);
		newEvent15.addOwner(User37);
		newEvent15.addParticipant(User37);
		newEvent15.addParticipant(User44);
		newEvent15.addParticipant(User0);
		newEvent15.addParticipant(User26);
		newEvent15.addParticipant(User10);
		newEvent15.addParticipant(User24);
		newEvent15.addParticipant(User25);
		newEvent15.addParticipant(User23);
		newEvent15.addParticipant(User15);
		newEvent15.setLocation(newLoc15);
		Occurrence newOccur15_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(29).getMillis()));
		newEvent15.addOccurrence(newOccur15_0);
		Occurrence newOccur15_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(131).getMillis()));
		newEvent15.addOccurrence(newOccur15_1);
		newEvent15.setDescription(
				"Odio non sapiente modi tempora porro. Earum ipsum ea atque. Nisi inventore itaque totam nemo.");
		newEvent15.setCategory(games);
		this.eventRepo.save(newEvent15);
		Event newEvent16 = new Event("Pariatur molestias vitae eligendi fuga.");
		Location newLoc16 = new Location("Libero officiis veniam doloremque.", "64540 Orah Spurs Suite 158", "Poway",
				"CA", "92070", 32.535754, -117.172555);
		newEvent16.addOwner(User45);
		newEvent16.addParticipant(User45);
		newEvent16.addParticipant(User46);
		newEvent16.addParticipant(User7);
		newEvent16.addParticipant(User47);
		newEvent16.addParticipant(User28);
		newEvent16.addParticipant(User43);
		newEvent16.addParticipant(User30);
		newEvent16.addParticipant(User33);
		newEvent16.addParticipant(User47);
		newEvent16.setLocation(newLoc16);
		Occurrence newOccur16_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(147).getMillis()));
		newEvent16.addOccurrence(newOccur16_0);
		Occurrence newOccur16_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(50).getMillis()));
		newEvent16.addOccurrence(newOccur16_1);
		Occurrence newOccur16_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(97).getMillis()));
		newEvent16.addOccurrence(newOccur16_2);
		Occurrence newOccur16_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(144).getMillis()));
		newEvent16.addOccurrence(newOccur16_3);
		newEvent16.setDescription(
				"Quasi consequuntur quae magni culpa labore. Excepturi quasi impedit sint tenetur odio illum enim.");
		newEvent16.setCategory(food);
		this.eventRepo.save(newEvent16);
		Event newEvent17 = new Event("Deleniti quidem deserunt in ad facere.");
		Location newLoc17 = new Location("Possimus dolores incidunt qui.", "99205 Swaniawski Ports", "Rancho Santa Fe",
				"CA", "92195", 32.654004, -116.874737);
		newEvent17.addOwner(User15);
		newEvent17.addParticipant(User15);
		newEvent17.addParticipant(User49);
		newEvent17.addParticipant(User7);
		newEvent17.addParticipant(User44);
		newEvent17.addParticipant(User42);
		newEvent17.addParticipant(User11);
		newEvent17.addParticipant(User46);
		newEvent17.addParticipant(User22);
		newEvent17.setLocation(newLoc17);
		Occurrence newOccur17_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(103).getMillis()));
		newEvent17.addOccurrence(newOccur17_0);
		Occurrence newOccur17_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(76).getMillis()));
		newEvent17.addOccurrence(newOccur17_1);
		newEvent17.setDescription("Ipsum natus non molestiae laborum esse alias. Labore cupiditate unde amet eos.");
		newEvent17.setCategory(outdoors);
		this.eventRepo.save(newEvent17);
		Event newEvent18 = new Event("Omnis ab laborum architecto sunt quia.");
		Location newLoc18 = new Location("Consequuntur tempora voluptatibus.", "660 Euna Park Suite 796", "Coronado",
				"CA", "91931", 32.813206, -117.093561);
		newEvent18.addOwner(User47);
		newEvent18.addParticipant(User47);
		newEvent18.addParticipant(User25);
		newEvent18.addParticipant(User40);
		newEvent18.addParticipant(User4);
		newEvent18.addParticipant(User10);
		newEvent18.addParticipant(User48);
		newEvent18.addParticipant(User49);
		newEvent18.setLocation(newLoc18);
		Occurrence newOccur18_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(103).getMillis()));
		newEvent18.addOccurrence(newOccur18_0);
		Occurrence newOccur18_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(123).getMillis()));
		newEvent18.addOccurrence(newOccur18_1);
		Occurrence newOccur18_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(100).getMillis()));
		newEvent18.addOccurrence(newOccur18_2);
		newEvent18.setDescription(
				"Totam beatae illo debitis dignissimos. Id occaecati laborum tenetur. Pariatur qui praesentium ut.");
		newEvent18.setCategory(tech);
		this.eventRepo.save(newEvent18);
		Event newEvent19 = new Event("Magni ab atque commodi non nobis.");
		Location newLoc19 = new Location("Nesciunt eum ipsa quis.", "991 Bartell Plaza", "Oceanside", "CA", "92066",
				32.817982, -116.888632);
		newEvent19.addOwner(User28);
		newEvent19.addParticipant(User28);
		newEvent19.addParticipant(User20);
		newEvent19.addParticipant(User41);
		newEvent19.setLocation(newLoc19);
		Occurrence newOccur19_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(82).getMillis()));
		newEvent19.addOccurrence(newOccur19_0);
		Occurrence newOccur19_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(134).getMillis()));
		newEvent19.addOccurrence(newOccur19_1);
		Occurrence newOccur19_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(46).getMillis()));
		newEvent19.addOccurrence(newOccur19_2);
		newEvent19.setDescription("Maxime impedit quisquam fugit ducimus ad. Nobis ipsa aliquam sapiente quasi.");
		newEvent19.setCategory(games);
		this.eventRepo.save(newEvent19);
		Event newEvent20 = new Event("Earum quibusdam eos illum.");
		Location newLoc20 = new Location("Illum quo omnis vitae.", "22471 Wehner Track", "Jamul", "CA", "91934",
				32.881009, -117.210219);
		newEvent20.addOwner(User5);
		newEvent20.addParticipant(User5);
		newEvent20.addParticipant(User23);
		newEvent20.addParticipant(User35);
		newEvent20.addParticipant(User41);
		newEvent20.addParticipant(User2);
		newEvent20.addParticipant(User22);
		newEvent20.addParticipant(User16);
		newEvent20.addParticipant(User42);
		newEvent20.addParticipant(User23);
		newEvent20.addParticipant(User40);
		newEvent20.setLocation(newLoc20);
		Occurrence newOccur20_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(26).getMillis()));
		newEvent20.addOccurrence(newOccur20_0);
		Occurrence newOccur20_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(114).getMillis()));
		newEvent20.addOccurrence(newOccur20_1);
		Occurrence newOccur20_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(36).getMillis()));
		newEvent20.addOccurrence(newOccur20_2);
		newEvent20.setDescription("Optio perspiciatis adipisci cumque sunt. Accusantium amet sunt nisi sequi.");
		newEvent20.setCategory(fitness);
		this.eventRepo.save(newEvent20);
		Event newEvent21 = new Event("Tempora tempora eum alias veritatis.");
		Location newLoc21 = new Location("Animi nihil velit.", "795 Jettie Haven", "Live Oak Springs", "CA", "91910",
				32.885168, -117.141290);
		newEvent21.addOwner(User22);
		newEvent21.addParticipant(User22);
		newEvent21.addParticipant(User48);
		newEvent21.addParticipant(User28);
		newEvent21.addParticipant(User28);
		newEvent21.addParticipant(User48);
		newEvent21.addParticipant(User32);
		newEvent21.addParticipant(User7);
		newEvent21.addParticipant(User7);
		newEvent21.addParticipant(User0);
		newEvent21.addParticipant(User12);
		newEvent21.setLocation(newLoc21);
		Occurrence newOccur21_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(146).getMillis()));
		newEvent21.addOccurrence(newOccur21_0);
		Occurrence newOccur21_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(2).getMillis()));
		newEvent21.addOccurrence(newOccur21_1);
		Occurrence newOccur21_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(138).getMillis()));
		newEvent21.addOccurrence(newOccur21_2);
		newEvent21.setDescription("Placeat dicta soluta repellendus. Expedita reprehenderit non ipsum delectus.");
		newEvent21.setCategory(music);
		this.eventRepo.save(newEvent21);
		Event newEvent22 = new Event("Maiores et quisquam veniam.");
		Location newLoc22 = new Location("Quas sequi neque molestias.", "70044 Bree Dale", "Fallbrook", "CA", "92119",
				32.556829, -117.199713);
		newEvent22.addOwner(User29);
		newEvent22.addParticipant(User29);
		newEvent22.addParticipant(User38);
		newEvent22.setLocation(newLoc22);
		Occurrence newOccur22_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(129).getMillis()));
		newEvent22.addOccurrence(newOccur22_0);
		Occurrence newOccur22_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(106).getMillis()));
		newEvent22.addOccurrence(newOccur22_1);
		Occurrence newOccur22_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(116).getMillis()));
		newEvent22.addOccurrence(newOccur22_2);
		newEvent22.setDescription(
				"Neque molestiae qui eum repellendus. Architecto incidunt incidunt fuga recusandae beatae.");
		newEvent22.setCategory(food);
		this.eventRepo.save(newEvent22);
		Event newEvent23 = new Event("In hic iste perspiciatis.");
		Location newLoc23 = new Location("Veniam unde hic nisi.", "500 Nakisha Skyway Apt. 874", "Fallbrook", "CA",
				"92038", 32.626733, -117.186033);
		newEvent23.addOwner(User1);
		newEvent23.addParticipant(User1);
		newEvent23.addParticipant(User22);
		newEvent23.setLocation(newLoc23);
		Occurrence newOccur23_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(105).getMillis()));
		newEvent23.addOccurrence(newOccur23_0);
		Occurrence newOccur23_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(41).getMillis()));
		newEvent23.addOccurrence(newOccur23_1);
		Occurrence newOccur23_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(15).getMillis()));
		newEvent23.addOccurrence(newOccur23_2);
		newEvent23.setDescription("Sunt esse ea nostrum est. Quaerat eum eos quas eaque.");
		newEvent23.setCategory(education);
		this.eventRepo.save(newEvent23);
		Event newEvent24 = new Event("Ex delectus eum incidunt delectus.");
		Location newLoc24 = new Location("Ea et magni.", "7401 Bogan Burg", "Vista", "CA", "92123", 32.817530,
				-117.067289);
		newEvent24.addOwner(User13);
		newEvent24.addParticipant(User13);
		newEvent24.addParticipant(User23);
		newEvent24.setLocation(newLoc24);
		Occurrence newOccur24_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(42).getMillis()));
		newEvent24.addOccurrence(newOccur24_0);
		Occurrence newOccur24_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(134).getMillis()));
		newEvent24.addOccurrence(newOccur24_1);
		Occurrence newOccur24_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(96).getMillis()));
		newEvent24.addOccurrence(newOccur24_2);
		Occurrence newOccur24_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(52).getMillis()));
		newEvent24.addOccurrence(newOccur24_3);
		newEvent24.setDescription(
				"Quisquam autem aut reiciendis beatae doloribus. Minima totam odio ab cum doloremque suscipit amet.");
		newEvent24.setCategory(games);
		this.eventRepo.save(newEvent24);
		Event newEvent25 = new Event("At vel cum iure vel.");
		Location newLoc25 = new Location("Omnis totam deleniti.", "549 Sipes Station", "Campo", "CA", "92170",
				32.611744, -117.160302);
		newEvent25.addOwner(User17);
		newEvent25.addParticipant(User17);
		newEvent25.addParticipant(User45);
		newEvent25.addParticipant(User27);
		newEvent25.addParticipant(User42);
		newEvent25.setLocation(newLoc25);
		Occurrence newOccur25_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(118).getMillis()));
		newEvent25.addOccurrence(newOccur25_0);
		Occurrence newOccur25_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(42).getMillis()));
		newEvent25.addOccurrence(newOccur25_1);
		newEvent25.setDescription(
				"Doloremque atque recusandae omnis ad. Dignissimos id minus est molestias quas quisquam molestiae.");
		newEvent25.setCategory(fitness);
		this.eventRepo.save(newEvent25);
		Event newEvent26 = new Event("Sapiente sint non id amet.");
		Location newLoc26 = new Location("Odio id quisquam asperiores beatae.", "0632 O'Keefe Mall Suite 884",
				"Encinitas", "CA", "92027", 32.919542, -116.980827);
		newEvent26.addOwner(User5);
		newEvent26.addParticipant(User5);
		newEvent26.addParticipant(User36);
		newEvent26.addParticipant(User6);
		newEvent26.setLocation(newLoc26);
		Occurrence newOccur26_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(92).getMillis()));
		newEvent26.addOccurrence(newOccur26_0);
		Occurrence newOccur26_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(61).getMillis()));
		newEvent26.addOccurrence(newOccur26_1);
		newEvent26.setDescription(
				"Alias aliquid maiores quae voluptatem cumque. Cupiditate ullam impedit hic iste provident.");
		newEvent26.setCategory(music);
		this.eventRepo.save(newEvent26);
		Event newEvent27 = new Event("Ab iure nam earum.");
		Location newLoc27 = new Location("Illum nemo quos.", "1060 Borer Tunnel Apt. 802", "Cardiff-by-the-Sea", "CA",
				"92134", 32.726180, -116.864964);
		newEvent27.addOwner(User10);
		newEvent27.addParticipant(User10);
		newEvent27.addParticipant(User35);
		newEvent27.addParticipant(User3);
		newEvent27.addParticipant(User17);
		newEvent27.setLocation(newLoc27);
		Occurrence newOccur27_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(143).getMillis()));
		newEvent27.addOccurrence(newOccur27_0);
		Occurrence newOccur27_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(10).getMillis()));
		newEvent27.addOccurrence(newOccur27_1);
		Occurrence newOccur27_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(57).getMillis()));
		newEvent27.addOccurrence(newOccur27_2);
		Occurrence newOccur27_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(55).getMillis()));
		newEvent27.addOccurrence(newOccur27_3);
		newEvent27.setDescription(
				"Magnam quas repellendus recusandae modi nemo. Dolore iure odit magnam tempore voluptas dolore.");
		newEvent27.setCategory(tech);
		this.eventRepo.save(newEvent27);
		Event newEvent28 = new Event("Ut illum quaerat architecto facilis.");
		Location newLoc28 = new Location("Ex natus.", "282 Lakin Cape Apt. 907", "Solana Beach", "CA", "92139",
				32.941404, -117.147365);
		newEvent28.addOwner(User15);
		newEvent28.addParticipant(User15);
		newEvent28.addParticipant(User22);
		newEvent28.addParticipant(User13);
		newEvent28.addParticipant(User38);
		newEvent28.setLocation(newLoc28);
		Occurrence newOccur28_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(25).getMillis()));
		newEvent28.addOccurrence(newOccur28_0);
		Occurrence newOccur28_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(138).getMillis()));
		newEvent28.addOccurrence(newOccur28_1);
		Occurrence newOccur28_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(138).getMillis()));
		newEvent28.addOccurrence(newOccur28_2);
		newEvent28.setDescription("Eligendi vel facere pariatur omnis saepe error. Consequuntur rem veritatis quo.");
		newEvent28.setCategory(arts);
		this.eventRepo.save(newEvent28);
		Event newEvent29 = new Event("Doloribus ex iste quam nulla quos vel.");
		Location newLoc29 = new Location("Repellat illo recusandae.", "509 Upton Green Suite 923", "Pala", "CA",
				"92072", 32.952664, -117.184737);
		newEvent29.addOwner(User41);
		newEvent29.addParticipant(User41);
		newEvent29.addParticipant(User16);
		newEvent29.addParticipant(User16);
		newEvent29.addParticipant(User41);
		newEvent29.addParticipant(User13);
		newEvent29.setLocation(newLoc29);
		Occurrence newOccur29_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(87).getMillis()));
		newEvent29.addOccurrence(newOccur29_0);
		Occurrence newOccur29_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(83).getMillis()));
		newEvent29.addOccurrence(newOccur29_1);
		Occurrence newOccur29_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(132).getMillis()));
		newEvent29.addOccurrence(newOccur29_2);
		Occurrence newOccur29_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(10).getMillis()));
		newEvent29.addOccurrence(newOccur29_3);
		newEvent29.setDescription("Ut aspernatur eum quos vitae. Rem esse assumenda earum eum inventore rem magnam.");
		newEvent29.setCategory(tech);
		this.eventRepo.save(newEvent29);
		Event newEvent30 = new Event("Et tenetur unde eos odio.");
		Location newLoc30 = new Location("Esse nostrum sapiente temporibus.", "5249 Carsen Lodge Apt. 914",
				"Live Oak Springs", "CA", "92134", 32.962361, -117.010040);
		newEvent30.addOwner(User25);
		newEvent30.addParticipant(User25);
		newEvent30.addParticipant(User15);
		newEvent30.addParticipant(User9);
		newEvent30.addParticipant(User31);
		newEvent30.addParticipant(User39);
		newEvent30.setLocation(newLoc30);
		Occurrence newOccur30_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(24).getMillis()));
		newEvent30.addOccurrence(newOccur30_0);
		newEvent30.setDescription("Aperiam neque officiis odit. Veniam eius itaque enim ad doloribus cum officia.");
		newEvent30.setCategory(tech);
		this.eventRepo.save(newEvent30);
		Event newEvent31 = new Event("Possimus enim nihil ea harum accusamus.");
		Location newLoc31 = new Location("Tenetur nam perspiciatis tempora.", "4476 Burton Drive", "Encinitas", "CA",
				"92081", 32.938678, -116.883222);
		newEvent31.addOwner(User13);
		newEvent31.addParticipant(User13);
		newEvent31.addParticipant(User22);
		newEvent31.setLocation(newLoc31);
		Occurrence newOccur31_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(69).getMillis()));
		newEvent31.addOccurrence(newOccur31_0);
		Occurrence newOccur31_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(0).getMillis()));
		newEvent31.addOccurrence(newOccur31_1);
		Occurrence newOccur31_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(2).getMillis()));
		newEvent31.addOccurrence(newOccur31_2);
		newEvent31.setDescription(
				"Veniam dignissimos dolor itaque minus harum. Quia laborum eos alias velit nulla quaerat.");
		newEvent31.setCategory(movies);
		this.eventRepo.save(newEvent31);
		Event newEvent32 = new Event("Modi ab vitae ipsum nemo fuga.");
		Location newLoc32 = new Location("Cum modi.", "488 Mabel Fields", "La Mesa", "CA", "92025", 32.702764,
				-116.944987);
		newEvent32.addOwner(User32);
		newEvent32.addParticipant(User32);
		newEvent32.addParticipant(User33);
		newEvent32.addParticipant(User28);
		newEvent32.addParticipant(User45);
		newEvent32.addParticipant(User12);
		newEvent32.addParticipant(User24);
		newEvent32.addParticipant(User16);
		newEvent32.addParticipant(User2);
		newEvent32.addParticipant(User14);
		newEvent32.addParticipant(User20);
		newEvent32.setLocation(newLoc32);
		Occurrence newOccur32_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(82).getMillis()));
		newEvent32.addOccurrence(newOccur32_0);
		Occurrence newOccur32_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(26).getMillis()));
		newEvent32.addOccurrence(newOccur32_1);
		newEvent32.setDescription(
				"Nulla dolor ex quod officia sit temporibus unde officiis. Dicta vitae doloremque odit ullam ipsum.");
		newEvent32.setCategory(fitness);
		this.eventRepo.save(newEvent32);
		Event newEvent33 = new Event("Labore consequatur eos quidem tempore.");
		Location newLoc33 = new Location("Deleniti in optio doloremque.", "1990 Maliyah Radial", "Cardiff", "CA",
				"92112", 32.803125, -117.039807);
		newEvent33.addOwner(User41);
		newEvent33.addParticipant(User41);
		newEvent33.addParticipant(User43);
		newEvent33.addParticipant(User4);
		newEvent33.addParticipant(User21);
		newEvent33.addParticipant(User9);
		newEvent33.addParticipant(User8);
		newEvent33.addParticipant(User0);
		newEvent33.setLocation(newLoc33);
		Occurrence newOccur33_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(71).getMillis()));
		newEvent33.addOccurrence(newOccur33_0);
		Occurrence newOccur33_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(111).getMillis()));
		newEvent33.addOccurrence(newOccur33_1);
		Occurrence newOccur33_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(78).getMillis()));
		newEvent33.addOccurrence(newOccur33_2);
		newEvent33.setDescription(
				"In eius laborum animi aliquid. Ipsam totam nesciunt ut placeat. Pariatur qui molestias molestiae.");
		newEvent33.setCategory(sports);
		this.eventRepo.save(newEvent33);
		Event newEvent34 = new Event("Commodi delectus voluptas suscipit.");
		Location newLoc34 = new Location("Nostrum deleniti provident nisi.", "936 Uriel Harbor Apt. 734", "Vista", "CA",
				"91944", 32.849329, -116.918446);
		newEvent34.addOwner(User35);
		newEvent34.addParticipant(User35);
		newEvent34.addParticipant(User44);
		newEvent34.setLocation(newLoc34);
		Occurrence newOccur34_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(34).getMillis()));
		newEvent34.addOccurrence(newOccur34_0);
		Occurrence newOccur34_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(74).getMillis()));
		newEvent34.addOccurrence(newOccur34_1);
		Occurrence newOccur34_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(94).getMillis()));
		newEvent34.addOccurrence(newOccur34_2);
		Occurrence newOccur34_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(23).getMillis()));
		newEvent34.addOccurrence(newOccur34_3);
		newEvent34.setDescription("Et nobis quibusdam doloribus. Corrupti temporibus natus iusto voluptates.");
		newEvent34.setCategory(sports);
		this.eventRepo.save(newEvent34);
		Event newEvent35 = new Event("Vel sed veritatis eius voluptas ex.");
		Location newLoc35 = new Location("Quae omnis autem dolore.", "89788 Roob Prairie Apt. 137", "Cardiff", "CA",
				"91921", 32.699450, -116.915817);
		newEvent35.addOwner(User23);
		newEvent35.addParticipant(User23);
		newEvent35.addParticipant(User37);
		newEvent35.addParticipant(User16);
		newEvent35.addParticipant(User17);
		newEvent35.addParticipant(User37);
		newEvent35.addParticipant(User20);
		newEvent35.addParticipant(User28);
		newEvent35.addParticipant(User3);
		newEvent35.addParticipant(User14);
		newEvent35.setLocation(newLoc35);
		Occurrence newOccur35_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(66).getMillis()));
		newEvent35.addOccurrence(newOccur35_0);
		Occurrence newOccur35_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(16).getMillis()));
		newEvent35.addOccurrence(newOccur35_1);
		newEvent35.setDescription(
				"Sunt dolorem distinctio quas quam similique. Similique culpa voluptatem optio dolorum totam.");
		newEvent35.setCategory(arts);
		this.eventRepo.save(newEvent35);
		Event newEvent36 = new Event("Et eaque error saepe neque.");
		Location newLoc36 = new Location("Fugit provident in.", "71489 Floy Junctions", "Encinitas", "CA", "92088",
				32.504609, -117.008943);
		newEvent36.addOwner(User17);
		newEvent36.addParticipant(User17);
		newEvent36.addParticipant(User24);
		newEvent36.addParticipant(User43);
		newEvent36.setLocation(newLoc36);
		Occurrence newOccur36_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(136).getMillis()));
		newEvent36.addOccurrence(newOccur36_0);
		Occurrence newOccur36_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(44).getMillis()));
		newEvent36.addOccurrence(newOccur36_1);
		Occurrence newOccur36_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(64).getMillis()));
		newEvent36.addOccurrence(newOccur36_2);
		newEvent36.setDescription("Sit perspiciatis doloribus cupiditate inventore. Nisi labore ullam sit vitae.");
		newEvent36.setCategory(fitness);
		this.eventRepo.save(newEvent36);
		Event newEvent37 = new Event("Ut totam voluptas perferendis.");
		Location newLoc37 = new Location("Odio quos perspiciatis.", "02684 Hodkiewicz Highway Apt. 325",
				"Pacific Beach", "CA", "92033", 32.816330, -116.904976);
		newEvent37.addOwner(User43);
		newEvent37.addParticipant(User43);
		newEvent37.addParticipant(User21);
		newEvent37.addParticipant(User19);
		newEvent37.addParticipant(User34);
		newEvent37.addParticipant(User42);
		newEvent37.addParticipant(User44);
		newEvent37.addParticipant(User23);
		newEvent37.addParticipant(User1);
		newEvent37.addParticipant(User10);
		newEvent37.addParticipant(User44);
		newEvent37.setLocation(newLoc37);
		Occurrence newOccur37_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(37).getMillis()));
		newEvent37.addOccurrence(newOccur37_0);
		Occurrence newOccur37_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(70).getMillis()));
		newEvent37.addOccurrence(newOccur37_1);
		newEvent37.setDescription(
				"Ullam ullam placeat incidunt cumque eum ullam. Inventore quidem nostrum debitis eius atque.");
		newEvent37.setCategory(community);
		this.eventRepo.save(newEvent37);
		Event newEvent38 = new Event("Quos vel ut aut quibusdam nam repellat.");
		Location newLoc38 = new Location("Harum doloribus rem quasi.", "901 Bode Knoll", "Fallbrook", "CA", "91942",
				32.734091, -116.908895);
		newEvent38.addOwner(User48);
		newEvent38.addParticipant(User48);
		newEvent38.addParticipant(User1);
		newEvent38.addParticipant(User11);
		newEvent38.setLocation(newLoc38);
		Occurrence newOccur38_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(147).getMillis()));
		newEvent38.addOccurrence(newOccur38_0);
		Occurrence newOccur38_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(20).getMillis()));
		newEvent38.addOccurrence(newOccur38_1);
		Occurrence newOccur38_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(64).getMillis()));
		newEvent38.addOccurrence(newOccur38_2);
		newEvent38.setDescription("Earum nemo eveniet cumque dolore. Doloribus dolorum ducimus minima.");
		newEvent38.setCategory(fitness);
		this.eventRepo.save(newEvent38);
		Event newEvent39 = new Event("Tempora quis cum voluptatem quasi.");
		Location newLoc39 = new Location("Recusandae suscipit quas.", "37344 Kai Skyway Apt. 272", "Pacific Beach",
				"CA", "92164", 32.523203, -117.038595);
		newEvent39.addOwner(User22);
		newEvent39.addParticipant(User22);
		newEvent39.addParticipant(User24);
		newEvent39.addParticipant(User43);
		newEvent39.addParticipant(User41);
		newEvent39.addParticipant(User16);
		newEvent39.setLocation(newLoc39);
		Occurrence newOccur39_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(27).getMillis()));
		newEvent39.addOccurrence(newOccur39_0);
		Occurrence newOccur39_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(117).getMillis()));
		newEvent39.addOccurrence(newOccur39_1);
		Occurrence newOccur39_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(62).getMillis()));
		newEvent39.addOccurrence(newOccur39_2);
		newEvent39.setDescription(
				"Quas doloribus et pariatur. Id nisi fugiat nemo quo consequatur. Nisi quaerat voluptas dolores.");
		newEvent39.setCategory(community);
		this.eventRepo.save(newEvent39);
		Event newEvent40 = new Event("Minima libero tempore aut ad.");
		Location newLoc40 = new Location("Doloribus fugiat molestias molestiae.", "977 Evan Mills", "Borrega Springs",
				"CA", "92120", 32.731482, -117.128228);
		newEvent40.addOwner(User44);
		newEvent40.addParticipant(User44);
		newEvent40.addParticipant(User13);
		newEvent40.setLocation(newLoc40);
		Occurrence newOccur40_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(49).getMillis()));
		newEvent40.addOccurrence(newOccur40_0);
		Occurrence newOccur40_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(139).getMillis()));
		newEvent40.addOccurrence(newOccur40_1);
		newEvent40.setDescription(
				"Cumque voluptatum dolore minima omnis incidunt. Et tempora quibusdam tempora praesentium.");
		newEvent40.setCategory(community);
		this.eventRepo.save(newEvent40);
		Event newEvent41 = new Event("Porro doloremque corrupti hic adipisci.");
		Location newLoc41 = new Location("Rerum modi ea.", "20774 Lorenza Harbors", "Escondido", "CA", "92040",
				32.511177, -116.898879);
		newEvent41.addOwner(User18);
		newEvent41.addParticipant(User18);
		newEvent41.addParticipant(User42);
		newEvent41.addParticipant(User8);
		newEvent41.addParticipant(User48);
		newEvent41.addParticipant(User40);
		newEvent41.addParticipant(User23);
		newEvent41.addParticipant(User45);
		newEvent41.addParticipant(User26);
		newEvent41.setLocation(newLoc41);
		Occurrence newOccur41_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(106).getMillis()));
		newEvent41.addOccurrence(newOccur41_0);
		Occurrence newOccur41_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(8).getMillis()));
		newEvent41.addOccurrence(newOccur41_1);
		newEvent41.setDescription(
				"Beatae earum inventore voluptatibus ipsum vitae. Nam corrupti doloribus inventore minus.");
		newEvent41.setCategory(education);
		this.eventRepo.save(newEvent41);
		Event newEvent42 = new Event("Odit perferendis vitae quibusdam at.");
		Location newLoc42 = new Location("Quia sunt sed possimus.", "0854 Gibson Roads Suite 858", "Imperial", "CA",
				"92049", 32.718901, -117.136854);
		newEvent42.addOwner(User39);
		newEvent42.addParticipant(User39);
		newEvent42.addParticipant(User39);
		newEvent42.addParticipant(User26);
		newEvent42.addParticipant(User5);
		newEvent42.addParticipant(User0);
		newEvent42.setLocation(newLoc42);
		Occurrence newOccur42_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(134).getMillis()));
		newEvent42.addOccurrence(newOccur42_0);
		Occurrence newOccur42_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(110).getMillis()));
		newEvent42.addOccurrence(newOccur42_1);
		newEvent42.setDescription(
				"Quas distinctio ratione odio sequi aliquid. Neque officiis sint sapiente pariatur cupiditate nihil.");
		newEvent42.setCategory(food);
		this.eventRepo.save(newEvent42);
		Event newEvent43 = new Event("Inventore vero atque nulla iste.");
		Location newLoc43 = new Location("Tempora facere alias.", "175 Satterfield Shores", "Hillcrest", "CA", "92131",
				32.961792, -117.152987);
		newEvent43.addOwner(User41);
		newEvent43.addParticipant(User41);
		newEvent43.addParticipant(User43);
		newEvent43.addParticipant(User7);
		newEvent43.addParticipant(User5);
		newEvent43.addParticipant(User28);
		newEvent43.addParticipant(User15);
		newEvent43.addParticipant(User9);
		newEvent43.addParticipant(User27);
		newEvent43.addParticipant(User48);
		newEvent43.setLocation(newLoc43);
		Occurrence newOccur43_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(117).getMillis()));
		newEvent43.addOccurrence(newOccur43_0);
		Occurrence newOccur43_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(85).getMillis()));
		newEvent43.addOccurrence(newOccur43_1);
		newEvent43.setDescription(
				"Laborum nulla quibusdam explicabo perferendis. Blanditiis ipsa iure at nesciunt itaque repellendus.");
		newEvent43.setCategory(fitness);
		this.eventRepo.save(newEvent43);
		Event newEvent44 = new Event("Veniam quod suscipit laudantium.");
		Location newLoc44 = new Location("Nisi non.", "53104 Torphy Common", "Del Mar", "CA", "92160", 32.798515,
				-117.219690);
		newEvent44.addOwner(User35);
		newEvent44.addParticipant(User35);
		newEvent44.addParticipant(User27);
		newEvent44.addParticipant(User15);
		newEvent44.addParticipant(User48);
		newEvent44.addParticipant(User38);
		newEvent44.setLocation(newLoc44);
		Occurrence newOccur44_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(92).getMillis()));
		newEvent44.addOccurrence(newOccur44_0);
		newEvent44.setDescription(
				"Error voluptatem consectetur cumque optio repudiandae. Adipisci at autem similique sapiente.");
		newEvent44.setCategory(movies);
		this.eventRepo.save(newEvent44);
		Event newEvent45 = new Event("Quos tempore blanditiis id hic ex ex.");
		Location newLoc45 = new Location("Animi nisi similique.", "88095 Ewing Branch", "Imperial", "CA", "92008",
				32.502959, -116.991951);
		newEvent45.addOwner(User23);
		newEvent45.addParticipant(User23);
		newEvent45.addParticipant(User30);
		newEvent45.addParticipant(User23);
		newEvent45.addParticipant(User8);
		newEvent45.addParticipant(User41);
		newEvent45.addParticipant(User11);
		newEvent45.addParticipant(User18);
		newEvent45.addParticipant(User4);
		newEvent45.addParticipant(User25);
		newEvent45.addParticipant(User34);
		newEvent45.setLocation(newLoc45);
		Occurrence newOccur45_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(110).getMillis()));
		newEvent45.addOccurrence(newOccur45_0);
		Occurrence newOccur45_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(30).getMillis()));
		newEvent45.addOccurrence(newOccur45_1);
		Occurrence newOccur45_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(30).getMillis()));
		newEvent45.addOccurrence(newOccur45_2);
		Occurrence newOccur45_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(45).getMillis()));
		newEvent45.addOccurrence(newOccur45_3);
		newEvent45.setDescription(
				"Dolore quae hic consectetur beatae dolores repellat. At natus saepe facere nam libero.");
		newEvent45.setCategory(book);
		this.eventRepo.save(newEvent45);
		Event newEvent46 = new Event("Quo quam ad vero asperiores quasi quas.");
		Location newLoc46 = new Location("Itaque nihil neque.", "0752 Stanton Branch Suite 206", "Poway", "CA", "92054",
				32.504833, -117.067390);
		newEvent46.addOwner(User10);
		newEvent46.addParticipant(User10);
		newEvent46.addParticipant(User40);
		newEvent46.addParticipant(User25);
		newEvent46.addParticipant(User20);
		newEvent46.addParticipant(User29);
		newEvent46.addParticipant(User45);
		newEvent46.addParticipant(User1);
		newEvent46.addParticipant(User33);
		newEvent46.addParticipant(User24);
		newEvent46.addParticipant(User5);
		newEvent46.setLocation(newLoc46);
		Occurrence newOccur46_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(139).getMillis()));
		newEvent46.addOccurrence(newOccur46_0);
		Occurrence newOccur46_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(58).getMillis()));
		newEvent46.addOccurrence(newOccur46_1);
		newEvent46.setDescription(
				"At neque beatae commodi ratione ipsum ad. Dolor dolor vel nulla eos. Culpa rerum amet pariatur.");
		newEvent46.setCategory(sports);
		this.eventRepo.save(newEvent46);
		Event newEvent47 = new Event("Sequi aperiam quia ipsa consequuntur.");
		Location newLoc47 = new Location("Provident sint eum.", "4865 Batz Wells Suite 381", "Encinitas", "CA", "91901",
				32.922735, -116.986222);
		newEvent47.addOwner(User25);
		newEvent47.addParticipant(User25);
		newEvent47.addParticipant(User49);
		newEvent47.addParticipant(User34);
		newEvent47.addParticipant(User27);
		newEvent47.addParticipant(User16);
		newEvent47.addParticipant(User15);
		newEvent47.setLocation(newLoc47);
		Occurrence newOccur47_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(97).getMillis()));
		newEvent47.addOccurrence(newOccur47_0);
		Occurrence newOccur47_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(40).getMillis()));
		newEvent47.addOccurrence(newOccur47_1);
		Occurrence newOccur47_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(137).getMillis()));
		newEvent47.addOccurrence(newOccur47_2);
		newEvent47.setDescription(
				"Repellat corporis consequuntur quam laboriosam ullam veritatis. Deserunt sequi nobis ratione.");
		newEvent47.setCategory(food);
		this.eventRepo.save(newEvent47);
		Event newEvent48 = new Event("Ipsa error tempore ipsam et eum aut.");
		Location newLoc48 = new Location("Asperiores corrupti esse.", "1432 Kelvin Fork", "Cardiff", "CA", "92122",
				32.911331, -117.099733);
		newEvent48.addOwner(User44);
		newEvent48.addParticipant(User44);
		newEvent48.addParticipant(User11);
		newEvent48.addParticipant(User0);
		newEvent48.addParticipant(User30);
		newEvent48.addParticipant(User41);
		newEvent48.setLocation(newLoc48);
		Occurrence newOccur48_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(29).getMillis()));
		newEvent48.addOccurrence(newOccur48_0);
		newEvent48.setDescription(
				"Odio totam eaque inventore earum eligendi. Et placeat aut nemo et. Itaque temporibus amet deleniti.");
		newEvent48.setCategory(community);
		this.eventRepo.save(newEvent48);
		Event newEvent49 = new Event("Amet quasi aliquam perspiciatis.");
		Location newLoc49 = new Location("Harum perspiciatis earum occaecati.", "578 Margarite Highway",
				"San Clemente Island", "CA", "92158", 32.861868, -117.038917);
		newEvent49.addOwner(User23);
		newEvent49.addParticipant(User23);
		newEvent49.addParticipant(User14);
		newEvent49.addParticipant(User39);
		newEvent49.addParticipant(User24);
		newEvent49.addParticipant(User6);
		newEvent49.addParticipant(User43);
		newEvent49.addParticipant(User1);
		newEvent49.addParticipant(User43);
		newEvent49.setLocation(newLoc49);
		Occurrence newOccur49_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(102).getMillis()));
		newEvent49.addOccurrence(newOccur49_0);
		Occurrence newOccur49_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(38).getMillis()));
		newEvent49.addOccurrence(newOccur49_1);
		newEvent49.setDescription(
				"Sed architecto rem aspernatur maxime harum. Sint debitis quo quod dolores iusto eius minima.");
		newEvent49.setCategory(tech);
		this.eventRepo.save(newEvent49);
		Event newEvent50 = new Event("Perspiciatis tempora nemo nam nihil.");
		Location newLoc50 = new Location("Necessitatibus doloremque.", "57653 Bryson Flats", "San Clemente Island",
				"CA", "92166", 32.858585, -117.148879);
		newEvent50.addOwner(User19);
		newEvent50.addParticipant(User19);
		newEvent50.addParticipant(User33);
		newEvent50.addParticipant(User26);
		newEvent50.addParticipant(User33);
		newEvent50.addParticipant(User25);
		newEvent50.addParticipant(User37);
		newEvent50.addParticipant(User49);
		newEvent50.addParticipant(User49);
		newEvent50.addParticipant(User40);
		newEvent50.addParticipant(User0);
		newEvent50.setLocation(newLoc50);
		Occurrence newOccur50_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(37).getMillis()));
		newEvent50.addOccurrence(newOccur50_0);
		Occurrence newOccur50_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(73).getMillis()));
		newEvent50.addOccurrence(newOccur50_1);
		Occurrence newOccur50_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(49).getMillis()));
		newEvent50.addOccurrence(newOccur50_2);
		newEvent50.setDescription(
				"Recusandae voluptatum possimus qui ipsam quae laboriosam. Laudantium voluptatem atque quisquam.");
		newEvent50.setCategory(food);
		this.eventRepo.save(newEvent50);
		Event newEvent51 = new Event("Placeat iure quidem deserunt quo.");
		Location newLoc51 = new Location("Et possimus dolore.", "3367 Otelia Camp Apt. 423", "Poway", "CA", "92101",
				32.867356, -117.224029);
		newEvent51.addOwner(User18);
		newEvent51.addParticipant(User18);
		newEvent51.addParticipant(User29);
		newEvent51.addParticipant(User42);
		newEvent51.addParticipant(User26);
		newEvent51.addParticipant(User17);
		newEvent51.addParticipant(User34);
		newEvent51.addParticipant(User9);
		newEvent51.addParticipant(User29);
		newEvent51.addParticipant(User23);
		newEvent51.setLocation(newLoc51);
		Occurrence newOccur51_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(65).getMillis()));
		newEvent51.addOccurrence(newOccur51_0);
		Occurrence newOccur51_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(79).getMillis()));
		newEvent51.addOccurrence(newOccur51_1);
		Occurrence newOccur51_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(79).getMillis()));
		newEvent51.addOccurrence(newOccur51_2);
		newEvent51
				.setDescription("Odio ipsam eius praesentium numquam. Minus exercitationem iure voluptates ex libero.");
		newEvent51.setCategory(movies);
		this.eventRepo.save(newEvent51);
		Event newEvent52 = new Event("Possimus inventore vero facere animi.");
		Location newLoc52 = new Location("Nemo nam dignissimos incidunt.", "8310 Schiller Dam Apt. 307", "Escondido",
				"CA", "92119", 32.829115, -116.935896);
		newEvent52.addOwner(User29);
		newEvent52.addParticipant(User29);
		newEvent52.addParticipant(User28);
		newEvent52.addParticipant(User40);
		newEvent52.addParticipant(User10);
		newEvent52.addParticipant(User33);
		newEvent52.addParticipant(User11);
		newEvent52.setLocation(newLoc52);
		Occurrence newOccur52_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(90).getMillis()));
		newEvent52.addOccurrence(newOccur52_0);
		Occurrence newOccur52_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(129).getMillis()));
		newEvent52.addOccurrence(newOccur52_1);
		newEvent52
				.setDescription("Dolores amet doloremque pariatur quasi odit. Nobis officia iste quasi libero totam.");
		newEvent52.setCategory(book);
		this.eventRepo.save(newEvent52);
		Event newEvent53 = new Event("Totam odit beatae alias recusandae.");
		Location newLoc53 = new Location("Vel iure officia asperiores.", "09219 Catharine Mountains", "San Ysidro",
				"CA", "92176", 32.917400, -117.083086);
		newEvent53.addOwner(User18);
		newEvent53.addParticipant(User18);
		newEvent53.addParticipant(User11);
		newEvent53.addParticipant(User18);
		newEvent53.addParticipant(User35);
		newEvent53.addParticipant(User35);
		newEvent53.addParticipant(User14);
		newEvent53.addParticipant(User23);
		newEvent53.setLocation(newLoc53);
		Occurrence newOccur53_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(67).getMillis()));
		newEvent53.addOccurrence(newOccur53_0);
		Occurrence newOccur53_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(133).getMillis()));
		newEvent53.addOccurrence(newOccur53_1);
		newEvent53.setDescription(
				"Aliquid laudantium quidem qui id minus. Molestiae quod cupiditate amet facere beatae.");
		newEvent53.setCategory(movies);
		this.eventRepo.save(newEvent53);
		Event newEvent54 = new Event("Odio maiores deleniti nihil provident.");
		Location newLoc54 = new Location("Iste ratione.", "666 Hartmann Key", "Leucadia", "CA", "92179", 32.681188,
				-116.997236);
		newEvent54.addOwner(User45);
		newEvent54.addParticipant(User45);
		newEvent54.addParticipant(User19);
		newEvent54.addParticipant(User42);
		newEvent54.addParticipant(User9);
		newEvent54.addParticipant(User44);
		newEvent54.addParticipant(User49);
		newEvent54.addParticipant(User1);
		newEvent54.addParticipant(User43);
		newEvent54.addParticipant(User28);
		newEvent54.addParticipant(User26);
		newEvent54.setLocation(newLoc54);
		Occurrence newOccur54_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(84).getMillis()));
		newEvent54.addOccurrence(newOccur54_0);
		Occurrence newOccur54_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(64).getMillis()));
		newEvent54.addOccurrence(newOccur54_1);
		Occurrence newOccur54_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(84).getMillis()));
		newEvent54.addOccurrence(newOccur54_2);
		Occurrence newOccur54_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(126).getMillis()));
		newEvent54.addOccurrence(newOccur54_3);
		newEvent54.setDescription("Ullam nam adipisci animi tempora. Cupiditate ratione animi quam id.");
		newEvent54.setCategory(community);
		this.eventRepo.save(newEvent54);
		Event newEvent55 = new Event("Optio ducimus facere eos et.");
		Location newLoc55 = new Location("Ad iure suscipit.", "2955 Heathcote Centers", "Rancho Santa Fe", "CA",
				"92197", 32.517109, -117.168132);
		newEvent55.addOwner(User11);
		newEvent55.addParticipant(User11);
		newEvent55.addParticipant(User6);
		newEvent55.addParticipant(User11);
		newEvent55.addParticipant(User35);
		newEvent55.addParticipant(User41);
		newEvent55.setLocation(newLoc55);
		Occurrence newOccur55_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(129).getMillis()));
		newEvent55.addOccurrence(newOccur55_0);
		newEvent55.setDescription(
				"Hic ullam illo est amet repudiandae. Repellat blanditiis accusantium nam nisi at harum culpa.");
		newEvent55.setCategory(music);
		this.eventRepo.save(newEvent55);
		Event newEvent56 = new Event("Enim ex ad ipsa quidem repudiandae.");
		Location newLoc56 = new Location("Dolor fugit qui facere.", "263 Kirsten Roads Apt. 481", "Rancho Santa Fe",
				"CA", "91903", 32.788324, -117.085702);
		newEvent56.addOwner(User27);
		newEvent56.addParticipant(User27);
		newEvent56.addParticipant(User29);
		newEvent56.addParticipant(User43);
		newEvent56.addParticipant(User3);
		newEvent56.addParticipant(User34);
		newEvent56.addParticipant(User30);
		newEvent56.addParticipant(User8);
		newEvent56.addParticipant(User46);
		newEvent56.addParticipant(User22);
		newEvent56.addParticipant(User33);
		newEvent56.setLocation(newLoc56);
		Occurrence newOccur56_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(77).getMillis()));
		newEvent56.addOccurrence(newOccur56_0);
		Occurrence newOccur56_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(5).getMillis()));
		newEvent56.addOccurrence(newOccur56_1);
		newEvent56.setDescription("Atque expedita sequi debitis provident. Veniam molestiae voluptas debitis iusto.");
		newEvent56.setCategory(sports);
		this.eventRepo.save(newEvent56);
		Event newEvent57 = new Event("Iste minus provident magnam officia.");
		Location newLoc57 = new Location("Molestias accusamus.", "8232 Hoppe Fork Suite 673", "Lakeside", "CA", "92119",
				32.759348, -116.923170);
		newEvent57.addOwner(User44);
		newEvent57.addParticipant(User44);
		newEvent57.addParticipant(User26);
		newEvent57.addParticipant(User38);
		newEvent57.addParticipant(User39);
		newEvent57.setLocation(newLoc57);
		Occurrence newOccur57_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(86).getMillis()));
		newEvent57.addOccurrence(newOccur57_0);
		Occurrence newOccur57_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(131).getMillis()));
		newEvent57.addOccurrence(newOccur57_1);
		newEvent57.setDescription("Magni placeat beatae fugiat ad amet. Ex rem saepe vero distinctio sequi.");
		newEvent57.setCategory(arts);
		this.eventRepo.save(newEvent57);
		Event newEvent58 = new Event("Eaque a quasi modi debitis.");
		Location newLoc58 = new Location("Atque saepe architecto.", "7051 Erby Summit", "Campo", "CA", "92161",
				32.865185, -116.995750);
		newEvent58.addOwner(User43);
		newEvent58.addParticipant(User43);
		newEvent58.addParticipant(User31);
		newEvent58.setLocation(newLoc58);
		Occurrence newOccur58_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(114).getMillis()));
		newEvent58.addOccurrence(newOccur58_0);
		Occurrence newOccur58_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(12).getMillis()));
		newEvent58.addOccurrence(newOccur58_1);
		Occurrence newOccur58_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(43).getMillis()));
		newEvent58.addOccurrence(newOccur58_2);
		Occurrence newOccur58_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(139).getMillis()));
		newEvent58.addOccurrence(newOccur58_3);
		newEvent58.setDescription(
				"Occaecati dicta ratione atque. Quam cupiditate harum labore a. Repellat quo hic et libero odio.");
		newEvent58.setCategory(community);
		this.eventRepo.save(newEvent58);
		Event newEvent59 = new Event("Hic nemo saepe ex eos natus.");
		Location newLoc59 = new Location("Adipisci ea dolor.", "630 Diamond Roads Suite 342", "Escondido", "CA",
				"92118", 32.641039, -117.118758);
		newEvent59.addOwner(User19);
		newEvent59.addParticipant(User19);
		newEvent59.addParticipant(User7);
		newEvent59.addParticipant(User39);
		newEvent59.addParticipant(User41);
		newEvent59.setLocation(newLoc59);
		Occurrence newOccur59_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(122).getMillis()));
		newEvent59.addOccurrence(newOccur59_0);
		Occurrence newOccur59_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(85).getMillis()));
		newEvent59.addOccurrence(newOccur59_1);
		Occurrence newOccur59_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(93).getMillis()));
		newEvent59.addOccurrence(newOccur59_2);
		newEvent59.setDescription(
				"Iusto et fugit incidunt cum. Nostrum incidunt quas occaecati quod. Hic sit dolore cumque ipsum.");
		newEvent59.setCategory(fitness);
		this.eventRepo.save(newEvent59);
		Event newEvent60 = new Event("Ea quam id magnam.");
		Location newLoc60 = new Location("Illo nesciunt corrupti magnam.", "093 Deckow Cove Apt. 694", "San Marcos",
				"CA", "92120", 32.646911, -117.110292);
		newEvent60.addOwner(User7);
		newEvent60.addParticipant(User7);
		newEvent60.addParticipant(User13);
		newEvent60.addParticipant(User12);
		newEvent60.addParticipant(User43);
		newEvent60.addParticipant(User2);
		newEvent60.addParticipant(User10);
		newEvent60.addParticipant(User38);
		newEvent60.addParticipant(User29);
		newEvent60.addParticipant(User41);
		newEvent60.addParticipant(User39);
		newEvent60.setLocation(newLoc60);
		Occurrence newOccur60_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(27).getMillis()));
		newEvent60.addOccurrence(newOccur60_0);
		Occurrence newOccur60_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(52).getMillis()));
		newEvent60.addOccurrence(newOccur60_1);
		Occurrence newOccur60_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(44).getMillis()));
		newEvent60.addOccurrence(newOccur60_2);
		Occurrence newOccur60_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(80).getMillis()));
		newEvent60.addOccurrence(newOccur60_3);
		newEvent60.setDescription(
				"Nostrum beatae possimus distinctio. Enim iure sit facilis sequi repellendus neque nam.");
		newEvent60.setCategory(fitness);
		this.eventRepo.save(newEvent60);
		Event newEvent61 = new Event("Tempore quaerat sed laudantium.");
		Location newLoc61 = new Location("Nobis eligendi quia.", "2672 Marcell Road", "Leucadia", "CA", "92139",
				32.524125, -117.142987);
		newEvent61.addOwner(User20);
		newEvent61.addParticipant(User20);
		newEvent61.addParticipant(User31);
		newEvent61.addParticipant(User25);
		newEvent61.addParticipant(User32);
		newEvent61.addParticipant(User28);
		newEvent61.addParticipant(User35);
		newEvent61.setLocation(newLoc61);
		Occurrence newOccur61_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(61).getMillis()));
		newEvent61.addOccurrence(newOccur61_0);
		Occurrence newOccur61_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(134).getMillis()));
		newEvent61.addOccurrence(newOccur61_1);
		Occurrence newOccur61_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(108).getMillis()));
		newEvent61.addOccurrence(newOccur61_2);
		Occurrence newOccur61_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(20).getMillis()));
		newEvent61.addOccurrence(newOccur61_3);
		newEvent61.setDescription(
				"Labore hic doloribus accusamus quasi. Ullam reprehenderit reprehenderit quasi corrupti.");
		newEvent61.setCategory(fitness);
		this.eventRepo.save(newEvent61);
		Event newEvent62 = new Event("Vitae quo sed laborum dicta.");
		Location newLoc62 = new Location("Voluptatem a enim aut illum.", "40994 Kshlerin Cove Suite 871", "Imperial",
				"CA", "92093", 32.678106, -116.985017);
		newEvent62.addOwner(User3);
		newEvent62.addParticipant(User3);
		newEvent62.addParticipant(User17);
		newEvent62.addParticipant(User48);
		newEvent62.addParticipant(User26);
		newEvent62.addParticipant(User46);
		newEvent62.addParticipant(User35);
		newEvent62.addParticipant(User38);
		newEvent62.addParticipant(User7);
		newEvent62.addParticipant(User14);
		newEvent62.addParticipant(User21);
		newEvent62.setLocation(newLoc62);
		Occurrence newOccur62_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(146).getMillis()));
		newEvent62.addOccurrence(newOccur62_0);
		Occurrence newOccur62_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(101).getMillis()));
		newEvent62.addOccurrence(newOccur62_1);
		Occurrence newOccur62_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(99).getMillis()));
		newEvent62.addOccurrence(newOccur62_2);
		newEvent62.setDescription(
				"Totam eaque eius iste tempore. Aut nulla vel consequuntur ratione facere deleniti soluta iste.");
		newEvent62.setCategory(book);
		this.eventRepo.save(newEvent62);
		Event newEvent63 = new Event("Quisquam sit dicta labore quo saepe.");
		Location newLoc63 = new Location("Eveniet eligendi quis qui.", "658 Willam Corners", "San Clemente Island",
				"CA", "92197", 32.870069, -117.235242);
		newEvent63.addOwner(User23);
		newEvent63.addParticipant(User23);
		newEvent63.addParticipant(User23);
		newEvent63.addParticipant(User1);
		newEvent63.addParticipant(User6);
		newEvent63.addParticipant(User6);
		newEvent63.addParticipant(User25);
		newEvent63.addParticipant(User44);
		newEvent63.setLocation(newLoc63);
		Occurrence newOccur63_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(72).getMillis()));
		newEvent63.addOccurrence(newOccur63_0);
		newEvent63.setDescription(
				"Voluptatibus eveniet minus quasi iste cum fuga mollitia. Natus nesciunt odit eum deleniti.");
		newEvent63.setCategory(sports);
		this.eventRepo.save(newEvent63);
		Event newEvent64 = new Event("Rerum odio facere ex.");
		Location newLoc64 = new Location("Aliquam accusamus reiciendis eum.", "093 Melvina Mountains", "Jamul", "CA",
				"92140", 32.724521, -116.952021);
		newEvent64.addOwner(User7);
		newEvent64.addParticipant(User7);
		newEvent64.addParticipant(User2);
		newEvent64.setLocation(newLoc64);
		Occurrence newOccur64_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(144).getMillis()));
		newEvent64.addOccurrence(newOccur64_0);
		Occurrence newOccur64_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(82).getMillis()));
		newEvent64.addOccurrence(newOccur64_1);
		newEvent64.setDescription("Fugiat ea eum illum. Ullam cupiditate amet earum quis.");
		newEvent64.setCategory(community);
		this.eventRepo.save(newEvent64);
		Event newEvent65 = new Event("Accusantium fuga repellendus numquam.");
		Location newLoc65 = new Location("Sed aut.", "708 Grady Walk", "Del Mar", "CA", "92159", 32.615837,
				-116.994641);
		newEvent65.addOwner(User37);
		newEvent65.addParticipant(User37);
		newEvent65.addParticipant(User17);
		newEvent65.addParticipant(User10);
		newEvent65.addParticipant(User38);
		newEvent65.addParticipant(User6);
		newEvent65.setLocation(newLoc65);
		Occurrence newOccur65_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(39).getMillis()));
		newEvent65.addOccurrence(newOccur65_0);
		Occurrence newOccur65_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(107).getMillis()));
		newEvent65.addOccurrence(newOccur65_1);
		newEvent65.setDescription(
				"Magnam aut doloribus dignissimos dolores. Aut ea eum nam. Quidem hic nostrum in earum culpa.");
		newEvent65.setCategory(book);
		this.eventRepo.save(newEvent65);
		Event newEvent66 = new Event("Cum cupiditate quisquam culpa.");
		Location newLoc66 = new Location("Fuga enim laboriosam.", "7030 Cruickshank Row Suite 110", "Fallbrook", "CA",
				"92114", 32.500164, -116.962124);
		newEvent66.addOwner(User1);
		newEvent66.addParticipant(User1);
		newEvent66.addParticipant(User9);
		newEvent66.addParticipant(User21);
		newEvent66.addParticipant(User0);
		newEvent66.addParticipant(User10);
		newEvent66.addParticipant(User27);
		newEvent66.addParticipant(User34);
		newEvent66.addParticipant(User34);
		newEvent66.addParticipant(User13);
		newEvent66.addParticipant(User13);
		newEvent66.setLocation(newLoc66);
		Occurrence newOccur66_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(53).getMillis()));
		newEvent66.addOccurrence(newOccur66_0);
		Occurrence newOccur66_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(115).getMillis()));
		newEvent66.addOccurrence(newOccur66_1);
		newEvent66.setDescription(
				"Accusantium ullam accusamus repellat. Sed asperiores asperiores dolorem nisi facilis.");
		newEvent66.setCategory(hobbies);
		this.eventRepo.save(newEvent66);
		Event newEvent67 = new Event("Autem et porro aut eius reprehenderit.");
		Location newLoc67 = new Location("Dignissimos totam totam ad.", "025 Pacocha Plains", "Live Oak Springs", "CA",
				"92123", 32.676646, -117.033129);
		newEvent67.addOwner(User25);
		newEvent67.addParticipant(User25);
		newEvent67.addParticipant(User35);
		newEvent67.addParticipant(User1);
		newEvent67.addParticipant(User6);
		newEvent67.setLocation(newLoc67);
		Occurrence newOccur67_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(80).getMillis()));
		newEvent67.addOccurrence(newOccur67_0);
		Occurrence newOccur67_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(94).getMillis()));
		newEvent67.addOccurrence(newOccur67_1);
		Occurrence newOccur67_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(125).getMillis()));
		newEvent67.addOccurrence(newOccur67_2);
		newEvent67.setDescription(
				"Hic a repellendus maiores labore et. Quia molestias pariatur impedit modi hic sapiente consectetur.");
		newEvent67.setCategory(community);
		this.eventRepo.save(newEvent67);
		Event newEvent68 = new Event("Aliquam harum iste a illum.");
		Location newLoc68 = new Location("Est quis sequi aut.", "232 Arizona Club", "Imperial", "CA", "92121",
				32.665062, -116.945193);
		newEvent68.addOwner(User22);
		newEvent68.addParticipant(User22);
		newEvent68.addParticipant(User36);
		newEvent68.addParticipant(User34);
		newEvent68.addParticipant(User12);
		newEvent68.addParticipant(User0);
		newEvent68.addParticipant(User45);
		newEvent68.addParticipant(User32);
		newEvent68.setLocation(newLoc68);
		Occurrence newOccur68_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(118).getMillis()));
		newEvent68.addOccurrence(newOccur68_0);
		newEvent68.setDescription(
				"Eligendi dignissimos numquam est a vero quos veritatis. Excepturi libero maiores illum repellendus.");
		newEvent68.setCategory(music);
		this.eventRepo.save(newEvent68);
		Event newEvent69 = new Event("Sapiente sint enim expedita quas.");
		Location newLoc69 = new Location("Molestias corrupti laudantium ea beatae.", "15781 Franecki Course Suite 262",
				"Leucadia", "CA", "91911", 32.855195, -117.043171);
		newEvent69.addOwner(User14);
		newEvent69.addParticipant(User14);
		newEvent69.addParticipant(User11);
		newEvent69.addParticipant(User36);
		newEvent69.addParticipant(User33);
		newEvent69.addParticipant(User23);
		newEvent69.addParticipant(User33);
		newEvent69.setLocation(newLoc69);
		Occurrence newOccur69_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(3).getMillis()));
		newEvent69.addOccurrence(newOccur69_0);
		Occurrence newOccur69_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(13).getMillis()));
		newEvent69.addOccurrence(newOccur69_1);
		Occurrence newOccur69_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(48).getMillis()));
		newEvent69.addOccurrence(newOccur69_2);
		newEvent69.setDescription("Repudiandae ad tenetur ab impedit. Nobis facilis officia beatae fugit.");
		newEvent69.setCategory(music);
		this.eventRepo.save(newEvent69);
		Event newEvent70 = new Event("Odit dolores aspernatur deserunt.");
		Location newLoc70 = new Location("Nam ex.", "2065 Germaine Ridges Suite 099", "Ramona", "CA", "92008",
				32.808020, -116.958789);
		newEvent70.addOwner(User18);
		newEvent70.addParticipant(User18);
		newEvent70.addParticipant(User41);
		newEvent70.addParticipant(User28);
		newEvent70.setLocation(newLoc70);
		Occurrence newOccur70_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(140).getMillis()));
		newEvent70.addOccurrence(newOccur70_0);
		Occurrence newOccur70_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(11).getMillis()));
		newEvent70.addOccurrence(newOccur70_1);
		newEvent70.setDescription("Neque veritatis natus vitae laudantium atque. Quam ipsa vitae dolorum mollitia.");
		newEvent70.setCategory(fitness);
		this.eventRepo.save(newEvent70);
		Event newEvent71 = new Event("Deserunt ad impedit sapiente ab.");
		Location newLoc71 = new Location("Ipsa minima fugiat harum.", "28047 Schulist Pines Suite 071", "Valley Center",
				"CA", "92085", 32.601797, -117.152997);
		newEvent71.addOwner(User5);
		newEvent71.addParticipant(User5);
		newEvent71.addParticipant(User48);
		newEvent71.addParticipant(User1);
		newEvent71.addParticipant(User12);
		newEvent71.setLocation(newLoc71);
		Occurrence newOccur71_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(116).getMillis()));
		newEvent71.addOccurrence(newOccur71_0);
		Occurrence newOccur71_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(99).getMillis()));
		newEvent71.addOccurrence(newOccur71_1);
		Occurrence newOccur71_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(12).getMillis()));
		newEvent71.addOccurrence(newOccur71_2);
		Occurrence newOccur71_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(4).getMillis()));
		newEvent71.addOccurrence(newOccur71_3);
		newEvent71.setDescription(
				"Aspernatur reiciendis labore et. Ipsam accusamus officiis deleniti aperiam voluptate.");
		newEvent71.setCategory(hobbies);
		this.eventRepo.save(newEvent71);
		Event newEvent72 = new Event("Voluptatem eaque consequuntur porro ad.");
		Location newLoc72 = new Location("Et eligendi ab.", "58621 Zulauf Cove Apt. 445", "Solana Beach", "CA", "92130",
				32.559402, -117.153330);
		newEvent72.addOwner(User19);
		newEvent72.addParticipant(User19);
		newEvent72.addParticipant(User37);
		newEvent72.addParticipant(User31);
		newEvent72.addParticipant(User40);
		newEvent72.addParticipant(User28);
		newEvent72.addParticipant(User10);
		newEvent72.addParticipant(User32);
		newEvent72.addParticipant(User2);
		newEvent72.setLocation(newLoc72);
		Occurrence newOccur72_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(60).getMillis()));
		newEvent72.addOccurrence(newOccur72_0);
		newEvent72.setDescription(
				"Dolores incidunt sequi fugiat eum corporis. Expedita quibusdam ipsam modi voluptates.");
		newEvent72.setCategory(community);
		this.eventRepo.save(newEvent72);
		Event newEvent73 = new Event("Fuga quia est eos quae laborum.");
		Location newLoc73 = new Location("Corrupti nobis.", "59792 Collins Pike", "Santee", "CA", "92122", 32.544703,
				-116.910023);
		newEvent73.addOwner(User10);
		newEvent73.addParticipant(User10);
		newEvent73.addParticipant(User47);
		newEvent73.addParticipant(User37);
		newEvent73.addParticipant(User2);
		newEvent73.addParticipant(User10);
		newEvent73.addParticipant(User9);
		newEvent73.addParticipant(User0);
		newEvent73.addParticipant(User5);
		newEvent73.addParticipant(User40);
		newEvent73.setLocation(newLoc73);
		Occurrence newOccur73_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(75).getMillis()));
		newEvent73.addOccurrence(newOccur73_0);
		Occurrence newOccur73_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(81).getMillis()));
		newEvent73.addOccurrence(newOccur73_1);
		Occurrence newOccur73_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(16).getMillis()));
		newEvent73.addOccurrence(newOccur73_2);
		newEvent73.setDescription(
				"Labore pariatur at perferendis ipsa temporibus. Nihil quibusdam hic vitae sed provident doloremque.");
		newEvent73.setCategory(tech);
		this.eventRepo.save(newEvent73);
		Event newEvent74 = new Event("Laboriosam at magni magni velit.");
		Location newLoc74 = new Location("Minima qui rerum rem.", "937 Nigel Shoals Suite 926", "Cardiff", "CA",
				"92191", 32.594329, -116.896855);
		newEvent74.addOwner(User11);
		newEvent74.addParticipant(User11);
		newEvent74.addParticipant(User3);
		newEvent74.setLocation(newLoc74);
		Occurrence newOccur74_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(5).getMillis()));
		newEvent74.addOccurrence(newOccur74_0);
		Occurrence newOccur74_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(89).getMillis()));
		newEvent74.addOccurrence(newOccur74_1);
		newEvent74
				.setDescription("Excepturi incidunt dolore laborum. Sed adipisci hic optio aliquam ipsum saepe esse.");
		newEvent74.setCategory(sports);
		this.eventRepo.save(newEvent74);
		Event newEvent75 = new Event("Animi modi dolorem dicta perferendis.");
		Location newLoc75 = new Location("Aspernatur veritatis velit recusandae.", "98529 Lorinda Road Apt. 966",
				"Ramona", "CA", "92115", 32.822446, -116.919910);
		newEvent75.addOwner(User31);
		newEvent75.addParticipant(User31);
		newEvent75.addParticipant(User43);
		newEvent75.addParticipant(User13);
		newEvent75.addParticipant(User11);
		newEvent75.addParticipant(User38);
		newEvent75.addParticipant(User15);
		newEvent75.addParticipant(User18);
		newEvent75.addParticipant(User45);
		newEvent75.setLocation(newLoc75);
		Occurrence newOccur75_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(95).getMillis()));
		newEvent75.addOccurrence(newOccur75_0);
		Occurrence newOccur75_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(59).getMillis()));
		newEvent75.addOccurrence(newOccur75_1);
		Occurrence newOccur75_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(15).getMillis()));
		newEvent75.addOccurrence(newOccur75_2);
		newEvent75.setDescription(
				"Maiores odit harum eius perspiciatis amet. Magni impedit blanditiis facere aspernatur veniam.");
		newEvent75.setCategory(outdoors);
		this.eventRepo.save(newEvent75);
		Event newEvent76 = new Event("Quas laborum sunt mollitia vero a ea.");
		Location newLoc76 = new Location("Animi repudiandae.", "986 Ryan Parkways", "Borrego Springs", "CA", "92140",
				32.822886, -117.175069);
		newEvent76.addOwner(User28);
		newEvent76.addParticipant(User28);
		newEvent76.addParticipant(User37);
		newEvent76.addParticipant(User43);
		newEvent76.addParticipant(User0);
		newEvent76.addParticipant(User11);
		newEvent76.addParticipant(User31);
		newEvent76.addParticipant(User49);
		newEvent76.setLocation(newLoc76);
		Occurrence newOccur76_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(77).getMillis()));
		newEvent76.addOccurrence(newOccur76_0);
		Occurrence newOccur76_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(100).getMillis()));
		newEvent76.addOccurrence(newOccur76_1);
		Occurrence newOccur76_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(119).getMillis()));
		newEvent76.addOccurrence(newOccur76_2);
		newEvent76.setDescription("Possimus sapiente ex minima fugiat pariatur commodi. Molestiae corrupti ab nobis.");
		newEvent76.setCategory(community);
		this.eventRepo.save(newEvent76);
		Event newEvent77 = new Event("Sequi perferendis rerum sint mollitia.");
		Location newLoc77 = new Location("Itaque ullam nesciunt.", "903 Kuphal Islands", "Solana Beach", "CA", "92029",
				32.895902, -116.871958);
		newEvent77.addOwner(User45);
		newEvent77.addParticipant(User45);
		newEvent77.addParticipant(User42);
		newEvent77.addParticipant(User19);
		newEvent77.addParticipant(User2);
		newEvent77.addParticipant(User10);
		newEvent77.addParticipant(User10);
		newEvent77.addParticipant(User19);
		newEvent77.setLocation(newLoc77);
		Occurrence newOccur77_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(73).getMillis()));
		newEvent77.addOccurrence(newOccur77_0);
		Occurrence newOccur77_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(112).getMillis()));
		newEvent77.addOccurrence(newOccur77_1);
		Occurrence newOccur77_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(69).getMillis()));
		newEvent77.addOccurrence(newOccur77_2);
		Occurrence newOccur77_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(79).getMillis()));
		newEvent77.addOccurrence(newOccur77_3);
		newEvent77.setDescription("Voluptatem beatae minus ex sapiente rerum. Nisi dolores quisquam possimus sequi.");
		newEvent77.setCategory(movies);
		this.eventRepo.save(newEvent77);
		Event newEvent78 = new Event("Optio neque iusto commodi temporibus.");
		Location newLoc78 = new Location("Rem praesentium fuga.", "558 Rudy Centers Apt. 400", "Carlsbad", "CA",
				"92171", 32.802656, -116.944117);
		newEvent78.addOwner(User7);
		newEvent78.addParticipant(User7);
		newEvent78.addParticipant(User43);
		newEvent78.addParticipant(User19);
		newEvent78.addParticipant(User34);
		newEvent78.addParticipant(User49);
		newEvent78.addParticipant(User40);
		newEvent78.addParticipant(User40);
		newEvent78.addParticipant(User29);
		newEvent78.setLocation(newLoc78);
		Occurrence newOccur78_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(70).getMillis()));
		newEvent78.addOccurrence(newOccur78_0);
		Occurrence newOccur78_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(2).getMillis()));
		newEvent78.addOccurrence(newOccur78_1);
		newEvent78.setDescription("Voluptatibus hic dolor non possimus. Eveniet fugiat culpa atque doloremque.");
		newEvent78.setCategory(games);
		this.eventRepo.save(newEvent78);
		Event newEvent79 = new Event("Illo iusto illo expedita.");
		Location newLoc79 = new Location("Sequi ducimus minus similique.", "6016 Hayes Streets Suite 051",
				"San Clemente Island", "CA", "92124", 32.515391, -116.895848);
		newEvent79.addOwner(User21);
		newEvent79.addParticipant(User21);
		newEvent79.addParticipant(User24);
		newEvent79.addParticipant(User14);
		newEvent79.addParticipant(User49);
		newEvent79.addParticipant(User40);
		newEvent79.setLocation(newLoc79);
		Occurrence newOccur79_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(131).getMillis()));
		newEvent79.addOccurrence(newOccur79_0);
		Occurrence newOccur79_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(19).getMillis()));
		newEvent79.addOccurrence(newOccur79_1);
		newEvent79.setDescription("Sunt vero modi quia ipsum ad commodi autem unde. Cum est doloremque reprehenderit.");
		newEvent79.setCategory(movies);
		this.eventRepo.save(newEvent79);
		Event newEvent80 = new Event("Vel accusantium iure deserunt.");
		Location newLoc80 = new Location("Ipsum harum illo laboriosam.", "2641 Beatty Harbors Suite 904", "Jamul", "CA",
				"91977", 32.502558, -116.913759);
		newEvent80.addOwner(User32);
		newEvent80.addParticipant(User32);
		newEvent80.addParticipant(User48);
		newEvent80.addParticipant(User32);
		newEvent80.addParticipant(User23);
		newEvent80.addParticipant(User38);
		newEvent80.addParticipant(User35);
		newEvent80.addParticipant(User25);
		newEvent80.addParticipant(User28);
		newEvent80.addParticipant(User18);
		newEvent80.setLocation(newLoc80);
		Occurrence newOccur80_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(42).getMillis()));
		newEvent80.addOccurrence(newOccur80_0);
		Occurrence newOccur80_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(55).getMillis()));
		newEvent80.addOccurrence(newOccur80_1);
		Occurrence newOccur80_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(34).getMillis()));
		newEvent80.addOccurrence(newOccur80_2);
		newEvent80.setDescription(
				"Optio quaerat quos aliquam. Blanditiis aut iure qui. Deleniti deserunt nobis architecto illo iure.");
		newEvent80.setCategory(fitness);
		this.eventRepo.save(newEvent80);
		Event newEvent81 = new Event("Illum a ut non error non.");
		Location newLoc81 = new Location("Totam corrupti numquam neque.", "188 Turner Trace Apt. 851", "Imperial", "CA",
				"92011", 32.585919, -117.181091);
		newEvent81.addOwner(User25);
		newEvent81.addParticipant(User25);
		newEvent81.addParticipant(User23);
		newEvent81.addParticipant(User42);
		newEvent81.addParticipant(User2);
		newEvent81.setLocation(newLoc81);
		Occurrence newOccur81_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(39).getMillis()));
		newEvent81.addOccurrence(newOccur81_0);
		Occurrence newOccur81_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(107).getMillis()));
		newEvent81.addOccurrence(newOccur81_1);
		newEvent81.setDescription(
				"Possimus fugiat nisi in occaecati praesentium. Aliquam impedit architecto repudiandae alias.");
		newEvent81.setCategory(education);
		this.eventRepo.save(newEvent81);
		Event newEvent82 = new Event("Dignissimos impedit ipsa tenetur totam.");
		Location newLoc82 = new Location("Ad minus beatae quo.", "113 Deon Roads Apt. 966", "Campo", "CA", "92139",
				32.677844, -117.163369);
		newEvent82.addOwner(User4);
		newEvent82.addParticipant(User4);
		newEvent82.addParticipant(User23);
		newEvent82.addParticipant(User14);
		newEvent82.addParticipant(User27);
		newEvent82.setLocation(newLoc82);
		Occurrence newOccur82_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(75).getMillis()));
		newEvent82.addOccurrence(newOccur82_0);
		newEvent82.setDescription(
				"Voluptatem officiis illo odio. Ratione dolor libero dolorum aspernatur est eligendi optio nostrum.");
		newEvent82.setCategory(games);
		this.eventRepo.save(newEvent82);
		Event newEvent83 = new Event("Amet quisquam sapiente vitae.");
		Location newLoc83 = new Location("Voluptatum odit autem.", "1129 Sawayn Squares Suite 771", "Chula Vista", "CA",
				"92007", 32.808441, -116.877815);
		newEvent83.addOwner(User39);
		newEvent83.addParticipant(User39);
		newEvent83.addParticipant(User42);
		newEvent83.addParticipant(User34);
		newEvent83.addParticipant(User10);
		newEvent83.addParticipant(User38);
		newEvent83.addParticipant(User14);
		newEvent83.setLocation(newLoc83);
		Occurrence newOccur83_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(121).getMillis()));
		newEvent83.addOccurrence(newOccur83_0);
		Occurrence newOccur83_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(55).getMillis()));
		newEvent83.addOccurrence(newOccur83_1);
		Occurrence newOccur83_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(2).getMillis()));
		newEvent83.addOccurrence(newOccur83_2);
		Occurrence newOccur83_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(132).getMillis()));
		newEvent83.addOccurrence(newOccur83_3);
		newEvent83.setDescription(
				"Mollitia sunt optio beatae eveniet quia suscipit eos sunt. Vero harum aperiam sed non quis nihil.");
		newEvent83.setCategory(tech);
		this.eventRepo.save(newEvent83);
		Event newEvent84 = new Event("Fugit deserunt quod alias.");
		Location newLoc84 = new Location("Voluptatem nam minima asperiores.", "8911 Runolfsdottir Corner", "Alpine",
				"CA", "92195", 32.779156, -117.122968);
		newEvent84.addOwner(User9);
		newEvent84.addParticipant(User9);
		newEvent84.addParticipant(User39);
		newEvent84.addParticipant(User27);
		newEvent84.addParticipant(User25);
		newEvent84.addParticipant(User10);
		newEvent84.addParticipant(User32);
		newEvent84.addParticipant(User11);
		newEvent84.addParticipant(User11);
		newEvent84.addParticipant(User47);
		newEvent84.setLocation(newLoc84);
		Occurrence newOccur84_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(125).getMillis()));
		newEvent84.addOccurrence(newOccur84_0);
		Occurrence newOccur84_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(36).getMillis()));
		newEvent84.addOccurrence(newOccur84_1);
		Occurrence newOccur84_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(38).getMillis()));
		newEvent84.addOccurrence(newOccur84_2);
		Occurrence newOccur84_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(33).getMillis()));
		newEvent84.addOccurrence(newOccur84_3);
		newEvent84.setDescription("Amet sed ratione quae optio. Corrupti pariatur ullam commodi reprehenderit.");
		newEvent84.setCategory(tech);
		this.eventRepo.save(newEvent84);
		Event newEvent85 = new Event("Perferendis nulla quo veniam odio.");
		Location newLoc85 = new Location("Sequi autem magni impedit.", "23629 Carrol Key", "Carlsbad", "CA", "92149",
				32.903728, -117.249191);
		newEvent85.addOwner(User12);
		newEvent85.addParticipant(User12);
		newEvent85.addParticipant(User15);
		newEvent85.addParticipant(User26);
		newEvent85.addParticipant(User41);
		newEvent85.addParticipant(User21);
		newEvent85.setLocation(newLoc85);
		Occurrence newOccur85_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(44).getMillis()));
		newEvent85.addOccurrence(newOccur85_0);
		Occurrence newOccur85_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(105).getMillis()));
		newEvent85.addOccurrence(newOccur85_1);
		Occurrence newOccur85_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(59).getMillis()));
		newEvent85.addOccurrence(newOccur85_2);
		newEvent85.setDescription("Vel vel et vel nam eveniet vero. Ex debitis sed a dicta cumque eos commodi.");
		newEvent85.setCategory(education);
		this.eventRepo.save(newEvent85);
		Event newEvent86 = new Event("Porro deleniti laboriosam eum eligendi.");
		Location newLoc86 = new Location("At cum quae aliquam.", "354 Marilla Spur Suite 477", "Hillcrest", "CA",
				"92102", 32.756315, -117.086894);
		newEvent86.addOwner(User29);
		newEvent86.addParticipant(User29);
		newEvent86.addParticipant(User8);
		newEvent86.setLocation(newLoc86);
		Occurrence newOccur86_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(21).getMillis()));
		newEvent86.addOccurrence(newOccur86_0);
		Occurrence newOccur86_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(76).getMillis()));
		newEvent86.addOccurrence(newOccur86_1);
		Occurrence newOccur86_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(6).getMillis()));
		newEvent86.addOccurrence(newOccur86_2);
		newEvent86.setDescription(
				"Et repudiandae cupiditate facere excepturi autem deleniti. Culpa quod iste quis illum.");
		newEvent86.setCategory(hobbies);
		this.eventRepo.save(newEvent86);
		Event newEvent87 = new Event("Optio sunt eum ut modi.");
		Location newLoc87 = new Location("Voluptate iste repellat distinctio explicabo.",
				"1973 Damien Fields Suite 571", "Solana Beach", "CA", "92104", 32.679543, -117.165706);
		newEvent87.addOwner(User20);
		newEvent87.addParticipant(User20);
		newEvent87.addParticipant(User38);
		newEvent87.addParticipant(User8);
		newEvent87.setLocation(newLoc87);
		Occurrence newOccur87_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(34).getMillis()));
		newEvent87.addOccurrence(newOccur87_0);
		newEvent87.setDescription("Quo occaecati perspiciatis magni. Reprehenderit eaque enim praesentium sit vel.");
		newEvent87.setCategory(outdoors);
		this.eventRepo.save(newEvent87);
		Event newEvent88 = new Event("Modi provident aliquam autem dolore.");
		Location newLoc88 = new Location("Nesciunt illo dolorum cum.", "742 Demarco Square Apt. 866", "Mission Bay",
				"CA", "91950", 32.614415, -116.880221);
		newEvent88.addOwner(User38);
		newEvent88.addParticipant(User38);
		newEvent88.addParticipant(User11);
		newEvent88.addParticipant(User34);
		newEvent88.addParticipant(User9);
		newEvent88.setLocation(newLoc88);
		Occurrence newOccur88_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(55).getMillis()));
		newEvent88.addOccurrence(newOccur88_0);
		Occurrence newOccur88_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(126).getMillis()));
		newEvent88.addOccurrence(newOccur88_1);
		newEvent88.setDescription(
				"Est inventore commodi sequi placeat ipsam. Facilis nobis qui ut debitis quisquam officiis.");
		newEvent88.setCategory(arts);
		this.eventRepo.save(newEvent88);
		Event newEvent89 = new Event("Culpa aliquam quod adipisci ex.");
		Location newLoc89 = new Location("Delectus aspernatur debitis ex.", "342 Frances Courts Suite 053", "Ramona",
				"CA", "92110", 32.852064, -117.183065);
		newEvent89.addOwner(User5);
		newEvent89.addParticipant(User5);
		newEvent89.addParticipant(User23);
		newEvent89.addParticipant(User21);
		newEvent89.addParticipant(User2);
		newEvent89.addParticipant(User0);
		newEvent89.addParticipant(User31);
		newEvent89.addParticipant(User7);
		newEvent89.addParticipant(User22);
		newEvent89.addParticipant(User23);
		newEvent89.setLocation(newLoc89);
		Occurrence newOccur89_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(114).getMillis()));
		newEvent89.addOccurrence(newOccur89_0);
		Occurrence newOccur89_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(90).getMillis()));
		newEvent89.addOccurrence(newOccur89_1);
		newEvent89.setDescription("Et eos consectetur in. Est magnam hic neque rem.");
		newEvent89.setCategory(music);
		this.eventRepo.save(newEvent89);
		Event newEvent90 = new Event("Soluta cum odio perferendis eligendi.");
		Location newLoc90 = new Location("Et fuga assumenda cum corrupti.", "425 Joretta Crescent", "Valley Center",
				"CA", "92024", 32.813843, -116.996927);
		newEvent90.addOwner(User33);
		newEvent90.addParticipant(User33);
		newEvent90.addParticipant(User6);
		newEvent90.addParticipant(User5);
		newEvent90.addParticipant(User46);
		newEvent90.addParticipant(User25);
		newEvent90.addParticipant(User38);
		newEvent90.addParticipant(User32);
		newEvent90.setLocation(newLoc90);
		Occurrence newOccur90_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(82).getMillis()));
		newEvent90.addOccurrence(newOccur90_0);
		newEvent90.setDescription(
				"Iusto temporibus inventore corrupti sapiente quas doloremque. Aspernatur inventore dolore eum enim.");
		newEvent90.setCategory(fitness);
		this.eventRepo.save(newEvent90);
		Event newEvent91 = new Event("Ratione ad repellat tempore quasi sed.");
		Location newLoc91 = new Location("Tempore ut earum.", "299 Duane Locks", "Campo", "CA", "92172", 32.563490,
				-117.180825);
		newEvent91.addOwner(User34);
		newEvent91.addParticipant(User34);
		newEvent91.addParticipant(User39);
		newEvent91.setLocation(newLoc91);
		Occurrence newOccur91_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(100).getMillis()));
		newEvent91.addOccurrence(newOccur91_0);
		newEvent91.setDescription(
				"Ducimus necessitatibus eius laudantium at dolores facere. Odit odit perferendis omnis eum.");
		newEvent91.setCategory(food);
		this.eventRepo.save(newEvent91);
		Event newEvent92 = new Event("Nam alias atque omnis magnam libero.");
		Location newLoc92 = new Location("Assumenda tenetur illum.", "42544 Medhurst Valley", "Solana Beach", "CA",
				"92145", 32.832936, -116.968706);
		newEvent92.addOwner(User49);
		newEvent92.addParticipant(User49);
		newEvent92.addParticipant(User43);
		newEvent92.addParticipant(User34);
		newEvent92.addParticipant(User29);
		newEvent92.addParticipant(User41);
		newEvent92.addParticipant(User19);
		newEvent92.addParticipant(User35);
		newEvent92.setLocation(newLoc92);
		Occurrence newOccur92_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(123).getMillis()));
		newEvent92.addOccurrence(newOccur92_0);
		newEvent92.setDescription("Libero accusamus ipsam atque vel ea. Non nulla non tempora nemo maxime nisi non.");
		newEvent92.setCategory(education);
		this.eventRepo.save(newEvent92);
		Event newEvent93 = new Event("Placeat quos odit quo vel.");
		Location newLoc93 = new Location("Repellat sint laborum.", "494 Carrol Estate", "Borrega Springs", "CA",
				"92187", 32.671640, -116.899198);
		newEvent93.addOwner(User27);
		newEvent93.addParticipant(User27);
		newEvent93.addParticipant(User16);
		newEvent93.addParticipant(User16);
		newEvent93.setLocation(newLoc93);
		Occurrence newOccur93_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(24).getMillis()));
		newEvent93.addOccurrence(newOccur93_0);
		Occurrence newOccur93_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(148).getMillis()));
		newEvent93.addOccurrence(newOccur93_1);
		Occurrence newOccur93_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(73).getMillis()));
		newEvent93.addOccurrence(newOccur93_2);
		newEvent93.setDescription(
				"Molestias quaerat dolorum nulla. Eaque delectus reprehenderit temporibus inventore debitis iusto.");
		newEvent93.setCategory(education);
		this.eventRepo.save(newEvent93);
		Event newEvent94 = new Event("Nisi harum minus eum.");
		Location newLoc94 = new Location("Enim suscipit vel culpa.", "8144 Campbell Cape", "Coronado", "CA", "92166",
				32.776046, -117.030103);
		newEvent94.addOwner(User38);
		newEvent94.addParticipant(User38);
		newEvent94.addParticipant(User1);
		newEvent94.addParticipant(User44);
		newEvent94.addParticipant(User11);
		newEvent94.addParticipant(User38);
		newEvent94.addParticipant(User32);
		newEvent94.addParticipant(User15);
		newEvent94.setLocation(newLoc94);
		Occurrence newOccur94_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(126).getMillis()));
		newEvent94.addOccurrence(newOccur94_0);
		Occurrence newOccur94_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(94).getMillis()));
		newEvent94.addOccurrence(newOccur94_1);
		Occurrence newOccur94_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(113).getMillis()));
		newEvent94.addOccurrence(newOccur94_2);
		Occurrence newOccur94_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(28).getMillis()));
		newEvent94.addOccurrence(newOccur94_3);
		newEvent94.setDescription("Necessitatibus et rem quos cupiditate fugiat. Hic sit sapiente quas quae dolor.");
		newEvent94.setCategory(education);
		this.eventRepo.save(newEvent94);
		Event newEvent95 = new Event("Facere officiis quis nemo ipsa ut.");
		Location newLoc95 = new Location("At facere ipsam veritatis cum.", "261 Reynolds Cliff", "Cardiff-by-the-Sea",
				"CA", "92046", 32.541679, -117.129748);
		newEvent95.addOwner(User24);
		newEvent95.addParticipant(User24);
		newEvent95.addParticipant(User15);
		newEvent95.addParticipant(User30);
		newEvent95.addParticipant(User35);
		newEvent95.addParticipant(User17);
		newEvent95.setLocation(newLoc95);
		Occurrence newOccur95_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(105).getMillis()));
		newEvent95.addOccurrence(newOccur95_0);
		newEvent95.setDescription(
				"Totam quo optio quibusdam cum quam omnis. Sunt omnis mollitia quia. At cupiditate ex officia velit.");
		newEvent95.setCategory(book);
		this.eventRepo.save(newEvent95);
		Event newEvent96 = new Event("Occaecati ipsam suscipit repellat est.");
		Location newLoc96 = new Location("Earum necessitatibus quo.", "859 Koepp Coves", "Borrega Springs", "CA",
				"92025", 32.515462, -117.092941);
		newEvent96.addOwner(User10);
		newEvent96.addParticipant(User10);
		newEvent96.addParticipant(User38);
		newEvent96.addParticipant(User17);
		newEvent96.addParticipant(User0);
		newEvent96.addParticipant(User13);
		newEvent96.addParticipant(User15);
		newEvent96.addParticipant(User21);
		newEvent96.addParticipant(User4);
		newEvent96.addParticipant(User42);
		newEvent96.addParticipant(User45);
		newEvent96.setLocation(newLoc96);
		Occurrence newOccur96_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(16).getMillis()));
		newEvent96.addOccurrence(newOccur96_0);
		Occurrence newOccur96_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(116).getMillis()));
		newEvent96.addOccurrence(newOccur96_1);
		Occurrence newOccur96_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(148).getMillis()));
		newEvent96.addOccurrence(newOccur96_2);
		Occurrence newOccur96_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(4).getMillis()));
		newEvent96.addOccurrence(newOccur96_3);
		newEvent96.setDescription(
				"Dolores non itaque aliquam distinctio. Debitis inventore laborum commodi aut vel dignissimos.");
		newEvent96.setCategory(hobbies);
		this.eventRepo.save(newEvent96);
		Event newEvent97 = new Event("Eum est dolore assumenda.");
		Location newLoc97 = new Location("Animi error mollitia necessitatibus.", "028 Aubrey Dale Suite 415",
				"Pacific Beach", "CA", "92022", 32.4, -104.2);
		newEvent97.addOwner(User39);
		newEvent97.addParticipant(User39);
		newEvent97.addParticipant(User0);
		newEvent97.addParticipant(User19);
		newEvent97.addParticipant(User19);
		newEvent97.addParticipant(User46);
		newEvent97.addParticipant(User45);
		newEvent97.addParticipant(User47);
		newEvent97.addParticipant(User47);
		newEvent97.addParticipant(User15);
		newEvent97.addParticipant(User20);
		newEvent97.setLocation(newLoc97);
		Occurrence newOccur97_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(113).getMillis()));
		newEvent97.addOccurrence(newOccur97_0);
		Occurrence newOccur97_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(19).getMillis()));
		newEvent97.addOccurrence(newOccur97_1);
		newEvent97.setDescription(
				"Consequuntur iure deleniti debitis recusandae quod aliquid voluptas. Natus nulla accusamus in.");
		newEvent97.setCategory(tech);
		this.eventRepo.save(newEvent97);
		Event newEvent98 = new Event("Natus non quaerat debitis consequatur.");
		Location newLoc98 = new Location("Modi quod nemo tenetur.", "2675 Lenord Summit", "Bonita", "CA", "92066",
				32.42, -104.22);
		newEvent98.addOwner(User45);
		newEvent98.addParticipant(User45);
		newEvent98.addParticipant(User1);
		newEvent98.addParticipant(User45);
		newEvent98.addParticipant(User11);
		newEvent98.addParticipant(User30);
		newEvent98.addParticipant(User10);
		newEvent98.addParticipant(User5);
		newEvent98.addParticipant(User38);
		newEvent98.addParticipant(User10);
		newEvent98.addParticipant(User33);
		newEvent98.setLocation(newLoc98);
		Occurrence newOccur98_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(21).getMillis()));
		newEvent98.addOccurrence(newOccur98_0);
		Occurrence newOccur98_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(78).getMillis()));
		newEvent98.addOccurrence(newOccur98_1);
		newEvent98.setDescription("Magni optio ea incidunt. Mollitia eligendi esse explicabo repudiandae accusantium.");
		newEvent98.setCategory(tech);
		this.eventRepo.save(newEvent98);
		Event newEvent99 = new Event("Cumque omnis ipsum officia deserunt.");
		Location newLoc99 = new Location("Praesentium ipsam occaecati.", "008 Elle Branch", "El Cajon", "CA", "91944",
				32.420, -104.228);
		newEvent99.addOwner(User26);
		newEvent99.addParticipant(User26);
		newEvent99.addParticipant(User8);
		newEvent99.addParticipant(User27);
		newEvent99.addParticipant(User37);
		newEvent99.addParticipant(User17);
		newEvent99.addParticipant(User9);
		newEvent99.setLocation(newLoc99);
		Occurrence newOccur99_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(5).getMillis()));
		newEvent99.addOccurrence(newOccur99_0);
		Occurrence newOccur99_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(96).getMillis()));
		newEvent99.addOccurrence(newOccur99_1);
		Occurrence newOccur99_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(102).getMillis()));
		newEvent99.addOccurrence(newOccur99_2);
		newEvent99.setDescription("Quia vero harum exercitationem. Dolor repellat iste molestiae quidem.");
		newEvent99.setCategory(movies);
		this.eventRepo.save(newEvent99);
		Event newEvent100 = new Event("Ad ex ratione eum velit.");
		Location newLoc100 = new Location("Deserunt reprehenderit quia incidunt occaecati.",
				"0105 Nella Place Suite 993", "Campo", "CA", "92052", 32.4206, -104.2288);
		newEvent100.addOwner(User1);
		newEvent100.addParticipant(User1);
		newEvent100.addParticipant(User45);
		newEvent100.addParticipant(User46);
		newEvent100.addParticipant(User26);
		newEvent100.addParticipant(User41);
		newEvent100.addParticipant(User14);
		newEvent100.setLocation(newLoc100);
		Occurrence newOccur100_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(92).getMillis()));
		newEvent100.addOccurrence(newOccur100_0);
		Occurrence newOccur100_1 = new Occurrence("Competition",
				new Timestamp(DateTime.now().plusDays(134).getMillis()));
		newEvent100.addOccurrence(newOccur100_1);
		Occurrence newOccur100_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(109).getMillis()));
		newEvent100.addOccurrence(newOccur100_2);
		newEvent100.setDescription(
				"Eius natus numquam id repudiandae quibusdam quibusdam. Optio quibusdam eos tenetur eveniet minus.");
		newEvent100.setCategory(arts);
		this.eventRepo.save(newEvent100);

	}
}