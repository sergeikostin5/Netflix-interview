import java.util.*;

/**
 * Created by sergeikostin on 7/26/15.
 */
public class typeFunction {

    private static final int COLUMNS = 4;
    private static final int ROWS    = 7;

    public static void main(String[] args) {

        char[][] arr = getArray();
        printMenu(arr);
        HashMap<Character, Integer[]> map = createHash();
        printHash(map);
        System.out.println();
        System.out.println(type("FAMILY_GUY", map));
    }

    public static ArrayList<String> type(String input, HashMap<Character, Integer[]> map){
        Integer[] focusCoords = map.get('A');
        ArrayList<String> commands = new ArrayList<String>();
        int focusX = focusCoords[1];
        int focusY = focusCoords[0];

        for(int i = 0; i <input.length(); i++){
            Character target = input.charAt(i);
            Integer[] targetCoords = map.get(target);
            int targetX = targetCoords[1];
            int targetY = targetCoords[0];

            if(targetX > focusX){
                while(focusX != targetX) {
                    commands.add("RIGHT");
                    focusX++;
                }
            }else{
                while(focusX != targetX) {
                    commands.add("LEFT");
                    focusX--;
                }
            }

            if(targetY > focusY){
                while(focusY != targetY) {
                    commands.add("DOWN");
                    focusY++;
                }
            }else{
                while(focusY != targetY) {
                    commands.add("UP");
                    focusY--;
                }
            }
            commands.add("Enter");
        }
        return commands;
    }

    public static HashMap<Character, Integer[]> createHash(){

        HashMap<Character, Integer[]> map = new HashMap<>();
        int k=0;
        Integer[] arr;
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLUMNS; j++){
                arr = new Integer[]{i, j};
                if      (i == 6 && j==2) map.put('_', arr);
                else if (i == 6 && j==3) map.put(' ', arr);
                else {
                    map.put((char) (65 + k), arr);
                    k++;
                }
            }
        }
        return map;

    }

    public static void printHash(HashMap<Character, Integer[]> map){
        int breakPoint = 0;
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            System.out.print(mapEntry.getKey() + " -> " + Arrays.toString((Integer[]) mapEntry.getValue()) + "  |  ");
            breakPoint++;
            if(breakPoint%5==0) System.out.println();
        }
    }

    public static char[][] getArray(){
        int k = 0;
        char[][] array = new char[7][4];
        for(int i = 0; i < array.length; i++){
            for (int j = 0; j < array[j].length; j++){
                array[i][j] = (char)(65 + k);
                k++;
            }
        }
        array[6][2] = '_';
        array[6][3] = ' ';
        return array;
    }

    public static void printMenu(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[j].length; j++) {
                System.out.printf(" %c ", array[i][j]);
            }
            System.out.println();
        }
    }
}
