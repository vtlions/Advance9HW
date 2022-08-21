package com.vtlions.HWmultithreading;

import java.util.List;

public class IdGenerator implements Runnable {
	private List<Integer> idList;
	private Integer id;
	private int i;

	public IdGenerator(List<Integer> idList) {
		this.idList = idList;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (i < 1000000) {
			id = (int) (Math.random() * Integer.MAX_VALUE);
			idList.add(id);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}
