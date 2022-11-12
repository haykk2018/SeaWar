import java.util.ArrayList;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }
    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        int index = locationCells.indexOf(userInput);
        String result = "Misfire";
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Hit the target";
                System.out.println("! You Hit the target " + name);
            } else {
                result = "Hit the target";
            }
        }
        return result;

    }
}
