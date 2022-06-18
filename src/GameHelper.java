import java.io.*;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        //without try
        //Scanner sc = new Scanner(System.in);
        //sc.next()
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<>();
        String[] alphacoords = new String[comSize]; // Хранит координаты типа f6
        String temp = null; // Временная строка для конкатенации
        int[] coords = new int[comSize]; // Координаты текущего "сайта"
        int attempts = 0; // Счетчик текущих попыток
        boolean success = false; // Нашли подходящее местоположение?
        int location = 0; // Текущее начальное местоположение
        comCount++;
        int incr = 1;
        if ((comCount % 2) == 1) incr = gridLength;

        while (!success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);
            System.out.print("\nпробуем" + location);
            int x = 0;
            success = true;
            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) { // Вышли за рамки - правый край
                        success = false; // Неудача
                    }
                } else {
                    System.out.print("\nиспользуется" + location);
                    success = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;
        while (x < comSize) {
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.print("\ncoord" + x + " = " + alphaCells.get(x - 1));
        }
        return alphaCells;
    }
}
