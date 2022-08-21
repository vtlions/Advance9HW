package com.vtlions.HWmultithreading;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class IdConsumer implements Runnable {
	private Integer id;
	private int i;

	public IdConsumer() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (i < 1000000) {
			i++;
		}
	}

	public void setId(Integer id) {
		this.id = id;
		System.out.println(id);
		writeIdToFile();
	}

	private void writeIdToFile() {
		try (FileWriter writer = new FileWriter("result.txt", true);) {
			writer.append(id + " " + LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8) + "\n");
			System.out.println("Wrote into file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
