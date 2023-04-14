import java.io.IOException;

public class CatService {
    public static void main(String[] args) {
        try {
            System.out.println(HttpStatusChecker.getStatusImage(100));
            System.out.println(HttpStatusChecker.getStatusImage(200));
            System.out.println(HttpStatusChecker.getStatusImage(300));
            System.out.println(HttpStatusChecker.getStatusImage(10000));
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        try {
            downloader.downloadStatusImage(200);
        } catch (Exception e) {
            System.out.println("Error code 400: " + e.getMessage());
        }

        try {
            downloader.downloadStatusImage(1000);
        } catch (Exception e) {
            System.out.println("Error code 1000: " + e.getMessage());
        }

        new HttpImageStatusCli().askStatus();
    }
}
