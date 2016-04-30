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
		Registrant aUser = new Registrant("testuser@email.com", "password", "testDisplayName", 3, 10000);
		Registrant registrantResult = this.registrantRepo.save(aUser);

		Event testEvent = new Event("Test Event");
		Location location = new Location("Test Location", "6542 Nowhere Blvd", "Los Angeles", "CA", "90005", 34.0498,
				-118.2498);
		testEvent.setLocation(location);
		Occurrence occur = new Occurrence("Test Occurrence", new Timestamp(DateTime.now().getMillis()));
		Category testCategory = new Category("testCategory");
		this.categoryRepo.save(testCategory);
		testEvent.addOccurrence(occur);
		testEvent.setCategory(testCategory);
		Event eventResult = this.eventRepo.save(testEvent);

		// Right now, Event owns all relationships, so Event must be saved for
		// data to be put in DB.
		testEvent.addParticipant(aUser);
		// It is recommended you also add the Event to the Registrant, so that
		// the in memory state of the objects is consistent with the DB
		// We can make either function do the opposite add if we wish, to
		// simplify usage elsewhere
		aUser.joinEvent(testEvent);
		this.eventRepo.save(testEvent);

		Event newEvent = new Event("Test1");
		Location newLoc = new Location("Test Location", "6000 Yeswhere Blvd", "Los Angeles", "CA", "90007", 32.770,
				-117.04);
		newEvent.addOwner(aUser);
		newEvent.addParticipant(aUser);
		newEvent.setLocation(newLoc);
		Occurrence newOccur = new Occurrence("First", new Timestamp(DateTime.now().plusDays(1).getMillis()));
		newEvent.addOccurrence(newOccur);
		newEvent.setDescription("lets play soccer!");
		Category soccer = new Category("Soccer");
		this.categoryRepo.save(soccer);
		newEvent.setCategory(soccer);
		this.eventRepo.save(newEvent);

		Event newEventa = new Event("Test2");
		Location newLoca = new Location("Test Location", "6542 Nowhere Blvd", "Los Angeles", "CA", "90005", 32.780,
				-117.03);
		newEvent.addOwner(aUser);
		newEventa.setLocation(newLoca);
		Occurrence newOccura = new Occurrence("Second", new Timestamp(DateTime.now().plusDays(2).getMillis()));
		newEventa.addOccurrence(newOccura);
		Occurrence newOccurb = new Occurrence("Second2", new Timestamp(DateTime.now().plusDays(5).getMillis()));
		newEventa.addOccurrence(newOccurb);
		newEventa.setDescription("lets swim!");
		Category swim = new Category("Swim");
		this.categoryRepo.save(swim);
		newEventa.setCategory(swim);

		Registrant User0 = new Registrant("nweissnat@emmerich.com", "password", "vgusikowski", 17, 92102);
		this.registrantRepo.save(User0);
		Registrant User1 = new Registrant("laverne84@hotmail.com", "password", "idatromp", 22, 92108);
		this.registrantRepo.save(User1);
		Registrant User2 = new Registrant("kutchathena@beier-mitchell.com", "password", "luciogoyette", 6, 92013);
		this.registrantRepo.save(User2);
		Registrant User3 = new Registrant("ellianahilll@ruecker-mayert.com", "password", "qdonnelly", 16, 92164);
		this.registrantRepo.save(User3);
		Registrant User4 = new Registrant("zturner@gmail.com", "password", "osborn69", 21, 92176);
		this.registrantRepo.save(User4);
		Registrant User5 = new Registrant("paucekchad@hand.com", "password", "staffordwelch", 13, 92137);
		this.registrantRepo.save(User5);
		Registrant User6 = new Registrant("utorp@hotmail.com", "password", "wunschruel", 5, 92153);
		this.registrantRepo.save(User6);
		Registrant User7 = new Registrant("vernhamill@marquardt.com", "password", "adelia56", 11, 92065);
		this.registrantRepo.save(User7);
		Registrant User8 = new Registrant("stephancarter@gmail.com", "password", "lmcglynn", 13, 91950);
		this.registrantRepo.save(User8);
		Registrant User9 = new Registrant("beecher87@yahoo.com", "password", "katie22", 2, 92013);
		this.registrantRepo.save(User9);
		Registrant User10 = new Registrant("clueilwitz@hotmail.com", "password", "feiltrae", 17, 92069);
		this.registrantRepo.save(User10);
		Registrant User11 = new Registrant("vhaley@boyle.info", "password", "bfunk", 17, 92196);
		this.registrantRepo.save(User11);
		Registrant User12 = new Registrant("nicklaus61@howe.biz", "password", "jaxkohler", 17, 92108);
		this.registrantRepo.save(User12);
		Registrant User13 = new Registrant("garrisonmraz@schneider.com", "password", "qcummerata", 2, 92114);
		this.registrantRepo.save(User13);
		Registrant User14 = new Registrant("kbatz@yahoo.com", "password", "langworthspencer", 7, 92088);
		this.registrantRepo.save(User14);
		Registrant User15 = new Registrant("asipes@cormier.info", "password", "brinleypollich", 18, 92127);
		this.registrantRepo.save(User15);
		Registrant User16 = new Registrant("wymanbechtelar@yahoo.com", "password", "eulabarton", 7, 92128);
		this.registrantRepo.save(User16);
		Registrant User17 = new Registrant("almiracorwin@hotmail.com", "password", "leeroywisozk", 17, 92175);
		this.registrantRepo.save(User17);
		Registrant User18 = new Registrant("mlakin@spencer-howell.com", "password", "daniellyric", 21, 91901);
		this.registrantRepo.save(User18);
		Registrant User19 = new Registrant("trena64@gmail.com", "password", "botsfordalexandr", 13, 92134);
		this.registrantRepo.save(User19);
		Registrant User20 = new Registrant("inicolas@strosin-hills.info", "password", "metzansley", 9, 92007);
		this.registrantRepo.save(User20);
		Registrant User21 = new Registrant("kosskatarina@yahoo.com", "password", "lynseyaufderhar", 9, 92039);
		this.registrantRepo.save(User21);
		Registrant User22 = new Registrant("carmelita93@yahoo.com", "password", "starr10", 7, 92182);
		this.registrantRepo.save(User22);
		Registrant User23 = new Registrant("muellerlillard@hyatt-schaefer.com", "password", "kwisozk", 6, 91980);
		this.registrantRepo.save(User23);
		Registrant User24 = new Registrant("pfannerstillmallie@konopelski-ziemann.org", "password", "jay30", 13, 92116);
		this.registrantRepo.save(User24);
		Registrant User25 = new Registrant("yaretzifarrell@hotmail.com", "password", "twisoky", 9, 92019);
		this.registrantRepo.save(User25);
		Registrant User26 = new Registrant("ethiestanton@friesen.com", "password", "wolfraymond", 21, 92123);
		this.registrantRepo.save(User26);
		Registrant User27 = new Registrant("greenemett@shanahan.info", "password", "jermeygulgowski", 19, 92140);
		this.registrantRepo.save(User27);
		Registrant User28 = new Registrant("ullrichhence@hotmail.com", "password", "zanderson", 17, 91946);
		this.registrantRepo.save(User28);
		Registrant User29 = new Registrant("farah45@gulgowski-runolfsdottir.org", "password", "roccocremin", 1, 92085);
		this.registrantRepo.save(User29);
		Registrant User30 = new Registrant("hermistonhurbert@hayes-heller.com", "password", "stoltenbergaleen", 11,
				92190);
		this.registrantRepo.save(User30);
		Registrant User31 = new Registrant("brennanratke@gmail.com", "password", "sheritakuphal", 21, 92010);
		this.registrantRepo.save(User31);
		Registrant User32 = new Registrant("bridgermiller@wehner.com", "password", "hrodriguez", 10, 92199);
		this.registrantRepo.save(User32);
		Registrant User33 = new Registrant("edouglas@hand-hintz.net", "password", "georgiana46", 3, 91933);
		this.registrantRepo.save(User33);
		Registrant User34 = new Registrant("cathleen48@yahoo.com", "password", "mschowalter", 2, 92010);
		this.registrantRepo.save(User34);
		Registrant User35 = new Registrant("astroman@williamson-borer.com", "password", "cnader", 23, 91903);
		this.registrantRepo.save(User35);
		Registrant User36 = new Registrant("hamilljethro@hotmail.com", "password", "shirliestrosin", 13, 92163);
		this.registrantRepo.save(User36);
		Registrant User37 = new Registrant("dhalvorson@hotmail.com", "password", "gulgowskitheadore", 23, 92010);
		this.registrantRepo.save(User37);
		Registrant User38 = new Registrant("hellerkimball@hahn.net", "password", "loveyheaney", 2, 92105);
		this.registrantRepo.save(User38);
		Registrant User39 = new Registrant("torn@grimes.biz", "password", "jeseniaschuppe", 3, 92142);
		this.registrantRepo.save(User39);
		Registrant User40 = new Registrant("brennenbrakus@strosin.biz", "password", "strosinqueen", 10, 91909);
		this.registrantRepo.save(User40);
		Registrant User41 = new Registrant("powlowskiwillodean@gleason.info", "password", "rosco73", 9, 92165);
		this.registrantRepo.save(User41);
		Registrant User42 = new Registrant("krismaxim@yahoo.com", "password", "hazle26", 3, 92070);
		this.registrantRepo.save(User42);
		Registrant User43 = new Registrant("jewellbaumbach@huel-funk.org", "password", "farmstrong", 3, 92025);
		this.registrantRepo.save(User43);
		Registrant User44 = new Registrant("hayeschristi@wilderman.com", "password", "zchristiansen", 10, 92033);
		this.registrantRepo.save(User44);
		Registrant User45 = new Registrant("gearldine69@kutch-morissette.com", "password", "townewillian", 6, 92126);
		this.registrantRepo.save(User45);
		Registrant User46 = new Registrant("bednarconrad@vonrueden.org", "password", "carolannhegmann", 7, 92021);
		this.registrantRepo.save(User46);
		Registrant User47 = new Registrant("charley28@heathcote-leffler.org", "password", "katlin75", 15, 92033);
		this.registrantRepo.save(User47);
		Registrant User48 = new Registrant("icaschinner@price.com", "password", "ibatz", 8, 92136);
		this.registrantRepo.save(User48);
		Registrant User49 = new Registrant("lucretia52@osinski-hirthe.com", "password", "adela14", 18, 92060);
		this.registrantRepo.save(User49);

		Event newEvent0 = new Event("Eos esse delectus error voluptatibus.");
		Location newLoc0 = new Location("Laboriosam totam pariatur rerum eum.", "927 Robin Island Apt. 228",
				"Point Loma", "CA", "91963", 32.727953, -116.953746);
		newEvent0.addOwner(User48);
		newEvent0.setLocation(newLoc0);
		Occurrence newOccur0_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(65).getMillis()));
		newEvent0.addOccurrence(newOccur0_0);
		Occurrence newOccur0_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(34).getMillis()));
		newEvent0.addOccurrence(newOccur0_1);
		Occurrence newOccur0_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(70).getMillis()));
		newEvent0.addOccurrence(newOccur0_2);
		Occurrence newOccur0_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(93).getMillis()));
		newEvent0.addOccurrence(newOccur0_3);
		newEvent0.setDescription(
				"Rem voluptatem amet quisquam ab. Dolore ex provident culpa modi. Quidem voluptatibus odio omnis.");
		newEvent0.setCategory(soccer);
		this.eventRepo.save(newEvent0);
		Event newEvent1 = new Event("Tempora asperiores neque numquam.");
		Location newLoc1 = new Location("Id nihil accusamus.", "96892 Reilly Brooks Apt. 510", "Ramona", "CA", "92145",
				32.746730, -117.130987);
		newEvent1.addOwner(User14);
		newEvent1.setLocation(newLoc1);
		Occurrence newOccur1_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(75).getMillis()));
		newEvent1.addOccurrence(newOccur1_0);
		Occurrence newOccur1_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(77).getMillis()));
		newEvent1.addOccurrence(newOccur1_1);
		newEvent1.setDescription("Eveniet magni impedit nam odio. Voluptate soluta pariatur porro at rerum cum.");
		newEvent1.setCategory(soccer);
		this.eventRepo.save(newEvent1);
		Event newEvent2 = new Event("Animi deserunt iusto optio at labore.");
		Location newLoc2 = new Location("Tempora omnis assumenda maiores nesciunt.", "7121 Fay Branch Apt. 770",
				"Cardiff-by-the-Sea", "CA", "92174", 32.818237, -117.078013);
		newEvent2.addOwner(User29);
		newEvent2.setLocation(newLoc2);
		Occurrence newOccur2_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(26).getMillis()));
		newEvent2.addOccurrence(newOccur2_0);
		Occurrence newOccur2_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(20).getMillis()));
		newEvent2.addOccurrence(newOccur2_1);
		Occurrence newOccur2_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(74).getMillis()));
		newEvent2.addOccurrence(newOccur2_2);
		newEvent2.setDescription(
				"Voluptate similique tempore in molestias doloremque. Iste velit accusamus eveniet deleniti ab.");
		newEvent2.setCategory(swim);
		this.eventRepo.save(newEvent2);
		Event newEvent3 = new Event("Error sunt nulla commodi optio.");
		Location newLoc3 = new Location("Itaque dignissimos commodi natus.", "0992 Hane Shoals", "Poway", "CA", "91976",
				32.841826, -117.055208);
		newEvent3.addOwner(User1);
		newEvent3.setLocation(newLoc3);
		Occurrence newOccur3_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(32).getMillis()));
		newEvent3.addOccurrence(newOccur3_0);
		Occurrence newOccur3_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(11).getMillis()));
		newEvent3.addOccurrence(newOccur3_1);
		Occurrence newOccur3_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(15).getMillis()));
		newEvent3.addOccurrence(newOccur3_2);
		newEvent3.setDescription("Quae quidem animi voluptatem ad illum. Nam accusantium rerum ratione.");
		newEvent3.setCategory(swim);
		this.eventRepo.save(newEvent3);
		Event newEvent4 = new Event("Totam maxime tempora vitae assumenda.");
		Location newLoc4 = new Location("Maxime voluptatum doloremque recusandae.", "18885 Buck Valley", "Poway", "CA",
				"92009", 32.712203, -117.035534);
		newEvent4.addOwner(User39);
		newEvent4.setLocation(newLoc4);
		Occurrence newOccur4_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(82).getMillis()));
		newEvent4.addOccurrence(newOccur4_0);
		Occurrence newOccur4_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(84).getMillis()));
		newEvent4.addOccurrence(newOccur4_1);
		newEvent4.setDescription(
				"Asperiores repudiandae distinctio ea corporis. Suscipit ipsam in eligendi perspiciatis.");
		newEvent4.setCategory(swim);
		this.eventRepo.save(newEvent4);
		Event newEvent5 = new Event("Tenetur ab est iste impedit.");
		Location newLoc5 = new Location("Porro adipisci perspiciatis.", "1028 Thiel Crossroad", "El Cajon", "CA",
				"91902", 32.671730, -116.992118);
		newEvent5.addOwner(User13);
		newEvent5.setLocation(newLoc5);
		Occurrence newOccur5_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(94).getMillis()));
		newEvent5.addOccurrence(newOccur5_0);
		Occurrence newOccur5_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(49).getMillis()));
		newEvent5.addOccurrence(newOccur5_1);
		newEvent5.setDescription("Eligendi illo reprehenderit suscipit. In iusto ut aperiam.");
		newEvent5.setCategory(soccer);
		this.eventRepo.save(newEvent5);
		Event newEvent6 = new Event("Sint numquam quo corrupti.");
		Location newLoc6 = new Location("Voluptate ad dolorem rerum.", "5579 Brain Street", "Pacific Beach", "CA",
				"92093", 32.742580, -117.057370);
		newEvent6.addOwner(User42);
		newEvent6.setLocation(newLoc6);
		Occurrence newOccur6_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(37).getMillis()));
		newEvent6.addOccurrence(newOccur6_0);
		newEvent6.setDescription("Laborum ullam nulla aliquam quia voluptates. Est deserunt ratione autem quas.");
		newEvent6.setCategory(swim);
		this.eventRepo.save(newEvent6);
		Event newEvent7 = new Event("Reiciendis dicta et qui ex.");
		Location newLoc7 = new Location("Exercitationem veritatis repellat minima.", "30780 Akira Run", "Lemon Grove",
				"CA", "92164", 32.857299, -117.079957);
		newEvent7.addOwner(User4);
		newEvent7.setLocation(newLoc7);
		Occurrence newOccur7_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(0).getMillis()));
		newEvent7.addOccurrence(newOccur7_0);
		Occurrence newOccur7_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(4).getMillis()));
		newEvent7.addOccurrence(newOccur7_1);
		newEvent7.setDescription(
				"Dolorum nemo cupiditate earum. Quam ipsam aliquid similique repudiandae reprehenderit quas.");
		newEvent7.setCategory(soccer);
		this.eventRepo.save(newEvent7);
		Event newEvent8 = new Event("Repellendus illum saepe in sunt.");
		Location newLoc8 = new Location("Doloremque ad corporis.", "81676 Iliana Avenue Apt. 066", "Pacific Beach",
				"CA", "92186", 32.741295, -117.090050);
		newEvent8.addOwner(User15);
		newEvent8.setLocation(newLoc8);
		Occurrence newOccur8_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(63).getMillis()));
		newEvent8.addOccurrence(newOccur8_0);
		newEvent8.setDescription("Consequatur voluptatum quo adipisci. Molestiae amet soluta repudiandae commodi.");
		newEvent8.setCategory(swim);
		this.eventRepo.save(newEvent8);
		Event newEvent9 = new Event("Necessitatibus earum fugiat asperiores.");
		Location newLoc9 = new Location("Nemo minima eaque.", "91054 Wuckert Terrace", "Pala", "CA", "92158", 32.823024,
				-116.978862);
		newEvent9.addOwner(User12);
		newEvent9.setLocation(newLoc9);
		Occurrence newOccur9_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(93).getMillis()));
		newEvent9.addOccurrence(newOccur9_0);
		Occurrence newOccur9_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(95).getMillis()));
		newEvent9.addOccurrence(newOccur9_1);
		newEvent9.setDescription("Assumenda culpa id veniam natus. Iusto minima unde natus rem.");
		newEvent9.setCategory(soccer);
		this.eventRepo.save(newEvent9);
		Event newEvent10 = new Event("Natus ratione aperiam beatae modi.");
		Location newLoc10 = new Location("Dolorum at.", "43853 Lulah Hills", "Rancho Santa Fe", "CA", "92037",
				32.851825, -117.023549);
		newEvent10.addOwner(User0);
		newEvent10.setLocation(newLoc10);
		Occurrence newOccur10_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(34).getMillis()));
		newEvent10.addOccurrence(newOccur10_0);
		Occurrence newOccur10_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(78).getMillis()));
		newEvent10.addOccurrence(newOccur10_1);
		newEvent10.setDescription(
				"Sequi similique ut tempore ex laborum ab. Id eaque aspernatur dolorum laboriosam ipsam.");
		newEvent10.setCategory(swim);
		this.eventRepo.save(newEvent10);
		Event newEvent11 = new Event("Quisquam est laudantium non quisquam.");
		Location newLoc11 = new Location("Accusantium nesciunt facilis ipsa.", "9155 Murazik Pike Suite 741", "Cardiff",
				"CA", "92022", 32.824524, -117.058262);
		newEvent11.addOwner(User10);
		newEvent11.setLocation(newLoc11);
		Occurrence newOccur11_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(22).getMillis()));
		newEvent11.addOccurrence(newOccur11_0);
		Occurrence newOccur11_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(28).getMillis()));
		newEvent11.addOccurrence(newOccur11_1);
		Occurrence newOccur11_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(27).getMillis()));
		newEvent11.addOccurrence(newOccur11_2);
		newEvent11.setDescription(
				"Quas accusamus ab voluptate repudiandae expedita velit. Veritatis repellendus eum sunt inventore.");
		newEvent11.setCategory(swim);
		this.eventRepo.save(newEvent11);
		Event newEvent12 = new Event("Blanditiis in laborum quis sed tempora.");
		Location newLoc12 = new Location("Ex tenetur eius nesciunt.", "5249 Melvina Roads Apt. 365", "Jamul", "CA",
				"91917", 32.744530, -116.964347);
		newEvent12.addOwner(User11);
		newEvent12.setLocation(newLoc12);
		Occurrence newOccur12_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(82).getMillis()));
		newEvent12.addOccurrence(newOccur12_0);
		newEvent12.setDescription(
				"Ratione consequatur omnis alias voluptatum. Recusandae illo porro alias delectus aut.");
		newEvent12.setCategory(swim);
		this.eventRepo.save(newEvent12);
		Event newEvent13 = new Event("Temporibus sit est quaerat eum ut.");
		Location newLoc13 = new Location("Rerum reiciendis temporibus totam.", "898 Garold Canyon Apt. 750",
				"Fallbrook", "CA", "92120", 32.716986, -117.076901);
		newEvent13.addOwner(User28);
		newEvent13.setLocation(newLoc13);
		Occurrence newOccur13_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(35).getMillis()));
		newEvent13.addOccurrence(newOccur13_0);
		newEvent13.setDescription("Officiis sequi autem eligendi. Est quidem repellat perferendis quas.");
		newEvent13.setCategory(swim);
		this.eventRepo.save(newEvent13);
		Event newEvent14 = new Event("Provident molestias dolores delectus a.");
		Location newLoc14 = new Location("Dolorem et deleniti ex.", "7663 Klein Heights", "Lakeside", "CA", "92101",
				32.758546, -116.964625);
		newEvent14.addOwner(User45);
		newEvent14.setLocation(newLoc14);
		Occurrence newOccur14_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(54).getMillis()));
		newEvent14.addOccurrence(newOccur14_0);
		Occurrence newOccur14_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(30).getMillis()));
		newEvent14.addOccurrence(newOccur14_1);
		newEvent14.setDescription(
				"Reiciendis qui reiciendis ducimus neque eius doloribus rerum. Id iste natus vel cum accusamus.");
		newEvent14.setCategory(swim);
		this.eventRepo.save(newEvent14);
		Event newEvent15 = new Event("Non maiores voluptatem animi odit.");
		Location newLoc15 = new Location("Unde est maiores.", "986 Reilly Extension Suite 368", "Valley Center", "CA",
				"92049", 32.613237, -117.010241);
		newEvent15.addOwner(User42);
		newEvent15.setLocation(newLoc15);
		Occurrence newOccur15_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(80).getMillis()));
		newEvent15.addOccurrence(newOccur15_0);
		Occurrence newOccur15_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(39).getMillis()));
		newEvent15.addOccurrence(newOccur15_1);
		Occurrence newOccur15_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(41).getMillis()));
		newEvent15.addOccurrence(newOccur15_2);
		Occurrence newOccur15_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(27).getMillis()));
		newEvent15.addOccurrence(newOccur15_3);
		newEvent15.setDescription(
				"Non vitae eaque quos amet mollitia. Explicabo culpa sunt expedita. Tempora possimus nihil sequi.");
		newEvent15.setCategory(swim);
		this.eventRepo.save(newEvent15);
		Event newEvent16 = new Event("Dolorem accusamus cupiditate soluta.");
		Location newLoc16 = new Location("Iusto cumque.", "4035 Olson Villages", "Vista", "CA", "92037", 32.735804,
				-117.129987);
		newEvent16.addOwner(User31);
		newEvent16.setLocation(newLoc16);
		Occurrence newOccur16_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(3).getMillis()));
		newEvent16.addOccurrence(newOccur16_0);
		Occurrence newOccur16_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(38).getMillis()));
		newEvent16.addOccurrence(newOccur16_1);
		Occurrence newOccur16_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(48).getMillis()));
		newEvent16.addOccurrence(newOccur16_2);
		Occurrence newOccur16_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(2).getMillis()));
		newEvent16.addOccurrence(newOccur16_3);
		newEvent16.setDescription("Accusantium fugiat nulla quidem similique. Soluta ipsa quo commodi autem.");
		newEvent16.setCategory(swim);
		this.eventRepo.save(newEvent16);
		Event newEvent17 = new Event("Magni vitae cum quasi sunt.");
		Location newLoc17 = new Location("Officiis voluptate.", "75447 Koepp Ville", "Oceanside", "CA", "92160",
				32.759899, -117.122761);
		newEvent17.addOwner(User32);
		newEvent17.setLocation(newLoc17);
		Occurrence newOccur17_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(17).getMillis()));
		newEvent17.addOccurrence(newOccur17_0);
		Occurrence newOccur17_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(78).getMillis()));
		newEvent17.addOccurrence(newOccur17_1);
		Occurrence newOccur17_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(25).getMillis()));
		newEvent17.addOccurrence(newOccur17_2);
		Occurrence newOccur17_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(44).getMillis()));
		newEvent17.addOccurrence(newOccur17_3);
		newEvent17.setDescription("Officia sit hic incidunt. Quibusdam iure sapiente quam. Ex dignissimos minima in.");
		newEvent17.setCategory(soccer);
		this.eventRepo.save(newEvent17);
		Event newEvent18 = new Event("Quibusdam facere enim illum magnam.");
		Location newLoc18 = new Location("Animi reiciendis.", "3472 Deborah Rest", "Rancho Santa Fe", "CA", "91921",
				32.775450, -117.040974);
		newEvent18.addOwner(User35);
		newEvent18.setLocation(newLoc18);
		Occurrence newOccur18_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(75).getMillis()));
		newEvent18.addOccurrence(newOccur18_0);
		Occurrence newOccur18_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(9).getMillis()));
		newEvent18.addOccurrence(newOccur18_1);
		newEvent18.setDescription(
				"Illum voluptatem neque ab mollitia magni incidunt ipsum pariatur. Molestiae id quis magni neque.");
		newEvent18.setCategory(swim);
		this.eventRepo.save(newEvent18);
		Event newEvent19 = new Event("Quasi illum rem neque consectetur.");
		Location newLoc19 = new Location("Laborum nesciunt tempore.", "18538 Crooks Rest Suite 872", "Point Loma", "CA",
				"92121", 32.701895, -117.100295);
		newEvent19.addOwner(User46);
		newEvent19.setLocation(newLoc19);
		Occurrence newOccur19_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(67).getMillis()));
		newEvent19.addOccurrence(newOccur19_0);
		newEvent19.setDescription(
				"Omnis quisquam quasi dolorum aperiam facere. Corporis molestiae fugit vitae temporibus ipsam hic.");
		newEvent19.setCategory(swim);
		this.eventRepo.save(newEvent19);
		Event newEvent20 = new Event("Vel nulla aliquam reprehenderit a.");
		Location newLoc20 = new Location("Esse illum.", "3249 Deckow Locks", "San Marco", "CA", "92170", 32.670679,
				-117.142151);
		newEvent20.addOwner(User35);
		newEvent20.setLocation(newLoc20);
		Occurrence newOccur20_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(32).getMillis()));
		newEvent20.addOccurrence(newOccur20_0);
		Occurrence newOccur20_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(41).getMillis()));
		newEvent20.addOccurrence(newOccur20_1);
		Occurrence newOccur20_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(72).getMillis()));
		newEvent20.addOccurrence(newOccur20_2);
		newEvent20
				.setDescription("Vero nihil expedita quaerat ea tenetur. Cumque quidem repudiandae nesciunt corporis.");
		newEvent20.setCategory(swim);
		this.eventRepo.save(newEvent20);
		Event newEvent21 = new Event("Architecto quasi illum qui.");
		Location newLoc21 = new Location("Consequuntur eos at error.", "695 Tawanda Ramp Apt. 697", "Del Mar", "CA",
				"91950", 32.867868, -117.070130);
		newEvent21.addOwner(User27);
		newEvent21.setLocation(newLoc21);
		Occurrence newOccur21_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(80).getMillis()));
		newEvent21.addOccurrence(newOccur21_0);
		newEvent21.setDescription(
				"Amet magni minima soluta ratione error nesciunt. Dolor suscipit tempora culpa sed et cum.");
		newEvent21.setCategory(swim);
		this.eventRepo.save(newEvent21);
		Event newEvent22 = new Event("Minus laudantium qui nemo.");
		Location newLoc22 = new Location("Vel maiores commodi molestias at.", "713 Harber Shoals Suite 629",
				"San Marcos", "CA", "91945", 32.621487, -117.021852);
		newEvent22.addOwner(User7);
		newEvent22.setLocation(newLoc22);
		Occurrence newOccur22_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(99).getMillis()));
		newEvent22.addOccurrence(newOccur22_0);
		Occurrence newOccur22_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(91).getMillis()));
		newEvent22.addOccurrence(newOccur22_1);
		Occurrence newOccur22_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(62).getMillis()));
		newEvent22.addOccurrence(newOccur22_2);
		newEvent22.setDescription(
				"Unde dolor enim ab iste porro dignissimos. Eos facilis porro expedita. Enim modi minima minima.");
		newEvent22.setCategory(swim);
		this.eventRepo.save(newEvent22);
		Event newEvent23 = new Event("Facere id nam libero necessitatibus.");
		Location newLoc23 = new Location("Eius sed quaerat.", "5791 Brinley Island Suite 471", "Chula Vista", "CA",
				"92182", 32.631893, -117.131720);
		newEvent23.addOwner(User43);
		newEvent23.setLocation(newLoc23);
		Occurrence newOccur23_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(92).getMillis()));
		newEvent23.addOccurrence(newOccur23_0);
		newEvent23.setDescription(
				"Dignissimos veniam nisi expedita facere odit. Dolores ut quia voluptates placeat voluptas.");
		newEvent23.setCategory(swim);
		this.eventRepo.save(newEvent23);
		Event newEvent24 = new Event("Voluptates nobis dolorum iure.");
		Location newLoc24 = new Location("Deleniti deserunt natus.", "90622 Sawayn Cliffs", "Oceanside", "CA", "92138",
				32.837130, -117.034496);
		newEvent24.addOwner(User9);
		newEvent24.setLocation(newLoc24);
		Occurrence newOccur24_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(9).getMillis()));
		newEvent24.addOccurrence(newOccur24_0);
		Occurrence newOccur24_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(95).getMillis()));
		newEvent24.addOccurrence(newOccur24_1);
		Occurrence newOccur24_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(81).getMillis()));
		newEvent24.addOccurrence(newOccur24_2);
		newEvent24.setDescription("Cumque odio dolor adipisci. Enim et voluptatem atque vitae minima enim corporis.");
		newEvent24.setCategory(soccer);
		this.eventRepo.save(newEvent24);
		Event newEvent25 = new Event("Odit rem dolor et nam.");
		Location newLoc25 = new Location("Officiis magnam iusto.", "063 Jessie Squares Apt. 311", "San Ysidro", "CA",
				"91911", 32.603894, -116.950978);
		newEvent25.addOwner(User49);
		newEvent25.setLocation(newLoc25);
		Occurrence newOccur25_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(11).getMillis()));
		newEvent25.addOccurrence(newOccur25_0);
		Occurrence newOccur25_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(73).getMillis()));
		newEvent25.addOccurrence(newOccur25_1);
		newEvent25.setDescription(
				"Sed cum minus natus cum. Debitis cumque quidem ullam praesentium provident numquam provident id.");
		newEvent25.setCategory(soccer);
		this.eventRepo.save(newEvent25);
		Event newEvent26 = new Event("Possimus eaque a voluptatum non nam.");
		Location newLoc26 = new Location("Tempora blanditiis quae.", "806 Howell Junction", "Del Mar", "CA", "92154",
				32.833332, -116.999812);
		newEvent26.addOwner(User14);
		newEvent26.setLocation(newLoc26);
		Occurrence newOccur26_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(60).getMillis()));
		newEvent26.addOccurrence(newOccur26_0);
		Occurrence newOccur26_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(81).getMillis()));
		newEvent26.addOccurrence(newOccur26_1);
		newEvent26
				.setDescription("Molestiae explicabo quo repudiandae distinctio. Magnam eius soluta repellendus esse.");
		newEvent26.setCategory(soccer);
		this.eventRepo.save(newEvent26);
		Event newEvent27 = new Event("Est doloribus occaecati a.");
		Location newLoc27 = new Location("Aperiam aliquid repellendus in.", "650 Pouros Inlet", "Coronado", "CA",
				"92078", 32.699410, -117.116938);
		newEvent27.addOwner(User41);
		newEvent27.setLocation(newLoc27);
		Occurrence newOccur27_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(3).getMillis()));
		newEvent27.addOccurrence(newOccur27_0);
		newEvent27.setDescription(
				"Dolore exercitationem distinctio voluptatum corrupti. Explicabo vero vitae corrupti harum.");
		newEvent27.setCategory(swim);
		this.eventRepo.save(newEvent27);
		Event newEvent28 = new Event("Quo aliquid ea possimus dolorem.");
		Location newLoc28 = new Location("Iure illo ut.", "982 Kale Hill Apt. 777", "Chula Vista", "CA", "91906",
				32.745796, -117.103188);
		newEvent28.addOwner(User18);
		newEvent28.setLocation(newLoc28);
		Occurrence newOccur28_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(13).getMillis()));
		newEvent28.addOccurrence(newOccur28_0);
		Occurrence newOccur28_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(54).getMillis()));
		newEvent28.addOccurrence(newOccur28_1);
		Occurrence newOccur28_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(14).getMillis()));
		newEvent28.addOccurrence(newOccur28_2);
		Occurrence newOccur28_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(5).getMillis()));
		newEvent28.addOccurrence(newOccur28_3);
		newEvent28.setDescription(
				"Magnam vero itaque quos saepe. Doloremque eos minima culpa quo delectus impedit molestiae.");
		newEvent28.setCategory(soccer);
		this.eventRepo.save(newEvent28);
		Event newEvent29 = new Event("Enim laudantium omnis ducimus.");
		Location newLoc29 = new Location("Blanditiis totam dolor.", "279 Mills Green Apt. 700", "Chula Vista", "CA",
				"92079", 32.640105, -117.000357);
		newEvent29.addOwner(User36);
		newEvent29.setLocation(newLoc29);
		Occurrence newOccur29_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(71).getMillis()));
		newEvent29.addOccurrence(newOccur29_0);
		newEvent29.setDescription("Quasi vero ipsa nulla vitae. Vel quae id ipsa accusantium vitae.");
		newEvent29.setCategory(soccer);
		this.eventRepo.save(newEvent29);
		Event newEvent30 = new Event("Ea veniam sunt natus nostrum hic.");
		Location newLoc30 = new Location("Voluptate occaecati nihil voluptate.", "8042 Gottlieb Hill Apt. 622",
				"El Cajon", "CA", "91909", 32.789822, -117.119993);
		newEvent30.addOwner(User5);
		newEvent30.setLocation(newLoc30);
		Occurrence newOccur30_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(45).getMillis()));
		newEvent30.addOccurrence(newOccur30_0);
		Occurrence newOccur30_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(1).getMillis()));
		newEvent30.addOccurrence(newOccur30_1);
		newEvent30.setDescription(
				"Unde error sapiente quisquam adipisci debitis. Est optio quod consectetur accusantium.");
		newEvent30.setCategory(swim);
		this.eventRepo.save(newEvent30);
		Event newEvent31 = new Event("Quaerat numquam ipsum optio rerum.");
		Location newLoc31 = new Location("Maiores quasi.", "4388 Debby Terrace", "Imperial", "CA", "92102", 32.780961,
				-117.052163);
		newEvent31.addOwner(User3);
		newEvent31.setLocation(newLoc31);
		Occurrence newOccur31_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(8).getMillis()));
		newEvent31.addOccurrence(newOccur31_0);
		Occurrence newOccur31_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(67).getMillis()));
		newEvent31.addOccurrence(newOccur31_1);
		Occurrence newOccur31_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(66).getMillis()));
		newEvent31.addOccurrence(newOccur31_2);
		Occurrence newOccur31_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(64).getMillis()));
		newEvent31.addOccurrence(newOccur31_3);
		newEvent31.setDescription(
				"Magni recusandae nihil commodi quisquam porro autem. Consequatur quis vero vel architecto nesciunt.");
		newEvent31.setCategory(swim);
		this.eventRepo.save(newEvent31);
		Event newEvent32 = new Event("Maxime cumque qui consequatur.");
		Location newLoc32 = new Location("Quaerat eaque saepe nesciunt.", "54585 Patrice Valley", "Live Oak Springs",
				"CA", "92197", 32.830257, -117.007299);
		newEvent32.addOwner(User11);
		newEvent32.setLocation(newLoc32);
		Occurrence newOccur32_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(46).getMillis()));
		newEvent32.addOccurrence(newOccur32_0);
		Occurrence newOccur32_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(3).getMillis()));
		newEvent32.addOccurrence(newOccur32_1);
		newEvent32
				.setDescription("Ipsam illo veniam dicta facere. Cumque porro in accusamus quam consequatur tempore.");
		newEvent32.setCategory(soccer);
		this.eventRepo.save(newEvent32);
		Event newEvent33 = new Event("Tenetur ex in est fugiat.");
		Location newLoc33 = new Location("Eveniet culpa harum quo.", "569 Lucetta Plaza", "Santee", "CA", "92190",
				32.777206, -117.056063);
		newEvent33.addOwner(User48);
		newEvent33.setLocation(newLoc33);
		Occurrence newOccur33_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(82).getMillis()));
		newEvent33.addOccurrence(newOccur33_0);
		newEvent33.setDescription("Sapiente ipsum quo dolore sit laudantium. Nesciunt laboriosam vel porro nemo.");
		newEvent33.setCategory(swim);
		this.eventRepo.save(newEvent33);
		Event newEvent34 = new Event("Repellendus libero harum id aspernatur.");
		Location newLoc34 = new Location("Animi eaque in tempore.", "0221 Harvey Haven Suite 116", "Solana Beach", "CA",
				"92145", 32.743620, -116.963252);
		newEvent34.addOwner(User35);
		newEvent34.setLocation(newLoc34);
		Occurrence newOccur34_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(65).getMillis()));
		newEvent34.addOccurrence(newOccur34_0);
		Occurrence newOccur34_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(16).getMillis()));
		newEvent34.addOccurrence(newOccur34_1);
		Occurrence newOccur34_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(82).getMillis()));
		newEvent34.addOccurrence(newOccur34_2);
		Occurrence newOccur34_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(59).getMillis()));
		newEvent34.addOccurrence(newOccur34_3);
		newEvent34.setDescription(
				"Praesentium dignissimos sit eum eius iusto quisquam quibusdam. Fugiat id nesciunt iusto amet.");
		newEvent34.setCategory(swim);
		this.eventRepo.save(newEvent34);
		Event newEvent35 = new Event("Nemo a minima provident repellendus.");
		Location newLoc35 = new Location("Commodi maxime dolores ipsa.", "1179 Delmer Corner Apt. 292", "Valley Center",
				"CA", "92102", 32.795755, -116.974494);
		newEvent35.addOwner(User17);
		newEvent35.setLocation(newLoc35);
		Occurrence newOccur35_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(57).getMillis()));
		newEvent35.addOccurrence(newOccur35_0);
		Occurrence newOccur35_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(49).getMillis()));
		newEvent35.addOccurrence(newOccur35_1);
		newEvent35.setDescription(
				"Porro quis nisi reiciendis hic iste et unde. Inventore exercitationem consequuntur odio recusandae.");
		newEvent35.setCategory(swim);
		this.eventRepo.save(newEvent35);
		Event newEvent36 = new Event("Mollitia fugiat quasi esse delectus.");
		Location newLoc36 = new Location("Minima totam.", "56472 Crona Freeway", "Poway", "CA", "92020", 32.663964,
				-116.963378);
		newEvent36.addOwner(User29);
		newEvent36.setLocation(newLoc36);
		Occurrence newOccur36_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(66).getMillis()));
		newEvent36.addOccurrence(newOccur36_0);
		Occurrence newOccur36_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(38).getMillis()));
		newEvent36.addOccurrence(newOccur36_1);
		Occurrence newOccur36_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(66).getMillis()));
		newEvent36.addOccurrence(newOccur36_2);
		newEvent36.setDescription(
				"Laborum officia error a dolores magni. Deleniti sed vero reprehenderit nisi impedit sapiente nihil.");
		newEvent36.setCategory(swim);
		this.eventRepo.save(newEvent36);
		Event newEvent37 = new Event("Qui natus vero impedit nihil.");
		Location newLoc37 = new Location("Amet ullam at.", "51495 Gina Road", "Hillcrest", "CA", "92092", 32.861912,
				-117.097307);
		newEvent37.addOwner(User7);
		newEvent37.setLocation(newLoc37);
		Occurrence newOccur37_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(0).getMillis()));
		newEvent37.addOccurrence(newOccur37_0);
		Occurrence newOccur37_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(35).getMillis()));
		newEvent37.addOccurrence(newOccur37_1);
		Occurrence newOccur37_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(59).getMillis()));
		newEvent37.addOccurrence(newOccur37_2);
		Occurrence newOccur37_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(59).getMillis()));
		newEvent37.addOccurrence(newOccur37_3);
		newEvent37.setDescription(
				"Et ipsa facere molestiae eum. Eos perferendis distinctio nulla consequatur quidem molestias totam.");
		newEvent37.setCategory(soccer);
		this.eventRepo.save(newEvent37);
		Event newEvent38 = new Event("Iste dicta minima doloremque dolorum.");
		Location newLoc38 = new Location("Nihil dolore culpa.", "1688 Beahan Islands", "Oceanside", "CA", "91917",
				32.606172, -117.139110);
		newEvent38.addOwner(User33);
		newEvent38.setLocation(newLoc38);
		Occurrence newOccur38_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(11).getMillis()));
		newEvent38.addOccurrence(newOccur38_0);
		Occurrence newOccur38_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(25).getMillis()));
		newEvent38.addOccurrence(newOccur38_1);
		Occurrence newOccur38_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(35).getMillis()));
		newEvent38.addOccurrence(newOccur38_2);
		Occurrence newOccur38_3 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(96).getMillis()));
		newEvent38.addOccurrence(newOccur38_3);
		newEvent38.setDescription(
				"Quisquam culpa nihil velit amet itaque sapiente. Nobis culpa quam odit est distinctio quia.");
		newEvent38.setCategory(swim);
		this.eventRepo.save(newEvent38);
		Event newEvent39 = new Event("Quae earum natus ipsa quasi illo odit.");
		Location newLoc39 = new Location("Quae saepe quam.", "135 Erla Isle Suite 070", "Encinitas", "CA", "92132",
				32.860777, -116.958876);
		newEvent39.addOwner(User38);
		newEvent39.setLocation(newLoc39);
		Occurrence newOccur39_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(21).getMillis()));
		newEvent39.addOccurrence(newOccur39_0);
		Occurrence newOccur39_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(39).getMillis()));
		newEvent39.addOccurrence(newOccur39_1);
		newEvent39.setDescription("Hic culpa expedita magni vero dolorum. Animi officia autem unde ipsum dolores vel.");
		newEvent39.setCategory(swim);
		this.eventRepo.save(newEvent39);
		Event newEvent40 = new Event("Fuga provident praesentium sequi est.");
		Location newLoc40 = new Location("Enim adipisci pariatur consectetur.", "1882 Schmidt Row", "San Ysidro", "CA",
				"91977", 32.720974, -117.138055);
		newEvent40.addOwner(User48);
		newEvent40.setLocation(newLoc40);
		Occurrence newOccur40_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(94).getMillis()));
		newEvent40.addOccurrence(newOccur40_0);
		Occurrence newOccur40_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(5).getMillis()));
		newEvent40.addOccurrence(newOccur40_1);
		newEvent40.setDescription(
				"Quidem vitae tempore odio quis. Aliquam cupiditate et illum officia amet quam quis quam.");
		newEvent40.setCategory(swim);
		this.eventRepo.save(newEvent40);
		Event newEvent41 = new Event("Dicta nostrum ab quia quia maiores.");
		Location newLoc41 = new Location("Cum odio odio.", "06959 Linnie Landing", "Hillcrest", "CA", "92091",
				32.801868, -117.045989);
		newEvent41.addOwner(User48);
		newEvent41.setLocation(newLoc41);
		Occurrence newOccur41_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(98).getMillis()));
		newEvent41.addOccurrence(newOccur41_0);
		newEvent41.setDescription(
				"Ullam nostrum aperiam unde soluta. Rem hic aliquam sit officia quisquam reprehenderit.");
		newEvent41.setCategory(swim);
		this.eventRepo.save(newEvent41);
		Event newEvent42 = new Event("Nesciunt nulla tenetur quia.");
		Location newLoc42 = new Location("Repellendus quod illum esse.", "431 Kiehn Forks", "Del Mar", "CA", "92158",
				32.637590, -116.962599);
		newEvent42.addOwner(User21);
		newEvent42.setLocation(newLoc42);
		Occurrence newOccur42_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(60).getMillis()));
		newEvent42.addOccurrence(newOccur42_0);
		newEvent42.setDescription(
				"Illo vel in fugiat optio voluptas libero libero consequuntur. Officia inventore accusamus magnam.");
		newEvent42.setCategory(soccer);
		this.eventRepo.save(newEvent42);
		Event newEvent43 = new Event("Incidunt labore animi non accusamus.");
		Location newLoc43 = new Location("Provident eos.", "35915 Wisozk Center Suite 927", "La Mesa", "CA", "92024",
				32.690599, -117.124272);
		newEvent43.addOwner(User9);
		newEvent43.setLocation(newLoc43);
		Occurrence newOccur43_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(24).getMillis()));
		newEvent43.addOccurrence(newOccur43_0);
		Occurrence newOccur43_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(71).getMillis()));
		newEvent43.addOccurrence(newOccur43_1);
		newEvent43.setDescription("Quo earum commodi est laudantium. Debitis doloremque aliquam eaque reiciendis.");
		newEvent43.setCategory(swim);
		this.eventRepo.save(newEvent43);
		Event newEvent44 = new Event("Error officiis sit iure fugit aliquam.");
		Location newLoc44 = new Location("Dicta nesciunt odio fugit.", "16913 Dolph Heights Suite 044", "San Marco",
				"CA", "92024", 32.792484, -117.055984);
		newEvent44.addOwner(User4);
		newEvent44.setLocation(newLoc44);
		Occurrence newOccur44_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(73).getMillis()));
		newEvent44.addOccurrence(newOccur44_0);
		Occurrence newOccur44_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(36).getMillis()));
		newEvent44.addOccurrence(newOccur44_1);
		newEvent44.setDescription(
				"Consectetur ex quis aliquid. Quo earum hic eum reiciendis. Nobis fugiat ipsum deserunt quis.");
		newEvent44.setCategory(soccer);
		this.eventRepo.save(newEvent44);
		Event newEvent45 = new Event("In libero consequatur dolore.");
		Location newLoc45 = new Location("Maxime repudiandae.", "2887 Beatty Isle", "Pala", "CA", "92115", 32.608741,
				-117.082941);
		newEvent45.addOwner(User21);
		newEvent45.setLocation(newLoc45);
		Occurrence newOccur45_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(58).getMillis()));
		newEvent45.addOccurrence(newOccur45_0);
		newEvent45.setDescription("Voluptatem quidem odio cupiditate. Quae aliquid qui rem odio.");
		newEvent45.setCategory(soccer);
		this.eventRepo.save(newEvent45);
		Event newEvent46 = new Event("Illum eum dignissimos doloremque vero.");
		Location newLoc46 = new Location("Facilis beatae ea.", "90036 Ebba Inlet Suite 809", "San Ysidro", "CA",
				"92124", 32.725060, -116.974962);
		newEvent46.addOwner(User29);
		newEvent46.setLocation(newLoc46);
		Occurrence newOccur46_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(8).getMillis()));
		newEvent46.addOccurrence(newOccur46_0);
		newEvent46.setDescription("Quo iste totam enim quos. Nobis laudantium modi ullam. Magni magnam ipsam nobis.");
		newEvent46.setCategory(soccer);
		this.eventRepo.save(newEvent46);
		Event newEvent47 = new Event("Soluta quos nobis voluptates.");
		Location newLoc47 = new Location("Deleniti a optio molestiae.", "89706 Isabella Ridge Suite 807", "Campo", "CA",
				"91963", 32.738454, -117.009137);
		newEvent47.addOwner(User5);
		newEvent47.setLocation(newLoc47);
		Occurrence newOccur47_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(55).getMillis()));
		newEvent47.addOccurrence(newOccur47_0);
		Occurrence newOccur47_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(71).getMillis()));
		newEvent47.addOccurrence(newOccur47_1);
		Occurrence newOccur47_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(28).getMillis()));
		newEvent47.addOccurrence(newOccur47_2);
		newEvent47.setDescription("Velit laborum inventore nobis. Asperiores minima dolorum voluptates eligendi.");
		newEvent47.setCategory(swim);
		this.eventRepo.save(newEvent47);
		Event newEvent48 = new Event("Est officia odio alias.");
		Location newLoc48 = new Location("Minus sunt minus voluptatem.", "91999 Schumm Valleys", "Rancho Bernardo",
				"CA", "92112", 32.619248, -116.999523);
		newEvent48.addOwner(User25);
		newEvent48.setLocation(newLoc48);
		Occurrence newOccur48_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(52).getMillis()));
		newEvent48.addOccurrence(newOccur48_0);
		Occurrence newOccur48_1 = new Occurrence("Competition", new Timestamp(DateTime.now().plusDays(89).getMillis()));
		newEvent48.addOccurrence(newOccur48_1);
		Occurrence newOccur48_2 = new Occurrence("Practice", new Timestamp(DateTime.now().plusDays(85).getMillis()));
		newEvent48.addOccurrence(newOccur48_2);
		newEvent48.setDescription("Magni atque perspiciatis autem tenetur. Quibusdam perferendis ducimus rerum.");
		newEvent48.setCategory(soccer);
		this.eventRepo.save(newEvent48);
		Event newEvent49 = new Event("Odit nobis aut tempora assumenda.");
		Location newLoc49 = new Location("Consequatur consequatur ipsa.", "28377 John Squares", "Rancho Santa Fe", "CA",
				"92170", 32.751372, -116.983552);
		newEvent49.addOwner(User9);
		newEvent49.setLocation(newLoc49);
		Occurrence newOccur49_0 = new Occurrence("Meeting", new Timestamp(DateTime.now().plusDays(84).getMillis()));
		newEvent49.addOccurrence(newOccur49_0);
		newEvent49.setDescription("Quam consequatur sequi excepturi. Assumenda ipsa reprehenderit eos sed cum itaque.");
		newEvent49.setCategory(swim);
		this.eventRepo.save(newEvent49);
	}
}