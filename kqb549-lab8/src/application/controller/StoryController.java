package application.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Story;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * StoryController
 * @author huaweisun
 *
 */
public class StoryController implements EventHandler<ActionEvent>, Initializable {
	@FXML
	private ImageView imageview;
	@FXML
	private Text pageNumber;
	@FXML
	private Text timinglabel;
	@FXML
	private Label title;
	@FXML
	private TextArea fieldtext;
	@FXML
	private Button homebutton;
	private int i = 0;
	Story story = new Story();
	//set up imageview, page number and story
	public void setupBaic() {
		imageview.setImage(story.getImageFiles().get(i));
		fieldtext.setText(story.getSentences().get(i));
		pageNumber.setText(Integer.toString(i + 1) + " of " + 
		Integer.toString(story.getImageFiles().size()));
		i++;
	}
	//thread and sleep 1second 
	public void start() {
		homebutton.setVisible(false);
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				int timing=story.getTimer();
				if(MainController.check==1) {
					title.setText("Amity");
				}else if(MainController.check==2)
				{
					title.setText("Jurassic Park");
				}
				for (int i = 0; i < timing; i++) 			
				{
					if(i%4==0) {
						setupBaic();
					}
					try {
						timinglabel.setText(Integer.toString(story.getTimer()));
						Thread.sleep(1000);
						story.setTimer(story.getTimer()-1);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
				homebutton.setVisible(true);
			}
		});
		thread.setDaemon(true);
		thread.start();
	}
	//initializing
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		story.loadeImage();
		try {
			story.loadeContents();
			System.out.println("success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		start();
	}
	//handle
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource().equals(homebutton)) {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
				Main.stage.setScene(new Scene(root, 650, 650));
				Main.stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
//		another method for threading
//		Thread thread= new Thread(new Runnable() {
//
//			@Override
//			public void run() {	
//				int PageNumber=story.getImageFiles().size();
//				Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
//				    @Override
//				    public void handle(ActionEvent event) {
//	
//							setupBaic();
//				    	
//				    }
//				}));
//				timeline.setCycleCount(PageNumber);
//				timeline.play();
//				
//			}
//
//		});

	}
}
