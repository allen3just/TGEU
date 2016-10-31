package TGEU;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyGymController  implements Initializable{
	private static Stage stage;
	private static Scene home;
	
	@FXML
	private Button homeButton;
	@FXML
	private PieChart chartOfPie;
	
	//gymequip machineusage GED
	public ArrayList<GymEquipment> gymEquip(){
		ArrayList<GymEquipment> equipments = new ArrayList<GymEquipment>();
		Connection c = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.241.213.248/GED";
	        String username = "allen3just";
	        String password = "Justanswer30!";
	        
	        c = DriverManager.getConnection( url, username, password );
	        Statement stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "select * from gymequip;" );
	        
	        while( rs.next() ){
            	
                GymEquipment equipment = new GymEquipment( rs.getInt( "id" ),
                    rs.getString( "name" ), rs.getInt( "numb" ));
                
                equipments.add( equipment );
            }
	        
		}
		catch( Exception e ){
			e.printStackTrace();
	    }
		
		return equipments;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<GymEquipment> equipments = new ArrayList<GymEquipment>();
		try {
			Collections.copy(equipments, gymEquip());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObservableList<PieChart.Data> pieChartData =
	            FXCollections.observableArrayList(
	            new PieChart.Data(equipments.get(0).getName() + "(" + equipments.get(0).getNumb() + ")", equipments.get(0).getNumb()),
	            new PieChart.Data("Treadmill (3)", 2),
	            new PieChart.Data("Stair Master (2)", 2),
	            new PieChart.Data("Elliptical Machine(3)", 3),
				new PieChart.Data("Free (2)", 2));
	    chartOfPie.setData(pieChartData);
	    chartOfPie.setLabelsVisible(false);
	    chartOfPie.setLegendVisible(true);
	}

    public static void setStage(Stage s) {
        stage = s;
    }
    public static void setHome(Scene h) {
        home = h;
    }
    
	public void login(){
		System.out.println("LOG ME IN BRO!");
		
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("MyGym.fxml"));
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
	}
	
	public void toHome(){
		stage.setScene(home);
	}
	
	

	
}
