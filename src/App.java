import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Membuat elemen GUI
        Label kodePasienLabel = new Label("Kode Pasien:");
        TextField kodePasienField = new TextField();

        Label namaPasienLabel = new Label("Nama Pasien:");
        TextField namaPasienField = new TextField();

        Label lamaInapLabel = new Label("Lama Inap:");
        TextField lamaInapField = new TextField();

        Label tipeKamarLabel = new Label("Tipe Kamar:");
        ComboBox<String> tipeKamarCombo = new ComboBox<>();
        tipeKamarCombo.getItems().addAll("A", "B", "C");

        Label hargaKamarLabel = new Label("Harga Kamar:");
        TextField hargaKamarField = new TextField();
        hargaKamarField.setEditable(false);

        Label totalBayarLabel = new Label("Total Bayar:");
        TextField totalBayarField = new TextField();
        totalBayarField.setEditable(false);

        Button prosesButton = new Button("Proses");
        Button exitButton = new Button("Exit");

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(kodePasienLabel, 0, 0);
        gridPane.add(kodePasienField, 1, 0);

        gridPane.add(namaPasienLabel, 0, 1);
        gridPane.add(namaPasienField, 1, 1);

        gridPane.add(lamaInapLabel, 0, 2);
        gridPane.add(lamaInapField, 1, 2);

        gridPane.add(tipeKamarLabel, 0, 3);
        gridPane.add(tipeKamarCombo, 1, 3);

        gridPane.add(hargaKamarLabel, 0, 4);
        gridPane.add(hargaKamarField, 1, 4);

        gridPane.add(totalBayarLabel, 0, 5);
        gridPane.add(totalBayarField, 1, 5);

        gridPane.add(prosesButton, 0, 6);
        gridPane.add(exitButton, 1, 6);

        // Event handling
        tipeKamarCombo.setOnAction(e -> {
            String tipe = tipeKamarCombo.getValue();
            if (tipe.equals("A")) {
                hargaKamarField.setText("150000");
            } else if (tipe.equals("B")) {
                hargaKamarField.setText("200000");
            } else if (tipe.equals("C")) {
                hargaKamarField.setText("250000");
            }
        });

        prosesButton.setOnAction(e -> {
            try {
                int lamaInap = Integer.parseInt(lamaInapField.getText());
                int hargaKamar = Integer.parseInt(hargaKamarField.getText());
                int pajak = 25000; // Pajak tetap
                int totalBayar = (hargaKamar * lamaInap) - pajak;
                totalBayarField.setText(String.valueOf(totalBayar));
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Masukkan data yang valid!");
                alert.show();
            }
        });

        exitButton.setOnAction(e -> primaryStage.close());

        // Scene dan Stage
        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setTitle("Pembayaran Pasien");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
