package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import processing.core.PApplet;

public class Main extends PApplet {

	private BufferedWriter writer;
	private BufferedReader reader;
	private ArrayList<User> Users = new ArrayList<User>();

	public static void main(String[] args) {
		PApplet.main("main.Main");
		// TODO Auto-generated method stub
	}

	public void settings() {

		size(400, 400);
	}

	public void setup() {

		initConecction();
		Users.add(new User("Valentina", "12345"));
		Users.add(new User("Nicolas", "1234"));
		Users.add(new User("Camila", "abcd"));
		Users.add(new User("Alejandro", "2345"));
		Users.add(new User("Santiago", "hijk"));

	}

	public void draw() {
		background(0);
	}

	public void initConecction() {

		new Thread(

				() -> {

					try {

						ServerSocket server = new ServerSocket(5000);
						System.out.println("Esperando cliente...");
						Socket socket = server.accept();
						System.out.println("Cliente conectado");

						// envio y recepcion
						InputStream is = socket.getInputStream();
						OutputStream os = socket.getOutputStream();

						writer = new BufferedWriter(new OutputStreamWriter(os));
						reader = new BufferedReader(new InputStreamReader(is));

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

		).start();

	}// cierra initConecction

}// cierra main
