import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private Stage stage;
    private ArrayList<Product> productsArrayList;

    @FXML
    private Button viewProductsButton;
    @FXML
    private Button viewOrderButton;
    @FXML
    private Button viewReturnButton;
    @FXML
    private Button viewSupplyStoreButton;
    @FXML
    private  Button viewAddProductButton;
    @FXML
    private Button viewCheckOrderButton;
    @FXML
    private Button viewSupplyStockButton;
    @FXML
    private Button viewEarningsExpensesButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        productsArrayList = Main.getProductsFromJSON();


    }


    // Button Listeners

    public void viewProducts() throws IOException {
        ProductsViewController controller = (ProductsViewController) gotToView(viewProductsButton, "ProductsView.fxml");
        controller.setProductsArrayList(productsArrayList);

    }

    public void viewOrder() throws IOException {
        OrderViewController controller = (OrderViewController) gotToView(viewOrderButton, "OrderView.fxml");
    }

    public void viewReturn() throws IOException {
        ReturnViewController controller = (ReturnViewController) gotToView(viewReturnButton, "ReturnView.fxml");
    }

    public void viewSupplyStore() throws IOException {
        SupplyStoreViewController controller = (SupplyStoreViewController) gotToView(viewSupplyStoreButton, "SupplyStoreView.fxml");
    }

    public void viewAddProduct() throws IOException {
        AddProductViewController controller = (AddProductViewController) gotToView(viewAddProductButton, "AddProductView.fxml");
        controller.setProductsArrayList(productsArrayList);
    }

    public void viewCheckOrder() throws IOException {
        CheckOrderViewController controller = (CheckOrderViewController) gotToView(viewCheckOrderButton, "CheckOrderView.fxml");
    }

    public void viewSupplyStock() throws IOException {
        SupplyStockViewController controller = (SupplyStockViewController) gotToView(viewSupplyStockButton, "SupplyStockView.fxml");
    }

    public void viewEarningsExpenses() throws IOException {
        EarningsExpensesViewController controller = (EarningsExpensesViewController) gotToView(viewEarningsExpensesButton, "EarningsExpensesView.fxml");
    }


    private Object gotToView(Button button, String fxml) throws IOException {

        // Switch to given FXML and returns the Controller

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Parent viewParent = fxmlLoader.load();
        Stage stage = (Stage) button.getScene().getWindow();

        stage.setScene(new Scene(viewParent));
        return fxmlLoader.getController();
    }
}
