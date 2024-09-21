import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AudioPlayer audioPlayer = new AudioPlayer();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Media Player ---");
            System.out.println("1. Play MP3");
            System.out.println("2. Play VLC");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter MP3 file name: ");
                    String mp3File = scanner.nextLine();
                    audioPlayer.play("mp3", mp3File);
                    break;

                case 2:
                    System.out.print("Enter VLC file name: ");
                    String vlcFile = scanner.nextLine();
                    audioPlayer.play("vlc", vlcFile);
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
