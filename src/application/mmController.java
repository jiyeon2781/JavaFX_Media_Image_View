package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

public class mmController implements Initializable {
	@FXML public Canvas canvas;
	@FXML public MediaView mediaview;
	@FXML public Button startbtn;
	@FXML public Button stopbtn;
	@FXML public ImageView imageview;
	@FXML public Image image;
	public GraphicsContext gc;
	public MediaPlayer mp;
	public Media media;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		media = new Media(getClass().getResource("뚱이동영상.mp4").toString());
		mp = new MediaPlayer(media);
		mediaview.setMediaPlayer(mp);
		gc = canvas.getGraphicsContext2D();
		draw(100,100);
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED ,new EventHandler<MouseEvent>() { //마우스버튼을 눌렀을 때
			@Override
			public void handle(MouseEvent event) {
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); //clear
				draw(event.getX(),event.getY());
			}
		});
		imageview.setOnMouseClicked( new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				System.out.println("사진을 눌렀습니다.");
			}
		});
	}
	
	public void startbutton() {
		mp.play();
	}
	
	public void stopbutton() {
		mp.pause();
	}
	void draw(double x, double y) {
		gc.strokeLine(0,0,x+3,y+3); //선
		gc.setFill(Color.BLACK); //테두리
		gc.fillRoundRect(x-1, y-1, 22, 22, 22, 22);
		gc.setFill(Color.SKYBLUE); //원
		gc.fillRoundRect(x, y, 20, 20, 20, 20);
	}
}
