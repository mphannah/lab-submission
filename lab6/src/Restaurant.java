// Distribution
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.lang.Math;
import java.util.List;

/*
Annie and Kevin have decided to open up two competing restaurants. They both take reservations but have different
systems of doing so.

Before continuing in the storyline, please read the Party.java file.
 */

public interface Restaurant {
    void insert(Party party);
    void removeParty(Party party);
    void resize();
}

/*
Annie opens up a Ramen Bar. Her specialty is spicy miso noodles. Sometimes the noodles can be really mid but at least
the broth and meat taste great. She plays an awful lot of Harry Styles music in her restaurant but that's besides the point.
 */

class AnniesRamenBar implements Restaurant{
    private ArrayList<Party> tables;
    private int totalCapacity;
    private int currentCapacity;

    public AnniesRamenBar(){
        this.totalCapacity = 7;
        this.currentCapacity = 0;
        this.tables = new ArrayList<>(this.totalCapacity);
        for(int i = 0; i < totalCapacity; i++){
            this.tables.add(i, new Party());
        }
    }

    public ArrayList<Party> getTables(){
        return this.tables;
    }

    public int hash(String name){
        return name.length() % totalCapacity;
    }

    /*
    TODO: Quad-probing
    Annie's insertion of parties into her reservation queue of tables (not data structure) is that she'll
    try to separate the tables as much as she can if there's already someone in that spot. She cares a lot about
    public health and safety and thus she decides to set it up so that the next open table is at:
    within the total capacity: hash(party name) + collisions^2. If the current Capacity (amount of tables being used)
    is half of the total capacity, then she wants to bring out more tables and keep the current parties in
    the system but replaced according to the new total capacity.
    This is quad-probing. She wants to avoid clustering if possible.
     */
    public void insert(Party party) {
        int index = hash(party.getGroup());
        int collisions = 0;

        while (this.tables.get(index).getKey() != -1) {
            collisions += 1;
            index = (int) ((party.getGroup().length() + Math.pow(collisions, 2)) % this.totalCapacity); //chage to math.pow
        }

        party.setKey(index);
        this.tables.set(index, party);
        this.currentCapacity += 1;

        if (this.currentCapacity >= this.totalCapacity/2) {
            resize();
        }
    }

    /*
    TODO: resize()
    This method will update the totalCapacity to the next prime number and translate the current parties to their new
    table reservation according to the updated totalCapacity.
    */
    public void resize() {
        ArrayList<Party> oldList = this.tables;
        ArrayList<Party> resizeList = new ArrayList<>();
        this.currentCapacity = 0;
        nextPrime();

        this.tables = resizeList;

        for (int i = 0; i < this.totalCapacity; i++) {
            this.tables.add(i, new Party());
        }

        for (Party party : oldList) {
            if (party.getKey() != -1) {
                insert(party);
            }
        }
    }

    public void removeParty(Party party) {
        for(int i = 0; i < this.tables.size(); i++){
            if(this.tables.get(i).getGroup().equals(party.getGroup())){
                this.tables.set(i, new Party());
                break;
            }
        }
    }

    public void nextPrime() {
        this.totalCapacity++;
        for (int i = 2; i < this.totalCapacity; i++) {
            if(this.totalCapacity%i == 0) {
                this.totalCapacity++;
                i=2;
            } else {
                continue;
            }
        }
    }
}
/*
Kevin decides to open up a Sushi bar. He cuts corners and doesn't use wasabi nor proper rice. He likes to use one minute
rice for sushi and also has a bad Yelp review where he yelled at a customer for being vegetarian. The upside is that
he likes to play KPop in his restaurant. That's besides the point.
 */
class KevinsSushiBar implements Restaurant{

    private ArrayList<Party> tables;
    private int totalCapacity;
    private int currentCapacity;

    public KevinsSushiBar(){
        this.totalCapacity = 7;
        this.currentCapacity = 0;
        this.tables = new ArrayList<>(this.totalCapacity);
        for(int i = 0; i < totalCapacity; i++){
            this.tables.add(i, new Party());
        }
    }

    public ArrayList<Party> getTables(){
        return this.tables;
    }

    public int hash(String name){
        return name.length() % totalCapacity;
    }

    /*
    TODO: Linear probing
    Kevin doesn't care about public health and just wants to get people in his restaurant. So his system of putting parties
    to tables is that he will find the next available one if it's open. Aka, 1 -> 2. or 1 -> 2 -> 3 (open). He decides to
    set it up so that the next open table is at:
    within the total capacity: hash(party name) + collisions. If the currenCapacity (amount of tables being used)
    is half of the total capacity, then he wants to bring out more tables and keep the current parties in
    the system but replaced according to the new total capacity.
     */
    public void insert(Party party) {
        int index = hash(party.getGroup());
        int collisions = 0;

        while (this.tables.get(index).getKey() != -1) {
            collisions += 1;
            index = (party.getGroup().length() + collisions) % this.totalCapacity;
        }

        party.setKey(index);
        this.tables.set(index, party);
        this.currentCapacity += 1;

        if (this.currentCapacity >= this.totalCapacity/2) {
            resize();
        }
    }

    /*
    TODO: resize()
    This method will update the totalCapacity to the next prime number and translate the current parties to their new
    table reservation according to the updated totalCapacity. You can use the resize function from above.
    */
    public void resize() {
        ArrayList<Party> oldList = this.tables;
        ArrayList<Party> resizeList = new ArrayList<>();
        this.currentCapacity = 0;
        nextPrime();

        this.tables = resizeList;

        for (int i = 0; i < this.totalCapacity; i++) {
            this.tables.add(i, new Party());
        }

        for (Party party : oldList) {
            if (party.getKey() != -1) {
                insert(party);
            }
        }
    }

    public void removeParty(Party party) {
        for(int i = 0; i < this.tables.size(); i++){
            if(this.tables.get(i).getGroup().equals(party.getGroup())){
                this.tables.set(i, new Party());
                break;
            }
        }
    }

    public void nextPrime() {
        this.totalCapacity++;
        for (int i = 2; i < this.totalCapacity; i++) {
            if(this.totalCapacity%i == 0) {
                this.totalCapacity++;
                i=2;
            } else {
                continue;
            }
        }
    }
}