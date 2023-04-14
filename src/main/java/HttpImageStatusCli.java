import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter HTTP status code: ");
        String input = scanner.nextLine();

        int code;
        try {
            code = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
            return;
        }

        try {
            String imageUrl = new HttpStatusChecker().getStatusImage(code);
            new HttpStatusImageDownloader().downloadStatusImage(code);
            System.out.println("Image downloaded: " + imageUrl);
        } catch (Exception e) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
