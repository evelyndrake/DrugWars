package net.evelyndrake.game.inventory;

public class Items {

    public static Item testItem;
    public static ItemDrug alcohol;
    public static ItemDrug weed;
    public static ItemDrug cocaine;
    public static ItemDrug heroin;
    public static ItemDrug meth;
    public static ItemDrug lsd;
    public static ItemDrug morphine;
    public static ItemDrug oxycodone;
    public static ItemDrug codeine;
    public static ItemDrug shrooms;
    public static ItemDrug ketamine;
    public static ItemDrug xanax;
    public static ItemDrug ecstacy;
    public static ItemDrug dxm;
    public static ItemDrug yerbamate;
    public static ItemDrug salvia;
    public static ItemDrug pcp;
    public static ItemDrug cb;
    public static ItemDrug adderall;
    public static ItemDrug percocet;
    public static ItemDrug vicodin;
    public static ItemDrug valium;
    public static ItemDrug nitrous;
    public static ItemDrug dmt;
    public static ItemDrug meascaline;
    public static ItemDrug melatonin;
    public static ItemDrug spice;
    public static ItemDrug ghb;
    public static ItemDrug fentanyl;
    public static ItemDrug bathsalts;
    public static ItemDrug steroids;
    public static ItemDrug mdma;

    //TODO increments, different volumes, risk, od, manufacturing, connections, robbery,
    static { // initialize items
        testItem = new Item("Test Item");
        alcohol = new ItemDrug("Alcohol", 10, 90, "Homemade alcohol is now available!", "Alcohol shortages sweep the nation.");
        weed = new ItemDrug("Weed", 133, 1200, "Weed prices bottomed out!", "Weed is high in demand!");
        heroin = new ItemDrug("Heroin", 1400, 9000, "A cartel truck carrying heroin is robbed!", "Addicts are buying heroin at ridiculous prices!");
        cocaine = new ItemDrug("Cocaine", 15000, 76000, "A speedboat carrying cocaine dusts the coast guard!", "Addicts are buying cocaine at ridiculous prices!");
        meth = new ItemDrug("Meth", 1200, 3400, "Large quantities of meth are available from the labs!", "Addicts are buying meth at ridiculous prices!");
        lsd = new ItemDrug("LSD", 1000, 4000, "Stolen LSD from a rival dealer's warehouse hits the streets!", "Chemical shortages disrupt the flow of LSD into the country.");
        morphine = new ItemDrug("Morphine", 20000, 50000, "Large quantities of morphine are stolen from a local hospital!", "Addicts are buying morphine at ridiculous prices!");
        oxycodone = new ItemDrug("Oxycodone", 500, 4000, "A pharmacy is robbed for bottles of oxycodone!", "Oxycodone addicts are desperate for more.");
        codeine = new ItemDrug("Codeine", 200, 1800, "A pharmacy is robbed for bottles of codeine!", "Codeine prices are at an all-time high!");
        shrooms = new ItemDrug("Shrooms", 200, 1200, "Dude! We found a shroom patch!", "Microdosing shrooms becomes trendy in the area.");
        ketamine = new ItemDrug("Ketamine", 300, 1200, "A hospital is robbed for large quantities of ketamine!", "Shortages of medical supplies make ketamine especially hard to come by!");
        xanax = new ItemDrug("Xanax", 300, 3000, "A pharmacy is robbed for large quantities of Xanax!", "The demand for Xanax explodes due to a rise in adolescent drug abuse!");
        ecstacy = new ItemDrug("Ecstacy", 400, 3000, "The market is flooded with homemade ecstacy!", "Ecstacy is extremely high in demand!");
        dxm = new ItemDrug("DXM", 100, 500, "DXM loses popularity among adolescents!", "DXM gains popularity among adolescents!");
        yerbamate = new ItemDrug("Yerba Mate", 2, 50, "Bountiful harvests make Yerba Mate easy to come by!", "Droughts in South America decrease the importation of Yerba Mate.");
        salvia = new ItemDrug("Salvia", 150, 500, "Bountiful harvests increase the availability of salvia!", "Enthusiasts are willing to pay extra for high-grade salvia.");
        pcp = new ItemDrug("PCP", 1500, 8000, "Large quantities of PCP are stolen from a local dealer!", "Chemical shortages make PCP hard to come by.");
        cb = new ItemDrug("2CB", 1000, 6500, "Large quantities of 2CB are available from the labs!", "Chemical shortages make 2CB hard to come by.");
        adderall = new ItemDrug("Adderall", 600,4000,"A pharmacy is robbed for bottles of adderall!", "Adderall is high in demand!");
        percocet = new ItemDrug("Percocet", 400, 3000, "Large quantities of percocet are stolen from a hospital!", "Percocet addicts are willing to pay extra for their next fix.");
        vicodin = new ItemDrug("Vicodin", 800,1200,"A pharmacy is robbed for bottles of vicodin!", "Vicodin prices are at an all-time high!");
        valium = new ItemDrug("Valium", 100, 5000, "A pharmacy is robbed for bottles of Valium!", "The demand for Vicodin explodes due to a rise in adolescent drug abuse!");
        nitrous = new ItemDrug("Nitrous", 100, 900, "Nitrous prices bottomed out!", "Nitrous explodes in popularity!");
        dmt = new ItemDrug("DMT", 30000, 80000, "DMT manufacturers create product at an astounding rate!", "DMT gains widespread popularity!");

        melatonin = new ItemDrug("Melatonin", 10, 100, "A pharmacy is robbed for bottles of melatonin!", "Sleep deprivation among adolescents creates a high demand for melatonin!");
        spice = new ItemDrug("Spice",100, 3000, "Interest in spice decreases to an all time low!", "Spice is promoted as a designer alternative to weed.");
        ghb = new ItemDrug("GHB", 200, 2000, "Large amounts of GHB are stolen from a local hospital!", "GHB is extremely high in demand!");
        fentanyl = new ItemDrug("Fentanyl", 1500, 8000, "Fentanyl loses popularity due to its lethality.", "Fentanyl addicts are desperate for more.");
        bathsalts = new ItemDrug("Bath Salts", 100, 1000, "Bath salts are readily available in local head shops.", "Bath salts explode in popularity!");
        steroids = new ItemDrug("Steroids", 20000, 40000, "Steroid prices bottomed out!", "Steroids are in high demand!");
        mdma = new ItemDrug("MDMA", 5000, 25000, "MDMA is readily available for sale!", "MDMA explodes in popularity!");
    }

}
