package app;

public class App {
   
    public static void main(String[] args) throws Exception {

        System.out.println("Player 1, what is your name?");
        String name = Game.getInput().nextLine();
        Player player1 = new Player(name, "X");

        System.out.println("Player 2, what is your name?");
        name = Game.getInput().next();
        Player player2 = new Player(name, "O");
        
        System.out.println();

        while(true) {

            Game game = new Game(player1, player2);
            game.play();

            System.out.println();
            System.out.println("rematch? (Y/N)");

            String input = Game.getInput().next();
            if(!input.toUpperCase().equals("Y")) {
                break;
            }
        }
    }
}