package com.example.spms;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ECM_Controller implements Initializable {


    @FXML
    private Scene main;

    @FXML
    private AnchorPane Navigation;

    @FXML
    private AnchorPane MainTopic;

    @FXML
    private AnchorPane HomeImg;

    @FXML
    private AnchorPane FReport;

    @FXML
    private AnchorPane SalesInvoice;

    @FXML
    private AnchorPane SuppliedInvoice;

    @FXML
    private AnchorPane MRevenue;

    @FXML
    private TextField SalesCid;

    @FXML
    private TextField Salesid;

    @FXML
    private TextField SuppliedCid;

    @FXML
    private TextField SuppliedID;

    @FXML
    private Button BtnFinance;

    @FXML
    private Button BtnSales;

    @FXML
    private Button BtnSupplied;

    @FXML
    private Button BtnMRevenue;

    @FXML
    private Button BtnBack;

    @FXML
    private Button Btnclear;
    @FXML
    private Button Clear;

   //-------------------------------------------------------------------------------

    @FXML
    private TableView<User> FR_Table;


    @FXML
    private TableColumn<User,String> Date;

    @FXML
    private TableColumn<User,String> Description;

    @FXML
    private TableColumn<User,String> Income;

    @FXML
    private TableColumn<User,String> Expenses;

    @FXML
    private TableColumn<User,String> Profit;

//------------------------------------------------------------------------------------

    @FXML
    private LineChart<?,?> chart;

//------------------------------------------------------------------------------------



    @FXML
    void SalesInvoice(ActionEvent event) {
        // Handle the SalesInvoice action
        // For example, you can open a new scene or perform some logic here
    }

    @FXML
    void SuppliedInvoice(ActionEvent event) {
        // Handle the SuppliedInvoice action
    }

    @FXML
    void ViewReport(ActionEvent event) {
        // Handle the ViewReport action
    }

    @FXML
    void ViewRevenue(ActionEvent event) {
        // Handle the ViewRevenue action
    }


//    @FXML
//    void goBack(ActionEvent event) throws IOException {
//        //Handle the goBack action
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ECM.fxml"));
//        Parent root = fxmlLoader.load();
//        Scene scene = new Scene(root, 900, 550);
//        Stage stage = (Stage) BtnBack.getScene().getWindow();
//        stage.setTitle("SPMS");
//        stage.setScene(scene);
//        stage.setResizable(false);
//    }
        //------------------------------------------------------------------------------------

    @FXML
    void ResetAll(ActionEvent event)
        {
            SalesCid.setText("");
            Salesid.setText("");

        }
    @FXML
    void ClearAll(ActionEvent event)
    {
        SuppliedCid.setText("");
        SuppliedID.setText("");

    }





    public void ButtonClicked (ActionEvent event)throws IOException{
            HomeImg.setVisible(true);
            FReport.setVisible(false);
            SalesInvoice.setVisible(false);
            SuppliedInvoice.setVisible(false);
            MRevenue.setVisible(false);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainDashboard.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 900, 550);
            Stage stage = (Stage) BtnBack.getScene().getWindow();
            stage.setTitle("SPMS");
            stage.setScene(scene);
            stage.setResizable(false);

    }
    public void gotoviweFinancialReport(ActionEvent event)throws IOException {
            FReport.setVisible(true);
            SalesInvoice.setVisible(false);
            SuppliedInvoice.setVisible(false);
            MRevenue.setVisible(false);
        HomeImg.setVisible(false);

    }

    public void gotoviweSalesInvoice(ActionEvent event)throws IOException{
            FReport.setVisible(false);
            SalesInvoice.setVisible(true);
            SuppliedInvoice.setVisible(false);
            MRevenue.setVisible(false);
        HomeImg.setVisible(false);

    }

    public void gotoviweSuppliedInvoice(ActionEvent event)throws IOException{
            FReport.setVisible(false);
            SalesInvoice.setVisible(false);
            SuppliedInvoice.setVisible(true);
            MRevenue.setVisible(false);
        HomeImg.setVisible(false);
    }

    public void gotoviweMonthlyRevenue(ActionEvent event)throws IOException{
            FReport.setVisible(false);
            SalesInvoice.setVisible(false);
            SuppliedInvoice.setVisible(false);
            MRevenue.setVisible(true);
        HomeImg.setVisible(false);
        }

     ObservableList<User>List = FXCollections.observableArrayList(
             new User("2023-10-01","Purchase of products","0","5 000","-5 000"),
             new User("2023-10-02","Sales revenue","15 000","0","15 000"),
             new User("2023-10-05","Advertising costs","0","1 000","-1 000"),
             new User("2023-10-07","Sales revenue","8 000","0","8 000"),
             new User("2023-10-10","Shipping expenses","0","300","-300"),
             new User("2023-10-15","Product return","0","2 000","-2 000"),
             new User("2023-10-20","Sales revenue","12 000","0","12 000"),
             new User("","","","",""),
              new User("Monthly","Total","Profit","=","26 700")
     );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Date.setCellValueFactory(new PropertyValueFactory<User,String>("Date"));
        Description.setCellValueFactory(new PropertyValueFactory<User,String>("Description"));
        Income.setCellValueFactory(new PropertyValueFactory<User,String>("Income"));
        Expenses.setCellValueFactory(new PropertyValueFactory<User,String>("Expenses"));
        Profit.setCellValueFactory(new PropertyValueFactory<User,String>("Profit"));

        FR_Table.setItems(List);


         XYChart.Series series1 = new XYChart.Series();

       series1.getData().add(new XYChart.Data("1","5"));
       series1.getData().add(new XYChart.Data("2","4"));
       series1.getData().add(new XYChart.Data("3","6"));

        XYChart.Series series2 = new XYChart.Series();

        series2.getData().add(new XYChart.Data("1","2"));
        series2.getData().add(new XYChart.Data("3","5"));
        series2.getData().add(new XYChart.Data("5","8"));

        //chart.getData().addAll(series1,series2);


    }
}
